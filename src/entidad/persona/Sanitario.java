package entidad.persona;

import entidad.registro.Cita;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.List;

/** Clase abstracta para representar el personal Sanitario de un Hospital. */
public abstract class Sanitario extends Personal {

  /** Código de la especialidad del Sanitario. */
  private CodigoEspecialidadEnum codigoEspecialidad;

  /** Citas asignadas al Sanitario. */
  private List<Cita> citas;

  /**
   * Constructor con los campos heredados de Personal {@link Personal}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   */
  protected Sanitario(String NIF, String nombre, String apellido1, String apellido2) {
    super(NIF, nombre, apellido1, apellido2);
  }

  /**
   * Constructor con los campos heredados de Personal {@link Personal}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   */
  protected Sanitario(
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
   * Constructor con los campos heredados de Personal {@link Personal} y los campos propios de
   * Sanitario.
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
  protected Sanitario(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      List<Cita> citas) {
    super(NIF, nombre, apellido1, apellido2, codigoUnidad, codigoArea, codigoActividad);
    this.codigoEspecialidad = codigoEspecialidad;
    this.citas = citas;
  }

  public CodigoEspecialidadEnum getCodigoEspecialidad() {
    return codigoEspecialidad;
  }

  public void setCodigoEspecialidad(CodigoEspecialidadEnum codigoEspecialidad) {
    this.codigoEspecialidad = codigoEspecialidad;
  }

  public List<Cita> getCitas() {
    return citas;
  }

  public void setCitas(List<Cita> cita) {
    this.citas = cita;
  }
}
