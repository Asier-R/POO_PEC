package entidad.unidad.medica.quirofano;

import entidad.unidad.medica.Medica;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/** Subclase de {@link Medica} que representa un quirófano del hospital. */
public class Quirofano extends Medica {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de Quirófano.
   *
   * @param nombre nombre de la unidad.
   */
  public Quirofano(String nombre) {
    super(CodigoAreaEnum.OPERATORIO, nombre);
    this.codigoActividad = CodigoActividadEnum.QUIROFANO;
  }

  @Override
  public CodigoActividadEnum getCodigoActividad() {
    return this.codigoActividad;
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
