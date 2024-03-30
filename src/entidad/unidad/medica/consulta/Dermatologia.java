package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de dermatología. */
public class Dermatologia extends Consulta{

    /**
     * Constructor de Consulta de Dermatología.
     *
     * @param nombre nombre de la unidad.
     */
    public Dermatologia(String nombre) {
        super(CodigoActividadEnum.CONSULTA_DERMATOLOGIA, nombre);
    }

    @Override
    public String toString() {
        return this.getCodigoUnidad()
                + "-"
                + this.getCodigoUnidad()
                + "-"
                + this.getCodigoActividad()
                + "-"
                + this.getNombre();
    }
}

