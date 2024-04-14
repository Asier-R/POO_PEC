package entidad.registro;

import entidad.persona.Paciente;
import servicio.DiagnosticoTratamiento;

import java.time.ZonedDateTime;

/** Clase que representa el expediente médico de un paciente. */
public class Expediente {

  /** Estados por los que puede pasar un paciente durante su visita al hospital. */
  public enum Estado {
    EN_ESPERA,
    CITADO,
    EN_CONSULTA,
    EN_TRATAMIENTO,
    DERIVADO,
    SANO;
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

  /**
   * Cita actual del paciente.
   */
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
  }

  public ZonedDateTime getFechaApertura() {
    return fechaApertura;
  }

  public ZonedDateTime getFechaCierre() {
    return fechaCierre;
  }

  public void setFechaCierre(ZonedDateTime fechaCierre) {
    this.fechaCierre = fechaCierre;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public Historial getHistorial() {
    return historial;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public Cita getCita() {
    return cita;
  }

  public void setCita(Cita cita) {
    this.cita = cita;
  }

  public DiagnosticoTratamiento.DiagnosticosTratamientos getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(DiagnosticoTratamiento.DiagnosticosTratamientos diagnostico) {
    this.diagnostico = diagnostico;
  }
}
