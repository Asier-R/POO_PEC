package entidad;

import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Subclase de Unidad {@link Unidad} que se utiliza para definir las unidades que realizan o prestan servicios fuera del ámbito
 * de la medicina, pero necesarios para el correcto funcionamiento del hospital.
 */
public abstract class Servicio extends Unidad {

    /**
     * Código único que identifica el área de la unidad. {@link CodigoUnidadEnum}
     */
    private CodigoAreaEnum codigoAreaEnum;

    /**
     * Constructor de las unidades de Servicios.
     * @param nombre nombre de la unidad.
     */
    public Servicio(CodigoAreaEnum codigoAreaEnum, String nombre){
        super(CodigoUnidadEnum.SERVICIOS, nombre);
        this.codigoAreaEnum = codigoAreaEnum;
    }

}
