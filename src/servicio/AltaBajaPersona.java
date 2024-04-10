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
    falta = Utiles.validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(grupo, falta, Utiles.STR_COD_GRUPO);

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
    falta = Utiles.validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);

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
    falta = Utiles.validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoEspecialidad, falta, Utiles.STR_COD_ESPECIALIDAD);
    falta = Utiles.validarCampoNumero(experiencia, falta, Utiles.STR_EXPERIENCIA);
    falta = Utiles.validarCampo(nombreCentro, falta, Utiles.STR_CENTRO);

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
    falta = Utiles.validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoEspecialidad, falta, Utiles.STR_COD_ESPECIALIDAD);
    falta = Utiles.validarCampoNumero(experiencia, falta, Utiles.STR_EXPERIENCIA);

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
    falta = Utiles.validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoEspecialidad, falta, Utiles.STR_COD_ESPECIALIDAD);
    falta = Utiles.validarCampoEnum(codigoSegundaEspecialidad, falta, Utiles.STR_COD_SEGUNDAESPECIALIDAD);
    falta = Utiles.validarCampoNumero(experiencia, falta, Utiles.STR_EXPERIENCIA);

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

      Utiles.mostrarDatosPersona(personal);

      PantallasTerminalDatos.pantallaConfirmacion(); // Confirmar baja
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        LogicaTerminalDatos.borrarPersonal(personal);
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
    falta = Utiles.validarCampo(NIF, falta, Utiles.STR_NIF);
    falta = Utiles.validarCampo(nombre, falta, Utiles.STR_NOMBRE);
    falta = Utiles.validarCampo(apellido1, falta, Utiles.STR_APELLIDO1);
    falta = Utiles.validarCampo(apellido2, falta, Utiles.STR_APELLIDO2);
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
