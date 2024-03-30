package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de medicína interna. */
public class MedicinaInterna extends Consulta{

    /**
     * Constructor de Consulta de Medicína Interna.
     *
     * @param nombre nombre de la unidad.
     */
    public MedicinaInterna(String nombre) {
        super(CodigoActividadEnum.CONSULTA_MEDICINA_INTERNA, nombre);
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

