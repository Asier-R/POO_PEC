package entidad.persona;

import servicio.Grabable;

/** Clase abstracta para representar todas las personas relacionadas con un Hospital. */
public abstract class Persona implements Grabable {

  /** Número de identificación fiscal de la persona. */
  private String NIF;

  /** Nombre de la persona. */
  private String nombre;

  /** Primer apellido de la persona. */
  private String apellido1;

  /** Segundo apellido de la persona. */
  private String apellido2;

  /**
   * Constructor de Persona.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   */
  protected Persona(String NIF, String nombre, String apellido1, String apellido2) {
    this.NIF = NIF;
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
  }

  /**
   * Devuelve el número de identificación fiscal de la persona.
   *
   * @return NIF.
   */
  public String getNIF() {
    return NIF;
  }

  /**
   * Devuelve el nombre de la persona.
   *
   * @return Nombre.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Devuelve el primer apellido de la persona.
   *
   * @return Primer apellido.
   */
  public String getApellido1() {
    return apellido1;
  }

  /**
   * Devuelve el segundo apellido de la persona.
   *
   * @return Segundo apellido.
   */
  public String getApellido2() {
    return apellido2;
  }

  /**
   * Devuelve una cadena de texto que identifica a la persona.
   *
   * @return cadena de texto.
   */
  public abstract String toString();
}
