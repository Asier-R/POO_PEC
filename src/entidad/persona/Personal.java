package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Clase abstracta para representar el personal implicado en un Hospital. */
public abstract class Personal extends Persona {
  /** Código de la unidad a la que está asignada la Persona. */
  private CodigoUnidadEnum codigoUnidad;

  /** Código del área a la que está asignada la Persona. */
  private CodigoAreaEnum codigoArea;

  /** Código de la actividad que realiza la Persona. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor con los campos heredados de Persona {@link Persona}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   */
  protected Personal(String NIF, String nombre, String apellido1, String apellido2) {
    super(NIF, nombre, apellido1, apellido2);
  }

  /**
   * Constructor con los campos heredados de Persona {@link Persona} y los campos propios de
   * Personal.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   */
  protected Personal(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad) {
    super(NIF, nombre, apellido1, apellido2);
    this.codigoUnidad = codigoUnidad;
    this.codigoArea = codigoArea;
    this.codigoActividad = codigoActividad;
  }

  public CodigoUnidadEnum getCodigoUnidad() {
    return codigoUnidad;
  }

  public void setCodigoUnidad(CodigoUnidadEnum codigoUnidad) {
    this.codigoUnidad = codigoUnidad;
  }

  public CodigoAreaEnum getCodigoArea() {
    return codigoArea;
  }

  public void setCodigoArea(CodigoAreaEnum codigoArea) {
    this.codigoArea = codigoArea;
  }

  public CodigoActividadEnum getCodigoActividad() {
    return codigoActividad;
  }

  public void setCodigoActividad(CodigoActividadEnum codigoActividad) {
    this.codigoActividad = codigoActividad;
  }
}
