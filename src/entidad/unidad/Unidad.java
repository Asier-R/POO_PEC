package entidad.unidad;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Clase abstracta para representar todas las unidades de un hospital. */
public abstract class Unidad implements Comparable<Unidad> {

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
   *
   * @return Código de unidad.
   */
  public CodigoUnidadEnum getCodigoUnidad() {
    return this.codigoUnidad;
  }

  /**
   * Devuelve el nombre de la unidad.
   *
   * @return nombre de la unidad.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Devuelve el código de área de la unidad.
   *
   * @return Código de área.
   */
  public abstract CodigoAreaEnum getCodigoArea();

  /**
   * Devuelve el código de actividad de la unidad.
   *
   * @return Código de actividad.
   */
  public abstract CodigoActividadEnum getCodigoActividad();

  /**
   * Devuelve una cadena de texto que identifica a la unidad.
   *
   * @return cadena de texto.
   */
  public abstract String toString();

  @Override
  public int compareTo(Unidad u) {
    return this.getCodigoUnidad().compareTo(u.getCodigoUnidad());
  }
}
