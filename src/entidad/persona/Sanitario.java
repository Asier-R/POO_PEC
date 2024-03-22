package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Clase abstracta para representar el personal Sanitario de un Hospital.
 */
public abstract class Sanitario extends Personal{

    /**
     * Código de la especialidad del Sanitario.
     */
    private CodigoEspecialidadEnum codigoEspecialidad;

    /**
     * Constructor con los campos heredados de Personal {@link Personal}.
     * @param NIF             NIF.
     * @param nombre          Nombre.
     * @param apellido1       Primer apellido.
     * @param apellido2       Segundo apellido.
     */
    protected Sanitario(
            String NIF,
            String nombre,
            String apellido1,
            String apellido2
    ){
        super(NIF, nombre, apellido1, apellido2);
    }

    /**
     * Constructor con los campos heredados de Personal {@link Personal}.
     *
     * @param NIF             NIF.
     * @param nombre          Nombre.
     * @param apellido1       Primer apellido.
     * @param apellido2       Segundo apellido.
     * @param codigoUnidad    Código de la unidad.
     * @param codigoArea      Código del área.
     * @param codigoActividad Código de actividad.
     */
    protected Sanitario(
            String NIF,
            String nombre,
            String apellido1,
            String apellido2,
            CodigoUnidadEnum codigoUnidad,
            CodigoAreaEnum codigoArea,
            CodigoActividadEnum codigoActividad
    ) {
        super(
                NIF,
                nombre,
                apellido1,
                apellido2,
                codigoUnidad,
                codigoArea,
                codigoActividad
        );
    }

    /**
     * Constructor con los campos heredados de Personal {@link Personal} y los campos propios de Sanitario.
     *
     * @param NIF                NIF.
     * @param nombre             Nombre.
     * @param apellido1          Primer apellido.
     * @param apellido2          Segundo apellido.
     * @param codigoUnidad       Código de la unidad.
     * @param codigoArea         Código del área.
     * @param codigoActividad    Código de actividad.
     * @param codigoEspecialidad Código de especialidad.
     */
    protected Sanitario(
            String NIF,
            String nombre,
            String apellido1,
            String apellido2,
            CodigoUnidadEnum codigoUnidad,
            CodigoAreaEnum codigoArea,
            CodigoActividadEnum codigoActividad,
            CodigoEspecialidadEnum codigoEspecialidad
    ) {
        super(
                NIF,
                nombre,
                apellido1,
                apellido2,
                codigoUnidad,
                codigoArea,
                codigoActividad
        );
        this.codigoEspecialidad = codigoEspecialidad;
    }

    public CodigoEspecialidadEnum getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(CodigoEspecialidadEnum codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }
}
