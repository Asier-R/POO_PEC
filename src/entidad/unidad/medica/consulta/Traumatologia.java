package entidad.unidad.medica.consulta;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Consulta} que representa una consulta externa de traumatología. */
public class Traumatologia extends Consulta{

    /**
     * Constructor de Consulta de Traumatología.
     *
     * @param nombre nombre de la unidad.
     */
    public Traumatologia(String nombre) {
        super(CodigoActividadEnum.CONSULTA_TRAUMATOLOGIA, nombre);
    }

}

