package entidad.unidad.servicio.administracion;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Administracion} que define a la unidad de mantenimiento. */
public class Mantenimiento extends Administracion {

  /**
   * Constructor de unidad de mantenimiento.
   *
   * @param nombre nombre de la unidad.
   */
  public Mantenimiento(String nombre) {
    super(CodigoActividadEnum.MANTENIMIENTO, nombre);
  }

  @Override
  public String toString() {
    return this.getCodigoUnidad()
        + "-"
        + this.getCodigoUnidad()
        + "-"
        + this.getCodigoActividad()
        + "-"
        + this.getNombre();
  }
}
