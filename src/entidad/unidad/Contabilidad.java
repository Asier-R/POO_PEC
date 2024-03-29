package entidad.unidad;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Administracion} que define a la unidad de contabilidad. */
public class Contabilidad extends Administracion {

  /**
   * Constructor de contabilidad.
   *
   * @param nombre nombre de la unidad.
   */
  public Contabilidad(String nombre) {
    super(CodigoActividadEnum.CONTABILIDAD, nombre);
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
