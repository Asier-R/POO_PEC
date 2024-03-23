package entidad.persona;

/** Clase abstracta para representar a un paciente. */
public class Paciente extends Persona{

    public enum Sexo{
        M,
        F
    }

    // TODO: agregar atributo expediente

    private int edad;

    private Sexo sexo;

    /**
     * Constructor con los campos heredados de Persona {@link Persona}.
     *
     * @param NIF NIF.
     * @param nombre Nombre.
     * @param apellido1 Primer apellido.
     * @param apellido2 Segundo apellido.
     */
    public Paciente(String NIF, String nombre, String apellido1, String apellido2) {
        super(NIF, nombre, apellido1, apellido2);
    }

    /**
     * Constructor con los campos heredados de Persona {@link Persona} y los propios de Paciente.
     *
     * @param NIF NIF.
     * @param nombre Nombre.
     * @param apellido1 Primer apellido.
     * @param apellido2 Segundo apellido.
     */
    public Paciente(String NIF, String nombre, String apellido1, String apellido2, int edad, Sexo sexo) {
        super(NIF, nombre, apellido1, apellido2);
        this.edad = edad;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return null;
    }

}
