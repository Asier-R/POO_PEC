package entidad.unidad.formacion;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/** Subclase de {@link Formacion} que representa una clase. */
public class Clase extends Formacion {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de la unidad de clase.
   *
   * @param nombre nombre de la unidad.
   */
  public Clase(String nombre) {
    super(CodigoAreaEnum.CLASE, nombre);
    this.codigoActividad = CodigoActividadEnum.CAFETERIA;
  }

  public CodigoActividadEnum getCodigoActividad() {
    return codigoActividad;
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
