package entidad.persona;

/**
 * Clase abstracta para representar todas las personas relacionadas con un Hospital.
 */
public abstract class Persona {

    /**
     * Número de identificación fiscal de la persona.
     */
    private String NIF;
    /**
     * Nombre de la persona.
     */
    private String nombre;
    /**
     * Primer apellido de la persona.
     */
    private String apellido1;
    /**
     * Segundo apellido de la persona.
     */
    private String apellido2;

    /**
     * Constructor de Persona.
     * @param NIF NIF.
     * @param nombre Nombre.
     * @param apellido1 Primer apellido.
     * @param apellido2 Segundo apellido.
     */
    public Persona(String NIF, String nombre, String apellido1, String apellido2){
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public abstract String toString();
}
