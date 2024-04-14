package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Subclase abstracta de {@link Persona} para representar el personal implicado en un Hospital. */
public abstract class Personal extends Persona implements Comparable<Personal>{

  /** Código de la unidad a la que está asignada la Persona. */
  private CodigoUnidadEnum codigoUnidad;

  /** Código del área a la que está asignada la Persona. */
  private CodigoAreaEnum codigoArea;

  /** Código de la actividad que realiza la Persona. */
  private CodigoActividadEnum codigoActividad;

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

  /**
   * Devuelve el código de unidad asociado a la persona.
   *
   * @return Código de unidad.
   */
  public CodigoUnidadEnum getCodigoUnidad() {
    return codigoUnidad;
  }

  /**
   * Devuelve el código de área de la unidad asociado a la persona.
   *
   * @return Código de área.
   */
  public CodigoAreaEnum getCodigoArea() {
    return codigoArea;
  }

  /**
   * Establece el código de área.
   * @param codigoArea Código de área.
   */
  public void setCodigoArea(CodigoAreaEnum codigoArea) {
    this.codigoArea = codigoArea;
  }

  /**
   * Devuelve el código de actividad de la unidad asociado a la persona.
   *
   * @return Código de actividad.
   */
  public CodigoActividadEnum getCodigoActividad() {
    return codigoActividad;
  }

  /**
   * Establece el código de actividad.
   * @param codigoActividad Código de actividad.
   */
  public void setCodigoActividad(CodigoActividadEnum codigoActividad) {
    this.codigoActividad = codigoActividad;
  }

  @Override
  public int compareTo(Personal p) {
    return this.getCodigoActividad().compareTo(p.getCodigoActividad());
  }
}
