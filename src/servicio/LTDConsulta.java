package servicio;

/**
 * Clase encargada de la lógica de interacción entre pantallas de consultas del terminal de datos.
 */
public final class LTDConsulta {

  /** Pantalla de consulta de personal. */
  static void pantallaConsultaPersonal() {
    PantallasTerminalDatos.pantallaConsultaComun();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. NIF
        PantallasTerminalDatos.pantallaCriterioConsulta(Utiles.STR_NIF);
        Consultas.consultarPorNIF(Utiles.inputNIF());
        break;
      case "2": // 2. Nombre
        PantallasTerminalDatos.pantallaCriterioConsulta(Utiles.STR_NOMBRE);
        Consultas.consultarPorNombre(Utiles.inputNombre());
        break;
      case "3": // 3. Primer apellido
        PantallasTerminalDatos.pantallaCriterioConsulta(Utiles.STR_APELLIDO1);
        Consultas.consultarPorPrimerApellido(Utiles.inputApellido1());
        break;
      case "4": // 4. Segundo apellido
        PantallasTerminalDatos.pantallaCriterioConsulta(Utiles.STR_APELLIDO2);
        Consultas.consultarPorSegundoApellido(Utiles.inputApellido2());
        break;
      case "5": // 5. Código unidad
        PantallasTerminalDatos.pantallaCriterioConsulta(Utiles.STR_COD_UNIDAD);
        Consultas.consultarPorCodigoUnidad(Utiles.inputCodUnidad());
        break;
      case "6": // 6. Código área
        PantallasTerminalDatos.pantallaCriterioConsulta(Utiles.STR_COD_AREA);
        Consultas.consultarPorCodigoArea(Utiles.inputCodArea());
        break;
      case "7": // 7. Código actividad
        PantallasTerminalDatos.pantallaCriterioConsulta(Utiles.STR_COD_ACTIVIDAD);
        Consultas.consultarPorCodigoActividad(Utiles.inputCodActividad());
        break;
      case "X": // X. Volver
        return;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaConsultaPersonal();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaConsultaPersonal();
        break;
    }
  }



}
