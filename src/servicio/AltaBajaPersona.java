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

  /** Variable temporal para conservar la edad del paciente */
  static int edad;

  /** Variable temporal para conservar el sexo del paciente */
  static Paciente.Sexo sexo;

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS ALTA PERSONA
  ------------------------------------------------------------------------------------------------------------------ */

  /** Inicializa la variable temporal como administrativo. */
  static void iniciarAdmin() {
    tmpPersona = new Administrativo(NIF, nombre, apellido1, apellido2, codigoActividad, grupo);
  }

  /** Valida los datos y graba el administrativo. */
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

  /** Inicializa la variable temporal como personal de mantenimiento y servicio. */
  static void iniciarMantenimientoServicio() {
    tmpPersona =
        new MantenimientoServicio(NIF, nombre, apellido1, apellido2, codigoArea, codigoActividad);
  }

  /** Valida los datos y graba el personal de mantenimiento y servicio. */
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

  /** Inicializa la variable temporal como estudiante. */
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

  /** Valida los datos y graba el estudiante. */
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

  /** Inicializa la variable temporal como enfermero. */
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

  /** Valida los datos y graba el enfermero. */
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

  /** Inicializa la variable temporal como médico. */
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

  /** Valida los datos y graba el médico. */
  static void validarGrabarMedico() {
    String falta = "";
    falta = validarCamposComunes(falta);
    falta = Utiles.validarCampoEnum(codigoArea, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoActividad, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoEnum(codigoEspecialidad, falta, Utiles.STR_COD_ESPECIALIDAD);
    falta =
        Utiles.validarCampoEnum(
            codigoSegundaEspecialidad, falta, Utiles.STR_COD_SEGUNDAESPECIALIDAD);
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

  /** Inicializa la variable temporal como paciente. */
  static void iniciarPaciente() {
    tmpPersona =
            new Paciente(
                    NIF,
                    nombre,
                    apellido1,
                    apellido2,
                    edad,
                    sexo);
  }

  /** Valida los datos y graba el paciente. */
  static void validarGrabarPaciente() {
    String falta = "";
    falta = validarCamposComunes(falta);
    falta = Utiles.validarCampoNumero(edad, falta, Utiles.STR_EDAD);
    falta = Utiles.validarCampoSexo(sexo, falta, Utiles.STR_SEXO);

    if (falta.isEmpty()) {
      iniciarPaciente();
      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        AltaBajaPersona.grabarPersona();
        LTDGerencia.pantallaGestionPacientes();
        return;
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaAltaPaciente();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS BAJA PERSONA
  ------------------------------------------------------------------------------------------------------------------ */

  /** Realiza la baja de una persona mediante el NIF de esta. */
  static void bajaPorNIFPersona() {
    String nif = Utiles.leerLinea(); // Obtener nif
    try {
      Personal personal =
          LogicaTerminalDatos.getHospital().getPersonal().stream()
              .filter(p -> p.getNIF().equals(nif))
              .findFirst()
              .orElse(null);

      Paciente paciente =
              LogicaTerminalDatos.getHospital().getPacientes().stream()
                      .filter(p -> p.getNIF().equals(nif))
                      .findFirst()
                      .orElse(null);

      if(personal == null && paciente == null) throw new NoSuchElementException();

      Utiles.mostrarDatosPersona(personal==null?paciente:personal);

      PantallasTerminalDatos.pantallaConfirmacion(); // Confirmar baja
      if(personal != null && paciente == null){
        if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
          LogicaTerminalDatos.borrarPersonal(personal);
          LTDGerencia.pantallaGestionBajaPersonas();
        }
      } else {
        if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
          LogicaTerminalDatos.borrarPaciente(paciente);
          LTDGerencia.pantallaGestionPacientes();
        }
      }

    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Valida los campos comunes de las personas.
   *
   * @param falta Texto del mensaje informativo.
   * @return Texto del mensaje informativo.
   */
  private static String validarCamposComunes(String falta) {
    falta = Utiles.validarCampo(NIF, falta, Utiles.STR_NIF);
    falta = Utiles.validarCampo(nombre, falta, Utiles.STR_NOMBRE);
    falta = Utiles.validarCampo(apellido1, falta, Utiles.STR_APELLIDO1);
    falta = Utiles.validarCampo(apellido2, falta, Utiles.STR_APELLIDO2);
    return falta;
  }

  /** Graba la persona almacenada en la variable temporal. */
  static void grabarPersona() {
    if (tmpPersona != null) {
      LecturaEscrituraFichero.grabarPersona(tmpPersona);
      if(tmpPersona instanceof Paciente) registrarPaciente();
      else registrarPersonal();
      resetCampos();
      tmpPersona = null;
    }
  }

  /** Muestra los datos de la persona almacenada en la variable temporal. */
  static void mostrarDatosPersona() {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(tmpPersona);
  }

  /** Pone a null todas las variables temporales. */
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

  /** Añade el nuevo miembro del personal a la lista de personal del hospital. */
  private static void registrarPersonal() {
    LogicaTerminalDatos.registrarPersonal((Personal) tmpPersona);
  }

  /** Añade el nuevo paciente a la lista de pacientes del hospital. */
  private static void registrarPaciente() {
    LogicaTerminalDatos.registrarPaciente((Paciente) tmpPersona);
  }
}
