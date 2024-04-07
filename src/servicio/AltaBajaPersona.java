package servicio;

import entidad.persona.*;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.NoSuchElementException;

/** Clase encargada de la gestión de altas y bajas de personas. */
public final class AltaBajaPersona {

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
     MÉTODOS ALTA PERSONA
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
        LTDGerencia.pantallaGestionPersonalAlta();
        return;
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaAltaAdministrativo();
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
        LTDGerencia.pantallaGestionPersonalAlta();
        return;
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaAltaMantenimientoServicio();
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
    falta = validarCampo(nombreCentro, falta, Utiles.STR_CENTRO);

    if (falta.isEmpty()) {
      iniciarEstudiante();
      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        AltaBajaPersona.grabarPersona();
        LTDGerencia.pantallaGestionPersonalAlta();
        return;
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaAltaEstudiante();
  }

  static void iniciarEnfermero() {
    tmpPersona =
        new Enfermero(
            NIF,
            nombre,
            apellido1,
            apellido2,
            codigoArea,
            codigoActividad,
            codigoEspecialidad,
            experiencia);
  }

  static void validarGrabarEnfermero() {
    String falta = "";
    falta = validarCamposComunes(falta);
    falta = validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(codigoEspecialidad, falta, Utiles.STR_COD_ESPECIALIDAD);
    falta = validarCampoNumero(experiencia, falta, Utiles.STR_EXPERIENCIA);

    if (falta.isEmpty()) {
      iniciarEnfermero();
      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        AltaBajaPersona.grabarPersona();
        LTDGerencia.pantallaGestionPersonalAlta();
        return;
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaAltaEnfermero();
  }

  static void iniciarMedico() {
    tmpPersona =
        new Medico(
            NIF,
            nombre,
            apellido1,
            apellido2,
            codigoArea,
            codigoActividad,
            codigoEspecialidad,
            codigoSegundaEspecialidad,
            experiencia);
  }

  static void validarGrabarMedico() {
    String falta = "";
    falta = validarCamposComunes(falta);
    falta = validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = validarCampoEnum(codigoEspecialidad, falta, Utiles.STR_COD_ESPECIALIDAD);
    falta = validarCampoEnum(codigoSegundaEspecialidad, falta, Utiles.STR_COD_SEGUNDAESPECIALIDAD);
    falta = validarCampoNumero(experiencia, falta, Utiles.STR_EXPERIENCIA);

    if (falta.isEmpty()) {
      iniciarMedico();
      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        AltaBajaPersona.grabarPersona();
        LTDGerencia.pantallaGestionPersonalAlta();
        return;
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaAltaMedico();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS BAJA PERSONA
  ------------------------------------------------------------------------------------------------------------------ */

  static void bajaPorNIFPersona() {
    String nif = Utiles.leerLinea(); // Obtener nif
    try {
      Personal personal =
              LogicaTerminalDatos.getHospital().getPersonal().stream()
                      .filter(p -> p.getNIF().equals(nif))
                      .findFirst()
                      .orElseThrow();

      mostrarDatosPersona(personal);

      PantallasTerminalDatos.pantallaConfirmacion(); // Confirmar baja
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        LogicaTerminalDatos.borrarPersonal(personal);
        // TODO: LLAMAR A METODO LECTURAESCRITURA PARA ACTUALIZAR CSV CON LO DE LA LISTA
      }
    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
    LTDGerencia.pantallaGestionBajaPersonal();
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
      registrarPersonal();
      resetCampos();
      tmpPersona = null;
    }
  }

  static void mostrarDatosPersona() {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(tmpPersona);
  }

  static void mostrarDatosPersona(Persona persona) {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(persona);
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

  private static void registrarPersonal() {
    LogicaTerminalDatos.registrarPersonal((Personal) tmpPersona);
  }
}
