package servicio;

import entidad.persona.Administrativo;
import entidad.persona.Paciente;
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

/**
 * Clase que contiene funciones útiles para toda la aplicación.
 */
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
  static final String STR_EDAD = "Edad";
  static final String STR_SEXO = "Sexo";
  static final String STR_CENTRO = "Nombre del centro";
  static final String STR_UBICACION = "Ubicación";
  static final String SI = "S";
  static final String STR_PACIENTE = "Paciente";
  static final String STR_SANITARIO = "Sanitario";
  static final String STR_ESTUDIANTE = "Estudiante";
  static final String STR_FECHA = "Fecha";
  static final String STR_FECHA_CITA = "Fecha Cita";
  static final String STR_FORMATO_FECHA = "HH:mm:ss dd-MM-uuuu";
  static final String STR_ZONA = "Europe/Madrid";

  private static ZonedDateTime ahora = ZonedDateTime.now();
  private static String dia = String.valueOf(ahora.getDayOfMonth());
  private static String mes =
      String.valueOf(ahora.getMonthValue()).length() == 1
          ? ("0" + (ahora.getMonthValue()))
          : String.valueOf(ahora.getMonthValue());
  private static String anio = String.valueOf(ahora.getYear());

  /** Fecha y hora base con la se crea la hora del sistema */
  private static final String FECHA_PRIMERA_CONSULTA = "08:00:00 " + dia + "-" + mes + "-" + anio;

  /** Fecha y hora del sistema. Se parte de las 8am. */
  private static final ZonedDateTime fechaHoraSistema =
      LocalDateTime.parse(FECHA_PRIMERA_CONSULTA, DateTimeFormatter.ofPattern(STR_FORMATO_FECHA))
          .atZone(ZoneId.of(STR_ZONA));

  /** Lector de input de usuario. */
  private static Scanner reader;

  /** Constructor privado de Utiles. */
  private Utiles() {
    // Constructor privado
  }

  /** Inicia la instancia de Scanner para admitir las entradas del usuario. */
  static void abrirLectorDeEntradas() {
    reader = new Scanner(System.in);
  }

  /** Cierra la instancia de Scanner. */
  static void cerrarLectorDeEntradas() {
    reader.close();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS PARA LAS FECHAS
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Devuelve la fecha y hora del sistema.
   *
   * @return ZonedDateTime con la fecha y hora del sistema.
   */
  static ZonedDateTime getFechaHoraSistema() {
    return fechaHoraSistema;
  }

  /**
   * Devuelve la fecha y hora del sistema formateada.
   *
   * @return String con la fecha y hora del sistema.
   */
  static String getFechaHoraSistemaFormateada(){
    return fechaHoraSistema.format(DateTimeFormatter.ofPattern(STR_FORMATO_FECHA));
  }

  /**
   * Devuelve la fecha de entrada formateada.
   * @param fecha Fecha a formatear.
   * @return Fecha formateada.
   */
  static String getFechaHoraFormateada(ZonedDateTime fecha){
    return fecha.format(DateTimeFormatter.ofPattern(STR_FORMATO_FECHA));
  }

  /**
   * Devuelve la fecha y hora del sistema avanzada N días y formateada.
   *
   * @return String con la fecha y hora del sistema avanzada N días.
   */
  static String getFechaSistemaAvanzadaNDias(Long numDias){
    return fechaHoraSistema.plusDays(numDias).format(DateTimeFormatter.ofPattern(STR_FORMATO_FECHA));
  }

  /**
   * Avanza la hora del sistema un número determinado de horas.
   *
   * @param horas Horas a avanzar.
   * @return ZonedDateTime con la fecha y hora del sistema.
   */
  static ZonedDateTime avanzarHoraSistema(long horas) {
    return fechaHoraSistema.plusHours(horas);
  }

  /**
   * Avanza la fecha del sistema un número determinado de días.
   *
   * @param dias Días a avanzar.
   * @return ZonedDateTime con la fecha y hora del sistema.
   */
  static ZonedDateTime avanzarDiaSistema(long dias) {
    return fechaHoraSistema.plusDays(dias);
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS DE ENTRADA POR TECLADO
  ------------------------------------------------------------------------------------------------------------------ */

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
   * Método común para leer input de usuario. El número debe ser un entero positivo.
   *
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

  /** Método para obtener la edad del paciente. */
  static int inputEdad() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_EDAD);
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

  /** Método para obtener el sexo del paciente. */
  static Paciente.Sexo inputSexoPaciente() {
    PantallasTerminalDatos.pantallaIntroducirDato(STR_SEXO);
    Paciente.Sexo.mostrarPorPantalla();
    int opt = leerNumero();
    return Paciente.Sexo.getFromId(opt);
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

  /* ------------------------------------------------------------------------------------------------------------------
     VALIDACIONES
  ------------------------------------------------------------------------------------------------------------------ */

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

  /** Método para validar campo sexo. */
  static String validarCampoSexo(Paciente.Sexo sexo, String falta, String campo) {
    if (sexo == null) {
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

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Muestra por pantalla los datos de una persona determinada.
   *
   * @param persona Persona cuyos datos se quieren mostrar.
   */
  static void mostrarDatosPersona(Persona persona) {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(persona);
  }

}
