package entidad.unidad.medica;

import entidad.unidad.Unidad;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Subclase abstracta de Unidad {@link Unidad} que se utiliza para definir las unidades que realizan labores
 * directamente relacionadas con el ámbito de la medicina.
 */
public abstract class Medica extends Unidad {

  /** Código único que identifica el área de la unidad. {@link CodigoUnidadEnum} */
  private CodigoAreaEnum codigoArea;

  /**
   * Constructor de las unidades Médicas.
   *
   * @param codigoArea código del área al que pertenece la Unidad.
   * @param nombre nombre de la unidad.
   */
  public Medica(CodigoAreaEnum codigoArea, String nombre) {
    super(CodigoUnidadEnum.MEDICINA, nombre);
    this.codigoArea = codigoArea;
  }

  public CodigoAreaEnum getCodigoArea() {
    return codigoArea;
  }
}
