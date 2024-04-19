package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de atención primaria. */
public class Primaria extends Consulta {

  /**
   * Constructor de Consulta de Atención Primaria.
   *
   * @param nombre nombre de la unidad.
   */
  public Primaria(String nombre) {
    super(CodigoActividadEnum.CONSULTA_PRIMARIA, nombre);
  }

}
