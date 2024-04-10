package servicio;

import entidad.persona.*;

/**
 * Clase encargada de la lógica de interacción entre pantallas de consultas del terminal de datos.
 */
public final class LTDConsulta {

  /** Pantalla de consulta de personas. */
  static void pantallaConsultaPersonas() {
    PantallasTerminalDatos.pantallaConsultaPersonas();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. NIF
        Consultas.consultarPorNIF(Utiles.inputNIF());
        break;
      case "2": // 2. Nombre
        Consultas.consultarPorNombre(Utiles.inputNombre());
        break;
      case "3": // 3. Primer apellido
        Consultas.consultarPorPrimerApellido(Utiles.inputApellido1());
        break;
      case "4": // 4. Segundo apellido
        Consultas.consultarPorSegundoApellido(Utiles.inputApellido2());
        break;
      case "5": // 5. Código unidad
        Consultas.consultarPorCodigoUnidad(Utiles.inputCodUnidad());
        break;
      case "6": // 6. Código área
        Consultas.consultarPorCodigoArea(Utiles.inputCodArea());
        break;
      case "7": // 7. Código actividad
        Consultas.consultarPorCodigoActividad(Utiles.inputCodActividad());
        break;
      case "8": // 8. Código especialidad
        Consultas.consultarPorCodigoEspecialidad(Utiles.inputCodEspecialidad());
        break;
      case "9": // 9. Código segunda especialidad
        Consultas.consultarPorCodigoSegundaEspecialidad(Utiles.inputCodEspecialidad());
        break;
      case "10": // 10. Experiencia
        Consultas.consultarPorExperiencia(Utiles.inputExperiencia());
        break;
      case "11": // 11. Nombre centro
        Consultas.consultarPorCodigoActividad(Utiles.inputCodActividad());
        break;
      case "X": // X. Volver
        // No hace falta nada
        return;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaConsultaPersonas();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaConsultaPersonas();
        break;
    }
  }

  /** Pantalla de consulta de personal. */
  static void pantallaConsultaPersonal(Class<? extends Persona> persona) {
    if (persona.equals(Paciente.class)) {
      Consultas.consultarPacientes();
    } else if (persona.equals(Administrativo.class)) {
      Consultas.consultarAdministrativos();
    } else if (persona.equals(MantenimientoServicio.class)) {
      Consultas.consultarMantenimientoServicio();
    } else if (persona.equals(Medico.class)) {
      Consultas.consultarMedicos();
    } else if (persona.equals(Enfermero.class)) {
      Consultas.consultarEnfermeros();
    } else { // Estudiante
      Consultas.consultarEstudiantes();
    }
  }

  static void pantallaConsultaCualquierPersona(){
    PantallasTerminalDatos.pantallaConsultaCualquierPersona();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Consultar personal administrativo
        LTDConsulta.pantallaConsultaPersonal(Administrativo.class);
        pantallaConsultaCualquierPersona();
        break;
      case "2": // 2. Consultar personal de mantenimiento y servicio
        LTDConsulta.pantallaConsultaPersonal(MantenimientoServicio.class);
        pantallaConsultaCualquierPersona();
        break;
      case "3": // 3. Consultar estudiantes
        LTDConsulta.pantallaConsultaPersonal(Estudiante.class);
        pantallaConsultaCualquierPersona();
        break;
      case "4": // 4. Consultar enfermeros
        LTDConsulta.pantallaConsultaPersonal(Enfermero.class);
        pantallaConsultaCualquierPersona();
        break;
      case "5": // 5. Consultar médicos
        LTDConsulta.pantallaConsultaPersonal(Medico.class);
        pantallaConsultaCualquierPersona();
        break;
      case "6": // 6. Consultar pacientes
        LTDConsulta.pantallaConsultaPersonal(Paciente.class);
        pantallaConsultaCualquierPersona();
        break;
      case "7": // 7. Otros Criterios
        LTDConsulta.pantallaConsultaPersonas();
        pantallaConsultaCualquierPersona();
        break;
      case "X": // X. Volver
        // No hace falta nada
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaConsultaCualquierPersona();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaConsultaCualquierPersona();
        break;
    }
  }
}
