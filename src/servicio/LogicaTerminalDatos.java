package servicio;

import entidad.Hospital;
import entidad.persona.Personal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Clase encargada de la lógica de interacción entre pantallas del terminal de datos. */
public final class LogicaTerminalDatos {

  private static Hospital hospital;

  /** Constructor de LogicaTerminalDatos. */
  private LogicaTerminalDatos() {
    // Constructor vacío
  }

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
      case "2": // 2. Servicios de Mantenimiento
        // TODO: meter algo
        break;
      case "3": // 3. Servicios Médicos
        // TODO: importante implementarlo
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
        // TODO: hacer gestión de pacientes
        break;
      case "3": // 3. Gestión Contable
        // TODO: lo que toque aquí
        break;
      case "4": // 4. Gestión mantenimiento
        // TODO: meter alguna historia
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

  static Hospital getHospital() {
    return hospital;
  }

  static void registrarPersonal(Personal personal) {
    hospital.registrarPersonal(personal);
  }

  static void borrarPersonal(Personal personal) {
    hospital.borrarPersonal(personal);
  }
}
