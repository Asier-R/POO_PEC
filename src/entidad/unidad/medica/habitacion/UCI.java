package entidad.unidad.medica.habitacion;

import enumerado.CodigoActividadEnum;

import java.util.ArrayList;

/**
 * Subclase de {@link Habitacion} que representa una habitación de la unidad de cuidados intensivos.
 */
public class UCI extends Habitacion{

    /**
     * Constructor de habitaciones de unidades de cuidados intensivos.
     *
     * @param nombre          nombre de la unidad.
     */
    public UCI(String nombre) {
        super(CodigoActividadEnum.UCI, nombre);
        this.pacientes = new ArrayList<>();
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
