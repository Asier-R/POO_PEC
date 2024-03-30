package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de oftalmología. */
public class Oftalmologia extends Consulta{

    /**
     * Constructor de Consulta de Oftalmología.
     *
     * @param nombre nombre de la unidad.
     */
    public Oftalmologia(String nombre) {
        super(CodigoActividadEnum.CONSULTA_OFTALMOLOGIA, nombre);
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

