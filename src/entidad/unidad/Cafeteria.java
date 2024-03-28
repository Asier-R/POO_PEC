package entidad.unidad;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/**
 * Subclase de {@link Servicio} que representa una cafeteria.
 */
public class Cafeteria extends Servicio {

    /** Código de la actividad que se realiza en la unidad. */
    private CodigoActividadEnum codigoActividad;

    /**
     * Constructor de cafeteria.
     */
    public Cafeteria(String nombre){
        super(CodigoAreaEnum.ALIMENTACION, nombre);
        this.codigoActividad = CodigoActividadEnum.CAFETERIA;
    }


    @Override
    public String toString() {
        return "";
    }
}
