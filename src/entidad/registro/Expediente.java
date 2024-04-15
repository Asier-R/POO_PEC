package entidad.registro;

import entidad.persona.Paciente;
import servicio.DiagnosticoTratamiento;

import java.time.ZonedDateTime;

/** Clase que representa el expediente médico de un paciente. */
public class Expediente {

  /** Estados por los que puede pasar un paciente durante su visita al hospital. */
  public enum Estado {
    EN_ESPERA("En espera"),
    CITADO("Citado"),
    EN_CONSULTA("En consulta"),
    EN_TRATAMIENTO("En tratamiento"),
    DERIVADO("Derivado"),
    SANO("Sano");

    /** Descripción del estado */
    private String descripcion;

    /**
     * Constructor privado de estado.
     *
     * @param descripcion Descripción.
     */
    private Estado(String descripcion) {
      this.descripcion = descripcion;
    }

    /**
     * Devuelve la descripción del estado.
     *
     * @return Descripción.
     */
    public String getDescripcion() {
      return this.descripcion;
    }

    /**
     * Establece la descripción.
     *
     * @param descripcion Descripción.
     */
    private void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
    }
  }

  /** Fecha de apertura de expediente. */
  private final ZonedDateTime fechaApertura;

  /** Fecha en la que se cierra el expendiente del paciente. Solo se cierra en caso de defunción */
  private ZonedDateTime fechaCierre;

  /** Paciente al que pertenece el expediente. */
  private final Paciente paciente;

  /** Historial del paciente. */
  private final Historial historial;

  /** Estado actual del paciente. */
  private Estado estado;

  /** Cita actual del paciente. */
  private Cita cita;

  /** Diagnóstico actual del paciente. */
  private DiagnosticoTratamiento.DiagnosticosTratamientos diagnostico;

  /**
   * Constructor de Expediente.
   *
   * @param paciente Paciente.
   */
  public Expediente(Paciente paciente) {
    this.fechaApertura = ZonedDateTime.now();
    this.paciente = paciente;
    this.historial = new Historial();
    this.estado = Estado.EN_ESPERA;
  }

  /**
   * Devuelve la fecha de apertura del expediente.
   *
   * @return Fecha de apertura.
   */
  public ZonedDateTime getFechaApertura() {
    return fechaApertura;
  }

  /**
   * Devuelve la fecha de cierre del expediente.
   *
   * @return Fecha de cierre.
   */
  public ZonedDateTime getFechaCierre() {
    return fechaCierre;
  }

  /**
   * Establece la fecha de cierre del expediente.
   *
   * @param fechaCierre Fecha de cierre.
   */
  public void setFechaCierre(ZonedDateTime fechaCierre) {
    this.fechaCierre = fechaCierre;
  }

  /**
   * Devuelve el paciente al que pertenece el expediente.
   *
   * @return Paciente del expediente.
   */
  public Paciente getPaciente() {
    return paciente;
  }

  /**
   * Devuelve el historial del expediente.
   *
   * @return Historial del expediente.
   */
  public Historial getHistorial() {
    return historial;
  }

  /**
   * Devuelve el estado del paciente.
   *
   * @return Estado del paciente.
   */
  public Estado getEstado() {
    return estado;
  }

  /**
   * Establece el estado del paciente.
   *
   * @param estado Estado del paciente.
   */
  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  /**
   * Devuelve la cita vigente del paciente.
   *
   * @return Cita vigente.
   */
  public Cita getCita() {
    return cita;
  }

  /**
   * Establece la cita vigente del paciente.
   *
   * @param cita Cita vigente.
   */
  public void setCita(Cita cita) {
    this.cita = cita;
  }

  /**
   * Devuelve el diagnóstico actual del paciente.
   *
   * @return Diagnóstico actual.
   */
  public DiagnosticoTratamiento.DiagnosticosTratamientos getDiagnostico() {
    return diagnostico;
  }

  /**
   * Establece el diagnóstico actual del paciente.
   *
   * @param diagnostico Diagnóstico actual.
   */
  public void setDiagnostico(DiagnosticoTratamiento.DiagnosticosTratamientos diagnostico) {
    this.diagnostico = diagnostico;
  }
}
