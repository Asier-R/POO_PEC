package servicio;

import entidad.Hospital;
import entidad.persona.*;
import entidad.unidad.Unidad;
import entidad.unidad.formacion.Clase;
import entidad.unidad.formacion.Laboratorio;
import entidad.unidad.medica.consulta.*;
import entidad.unidad.medica.habitacion.EnPlanta;
import entidad.unidad.medica.habitacion.UCI;
import entidad.unidad.medica.quirofano.Quirofano;
import entidad.unidad.medica.urgencias.Urgencias;
import entidad.unidad.servicio.Aparcamiento;
import entidad.unidad.servicio.Cafeteria;
import entidad.unidad.servicio.administracion.*;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de escribir en ficheros y leer de ficheros para poder iniciar el hospital con
 * unos datos determinados.
 */
public final class LecturaEscrituraFichero {

  private static final String DELIMITADOR = "\r\n";
  private static final String SEPARADOR = ",";

  /** Path devuelto por el sistema. */
  private static final String PATH_BASE = System.getProperty("user.dir");

  /**
   * Path adaptado para poder arrancar la aplicación tanto en IntelliJ como en BlueJ. Si el proyecto
   * está ubicado en un fichero llamado src, es posible que no funcione, adaptar esta ruta.
   */
  private static final String PATH_ADAPTADO =
      PATH_BASE.endsWith("src") ? PATH_BASE : PATH_BASE + "\\src";

  private static final String PATH_PACIENTE = PATH_ADAPTADO + "\\zz_recursos\\pacientes.csv";
  private static final String PATH_MANTENIMIENTOSERVICIO =
      PATH_ADAPTADO + "\\zz_recursos\\mantenimientoServicios.csv";
  private static final String PATH_ADMINISTRATIVO =
      PATH_ADAPTADO + "\\zz_recursos\\administrativos.csv";
  private static final String PATH_MEDICOS = PATH_ADAPTADO + "\\zz_recursos\\medicos.csv";
  private static final String PATH_ENFERMEROS = PATH_ADAPTADO + "\\zz_recursos\\enfermeros.csv";
  private static final String PATH_ESTUDIANTES = PATH_ADAPTADO + "\\zz_recursos\\estudiantes.csv";
  private static final List<String> paths =
      List.of(
          PATH_PACIENTE,
          PATH_MANTENIMIENTOSERVICIO,
          PATH_ADMINISTRATIVO,
          PATH_MEDICOS,
          PATH_ENFERMEROS,
          PATH_ESTUDIANTES);

  /**
   * Crea una instancia de Hospital a partir de los datos guardados en los ficheros csv.
   *
   * @return Instancia de Hospital.
   */
  public static Hospital iniciarHospital() {
    System.out.println(">>> Inicialización de hospital");

    // Generar una unidad de cada tipo
    System.out.println(">>> Generación de unidades");
    List<Unidad> unidades = new ArrayList<>();
    Arrays.asList(CodigoActividadEnum.values())
        .forEach(
            unidad -> {
              unidades.add(generarUnidad(unidad, unidad.getDescripcion()));
            });
    unidades.sort(Unidad::compareTo);

    // No se generan pacientes, se registran al inicio de la aplicación.
    List<Paciente> pacientes = new ArrayList<>();
    generarPacientes(pacientes);
    pacientes.sort(Paciente::compareTo);

    // Se genera un miembro del personal del hospital por cada especialidad y por cada unidad.
    List<Personal> personal = new ArrayList<>();
    generarAdministrativos(personal);
    generarMantenimientoServicios(personal);
    generarMedicos(personal);
    generarEnfermeros(personal);
    generarEstudiantes(personal);
    personal.sort(Personal::compareTo);

    return new Hospital(unidades, pacientes, personal);
  }

  /**
   * Graba en un fichero csv los datos de las personas que interactúan con un hospital.
   *
   * @param grabable Objeto de tipo Grabable.
   */
  public static void grabarPersona(Grabable grabable) {
    PantallasTerminalDatos.pantallaAvisoGrabado();
    grabarDatos(grabable);
    PantallasTerminalDatos.pantallaDatosGrabados();
  }

  /**
   * Método privado encargado de grabar los datos en un fichero csv determinado.
   *
   * @param grabable Objeto cuyos datos se graban.
   */
  private static void grabarDatos(Grabable grabable) {
    Path path;
    if (grabable instanceof Paciente) path = Paths.get(PATH_PACIENTE);
    else if (grabable instanceof Administrativo) path = Paths.get(PATH_ADMINISTRATIVO);
    else if (grabable instanceof MantenimientoServicio)
      path = Paths.get(PATH_MANTENIMIENTOSERVICIO);
    else if (grabable instanceof Medico) path = Paths.get(PATH_MEDICOS);
    else if (grabable instanceof Enfermero) path = Paths.get(PATH_ENFERMEROS);
    else path = Paths.get(PATH_ESTUDIANTES); // if (grabable instanceof Estudiante)

    try {
      StandardOpenOption opcion;
      String datos;
      if (Files.readAllBytes(path).length == 0) {
        opcion = StandardOpenOption.WRITE;
        datos = grabable.generarCadenaCSV();
      }
      else {
        opcion = StandardOpenOption.APPEND;
        datos = DELIMITADOR + grabable.generarCadenaCSV();
      }

      Files.write(
          path,
          (datos).getBytes(),
          StandardOpenOption.CREATE,
          opcion);
    } catch (IOException e) {
      System.err.println("IOException: " + e.getMessage());
    }
  }

  /** Borra el contenido de todos los ficheros csv. */
  private static void borrarDatosFicheros(List<? extends Grabable> grabables) {
    paths.forEach(
        p -> {
          try {
            System.out.println(p);
            Files.delete(Paths.get(p));
            Files.createFile(Paths.get(p));
          } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
          }
        });
  }

  /**
   * Actualiza los ficheros csv con los datos de las personas del hospital de la sesión actual.
   *
   * @param grabables Los datos a grabar.
   */
  public static void actualizarDatos(List<? extends Grabable> grabables) {
    borrarDatosFicheros(grabables);
    grabables.forEach(LecturaEscrituraFichero::grabarDatos);
  }

  /**
   * Instancia los pacientes de un hospital a partir de los datos grabados en un fichero csv.
   *
   * @param pacientes Las instancias de pacientes.
   */
  private static void generarPacientes(List<Paciente> pacientes) {
    System.out.println(">>> Generación de pacientes");
    System.out.println(">>> Path fichero: " + PATH_PACIENTE);
    Paciente paciente;
    Scanner sc;
    int contador = 0;
    try {
      sc = new Scanner(new File(PATH_PACIENTE));
      sc.useDelimiter(DELIMITADOR);
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(SEPARADOR);
        paciente =
            new Paciente(
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                Integer.parseInt(datos[4]),
                Paciente.Sexo.valueOf(datos[5]));
        pacientes.add(paciente);
        contador++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
    System.out.println(">>> Total generados: " + contador);
  }

  /**
   * Instancia el personal administrativo de un hospital a partir de los datos grabados en un
   * fichero csv.
   *
   * @param personal Las instancias de personal.
   */
  private static void generarAdministrativos(List<Personal> personal) {
    System.out.println(">>> Generación de administrativos");
    System.out.println(">>> Path fichero: " + PATH_ADMINISTRATIVO);
    Personal persona;
    Scanner sc;
    int contador = 0;
    try {
      sc = new Scanner(new File(PATH_ADMINISTRATIVO));
      sc.useDelimiter(DELIMITADOR);
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(SEPARADOR);
        CodigoActividadEnum codigoActividad = CodigoActividadEnum.valueOf(datos[6]);
        Administrativo.Grupo grupo =
            datos[7].equals("null") ? null : Administrativo.Grupo.valueOf(datos[7]);
        persona =
            new Administrativo(datos[0], datos[1], datos[2], datos[3], codigoActividad, grupo);
        personal.add(persona);
        contador++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
    System.out.println(">>> Total generados: " + contador);
  }

  /**
   * Instancia el personal de mantenimiento y servicios de un hospital a partir de los datos
   * grabados en un fichero csv.
   *
   * @param personal Las instancias de personal.
   */
  private static void generarMantenimientoServicios(List<Personal> personal) {
    System.out.println(">>> Generación de personal de mantenimiento");
    System.out.println(">>> Path fichero: " + PATH_MANTENIMIENTOSERVICIO);
    Personal persona;
    Scanner sc;
    int contador = 0;
    try {
      sc = new Scanner(new File(PATH_MANTENIMIENTOSERVICIO));
      sc.useDelimiter(DELIMITADOR);
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(SEPARADOR);
        CodigoActividadEnum codigoActividad = CodigoActividadEnum.valueOf(datos[6]);
        persona =
            new MantenimientoServicio(
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                CodigoAreaEnum.valueOf(datos[5]),
                codigoActividad);
        personal.add(persona);
        contador++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
    System.out.println(">>> Total generados: " + contador);
  }

  /**
   * Instancia médicos de un hospital a partir de los datos grabados en un fichero csv.
   *
   * @param personal Las instancias de personal.
   */
  private static void generarMedicos(List<Personal> personal) {
    System.out.println(">>> Generación de médicos");
    System.out.println(">>> Path fichero: " + PATH_MEDICOS);
    Personal persona;
    Scanner sc;
    int contador = 0;
    try {
      sc = new Scanner(new File(PATH_MEDICOS));
      sc.useDelimiter(DELIMITADOR);
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(SEPARADOR);
        CodigoEspecialidadEnum segundaEspecialidad =
            datos[7].equals("null") ? null : CodigoEspecialidadEnum.valueOf(datos[7]);
        persona =
            new Medico(
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                CodigoAreaEnum.valueOf(datos[4]),
                CodigoActividadEnum.valueOf(datos[5]),
                CodigoEspecialidadEnum.valueOf(datos[6]),
                segundaEspecialidad,
                Integer.parseInt(datos[8]));
        personal.add(persona);
        contador++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
    System.out.println(">>> Total generados: " + contador);
  }

  /**
   * Instancia enfermeros de un hospital a partir de los datos grabados en un fichero csv.
   *
   * @param personal Las instancias de personal.
   */
  private static void generarEnfermeros(List<Personal> personal) {
    System.out.println(">>> Generación de enfermeros");
    System.out.println(">>> Path fichero: " + PATH_ENFERMEROS);
    Personal persona;
    Scanner sc;
    int contador = 0;
    try {
      sc = new Scanner(new File(PATH_ENFERMEROS));
      sc.useDelimiter(DELIMITADOR);
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(SEPARADOR);
        persona =
            new Enfermero(
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                CodigoAreaEnum.valueOf(datos[4]),
                CodigoActividadEnum.valueOf(datos[5]),
                CodigoEspecialidadEnum.valueOf(datos[6]),
                Integer.parseInt(datos[7]));
        personal.add(persona);
        contador++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
    System.out.println(">>> Total generados: " + contador);
  }

  /**
   * Instancia estudiantes de un hospital a partir de los datos grabados en un fichero csv.
   *
   * @param personal Las instancias de personal.
   */
  private static void generarEstudiantes(List<Personal> personal) {
    System.out.println(">>> Generación de estudiantes");
    System.out.println(">>> Path fichero: " + PATH_ESTUDIANTES);
    Personal persona;
    Scanner sc;
    int contador = 0;
    try {
      sc = new Scanner(new File(PATH_ESTUDIANTES));
      sc.useDelimiter(DELIMITADOR);
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(SEPARADOR);
        persona =
            new Estudiante(
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                CodigoAreaEnum.valueOf(datos[4]),
                CodigoActividadEnum.valueOf(datos[5]),
                CodigoEspecialidadEnum.valueOf(datos[6]),
                Integer.parseInt(datos[7]),
                datos[8]);
        personal.add(persona);
        contador++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
    System.out.println(">>> Total generados: " + contador);
  }

  /**
   * Genera unidades para una instancia de hospital.
   *
   * @param codigo Código de actividad de la unidad.
   * @param nombre Nombre de la unidad.
   * @return Instancia de unidad.
   */
  private static Unidad generarUnidad(CodigoActividadEnum codigo, String nombre) {
    Unidad unidad;
    switch (codigo) {
      case CONTABILIDAD:
        unidad = new Contabilidad(nombre);
        break;
      case DIRECCION:
        unidad = new Direccion(nombre);
        break;
      case DOC_CLINICA:
        unidad = new DocClinica(nombre);
        break;
      case MANTENIMIENTO:
        unidad = new Mantenimiento(nombre);
        break;
      case LIMPIEZA:
        unidad = new Limpieza(nombre);
        break;
      case RRHH:
        unidad = new RRHH(nombre);
        break;
      case SEGURIDAD:
        unidad = new Seguridad(nombre);
        break;
      case CAFETERIA:
        unidad = new Cafeteria(nombre);
        break;
      case APARCAMIENTO:
        unidad = new Aparcamiento(nombre);
        break;
      case UCI:
        unidad = new UCI(nombre);
        break;
      case EN_PLANTA:
        unidad = new EnPlanta(nombre);
        break;
      case QUIROFANO:
        unidad = new Quirofano(nombre);
        break;
      case ATENCION_URGENCIAS:
        unidad = new Urgencias(nombre);
        break;
      case CONSULTA_APARATO_DIGESTIVO:
        unidad = new AparatoDigestivo(nombre);
        break;
      case CONSULTA_CARDIOLOGIA:
        unidad = new Cardiologia(nombre);
        break;
      case CONSULTA_CIRUGIA_GENERAL:
        unidad = new CirugiaGeneral(nombre);
        break;
      case CONSULTA_DERMATOLOGIA:
        unidad = new Dermatologia(nombre);
        break;
      case CONSULTA_MEDICINA_INTERNA:
        unidad = new MedicinaInterna(nombre);
        break;
      case CONSULTA_ONCOLOGIA:
        unidad = new Oncologia(nombre);
        break;
      case CONSULTA_OFTALMOLOGIA:
        unidad = new Oftalmologia(nombre);
        break;
      case CONSULTA_PRIMARIA:
        unidad = new Primaria(nombre);
        break;
      case CONSULTA_PSIQUIATRIA:
        unidad = new Psiquiatria(nombre);
        break;
      case CONSULTA_TRAUMATOLOGIA:
        unidad = new Traumatologia(nombre);
        break;
      case CLASE:
        unidad = new Clase(nombre);
        break;
      case LABORATORIO:
        unidad = new Laboratorio(nombre);
        break;
      default:
        unidad = null;
    }
    return unidad;
  }
}
