package entidad.unidad.servicio.administracion;

import entidad.unidad.servicio.Servicio;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/**
 * Subclase de {@link Servicio} que se utiliza para definir las unidades que realizan tareas
 * administrativas.
 */
public abstract class Administracion extends Servicio {

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de las unidades de Servicios.
   * @param codigoActividad código de actividad.
   * @param nombre nombre de la unidad.
   */
  public Administracion(CodigoActividadEnum codigoActividad, String nombre) {
    super(CodigoAreaEnum.ADMINISTRACION, nombre);
    this.codigoActividad = codigoActividad;
  }

  public CodigoActividadEnum getCodigoActividad(){
    return this.codigoActividad;
  }
}
