package entidad.unidad;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Administracion} que define a la unidad de dirección. */
public class Direccion extends Administracion {

  /**
   * Constructor de dirección.
   *
   * @param nombre nombre de la unidad.
   */
  public Direccion(String nombre) {
    super(CodigoActividadEnum.DIRECCION, nombre);
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
