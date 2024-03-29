package entidad.unidad.servicio;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/** Subclase de {@link Servicio} que representa una cafeteria. */
public class Cafeteria extends Servicio {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de cafeteria.
   *
   * @param nombre nombre de la unidad.
   */
  public Cafeteria(String nombre) {
    super(CodigoAreaEnum.ALIMENTACION, nombre);
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
