package servicio;

import entidad.Hospital;
import entidad.persona.Paciente;
import entidad.persona.Personal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Clase encargada de la lógica de interacción entre pantallas del terminal de datos. */
public final class LogicaTerminalDatos {

  private static Hospital hospital;

  /** Constructor de LogicaTerminalDatos. */
  private LogicaTerminalDatos() {
    // Constructor vacío
  }

  /** Incializa la instancia del hospital con los datos almacenados en los ficheros csv. */
  public static void iniciarLogicaTerminalDatos() {
    hospital = LecturaEscrituraFichero.iniciarHospital();
    Utiles.abrirLectorDeEntradas();
    pantallaInicio();
    Utiles.cerrarLectorDeEntradas();
  }

  /** Lógica de pantalla 0. INICIO */
  static void pantallaInicio() {
    PantallasTerminalDatos.pantallaInicio();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Gerencia y Administración
        pantallaGerencia();
        break;
      case "2": // 2. Servicios Médicos
        pantallaServiciosMedicos();
        break;
      case "X": // X. Volver. En este punto es igual a finalizar.
        if (!finPrograma()) pantallaInicio();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaInicio();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaInicio();
        break;
    }
  }

  /** Lógica de pantalla 1. GERENCIA */
  static void pantallaGerencia() {
    PantallasTerminalDatos.pantallaGerencia();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Gestión del personal
        LTDGerencia.pantallaGestionPersonal();
        break;
      case "2": // 2. Gestión de pacientes
        LTDGerencia.pantallaGestionPacientes();
        break;
      case "3": // 3. Gestión Contable
        // TODO: opcional
        break;
      case "4": // 4. Gestión mantenimiento
        // TODO: opcional
        break;
      case "X": // X. Volver a 0. INICIO
        pantallaInicio();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaGerencia();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaGerencia();
        break;
    }
  }

  /** Lógica de pantalla 2. SERVICIOS MÉDICOS */
  static void pantallaServiciosMedicos() {
    PantallasTerminalDatos.pantallaServiciosMedicos();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Atender nuevos pacientes
        ServicioMedico.atenderPacientes();
        pantallaServiciosMedicos();
        break;
      case "2": // 2. Actualizar expedientes
        ServicioMedico.actualizarExpedientes();

        // TODO: probablemente automatico y mostrar por pantalla las actualizacions (pedir fecha para actualizar los previos)
        // TODO: los pacientes derivados a consulta primaria son diagnosticados de forma random
        // TODO: los pacientes que han sido diagnosticados son derivados a la unidad que sea o fuera del hospital
        // TODO: ¿meter alta sanitaria del paciente? Si, hay campo estado en el expediente
        break;
      case "3": // 3. Consultar ocupación

        break;
      case "4": // 4. Consultar pacientes ingresados

        break;
      case "5": // 5. Consultar pacientes con cita en consulta externa

        break;
      case "6": // 6. Consultar pacientes con cita con un especialista

        break;
      case "X": // X. Volver a 0. INICIO
        pantallaInicio();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaGerencia();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaGerencia();
        break;
    }
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Finaliza el programa.
   *
   * @return True si se quiere finalizar el programa.
   */
  static boolean finPrograma() {
    PantallasTerminalDatos.pantallaFin();
    PantallasTerminalDatos.pantallaConfirmacion();
    String opt = Utiles.leerLinea().toUpperCase();
    if (opt.equals(Utiles.SI)) {
      pantallaCierre();
      return true;
    }
    return false;
  }

  /** Actualiza los csv con los datos actuales del hospital. */
  static void pantallaCierre() {
    LecturaEscrituraFichero.actualizarDatos(
        Stream.concat(hospital.getPersonal().stream(), hospital.getPacientes().stream())
            .collect(Collectors.toList()));
  }

  /**
   * Devuelve el hospital.
   *
   * @return Hospital.
   */
  static Hospital getHospital() {
    return hospital;
  }

  /**
   * Registra un nuevo miembro del personal hospitalario.
   *
   * @param personal Personal a registrar.
   */
  static void registrarPersonal(Personal personal) {
    hospital.registrarPersonal(personal);
  }

  /**
   * Registra un nuevo paciente en el hospital.
   *
   * @param paciente Paciente a registrar.
   */
  static void registrarPaciente(Paciente paciente) {
    hospital.registrarPaciente(paciente);
  }

  /**
   * Borra un miembro del personal hospitalario.
   *
   * @param personal Personal a borrar.
   */
  static void borrarPersonal(Personal personal) {
    hospital.borrarPersonal(personal);
  }

  /**
   * Borra un paciente del hospital.
   *
   * @param paciente Paciente a borrar.
   */
  static void borrarPaciente(Paciente paciente) {
    hospital.borrarPaciente(paciente);
  }
}
