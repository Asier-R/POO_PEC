package servicio;

import entidad.Hospital;
import entidad.persona.Paciente;
import entidad.persona.Personal;
import entidad.persona.Sanitario;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Clase encargada de la lógica de interacción entre pantallas del terminal de datos. */
public final class LogicaTerminalDatos {

  private static Hospital hospital;

  private static Sanitario sanitario;
  private static ZonedDateTime fechaDesde;
  private static ZonedDateTime fechaHasta;

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
        LTDGerencia.pantallaGestionContable();
        break;
      //case "4": // 4. Gestión mantenimiento
      //  // TODO: opcional
      //  break;
      case "4": // 4. Consultar empleados del sistema
        Consultas.consultarEmpleadosDelSistema();
        pantallaGerencia();
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
        pantallaServiciosMedicos();
        break;
      case "3": // 3. Consultar ocupación
        Consultas.consultarOcupacion();
        pantallaServiciosMedicos();
        break;
      case "4": // 4. Consultar pacientes ingresados
        Consultas.consultarPacientesIngresados();
        pantallaServiciosMedicos();
        break;
      case "5": // 5. Consultar pacientes con cita en consulta externa
        pantallaConsultarPacientesCitaConsultaExterna();
        pantallaServiciosMedicos();
        break;
      case "6": // 6. Consultar pacientes con cita con un especialista
        pantallaConsultarPacientesCitaConEspecialista();
        pantallaServiciosMedicos();
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

  /** Lógica de pantalla 2.5. CONSULTAR PACIENTES CON CITA PARA CONSULTA EXTERNA */
  static void pantallaConsultarPacientesCitaConsultaExterna() {
    PantallasTerminalDatos.pantallaConsultarPacientesCitaConsultaExterna();
    PantallasTerminalDatos.pantallaConsultarPeriodo();

    String opt = Utiles.leerLinea().toUpperCase();
    switch (opt) {
      case "X": // X. Volver a 2. SERVICIOS MÉDICOS
        pantallaServiciosMedicos();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaServiciosMedicos();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // 1. Día específico.  2. Semana (un día específico y los siguientes seís). 3. Entre fechas.
        seleccionarRango(opt);
        Consultas.consultarPacientesCitaConsultaExterna(fechaDesde, fechaHasta);
        pantallaConsultarPacientesCitaConsultaExterna();
        break;
    }
  }

  /** Lógica de pantalla 2.6. CONSULTAR PACIENTE CON CITA CON ESPECIALISTA */
  static void pantallaConsultarPacientesCitaConEspecialista(){
    PantallasTerminalDatos.pantallaConsultarPacientesCitaConEspecialista();

    String opt = Utiles.leerLinea().toUpperCase();
    switch (opt) {
      case "1": // 1. Seleccionar especialista por NIF.
        sanitario = Consultas.consultarEspecialistaPorNIF(Utiles.inputNIF());
        pantallaConsultarPacientesCitaConEspecialista();
        break;
      case "2": // 2. Seleccionar rango de consulta.
        PantallasTerminalDatos.pantallaConsultarPeriodo();
        seleccionarRango(Utiles.leerLinea().toUpperCase());
        pantallaConsultarPacientesCitaConEspecialista();
        break;
      case "3": // 3. Ejecutar consulta
        Consultas.consultarPacientesCitaConEspecialista(sanitario, fechaDesde, fechaHasta);
        pantallaConsultarPacientesCitaConEspecialista();
        break;
      case "4": // 4. Consultar personas
        LTDConsulta.pantallaConsultaCualquierPersona();
        pantallaConsultarPacientesCitaConEspecialista();
        break;
      case "X": // X. Volver a 2. SERVICIOS MÉDICOS
        pantallaServiciosMedicos();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaServiciosMedicos();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        System.out.println("> INFO: Opción '" + opt + "' no válida...");
        pantallaConsultarPacientesCitaConEspecialista();
        break;
    }
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Permite seleccionar una opción de rango para fechas.
   *  Opciones:
   *  1. Día específico.
   *  2. Semana (un día específico y los siguientes seís).
   *  3. Entre fechas.
   * @param opt Opción a seleccionar.
   */
  private static void seleccionarRango(String opt){
    switch (opt) {
      case "1": // 1. Día específico.
        fechaDesde = Utiles.inputFecha().truncatedTo(ChronoUnit.DAYS);
        fechaHasta = fechaDesde.plusDays(1L);
        break;
      case "2": // 2. Semana (un día específico y los siguientes seís).
        fechaDesde = Utiles.inputFecha().truncatedTo(ChronoUnit.DAYS);
        fechaHasta = fechaDesde.plusWeeks(1L);
        break;
      case "3": //  3. Entre fechas.
        System.out.println(">> FECHA DESDE");
        fechaDesde = Utiles.inputFecha();
        System.out.println(">> FECHA HASTA");
        fechaHasta = Utiles.inputFecha();
        break;
      default: // Permanecer en la pantalla
        System.out.println("> INFO: Opción '" + opt + "' no válida...");
        break;
    }
  }

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
