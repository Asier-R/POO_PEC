package entidad.persona;

import entidad.registro.Cita;
import entidad.registro.Expediente;
import entidad.unidad.Unidad;
import servicio.Grabable;

/** Subclase de {@link Persona} que representa a un paciente. */
public class Paciente extends Persona implements Comparable<Paciente>{

  /** Sexo del paciente. */
  public enum Sexo {
    M,
    F
  }

  /** Expediente del paciente. */
  private Expediente expediente;

  /** Cita vigente del paciente. */
  private Cita cita;

  /** Unidad en la que se encuentra el paciente. */
  private Unidad unidad;

  /** Edad del paciente. */
  private final int edad;

  /** Sexo del paciente. */
  private final Sexo sexo;

  /**
   * Constructor con los campos heredados de Persona {@link Persona} y los propios de Paciente.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param edad Edad.
   * @param sexo Sexo.
   */
  public Paciente(
      String NIF, String nombre, String apellido1, String apellido2, int edad, Sexo sexo) {
    super(NIF, nombre, apellido1, apellido2);
    this.edad = edad;
    this.sexo = sexo;
  }

  /**
   * Devuelve el expediente del paciente.
   *
   * @return Expediente.
   */
  public Expediente getExpediente() {
    return expediente;
  }

  /**
   * Establece el expediente del paciente.
   *
   * @param expediente Expediente.
   */
  public void setExpediente(Expediente expediente) {
    this.expediente = expediente;
  }

  /**
   * Devuelve la cita vigente del paciente.
   *
   * @return Cita.
   */
  public Cita getCita() {
    return cita;
  }

  /**
   * Establece la nueva cita vigente del paciente.
   *
   * @param cita Cita.
   */
  public void setCita(Cita cita) {
    this.cita = cita;
  }

  /**
   * Devuelve la edad del paciente.
   *
   * @return Edad.
   */
  public int getEdad() {
    return edad;
  }

  /**
   * Devuelve el sexo del paciente.
   *
   * @return Sexo.
   */
  public Sexo getSexo() {
    return sexo;
  }

  @Override
  public String toString() {
    return "NIF: "
        + this.getNIF()
        + "\n"
        + "Nombre: "
        + this.getNombre()
        + "\n"
        + "Primer apellido: "
        + this.getApellido1()
        + "\n"
        + "Segundo apellido: "
        + this.getApellido2()
        + "\n"
        + "Edad: "
        + this.getEdad()
        + "\n"
        + "Sexo: "
        + this.getSexo();
  }

  @Override
  public String generarCadenaCSV() {
    return this.getNIF()
        + ","
        + this.getNombre()
        + ","
        + this.getApellido1()
        + ","
        + this.getApellido2()
        + ","
        + this.getEdad()
        + ","
        + this.getSexo().name();
  }

  @Override
  public int compareTo(Paciente p) {
    return this.getNIF().compareTo(p.getNIF());
  }
}
