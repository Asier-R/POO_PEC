package entidad.unidad.formacion;

import entidad.unidad.Unidad;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;
import entidad.persona.Medico;
import entidad.persona.Enfermero;

/**
 * Subclase de Unidad {@link Unidad} que se utiliza para definir las unidades que realizan labores
 * relacionadas con la formación del futuro personal médico {@link Medico} y de enfermería {@link
 * Enfermero}.
 */
public abstract class Formacion extends Unidad {

  /** Código único que identifica el área de la unidad. {@link CodigoUnidadEnum} */
  private CodigoAreaEnum codigoArea;

  /**
   * Constructor de las unidades Formativas.
   *
   * @param codigoArea código del área al que pertenece la Unidad.
   * @param nombre nombre de la unidad.
   */
  public Formacion(CodigoAreaEnum codigoArea, String nombre) {
    super(CodigoUnidadEnum.FORMACION, nombre);
    this.codigoArea = codigoArea;
  }

  public CodigoAreaEnum getCodigoArea(){
    return this.codigoArea;
  }
}
