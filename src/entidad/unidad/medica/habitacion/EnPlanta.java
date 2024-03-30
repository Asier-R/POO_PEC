package entidad.unidad.medica.habitacion;

import enumerado.CodigoActividadEnum;

/**
 * Subclase de {@link Habitacion} que representa una habitación de ingreso en planta.
 */
public class EnPlanta extends Habitacion {
  /**
   * Constructor de habitaciones para ingresos en planta.
   *
   * @param nombre nombre de la unidad.
   */
  public EnPlanta(String nombre) {
    super(CodigoActividadEnum.EN_PLANTA, nombre);
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
