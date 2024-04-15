package servicio;

import entidad.persona.Medico;
import entidad.persona.Paciente;
import entidad.registro.Cita;
import entidad.registro.Expediente;
import entidad.unidad.medica.consulta.Primaria;
import enumerado.CodigoActividadEnum;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

/** Clase encargada de implementar las acciones (automáticas) propias del servicio médico. */
public final class ServicioMedico {

  /**
   * Da cita a los nuevos pacientes que carecen de cita, derivándolos directamente a consulta
   * primaria.
   */
  static void atenderPacientes() {
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

    // Si no existe consulta primaria, se crea.
    if (consutaPrimaria == null) {
      consutaPrimaria = new Primaria(CodigoActividadEnum.CONSULTA_PRIMARIA.getDescripcion());
      LogicaTerminalDatos.getHospital().registrarUnidad(consutaPrimaria);
    }

    // Si hay médico en consulta primaria, y hay pacientes, se les da cita.
    if (!medicos.isEmpty() && !pacientes.isEmpty()) {
      // Se da cita para el dia siguiente (valor arbitrario).
      ZonedDateTime fechaCita = ZonedDateTime.now().plusDays(1L);
      Cita citaCP;
      PantallasTerminalDatos.pantallaInfoCitaPacientesNuevos();
      for (Paciente p : pacientes) {
        citaCP = new Cita(fechaCita, p, consutaPrimaria);
        p.setCita(citaCP);
        p.getExpediente().setEstado(Expediente.Estado.CITADO);
        // Mostrar por pantalla.
        Consultas.presentar(p);
        Consultas.printAgenda("..",p.getCita());
      }
    }
  }
}
