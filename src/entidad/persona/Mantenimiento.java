package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Clase que representa al personal de mantenimiento de un Hospital. */
public class Mantenimiento extends Personal {

  /** Enum de las labores de mantenimiento. */
  enum Labor {
    MANTENIMIENTO,
    LIMPIEZA,
    SEGURIDAD
  }

  /** Labor de mantenimiento. */
  private Labor labor;

  /**
   * Constructor con los campos heredados de Personal {@link Personal}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   */
  public Mantenimiento(String NIF, String nombre, String apellido1, String apellido2) {
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
  public Mantenimiento(
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
    super(NIF, nombre, apellido1, apellido2, codigoUnidad, codigoArea, codigoActividad);
    this.labor = labor;
  }

  public Labor getLabor() {
    return labor;
  }

  public void setLabor(Labor labor) {
    this.labor = labor;
  }

  @Override
  public String toString() {
    return null;
  }
}
