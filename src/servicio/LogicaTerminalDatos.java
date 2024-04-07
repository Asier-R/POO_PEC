package servicio;

/** Clase encargada de la lógica de interacción entre pantallas del terminal de datos. */
public final class LogicaTerminalDatos {

  /** Constructor de LogicaTerminalDatos. */
  private LogicaTerminalDatos() {
    // Constructor vacío
  }

  public static void iniciarLogicaTerminalDatos() {
    Utiles.abrirLectorDeEntradas();
    pantallaInicio();
  }

  /** Lógica de pantalla 0. INICIO */
  static void pantallaInicio() {
    PantallasTerminalDatos.pantallaInicio();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Gerencia y Administración
        pantallaGerencia();
        break;
      case "2": // 2. Servicios de Mantenimiento
        break;
      case "3": // 3. Servicios Médicos
        break;
      case "X": // X. Volver. En este punto es igual a finalizar.
        if (!finPrograma()) pantallaInicio();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaInicio();
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
        pantallaGestionPersonal();
        break;
      case "2": // 2. Gestión de pacientes
        break;
      case "3": // 3. Gestión Contable
        break;
      case "4": // 4. Gestión mantenimiento
        break;
      case "X": // X. Volver a 0. INICIO
        pantallaInicio();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaGerencia();
        break;
      default: // Permanecer en la pantalla
        pantallaGerencia();
        break;
    }
  }

  /** Lógica de pantalla 1.1. GESTIÓN DEL PERSONAL */
  static void pantallaGestionPersonal() {
    PantallasTerminalDatos.pantallaGestionPersonal();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Alta
        pantallaGestionPersonalAlta();
        break;
      case "2": // 2. Baja
        break;
      case "3": // 3. Gestión
        break;
      case "X": // X. Volver a 1. GERENCIA
        pantallaGerencia();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaGestionPersonal();
        break;
      default: // Permanecer en la pantalla
        pantallaGestionPersonal();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1. GESTIÓN DE ALTAS DE PERSONAL */
  static void pantallaGestionPersonalAlta() {
    PantallasTerminalDatos.pantallaGestionPersonalAlta();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Alta de administrativos
        pantallaAltaAdministrativo();
        break;
      case "2": // 2. Alta de personal de mantenimiento y servicio
        pantallaAltaMantenimientoServicio();
        break;
      case "3": // 3. Alta de estudiantes
        break;
      case "4": // 4. Alta de enfermeros
        break;
      case "5": // 5. Alta de médicos
        break;
      case "X": // X. Volver a 1.1. GESTIÓN DEL PERSONAL
        pantallaGestionPersonal();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaGestionPersonalAlta();
        break;
      default: // Permanecer en la pantalla
        pantallaGestionPersonalAlta();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1.1. ALTAS DE ADMINISTRATIVO */
  static void pantallaAltaAdministrativo() {
    PantallasTerminalDatos.pantallaAltaAdministrativo();
    AltaBajaPersona.iniciarAdmin(); // Se inicia tipo de persona para poder mostrar sus datos
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        AltaBajaPersona.NIF = Utiles.inputNIF();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        AltaBajaPersona.nombre = Utiles.inputNombre();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        AltaBajaPersona.apellido1 = Utiles.inputApellido1();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        AltaBajaPersona.apellido2 = Utiles.inputApellido2();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código actividad
        AltaBajaPersona.codigoActividad = Utiles.inputCodActividad();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar grupo administrativo
        AltaBajaPersona.grupo = Utiles.inputGrupoAdmin();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Mostrar datos
        AltaBajaPersona.mostrarDatosPersona();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "8": // 8. Finalizar Alta
        AltaBajaPersona.validarGrabarAdministrador(); // Validación y alta
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaAltaAdministrativo();
        break;
      default: // Permanecer en la pantalla
        pantallaAltaAdministrativo();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1.2. ALTAS DE PERSONAL DE MANTENIMIENTO Y SERVICIO */
  static void pantallaAltaMantenimientoServicio() {
    PantallasTerminalDatos.pantallaAltaMantenimientoServicio();
    AltaBajaPersona.iniciarMantenimientoServicio();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        AltaBajaPersona.NIF = Utiles.inputNIF();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        AltaBajaPersona.nombre = Utiles.inputNombre();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        AltaBajaPersona.apellido1 = Utiles.inputApellido1();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        AltaBajaPersona.apellido2 = Utiles.inputApellido2();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código área
        AltaBajaPersona.codigoArea = Utiles.inputCodArea();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar código actividad
        AltaBajaPersona.codigoActividad = Utiles.inputCodActividad();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Mostrar datos
        AltaBajaPersona.mostrarDatosPersona();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "8": // 8. Finalizar Alta
        AltaBajaPersona.validarGrabarMantenimientoServicio(); // Validación y alta
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!finPrograma()) pantallaAltaMantenimientoServicio();
        break;
      default: // Permanecer en la pantalla
        pantallaAltaMantenimientoServicio();
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
      Utiles.cerrarLectorDeEntradas();
      return true;
    }
    return false;
  }
}
