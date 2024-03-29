package entidad.unidad.medica.habitacion;

import enumerado.CodigoActividadEnum;

/**
 * Subclase de {@link Habitacion} que representa una habitación de la unidad de cuidados intensivos.
 */
public class UCI extends Habitacion{
    /**
     * Constructor de habitaciones de unidades de cuidados intensivos.
     *
     * @param codigoActividad código del área al que pertenece la Unidad.
     * @param nombre          nombre de la unidad.
     */
    public UCI(CodigoActividadEnum codigoActividad, String nombre) {
        super(codigoActividad, nombre);
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
