package entidad.unidad.medica.consulta;

import entidad.unidad.medica.Medica;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

/**
 * Subclase de {@link Medica} que se utiliza para definir las unidades que realizan consultas médicas.
 */
public abstract class Consulta extends Medica {

    /** Código de la actividad que se realiza en la unidad. */
    private CodigoActividadEnum codigoActividad;

    /**
     * Constructor de Consulta.
     *
     * @param codigoActividad código del área al que pertenece la Unidad.
     * @param nombre     nombre de la unidad.
     */
    public Consulta(CodigoActividadEnum codigoActividad, String nombre) {
        super(CodigoAreaEnum.CONSULTA, nombre);
        this.codigoActividad = codigoActividad;
    }

    @Override
    public CodigoActividadEnum getCodigoActividad() {
        return codigoActividad;
    }
}
