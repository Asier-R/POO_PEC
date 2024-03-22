package entidad.unidad;

import entidad.unidad.Unidad;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Subclase de Unidad {@link Unidad} que se utiliza para definir las unidades que realizan labores
 * relacionadas con la formación del futuro personal médico y de enfermería.
 */
public abstract class Formacion extends Unidad {

  /** Código único que identifica el área de la unidad. {@link CodigoUnidadEnum} */
  private CodigoAreaEnum codigoAreaEnum;

  /**
   * Constructor de las unidades Formativas.
   *
   * @param nombre nombre de la unidad.
   */
  public Formacion(CodigoAreaEnum codigoAreaEnum, String nombre) {
    super(CodigoUnidadEnum.FORMACION, nombre);
    this.codigoAreaEnum = codigoAreaEnum;
  }
}
