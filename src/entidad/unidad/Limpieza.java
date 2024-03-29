package entidad.unidad;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Administracion} que define a la unidad de limpieza. */
public class Limpieza extends Administracion {

  /**
   * Constructor de unidad de limpieza.
   *
   * @param nombre nombre de la unidad.
   */
  public Limpieza(String nombre) {
    super(CodigoActividadEnum.LIMPIEZA, nombre);
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
