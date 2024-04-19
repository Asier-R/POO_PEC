package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de aparato digestivo. */
public class AparatoDigestivo extends Consulta{

  /**
   * Constructor de Consulta de Aparato Digestivo.
   *
   * @param nombre nombre de la unidad.
   */
  public AparatoDigestivo(String nombre) {
        super(CodigoActividadEnum.CONSULTA_APARATO_DIGESTIVO, nombre);
    }

}
