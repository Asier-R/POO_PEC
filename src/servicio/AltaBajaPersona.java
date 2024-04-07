package servicio;

import entidad.persona.Administrativo;
import entidad.persona.Estudiante;
import entidad.persona.MantenimientoServicio;
import entidad.persona.Persona;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

/** Clase encargada de la gestión de altas y bajas de personas. */
public final class AltaBajaPersona {

  //private static final String STR_NIF = "NIF";
  //private static final String STR_NOMBRE = "Nombre";
  //private static final String STR_APELLIDO1 = "Primer apellido";
  //private static final String STR_APELLIDO2 = "Segundo apellido";
  //private static final String STR_COD_UNIDAD = "Código unidad";
  //private static final String STR_COD_AREA = "Código área";
  //private static final String STR_COD_ACTIVIDAD = "Código actividad";
  //private static final String STR_COD_ESPECIALIDAD = "Especialidad";
  //private static final String STR_COD_SEGUNDAESPECIALIDAD = "Segunda especialidad";
  //private static final String STR_COD_GRUPO = "Grupo administrativo";
  //private static final String STR_EXPERIENCIA = "Experiencia";
  //private static final String STR_CENTRO = "Nombre del centro";

  /** Variable temporal para conservar los datos de una persona */
  private static Persona tmpPersona;

  /** Variable temporal para conservar el NIF de una persona */
  static String NIF;

  /** Variable temporal para conservar el nombre de una persona */
  static String nombre;

  /** Variable temporal para conservar el primer apellido de una persona */
  static String apellido1;

  /** Variable temporal para conservar el segundo apellido de una persona */
  static String apellido2;

  /** Variable temporal para conservar el código de unidad */
  static CodigoUnidadEnum codigoUnidad;

  /** Variable temporal para conservar el código de área */
  static CodigoAreaEnum codigoArea;

  /** Variable temporal para conservar el código de actividad */
  static CodigoActividadEnum codigoActividad;

  /** Variable temporal para conservar el código de especialidad */
  static CodigoEspecialidadEnum codigoEspecialidad;

  /** Variable temporal para conservar el código de la segunda especialidad */
  static CodigoEspecialidadEnum codigoSegundaEspecialidad;

  /** Variable temporal para conservar la experiencia del sanitario */
  static int experiencia;

  /** Variable temporal para conservar el nombre del centro del estudiante */
  static String nombreCentro;

  /** Variable temporal para conservar el grupo administrativo de una persona */
  static Administrativo.Grupo grupo;

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS PERSONA
  ------------------------------------------------------------------------------------------------------------------ */

  static void iniciarAdmin() {
    tmpPersona = new Administrativo(NIF, nombre, apellido1, apellido2, codigoActividad, grupo);
  }

  static void validarGrabarAdministrador() {
    String falta = "";
    falta = validarCamposComunes(falta);
    falta = validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(grupo, falta, Utiles.STR_COD_GRUPO);

    if (falta.isEmpty()) {
      iniciarAdmin();
      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        AltaBajaPersona.grabarPersona();
        LogicaTerminalDatos.pantallaGestionPersonalAlta();
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
      LogicaTerminalDatos.pantallaAltaAdministrativo();
    }
  }

  static void iniciarMantenimientoServicio() {
    tmpPersona =
        new MantenimientoServicio(NIF, nombre, apellido1, apellido2, codigoArea, codigoActividad);
  }

  static void validarGrabarMantenimientoServicio() {
    String falta = "";
    falta = validarCamposComunes(falta);
    falta = validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);

    if (falta.isEmpty()) {
      iniciarMantenimientoServicio();
      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        AltaBajaPersona.grabarPersona();
        LogicaTerminalDatos.pantallaGestionPersonalAlta();
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
      LogicaTerminalDatos.pantallaAltaMantenimientoServicio();
    }
  }

  static void iniciarEstudiante() {
    tmpPersona =
        new Estudiante(
            NIF,
            nombre,
            apellido1,
            apellido2,
            codigoArea,
            codigoActividad,
            codigoEspecialidad,
            experiencia,
            nombreCentro);
  }

  static void validarGrabarEstudiante() {
    String falta = "";
    falta = validarCamposComunes(falta);
    falta = validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(codigoEspecialidad, falta, Utiles.STR_COD_ESPECIALIDAD);
    falta = validarCampoNumero(experiencia, falta, Utiles.STR_EXPERIENCIA);

    if (falta.isEmpty()) {
      iniciarEstudiante();
      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        AltaBajaPersona.grabarPersona();
        LogicaTerminalDatos.pantallaGestionPersonalAlta();
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
      LogicaTerminalDatos.pantallaAltaEstudiante();
    }
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  private static String validarCamposComunes(String falta) {
    falta = validarCampo(NIF, falta, Utiles.STR_NIF);
    falta = validarCampo(nombre, falta, Utiles.STR_NOMBRE);
    falta = validarCampo(apellido1, falta, Utiles.STR_APELLIDO1);
    falta = validarCampo(apellido2, falta, Utiles.STR_APELLIDO2);
    return falta;
  }

  static void grabarPersona() {
    if (tmpPersona != null) {
      LecturaEscrituraFichero.grabarPersona(tmpPersona);
      resetCampos();
      tmpPersona = null;
    }
  }

  static void mostrarDatosPersona() {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(tmpPersona);
  }

  private static String validarCampo(String dato, String falta, String campo) {
    if (dato == null || dato.isEmpty() || dato.isBlank()) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  private static String validarCampoNumero(int dato, String falta, String campo) {
    if (dato < 0) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  private static String validarCampoEnum(Enum dato, String falta, String campo) {
    if (dato == null) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  private static void resetCampos() {
    NIF = null;
    nombre = null;
    apellido1 = null;
    apellido2 = null;
    codigoUnidad = null;
    codigoArea = null;
    codigoActividad = null;
    grupo = null;
  }
}
