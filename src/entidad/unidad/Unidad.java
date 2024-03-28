package entidad.unidad;

import enumerado.CodigoUnidadEnum;

/** Clase abstracta para representar todas las unidades de un hospital. */
public abstract class Unidad {

  /** Código único que identifica a la unidad. {@link CodigoUnidadEnum} */
  private CodigoUnidadEnum codigoUnidad;

  /** Nombre completo que recibe la unidad. */
  private String nombre;

  /**
   * Constructor de unidad.
   *
   * @param codigoUnidad código de la unidad.
   * @param nombre nombre de la unidad.
   */
  protected Unidad(CodigoUnidadEnum codigoUnidad, String nombre) {
    this.nombre = nombre;
    this.codigoUnidad = codigoUnidad;
  }

  /**
   * Devuelve el código de unidad.
   * @return Código de área.
   */
  public CodigoUnidadEnum getCodigoUnidad(){
    return this.codigoUnidad;
  }

  public abstract String toString();
}
