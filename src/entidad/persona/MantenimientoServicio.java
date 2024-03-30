package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Subclase de {@link Personal} que representa al personal de mantenimiento de un Hospital. Esta
 * clase engloba al personal de mantenimiento, limpieza, seguridad, cafeteria y aparcamiento.
 */
public class MantenimientoServicio extends Personal {

  /** Código de la unidad a la que está asignada la Persona. */
  private CodigoUnidadEnum codigoUnidad;

  /** Código del área a la que está asignada la Persona. */
  private CodigoAreaEnum codigoArea;

  /** Código de la actividad que realiza la Persona. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor con los campos heredados de Personal {@link Personal} y los campos propios de
   * Mantenimiento.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoActividad código de actividad.
   */
  public MantenimientoServicio(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoActividadEnum codigoActividad) {
    super(NIF, nombre, apellido1, apellido2);
    this.codigoUnidad = CodigoUnidadEnum.SERVICIOS;
    this.codigoArea = CodigoAreaEnum.ADMINISTRACION;
    this.codigoActividad = codigoActividad;
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

  @Override
  public String toString() {
    return null;
  }
}
