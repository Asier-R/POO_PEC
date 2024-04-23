package servicio;

import entidad.persona.Medico;
import entidad.persona.Paciente;
import entidad.persona.Sanitario;
import entidad.registro.Cita;
import entidad.registro.Expediente;
import entidad.unidad.Unidad;
import entidad.unidad.medica.consulta.Consulta;
import entidad.unidad.medica.consulta.Primaria;
import entidad.unidad.medica.habitacion.EnPlanta;
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

    public static void generarInforme(Paciente paciente) {
      PantallasTerminalDatos.separarPantallaSimple();
      System.out.println("> INFORME DE PACIENTE <");
      Consultas.presentar(paciente);
      System.out.println();
      System.out.println("> El paciente ha sido diagnosticado " + diagnostico.getDiagnostico());

      if (ubicacionPrev != null) {
        System.out.println("> El paciente procede de " + ubicacionPrev);
      }

      if (ubicacionAct != null) {
        System.out.println("> El paciente es tratado en " + ubicacionAct);
      }

      if (diagnostico.getCodigoPruebaMedica() != null) {
        System.out.println(
            "> Requiere de una prueba de " + diagnostico.getCodigoPruebaMedica().getDescripcion());
      }

      if (diagnostico.getTratamiento() != null) {
        System.out.println("> Se prescribe: " + diagnostico.getTratamiento());
      }

      if (ubicacionSig != null) {
        System.out.println("> El paciente es enviado a " + ubicacionSig);
      }

      if (paciente.getCita() != null) {
        Consultas.printCitaParaPaciente(paciente.getCita());
      }

      if (paciente.getExpediente().getEstado().equals(Expediente.Estado.SANO)) {
        System.out.println("> Se ha tratado al paciente y se le ha dado de alta.");
      } else if (paciente.getExpediente().getEstado().equals(Expediente.Estado.DERIVADO)) {
        System.out.println("> Se ha visto al paciente y se ha externalizado su tratamiento.");
      }

      System.out.println();
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
    final long avance = Utiles.leerNumero();
    PantallasTerminalDatos.pantallaInfoActualizarExpedientesAvanzarDias(avance);
    System.out.println(
        "> Fecha establecida en --> "
            + Utiles.getFechaHoraFormateada(Utiles.avanzarDiaSistema(avance)));
    // Obtener la fecha para compararla.
    ZonedDateTime fechaActual = Utiles.getFechaHoraSistema();
    // Obtener todos los pacientes.
    int contador = 0;
    List<Paciente> pacientes = LogicaTerminalDatos.getHospital().getPacientes();
    for (Paciente p : pacientes) {
      // Solo se tienen en cuenta pacientes con cita vigente y previa a la fecha de sistema.
      if (p.getCita() != null && p.getCita().getFechaCita().isBefore(fechaActual)) {
        establecerDiagnostico(p);
        tratarPaciente(p);
        contador++;
      }
    }
    PantallasTerminalDatos.pantallaInfoNumPacientesTratados(contador);
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
    actualizarInforme(paciente);

    // Si el paciente está ingresado en la UCI o en planta no se le atiende.
    // Permanece ingresado indefinidamente.
    final CodigoActividadEnum ubicacionPaciente = paciente.getUbicacion().getCodigoActividad();
    if (ubicacionPaciente.equals(CodigoActividadEnum.UCI)
        || ubicacionPaciente.equals(CodigoActividadEnum.EN_PLANTA)) {
      Informe.ubicacionAct = paciente.getUbicacion();
      Informe.generarInforme(paciente);
      PantallasTerminalDatos.pantallaInfoPacientesPermaneceIngresado(
          Informe.ubicacionPrev.getCodigoActividad());
    } else {
      // Si el paciente ha pasado por quirófano se le cambia el diagnostico a POSTCIRUGIA.
      if (ubicacionPaciente.equals(CodigoActividadEnum.QUIROFANO))
        diagnosticarPostCirugia(paciente);

      // El ciclo de tratamientos termina cuando no hay unidad destino.
      if (Informe.ubicacionSig == null) {
        darAltaPaciente(paciente);
      } else {
        atenderPaciente(paciente);
      }
    }
  }

  /**
   * Actualiza los campos de la clase interna Informe {@link Informe}
   *
   * @param paciente Paciente cuyo informe se actualiza.
   */
  private static void actualizarInforme(Paciente paciente) {
    Informe.diagnostico = paciente.getExpediente().getDiagnostico();
    Informe.ubicacionPrev = paciente.getUbicacion();
    Informe.ubicacionAct =
        Consultas.obtenerUnidadPorCodActividad(Informe.diagnostico.getUnidadOrigen());
    Informe.ubicacionSig =
        Consultas.obtenerUnidadPorCodActividad(Informe.diagnostico.getUnidadDestino());
  }

  /**
   * Modifica el diagnóstico del paciente a post-cirugía.
   *
   * @param paciente Paciente cuyo diagnóstico hay que modificar.
   */
  private static void diagnosticarPostCirugia(Paciente paciente) {
    paciente.getExpediente().setDiagnostico(DiagnosticosTratamientos.POSTCIRUGIA);
    actualizarInforme(paciente);
  }

  /**
   * Atender a un paciente.
   *
   * @param paciente Paciente al que se atiende.
   */
  private static void atenderPaciente(Paciente paciente) {
    // Se genera una cita para el siguiente paso en el tratamiento.
    final Cita cita = generarCita(paciente);
    if (cita == null) {
      PantallasTerminalDatos.pantallaAvisoNoSeHaPodidoCitarPaciente();
      Consultas.presentar(paciente);
    } else {
      paciente.setCita(cita);
      trasladarPaciente(paciente);
      Informe.generarInforme(paciente);
      paciente.getExpediente().grabarDatos();
    }
  }

  /**
   * Modifica la ubicación del paciente, su estado y si es pertinente se le ingresa en habitación.
   *
   * @param paciente Paciente a trasladar.
   */
  private static void trasladarPaciente(Paciente paciente) {
    // Se traslada al paciente al lugar de la cita vigente.
    paciente.setUbicacion(Informe.ubicacionSig);

    // Actualizar estado del paciente
    if (Informe.ubicacionSig instanceof Consulta)
      paciente.getExpediente().setEstado(Expediente.Estado.EN_CONSULTA);

    if (Informe.ubicacionSig instanceof Quirofano)
      paciente.getExpediente().setEstado(Expediente.Estado.INTERVENIDO);

    if (Informe.ubicacionSig instanceof Habitacion) {
      paciente.getExpediente().setEstado(Expediente.Estado.EN_TRATAMIENTO);
      ((Habitacion) Informe.ubicacionSig).ingresarPaciente(paciente);
    }
  }

  /**
   * Genera una cita para un paciente.
   *
   * @param paciente Paciente para el que se genera la cita.
   * @return Cita.
   */
  private static Cita generarCita(Paciente paciente) {
    ZonedDateTime fechaCita = Utiles.getFechaHoraSistema().plusDays(1L);
    Cita cita = new Cita(fechaCita, paciente, Informe.ubicacionSig);

    // Obtener el sanitario que atenderá al paciente.
    Sanitario sanitario;
    if (Informe.diagnostico.getSanitario().equals(Sanitario.TipoSanitario.MEDICO))
      sanitario = Consultas.obtenerMedicoDeConsulta(Informe.ubicacionSig.getCodigoActividad());
    else if (Informe.diagnostico.getSanitario().equals(Sanitario.TipoSanitario.ENFERMERO))
      sanitario = Consultas.obtenerEnfermeroDeConsulta(Informe.ubicacionSig.getCodigoActividad());
    else sanitario = null;

    boolean citar = (sanitario != null) && sePuedeIngresar();

    if (citar) {
      cita.addSanitario(sanitario);
      return cita;
    } else {
      PantallasTerminalDatos.pantallaAvisoSinSanitario(Informe.ubicacionSig.toString());
      return null;
    }
  }

  /**
   * Determina si es posible ingresar a un paciente destinado a una habitación en planta.
   *
   * @return True si puede ser ingresado.
   */
  private static boolean sePuedeIngresar() {
    if (Informe.ubicacionAct instanceof EnPlanta) {
      EnPlanta enPlanta = (EnPlanta) Informe.ubicacionAct;
      if ((enPlanta.getNumHabitacionesLibres() <= 0))
        PantallasTerminalDatos.pantallaAvisoSinHabitaciones();
      return (enPlanta.getNumHabitacionesLibres() > 0);
    } else {
      return true;
    }
  }

  /**
   * Da de alta a un paciente.
   *
   * @param paciente Paciente al que se da de alta.
   */
  private static void darAltaPaciente(Paciente paciente) {
    boolean externalizado =
        paciente.getExpediente().getDiagnostico().getDiagnostico().contains("Derivación");
    if (externalizado) paciente.getExpediente().setEstado(Expediente.Estado.DERIVADO);
    else paciente.getExpediente().setEstado(Expediente.Estado.SANO);
    paciente.getExpediente().grabarDatos();
    paciente.setCita(null);
    paciente.getExpediente().setDiagnostico(null);
    Informe.generarInforme(paciente);
    trasladarPaciente(paciente);
  }
}
