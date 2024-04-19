package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de oncología. */
public class Oncologia extends Consulta{

    /**
     * Constructor de Consulta de Oncología.
     *
     * @param nombre nombre de la unidad.
     */
    public Oncologia(String nombre) {
        super(CodigoActividadEnum.CONSULTA_ONCOLOGIA, nombre);
    }

}

