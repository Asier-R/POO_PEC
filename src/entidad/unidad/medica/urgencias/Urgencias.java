package entidad.unidad.medica.urgencias;

import entidad.unidad.medica.Medica;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/** Subclase de {@link Medica} que representa una sala de urgencias del hospital. */
public class Urgencias extends Medica {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de Urgencias.
   *
   * @param nombre nombre de la unidad.
   */
  public Urgencias(String nombre) {
    super(CodigoAreaEnum.URGENCIAS, nombre);
    this.codigoActividad = CodigoActividadEnum.ATENCION_URGENCIAS;
  }

  @Override
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
