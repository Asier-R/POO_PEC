package entidad.persona;

import entidad.registro.Cita;
import entidad.registro.Expediente;
import entidad.unidad.Unidad;

/** Clase que representa a un paciente. */
public class Paciente extends Persona {

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

  public Expediente getExpediente() {
    return expediente;
  }

  public void setExpediente(Expediente expediente) {
    this.expediente = expediente;
  }

  public Cita getCita() {
    return cita;
  }

  public void setCita(Cita cita) {
    this.cita = cita;
  }

  public Unidad getUnidad() {
    return unidad;
  }

  public void setUnidad(Unidad unidad) {
    this.unidad = unidad;
  }

  public int getEdad() {
    return edad;
  }

  public Sexo getSexo() {
    return sexo;
  }

  @Override
  public String toString() {
    return null;
  }
}
