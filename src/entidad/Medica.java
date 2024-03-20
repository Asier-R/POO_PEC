package entidad;

import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Subclase de Unidad {@link Unidad} que se utiliza para definir las unidades que realizan labores directamente relacionadas
 * con el ámbito de la medicina.
 */
public abstract class Medica extends Unidad{

    /**
     * Código único que identifica el área de la unidad. {@link CodigoUnidadEnum}
     */
    private CodigoAreaEnum codigoAreaEnum;

    /**
     * Constructor de las unidades Médicas.
     * @param nombre nombre de la unidad.
     */
    public Medica(CodigoAreaEnum codigoAreaEnum, String nombre){
        super(CodigoUnidadEnum.MEDICINA, nombre);
        this.codigoAreaEnum = codigoAreaEnum;
    }

}
