package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Clase abstracta para representar el personal implicado en un Hospital.
 */
public abstract class Personal {
// TODO-ASIER: hacer de esto una interfaz??
    /**
     * Código de la unidad a la que está asignada la Persona.
     */
    private CodigoUnidadEnum NIF;
    /**
     * Código del área a la que está asignada la Persona.
     */
    private CodigoAreaEnum nombre;
    /**
     * Código de la actividad que realiza la Persona.
     */
    private CodigoActividadEnum apellido1;


    public Personal(){

    }
}
