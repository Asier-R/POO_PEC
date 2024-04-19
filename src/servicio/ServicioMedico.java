package servicio;

import entidad.persona.Medico;
import entidad.persona.Paciente;
import entidad.registro.Cita;
import entidad.registro.Expediente;
import entidad.unidad.Unidad;
import entidad.unidad.medica.consulta.Consulta;
import entidad.unidad.medica.consulta.Primaria;
import entidad.unidad.medica.habitacion.Habitacion;
import entidad.unidad.medica.quirofano.Quirofano;
import enumerado.CodigoActividadEnum;
import servicio.DiagnosticoTratamiento.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

/** Clase encargada de implementar las acciones (automáticas) propias del servicio médico. */
public final class ServicioMedico {

  /** Clase interna utilizada para generar informes a mostrar por pantalla. */
  private static class Informe {
    /** Ubicación del paciente antes del tratamiento. */
    private static Unidad ubicacionPrev;

    /** Ubicación actual del paciente. */
    private static Unidad ubicacionAct;

    /** Ubicación del paciente después del tratamiento. */
    private static Unidad ubicacionSig;

    /** Diagnóstico del paciente */
    private static DiagnosticosTratamientos diagnostico;

    public static void generarInforme() {

      System.out.println("");
    }
  }

  /**
   * Da cita a los nuevos pacientes que carecen de cita, derivándolos directamente a consulta
   * primaria.
   */
  static void atenderPacientes() {
    PantallasTerminalDatos.pantallaAtenderPacientes();
    // Obtener los pacientes nuevos.
    final List<Paciente> pacientes =
        LogicaTerminalDatos.getHospital().getPacientes().stream()
            .filter(p -> (p.getExpediente().getEstado().equals(Expediente.Estado.EN_ESPERA)))
            .collect(Collectors.toList());
    // Aviso sin pacientes nuevos.
    if (pacientes.isEmpty()) {
      PantallasTerminalDatos.pantallaAvisoSinPacientesNuevos();
    }

    // Obtener el médico de consulta primaria.
    final List<Medico> medicos =
        Consultas.obtenerMedicos().stream()
            .filter(m -> m.getCodigoActividad().equals(CodigoActividadEnum.CONSULTA_PRIMARIA))
            .collect(Collectors.toList());
    Primaria consutaPrimaria = Consultas.obtenerUnidadConsultaPrimaria();
    // Aviso no hay médico en consulta primaria.
    if (medicos.isEmpty()) {
      PantallasTerminalDatos.pantallaAvisoSinMedicoPrimaria();
    }
    final Medico medicoPrimaria = medicos.get(0);

    // Si no existe consulta primaria, se crea.
    if (consutaPrimaria == null) {
      consutaPrimaria = new Primaria(CodigoActividadEnum.CONSULTA_PRIMARIA.getDescripcion());
      LogicaTerminalDatos.getHospital().registrarUnidad(consutaPrimaria);
    }

    // Si hay médico en consulta primaria, y hay pacientes, se les da cita.
    if (!medicos.isEmpty() && !pacientes.isEmpty()) {
      // Se da cita para el dia siguiente (valor arbitrario).
      ZonedDateTime fechaCita = Utiles.getFechaHoraSistema().plusDays(1L);
      Cita citaCP;
      PantallasTerminalDatos.pantallaInfoCitaPacientesNuevos();
      for (Paciente p : pacientes) {
        citaCP = new Cita(fechaCita, p, consutaPrimaria);
        p.setCita(citaCP);
        p.getExpediente().setEstado(Expediente.Estado.CITADO);
        p.setUbicacion(consutaPrimaria);
        medicoPrimaria.anotarCita(citaCP);
        // Se avanza una hora para asignar la siguiente cita.
        fechaCita = fechaCita.plusHours(1L);
        // Mostrar por pantalla.
        Consultas.presentar(p);
        Consultas.printAgenda("..", p.getCita());
      }
    }
  }

  /** Se trata cada paciente con una cita y actualizan los expedientes, citas, agendas, etc. */
  static void actualizarExpedientes() {
    PantallasTerminalDatos.pantallaInfoActualizarExpedientes();
    PantallasTerminalDatos.pantallaInfoActualizarExpedientesAvanzarDias((long) Utiles.leerNumero());
    // Obtener la fecha para compararla.
    ZonedDateTime fechaActual = Utiles.getFechaHoraSistema();
    // Obtener todos los pacientes.
    List<Paciente> pacientes = LogicaTerminalDatos.getHospital().getPacientes();
    for (Paciente p : pacientes) {
      // Solo se tienen en cuenta pacientes con cita vigente y previa a la fecha de sistema.
      if (p.getCita() != null && p.getCita().getFechaCita().isBefore(fechaActual)) {
        establecerDiagnostico(p);
        tratarPaciente(p);
      }
    }
  }

  /**
   * Establece automáticamente un diagnóstico aleatorio para el paciente
   *
   * @param paciente Paciente a diagnosticar.
   */
  private static void establecerDiagnostico(Paciente paciente) {
    if (paciente.getExpediente().getDiagnostico() == null) {
      final DiagnosticosTratamientos diagnostico = DiagnosticoTratamiento.diagnosticar();
      paciente.getExpediente().setDiagnostico(diagnostico);
    }
  }

  /**
   * Trata a un paciente en función de su expediente.
   *
   * @param paciente Paciente a tratar.
   */
  private static void tratarPaciente(Paciente paciente) {
    // Preparar informe.
    Informe.diagnostico = paciente.getExpediente().getDiagnostico();
    Informe.ubicacionPrev = paciente.getUbicacion();
    Informe.ubicacionAct = paciente.getCita().getUbicacion();
    Informe.ubicacionSig =
        Utiles.obtenerUnidadPorCodActividad(Informe.diagnostico.getUnidadDestino());

    // El ciclo de tratamientos termina cuando no hay unidad destino.
    if (Informe.ubicacionAct == null) {
      darAltaPaciente(paciente);
    } else {
      atenderPaciente(paciente);
    }

    // TODO: terminar tratamiento paciente, mostrar informe (desarrollar)
  }

  /**
   * Atender a un paciente.
   * @param paciente Paciente al que se atiende.
   */
  private static void atenderPaciente(Paciente paciente){
    if (Informe.ubicacionAct instanceof Consulta)
      paciente.getExpediente().setEstado(Expediente.Estado.EN_CONSULTA);

    if (Informe.ubicacionAct instanceof Habitacion)
      paciente.getExpediente().setEstado(Expediente.Estado.EN_TRATAMIENTO);

    if (Informe.ubicacionAct instanceof Quirofano)
      paciente.getExpediente().setEstado(Expediente.Estado.DERIVADO);

    paciente.setUbicacion(Informe.ubicacionAct);

    // Se genera una cita para el siguiente paso en el tratamiento.
    paciente.setCita(generarCita(paciente));

    //TODO: terminar atencion paciente
  }

  /**
   * Genera una cita para un paciente.
   * @param paciente Paciente para el que se genera la cita.
   */
  private static Cita generarCita(Paciente paciente){
    ZonedDateTime fechaCita = Utiles.getFechaHoraSistema().plusDays(1L);
    final Cita cita = new Cita(fechaCita, paciente, Informe.ubicacionSig);
    if(Informe.ubicacionSig == null) cita.setVencida();

    // TODO: citar medicos y revisar modificaciones de citas

    return cita;
  }

  /**
   * Da de alta a un paciente, eliminando
   * @param paciente Paciente al que se da de alta.
   */
  private static void darAltaPaciente(Paciente paciente){
    paciente.getExpediente().setEstado(Expediente.Estado.SANO);
    paciente.getExpediente().grabarDatos();
    paciente.setCita(null);
    paciente.getExpediente().setDiagnostico(null);
  }
}
