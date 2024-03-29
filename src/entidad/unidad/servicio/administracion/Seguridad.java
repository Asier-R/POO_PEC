package entidad.unidad.servicio.administracion;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Administracion} que define a la unidad de seguridad. */
public class Seguridad extends Administracion {

  /**
   * Constructor de unidad de seguridad.
   *
   * @param nombre nombre de la unidad.
   */
  public Seguridad(String nombre) {
    super(CodigoActividadEnum.SEGURIDAD, nombre);
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
