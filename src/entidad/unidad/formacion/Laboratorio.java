package entidad.unidad.formacion;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/** Subclase de {@link Formacion} que representa un laboratorio. */
public class Laboratorio extends Formacion {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de laboratorio.
   *
   * @param nombre nombre de la unidad.
   */
  public Laboratorio(String nombre) {
    super(CodigoAreaEnum.LABORATORIO, nombre);
    this.codigoActividad = CodigoActividadEnum.LABORATORIO;
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
