package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Clase que representa al personal de mantenimiento de un Hospital. */
public class Mantenimiento extends Personal {

  /** Enum de las labores de mantenimiento. */
  public enum Labor {
    MANTENIMIENTO,
    LIMPIEZA,
    SEGURIDAD
  }

  /** Código de la unidad a la que está asignada la Persona. */
  private CodigoUnidadEnum codigoUnidad;

  /** Código del área a la que está asignada la Persona. */
  private CodigoAreaEnum codigoArea;

  /** Código de la actividad que realiza la Persona. */
  private CodigoActividadEnum codigoActividad;

  /** Labor de mantenimiento. */
  private Labor labor;

  /**
   * Constructor con los campos heredados de Personal {@link Personal} y los campos propios de
   * Mantenimiento.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param labor labor que realiza el técnico.
   */
  public Mantenimiento(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      Labor labor) {
    super(NIF, nombre, apellido1, apellido2);
    this.codigoUnidad = codigoUnidad;
    this.codigoArea = codigoArea;
    this.codigoActividad = codigoActividad;
    this.labor = labor;
  }

  @Override
  public CodigoUnidadEnum getCodigoUnidad() {
    return codigoUnidad;
  }

  @Override
  public CodigoAreaEnum getCodigoArea() {
    return codigoArea;
  }

  @Override
  public CodigoActividadEnum getCodigoActividad() {
    return codigoActividad;
  }

  public Labor getLabor() {
    return labor;
  }

  @Override
  public String toString() {
    return null;
  }
}
