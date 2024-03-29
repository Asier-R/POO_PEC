package entidad.unidad.servicio.administracion;

import enumerado.CodigoActividadEnum;

/**
 * Subclase de {@link Administracion} que define a la unidad encargada de gestionar la documentación
 * clínica.
 */
public class DocClinica extends Administracion {

  /**
   * Constructor de unidad de documentación clínica.
   *
   * @param nombre nombre de la unidad.
   */
  public DocClinica(String nombre) {
    super(CodigoActividadEnum.DOC_CLINICA, nombre);
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
