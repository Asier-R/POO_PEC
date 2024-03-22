package entidad.persona;

import entidad.registro.Cita;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.List;

/** Clase que representa a un estudiante de medicína o enfermería. */
public class Estudiante extends Sanitario {
  /** Nombre del centro de estudios de procedencia. */
  private String nombreCentro;

  /**
   * Constructor con los campos heredados de Sanitario {@link Sanitario}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   */
  public Estudiante(String NIF, String nombre, String apellido1, String apellido2) {
    super(NIF, nombre, apellido1, apellido2);
  }

  /**
   * Constructor con los campos heredados de Sanitario {@link Sanitario}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   */
  public Estudiante(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad) {
    super(NIF, nombre, apellido1, apellido2, codigoUnidad, codigoArea, codigoActividad);
  }

  /**
   * Constructor con los campos heredados de {@link Sanitario}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param citas Citas.
   */
  public Estudiante(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      List<Cita> citas) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        codigoUnidad,
        codigoArea,
        codigoActividad,
        codigoEspecialidad,
        citas);
  }

  /**
   * Constructor con los campos heredados de {@link Sanitario} y los campos propios de Estudiante.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param citas Citas.
   * @param nombreCentro Código de actividad.
   */
  public Estudiante(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      List<Cita> citas,
      String nombreCentro) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        codigoUnidad,
        codigoArea,
        codigoActividad,
        codigoEspecialidad,
        citas);
    this.nombreCentro = nombreCentro;
  }

  public String getNombreCentro() {
    return nombreCentro;
  }

  public void setNombreCentro(String nombreCentro) {
    this.nombreCentro = nombreCentro;
  }

  @Override
  public String toString() {
    return null;
  }
}
