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
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class LecturaEscrituraFichero {

  private static final String PATH_PACIENTE =
      System.getProperty("user.dir") + "\\src\\zz_recursos\\pacientes.csv";
  private static final String PATH_MANTENIMIENTOSERVICIO =
      System.getProperty("user.dir") + "\\src\\zz_recursos\\mantenimientoServicios.csv";
  private static final String PATH_ADMINISTRATIVO =
      System.getProperty("user.dir") + "\\src\\zz_recursos\\administrativos.csv";
  private static final String PATH_MEDICOS =
      System.getProperty("user.dir") + "\\src\\zz_recursos\\medicos.csv";
  private static final String PATH_ENFERMEROS =
      System.getProperty("user.dir") + "\\src\\zz_recursos\\enfermeros.csv";
  private static final String PATH_ESTUDIANTES =
      System.getProperty("user.dir") + "\\src\\zz_recursos\\estudiantes.csv";

  public static Hospital iniciarHospital() {
    // Generar una unidad de cada tipo
    List<Unidad> unidades = new ArrayList<>();
    Arrays.asList(CodigoActividadEnum.values())
        .forEach(
            unidad -> {
              unidades.add(generarUnidad(unidad, unidad.getDescripcion()));
            });

    // No se generan pacientes, se registran al inicio de la aplicación.
    List<Paciente> pacientes = new ArrayList<>();
    generarPacientes(pacientes);

    // Se genera un miembro del personal del hospital por cada especialidad y por cada unidad.
    List<Personal> personal = new ArrayList<>();
    generarAdministrativos(personal);
    generarMantenimientoServicios(personal);
    generarMedicos(personal);
    generarEnfermeros(personal);
    generarEstudiantes(personal);

    return new Hospital(unidades, pacientes, personal);
  }

  public static void grabarPersona(Grabable grabable) {
    if (grabable instanceof Paciente) grabarDatos(grabable, PATH_PACIENTE);
    else if (grabable instanceof Administrativo) grabarDatos(grabable, PATH_ADMINISTRATIVO);
    else if (grabable instanceof MantenimientoServicio) grabarDatos(grabable, PATH_MANTENIMIENTOSERVICIO);
    else if (grabable instanceof Medico) grabarDatos(grabable, PATH_MEDICOS);
    else if (grabable instanceof Enfermero) grabarDatos(grabable, PATH_ENFERMEROS);
    else if (grabable instanceof Estudiante) grabarDatos(grabable, PATH_ESTUDIANTES);
  }

  private static void grabarDatos(Grabable grabable, String path){
    try {
      Files.write(Paths.get(path), ("\n"+grabable.generarCadenaCSV()).getBytes(), StandardOpenOption.APPEND);
    }catch (IOException e) {
      System.err.println("IOException: " +e.getMessage());
    }
  }

  private static void generarPacientes(List<Paciente> pacientes) {
    Paciente paciente;
    Scanner sc;
    try {
      sc = new Scanner(new File(PATH_PACIENTE));
      sc.useDelimiter("\r\n");
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(",");
        paciente =
            new Paciente(
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                Integer.parseInt(datos[4]),
                Paciente.Sexo.valueOf(datos[5]));
        pacientes.add(paciente);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
  }

  private static void generarAdministrativos(List<Personal> personal) {
    Personal persona;
    Scanner sc;
    try {
      sc = new Scanner(new File(PATH_ADMINISTRATIVO));
      sc.useDelimiter("\r\n");
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(",");
        CodigoActividadEnum codigoActividad = CodigoActividadEnum.valueOf(datos[6]);
        Administrativo.Grupo grupo =
            datos[7].equals("null") ? null : Administrativo.Grupo.valueOf(datos[7]);
        persona =
            new Administrativo(datos[0], datos[1], datos[2], datos[3], codigoActividad, grupo);
        personal.add(persona);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
  }

  private static void generarMantenimientoServicios(List<Personal> personal) {
    Personal persona;
    Scanner sc;
    try {
      sc = new Scanner(new File(PATH_MANTENIMIENTOSERVICIO));
      sc.useDelimiter("\r\n");
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(",");
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
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
  }

  private static void generarMedicos(List<Personal> personal) {
    Personal persona;
    Scanner sc;
    try {
      sc = new Scanner(new File(PATH_MEDICOS));
      sc.useDelimiter("\r\n");
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(",");
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
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
  }

  private static void generarEnfermeros(List<Personal> personal) {
    Personal persona;
    Scanner sc;
    try {
      sc = new Scanner(new File(PATH_ENFERMEROS));
      sc.useDelimiter("\r\n");
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(",");
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
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
  }

  private static void generarEstudiantes(List<Personal> personal) {
    Personal persona;
    Scanner sc;
    try {
      sc = new Scanner(new File(PATH_ESTUDIANTES));
      sc.useDelimiter("\r\n");
      while (sc.hasNext()) {
        String sig = sc.next();
        String[] datos = sig.split(",");
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
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    sc.close();
  }

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
