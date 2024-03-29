package entidad.unidad.medica.habitacion;

import entidad.unidad.medica.Medica;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/**
 * Subclase de {@link Medica} que se utiliza para definir las unidades que se ocupan de alojar a los
 * pacientes en el hospital.
 */
public abstract class Habitacion extends Medica {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de unidades de Habitación.
   *
   * @param codigoActividad código del área al que pertenece la Unidad.
   * @param nombre nombre de la unidad.
   */
  public Habitacion(CodigoActividadEnum codigoActividad, String nombre) {
    super(CodigoAreaEnum.HABITACION, nombre);
    this.codigoActividad = codigoActividad;
  }

  @Override
  public CodigoActividadEnum getCodigoActividad() {
    return this.codigoActividad;
  }
}
