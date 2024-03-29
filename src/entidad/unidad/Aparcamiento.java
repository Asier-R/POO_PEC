package entidad.unidad;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/** Subclase de {@link Servicio} que representa un aparcamiento. */
public class Aparcamiento extends Servicio {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de aparcamiento.
   *
   * @param nombre nombre de la unidad.
   */
  public Aparcamiento(String nombre) {
    super(CodigoAreaEnum.GARAJE, nombre);
    this.codigoActividad = CodigoActividadEnum.APARCAMIENTO;
  }

  /**
   * Devuelve el código de actividad de la unidad.
   *
   * @return Código de área.
   */
  public CodigoActividadEnum getCodigoActividad() {
    return codigoActividad;
  }

  @Override
  public String toString() {
    return this.getCodigoUnidad() + "-" + this.getCodigoUnidad() + "-" + this.getCodigoActividad();
  }
}
