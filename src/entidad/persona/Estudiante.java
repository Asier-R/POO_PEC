package entidad.persona;

import entidad.Hospital;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

/** Clase que representa a un estudiante de medicína o enfermería. */
public class Estudiante extends Sanitario {
  /** Nombre del centro de estudios de procedencia. */
  private String nombreCentro;

  /** Hospital en el que el estudiante realiza su formación. */
  private Hospital hospital;

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
   * @param nombreCentro Código de actividad.
   * @param hospital Hospital.
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
      String nombreCentro,
      Hospital hospital) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        codigoUnidad,
        codigoArea,
        codigoActividad,
        codigoEspecialidad);
    this.nombreCentro = nombreCentro;
    this.hospital = hospital;
  }

  public String getNombreCentro() {
    return nombreCentro;
  }

  public void setNombreCentro(String nombreCentro) {
    this.nombreCentro = nombreCentro;
  }

  public Hospital getHospital() {
    return hospital;
  }

  public void setHospital(Hospital hospital) {
    this.hospital = hospital;
  }

  @Override
  public String toString() {
    return null;
  }
}
