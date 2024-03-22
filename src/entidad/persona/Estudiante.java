package entidad.persona;

import enumerado.CodigoEspecialidadEnum;

/**
 * Clase que representa a un estudiante de medicína o enfermería.
 */
public class Estudiante{

    /**
     * Especialidad del estudiante.
     */
    private CodigoEspecialidadEnum especialidad;

    public Estudiante(String NIF, String nombre, String apellido1, String apellido2, CodigoEspecialidadEnum especialidad){
        //super(NIF, nombre, apellido1, apellido2);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return null;
    }
}
