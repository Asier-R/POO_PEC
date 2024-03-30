package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de cardiología. */
public class Cardiologia extends Consulta{

    /**
     * Constructor de Consulta de Cardiología.
     *
     * @param nombre nombre de la unidad.
     */
    public Cardiologia(String nombre) {
        super(CodigoActividadEnum.CONSULTA_CARDIOLOGIA, nombre);
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

