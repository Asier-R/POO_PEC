package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de cirugía general. */
public class CirugiaGeneral extends Consulta{

    /**
     * Constructor de Consulta de Cirugía General.
     *
     * @param nombre nombre de la unidad.
     */
    public CirugiaGeneral(String nombre) {
        super(CodigoActividadEnum.CONSULTA_CIRUGIA_GENERAL, nombre);
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

