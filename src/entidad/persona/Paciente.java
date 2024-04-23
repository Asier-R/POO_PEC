package entidad.persona;

import entidad.registro.Cita;
import entidad.registro.Expediente;
import entidad.unidad.Unidad;

/** Subclase de {@link Persona} que representa a un paciente. */
public class Paciente extends Persona implements Comparable<Paciente> {

  /** Sexo del paciente. */
  public enum Sexo {
    M(1, "M"),
    F(2, "F");

    /** Id del sexo. */
    private int id;

    /** Código del sexo. */
    private String codigo;

    /**
     * Constructor de Sexo.
     * @param id Id del sexo.
     * @param codigo Código del sexo.
     */
    private Sexo(int id, String codigo) {
      this.id = id;
      this.codigo = codigo;
    }

    /**
     * Devuelve un sexo en función del código.
     *
     * @param codigo código.
     * @return sexo correspondiente al código de entrada.
     */
    public static Sexo getFromCodigo(String codigo) {
      for (Sexo g : values()) {
        if (g.codigo.equals(codigo)) {
          return g;
        }
      }
      return null;
    }

    /**
     * Devuelve el sexo a partir del ID.
     *
     * @param id Id del código a obtener.
     * @return sexo correspondiente al id.
     */
    public static Sexo getFromId(int id) {
      for (Sexo c : values()) {
        if (c.getId() == id) {
          return c;
        }
      }
      return null;
    }

    /** Muestra por pantalla los diferentes códigos de sexo. */
    public static void mostrarPorPantalla() {
      for (Sexo c : values()) {
        System.out.println("> " + c.getId() + ". " + c.getCodigo());
      }
    }

    /**
     * Devuelve el id del sexo.
     *
     * @return Id del sexo.
     */
    public int getId() {
      return this.id;
    }

    /**
     * Devuelve el código del sexo.
     *
     * @return Código del sexo.
     */
    public String getCodigo() {
      return this.codigo;
    }
  }

  /** Expediente del paciente. */
  private Expediente expediente;

  /** Cita vigente del paciente. */
  private Cita cita;

  /** Unidad en la que se encuentra el paciente. */
  private Unidad ubicacion;

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
    this.expediente = new Expediente(this);
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

  /**
   * Devuelve la ubicación del paciente.
   *
   * @return Unidad en la que se encuentra el paciente.
   */
  public Unidad getUbicacion() {
    return ubicacion;
  }

  /**
   * Establece la ubicación del paciente.
   *
   * @param ubicacion Unidad en la que se encuentra el paciente.
   */
  public void setUbicacion(Unidad ubicacion) {
    this.ubicacion = ubicacion;
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
        + this.getSexo()
        + "\n"
        + "Ubicación: "
        + (this.getUbicacion()==null?"sin asignar":this.getUbicacion());
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
