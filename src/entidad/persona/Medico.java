package entidad.persona;

import entidad.Hospital;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

/** Clase que representa a un médico. */
public class Medico extends Sanitario {
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
  public Medico(String NIF, String nombre, String apellido1, String apellido2) {
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
  public Medico(
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
   * Constructor con los campos heredados de {@link Sanitario} y los campos propios de Enfermero.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param hospital Hospital.
   */
  public Medico(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
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
    this.hospital = hospital;
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
