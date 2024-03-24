package entidad.registro;

import entidad.persona.Paciente;
import entidad.persona.Sanitario;
import entidad.unidad.Unidad;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/** Apunte en la agenda de un sanitario que tiene resguardo en el expediente */
public class Cita {

  /**
   * Horario de la cita. Puede ser de mañana o de tarde. Mañana (6am a 2pm) -> M Tarde (2pm a 10pm)
   * -> T Noche (10pm a 6am) -> N
   */
  public enum Horario {
    M(6),
    T(13),
    N(22);

    /** Hora inicial rango. */
    private int inicio;

    /**
     * Constructor de Horario.
     *
     * @param inicio Hora inicial.
     */
    private Horario(int inicio) {
      this.inicio = inicio;
    }
  }

  /** Horario en el que se cita al paciente y a los sanitarios. */
  private Horario horario;

  /** Fecha en la que se ha creado la cita. */
  private ZonedDateTime fechaCreacion;

  /** Fecha en la que se cita al paciente en una unidad junto con el sanitario que le atiende. */
  private ZonedDateTime fechaCita;

  /** Paciente citado para recibir la atención sanitaria */
  private Paciente paciente;

  /** Personal sanitario implicado en la cita. Pueden ser médicos, enfermeros o estudiantes. */
  private List<Sanitario> sanitarios;

  /**
   * Unidad destíno de la cita.
   */
  private Unidad unidad;

  /** Indica si la cita ha vencido. */
  private boolean vencida;

  /**
   * Constructor de Cita, donde se inserta la fecha de creación en el momento de la
   * creación, se inicializa la lista de sanitarios y se determina el horario.
   *
   * @param fechaCreacion Fecha de creación.
   * @param fechaCita Fecha de la cita.
   * @param paciente Paciente.
   */
  public Cita(
      ZonedDateTime fechaCreacion,
      ZonedDateTime fechaCita,
      Paciente paciente) {
    this.fechaCreacion = ZonedDateTime.now();
    this.fechaCita = fechaCita;
    this.paciente = paciente;
    this.sanitarios = new ArrayList<>();
    this.vencida = false;
    determinarHorario(fechaCreacion);
  }

  private void determinarHorario(ZonedDateTime fechaCreacion) {
    final int hora = fechaCreacion.getHour();
    if(Horario.M.inicio <= hora && hora < Horario.T.inicio) this.horario = Horario.M;
    else if(Horario.T.inicio <= hora && hora < Horario.N.inicio) this.horario = Horario.T;
    else this.horario = Horario.N;
  }

  public ZonedDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public ZonedDateTime getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(ZonedDateTime fechaCita) {
    this.fechaCita = fechaCita;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public List<Sanitario> getSanitarios() {
    return sanitarios;
  }

  public void addSanitario(Sanitario sanitario) {
    this.sanitarios.add(sanitario);
  }

  public void setVencida() {
    this.vencida = true;
  }
}
