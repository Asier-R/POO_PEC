package servicio.terminalDatos;

import entidad.persona.Administrativo;
import entidad.persona.Persona;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;
import servicio.LecturaEscrituraFichero;

import java.util.Scanner;

/** Clase encargada de la lógica de interacción entre pantallas del terminal de datos. */
public class LogicaTerminalDatos {

  private static final String STR_NIF = "NIF";
  private static final String STR_NOMBRE = "Nombre";
  private static final String STR_APELLIDO1 = "Primer apellido";
  private static final String STR_APELLIDO2 = "Segundo apellido";
  private static final String STR_COD_UNIDAD = "Código unidad";
  private static final String STR_COD_AREA = "Código área";
  private static final String STR_COD_ACTIVIDAD = "Código actividad";
  private static final String STR_COD_ESPECIALIDAD = "Especialidad";
  private static final String STR_COD_SEGUNDAESPECIALIDAD = "Segunda especialidad";
  private static final String STR_COD_GRUPO = "Grupo administrativo";
  private static final String STR_EXPERIENCIA = "Experiencia";

  /** Variable temporal para conservar los datos de una persona */
  private Persona tmpPersona;

  /** Variable temporal para conservar el NIF de una persona */
  private String NIF;

  /** Variable temporal para conservar el nombre de una persona */
  private String nombre;

  /** Variable temporal para conservar el primer apellido de una persona */
  private String apellido1;

  /** Variable temporal para conservar el segundo apellido de una persona */
  private String apellido2;

  /** Variable temporal para conservar el código de unidad */
  private CodigoUnidadEnum codigoUnidad;

  /** Variable temporal para conservar el código de área */
  private CodigoAreaEnum codigoArea;

  /** Variable temporal para conservar el código de actividad */
  private CodigoActividadEnum codigoActividad;

  /** Variable temporal para conservar el grupo administrativo de una persona */
  private Administrativo.Grupo grupo;

  /** Pantallas del terminal de datos. */
  private PantallasTerminalDatos pantallasTerminalDatos;

  /** Lector de input de usuario. */
  private Scanner reader;

  /** Constructor de LogicaTerminalDatos. */
  public LogicaTerminalDatos() {
    this.pantallasTerminalDatos = new PantallasTerminalDatos();
    reader = new Scanner(System.in);
    pantallaInicio();
  }

  /** Lógica de pantalla 0. INICIO */
  private void pantallaInicio() {
    pantallasTerminalDatos.pantallaInicio();
    String opt = leerLinea().toUpperCase();

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
  private void pantallaGerencia() {
    pantallasTerminalDatos.pantallaGerencia();
    String opt = leerLinea().toUpperCase();

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
  private void pantallaGestionPersonal() {
    pantallasTerminalDatos.pantallaGestionPersonal();
    String opt = leerLinea().toUpperCase();

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
  private void pantallaGestionPersonalAlta() {
    pantallasTerminalDatos.pantallaGestionPersonalAlta();
    String opt = leerLinea().toUpperCase();

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
  private void pantallaAltaAdministrativo() {
    pantallasTerminalDatos.pantallaAltaAdministrativo();
    String opt = leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        inputNIF();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        inputNombre();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        inputApellido1();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        inputApellido2();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código actividad
        inputCodActividad();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar grupo administrativo
        inputGrupoAdmin();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Finalizar Alta
        validarGrabarAdministrador();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
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
  private void pantallaAltaMantenimientoServicio() {
    pantallasTerminalDatos.pantallaAltaAdministrativo();
    String opt = leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        inputNIF();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        inputNombre();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        inputApellido1();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        inputApellido2();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código actividad
        inputCodActividad();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar grupo administrativo
        inputGrupoAdmin();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Finalizar Alta
        validarGrabarAdministrador();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
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

  private void validarGrabarAdministrador() {
    String falta = "";
    falta = validarCampo(NIF, falta, STR_NIF);
    falta = validarCampo(nombre, falta, STR_NOMBRE);
    falta = validarCampo(apellido1, falta, STR_APELLIDO1);
    falta = validarCampo(apellido2, falta, STR_APELLIDO2);
    falta = validarCampoEnum(codigoActividad, falta, STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(grupo, falta, STR_COD_GRUPO);

    if (falta.isEmpty()) {
      tmpPersona = new Administrativo(NIF, nombre, apellido1, apellido2, codigoActividad, grupo);
      resetCampos();
      LecturaEscrituraFichero.grabarPersona(tmpPersona);
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
  }

  private String validarCampo(String dato, String falta, String campo) {
    if (dato == null || dato.isEmpty() || dato.isBlank()) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  private String validarCampoEnum(Enum dato, String falta, String campo) {
    if (dato == null) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  private void resetCampos(){
    this.tmpPersona = null;
    this.NIF = null;
    this.nombre = null;
    this.apellido1 = null;
    this.apellido2 = null;
    this.codigoUnidad = null;
    this.codigoArea = null;
    this.codigoActividad = null;
    this.grupo = null;
    this.pantallasTerminalDatos = null;
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS COMUNES
  ------------------------------------------------------------------------------------------------------------------ */

  /** Método para obtener el NIF de la persona. */
  private void inputNIF() {
    pantallasTerminalDatos.pantallaIntroducirDato(STR_NIF);
    this.NIF = leerLinea().toUpperCase();
  }

  /** Método para obtener el nombre de la persona. */
  private void inputNombre() {
    pantallasTerminalDatos.pantallaIntroducirDato(STR_NOMBRE);
    this.nombre = leerLinea();
  }

  /** Método para obtener el primer apellido de la persona. */
  private void inputApellido1() {
    pantallasTerminalDatos.pantallaIntroducirDato(STR_APELLIDO1);
    this.apellido1 = leerLinea();
  }

  /** Método para obtener el segundo apellido de la persona. */
  private void inputApellido2() {
    pantallasTerminalDatos.pantallaIntroducirDato(STR_APELLIDO2);
    this.apellido2 = leerLinea();
  }

  /** Método para obtener el código de unidad. */
  private void inputCodUnidad() {
    pantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_UNIDAD);
    CodigoUnidadEnum.mostrarPorPantalla();
    int opt = leerNumero();
    CodigoUnidadEnum cod = CodigoUnidadEnum.getFromId(opt);
    if(cod != null) this.codigoUnidad = cod;
  }

  /** Método para obtener el código de área. */
  private void inputCodArea() {
    pantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_AREA);
    CodigoAreaEnum.mostrarPorPantalla();
    int opt = leerNumero();
    CodigoAreaEnum cod = CodigoAreaEnum.getFromId(opt);
    if(cod != null) this.codigoArea = cod;
  }

  /** Método para obtener el código de área. */
  private void inputCodActividad() {
    pantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_AREA);
    CodigoActividadEnum.mostrarPorPantalla();
    int opt = leerNumero();
    CodigoActividadEnum cod = CodigoActividadEnum.getFromId(opt);
    if(cod != null) this.codigoActividad = cod;
  }

  /** Método para obtener el grupo administrativo. */
  private void inputGrupoAdmin() {
    pantallasTerminalDatos.pantallaIntroducirDato(STR_COD_GRUPO);
    Administrativo.Grupo.mostrarPorPantalla();
    int opt = leerNumero();
    Administrativo.Grupo grupo = Administrativo.Grupo.getFromId(opt);
    if(grupo != null) this.grupo = grupo;
  }

  /**
   * Método común para leer input de usuario.
   *
   * @return Cadena de texto del input de usuario.
   */
  private String leerLinea() {
    //reader = new Scanner(System.in);
    return reader.nextLine();
  }

  /**
   * Método común para leer input de usuario.
   *
   * @return Cadena de texto del input de usuario.
   */
  private int leerNumero() {
    int num = -1;
    try {
      num = reader.nextInt();
    } catch (Exception e) {
      System.out.println("> Opción no válida...");
    }
    return num;
  }

  /**
   * Finaliza el programa.
   *
   * @return True si se quiere finalizar el programa.
   */
  private boolean finPrograma() {
    pantallasTerminalDatos.pantallaFin();
    pantallasTerminalDatos.pantallaConfirmacion();
    String opt = leerLinea().toUpperCase();
    if (opt.equals("S")) {
      reader.close();
      return true;
    }
    return false;
  }
}
