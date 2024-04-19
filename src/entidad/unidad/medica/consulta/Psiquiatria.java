package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de psiquiatría. */
public class Psiquiatria extends Consulta{

    /**
     * Constructor de Consulta de Psiquiatría.
     *
     * @param nombre nombre de la unidad.
     */
    public Psiquiatria(String nombre) {
        super(CodigoActividadEnum.CONSULTA_PSIQUIATRIA, nombre);
    }

}

