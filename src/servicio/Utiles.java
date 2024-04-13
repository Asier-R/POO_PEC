package servicio;

import entidad.persona.Administrativo;
import entidad.persona.Persona;
import entidad.unidad.Unidad;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public final class Utiles {

  static final String STR_NIF = "NIF";
  static final String STR_NOMBRE = "Nombre";
  static final String STR_APELLIDO1 = "Primer apellido";
  static final String STR_APELLIDO2 = "Segundo apellido";
  static final String STR_COD_UNIDAD = "Código unidad";
  static final String STR_COD_AREA = "Código área";
  static final String STR_COD_ACTIVIDAD = "Código actividad";
  static final String STR_COD_ESPECIALIDAD = "Especialidad";
  static final String STR_COD_SEGUNDAESPECIALIDAD = "Segunda especialidad";
  static final String STR_COD_GRUPO = "Grupo administrativo";
  static final String STR_EXPERIENCIA = "Experiencia";
  static final String STR_CENTRO = "Nombre del centro";
  static final String SI = "S";
  static final String STR_PACIENTE = "Paciente";
  static final String STR_SANITARIO = "Sanitario";
  static final String STR_FECHA = "Fecha";
  static final String STR_FECHA_CITA = "Fecha Cita";
  static final String STR_CITA = "Cita";
  static final String STR_FORMATO_FECHA = "HH:mm:ss dd-MM-uuuu";
  static final String STR_ZONA = "Europe/Madrid";

  /** Lector de input de usuario. */
  private static Scanner reader;

  /** Constructor privado de Utiles. */
  private Utiles() {
    // Constructor privado
  }

  static void abrirLectorDeEntradas() {
    reader = new Scanner(System.in);
  }

  static void cerrarLectorDeEntradas() {
    reader.close();
  }

  static void mostrarDatosPersona(Persona persona) {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(persona);
  }

  /**
   * Método común para leer input de usuario.
   *
   * @return Cadena de texto del input de usuario.
   */
  static String leerLinea() {
    String rd = reader.nextLine();
    if (rd.isEmpty()) rd = reader.nextLine();
    return rd;
  }

  /**
   * Método común para leer input de usuario.
   * El número debe ser un entero positivo.
   * @return Cadena de texto del input de usuario.
   */
  static int leerNumero() {
    int num;
    try {
      num = reader.nextInt();
    } catch (Exception e) {
      System.out.println("> Opción no válida...debe ser un número entero positivo...");
      return leerNumero();
    }
    return num;
  }

  /** Método para obtener el NIF de la persona. */
  static String inputNIF() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_NIF);
    return leerLinea().toUpperCase();
  }

  /** Método para obtener el nombre de la persona. */
  static String inputNombre() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_NOMBRE);
    return leerLinea();
  }

  /** Método para obtener el primer apellido de la persona. */
  static String inputApellido1() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_APELLIDO1);
    return leerLinea();
  }

  /** Método para obtener el segundo apellido de la persona. */
  static String inputApellido2() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_APELLIDO2);
    return leerLinea();
  }

  /** Método para obtener el nombre del centro. */
  static String inputNombreCentro() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_CENTRO);
    return leerLinea();
  }

  /** Método para obtener la experiencia del sanitario. */
  static int inputExperiencia() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_EXPERIENCIA);
    return leerNumero();
  }

  /** Método para obtener el código de unidad. */
  static CodigoUnidadEnum inputCodUnidad() {
    PantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_UNIDAD);
    CodigoUnidadEnum.mostrarPorPantalla();
    int opt = leerNumero();
    return CodigoUnidadEnum.getFromId(opt);
  }

  /** Método para obtener el código de área. */
  static CodigoAreaEnum inputCodArea() {
    PantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_AREA);
    CodigoAreaEnum.mostrarPorPantalla();
    int opt = leerNumero();
    return CodigoAreaEnum.getFromId(opt);
  }

  /** Método para obtener el código de área. */
  static CodigoActividadEnum inputCodActividad() {
    PantallasTerminalDatos.pantallaSeleccionarCodigo(
        STR_COD_ACTIVIDAD + " (lugar donde se realiza la actividad)");
    CodigoActividadEnum.mostrarPorPantalla();
    int opt = leerNumero();
    return CodigoActividadEnum.getFromId(opt);
  }

  /** Método para obtener el código de especialidad. */
  static CodigoEspecialidadEnum inputCodEspecialidad() {
    PantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_ESPECIALIDAD);
    CodigoEspecialidadEnum.mostrarPorPantalla();
    int opt = leerNumero();
    return CodigoEspecialidadEnum.getFromId(opt);
  }

  /** Método para obtener el grupo administrativo. */
  static Administrativo.Grupo inputGrupoAdmin() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_COD_GRUPO);
    Administrativo.Grupo.mostrarPorPantalla();
    int opt = leerNumero();
    return Administrativo.Grupo.getFromId(opt);
  }

  /** Método recursivo para obtener una fecha. */
  static ZonedDateTime inputFecha() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(STR_FORMATO_FECHA);
    PantallasTerminalDatos.pantallaIntroducirDato(
        STR_FECHA + " en el formato " + STR_FORMATO_FECHA);
    String str = leerLinea();
    ZonedDateTime fecha;
    try {
      LocalDateTime ldt = LocalDateTime.parse(str, dtf);
      fecha = ldt.atZone(ZoneId.of(STR_ZONA));
    } catch (Exception e) {
      PantallasTerminalDatos.pantallaAvisoFormatoErroneo();
      fecha = inputFecha();
    }
    return fecha;
  }

  /** Método para validar un campo de texto. */
  static String validarCampo(String dato, String falta, String campo) {
    if (dato == null || dato.isEmpty() || dato.isBlank()) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  /** Método para validar un campo numérico. */
  static String validarCampoNumero(int dato, String falta, String campo) {
    if (dato < 0) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  /** Método para validar un campo enumerable. */
  static String validarCampoEnum(Enum dato, String falta, String campo) {
    if (dato == null) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  /** Método para validar un campo fecha. */
  static String validarCampoFecha(ZonedDateTime dato, String falta, String campo) {
    if (dato == null) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  /** Método para validar un campo persona. */
  static String validarCampoPersona(Persona dato, String falta, String campo) {
    if (dato == null) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  /** Método para validar un campo persona. */
  static String validarCampoPersona(List<? extends Persona> dato, String falta, String campo) {
    if (dato == null || dato.isEmpty()) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }

  /** Método para validar un campo unidad. */
  static String validarCampoUnidad(Unidad dato, String falta, String campo) {
    if (dato == null) {
      return falta.isEmpty() ? campo : falta + ", " + campo;
    } else {
      return falta;
    }
  }
}
