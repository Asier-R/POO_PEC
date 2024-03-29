package entidad.unidad;

import enumerado.CodigoActividadEnum;

/** Subclase de {@link Administracion} que define a la unidad de recursos humanos. */
public class RRHH extends Administracion {

    /**
     * Constructor de unidad de recursos humanos.
     *
     * @param nombre nombre de la unidad.
     */
    public RRHH(String nombre) {
        super(CodigoActividadEnum.RRHH, nombre);
    }

    @Override
    public String toString() {
        return this.getCodigoUnidad() + "-" + this.getCodigoUnidad() + "-" + this.getCodigoActividad() + "-" + this.getNombre();
    }
}

