package entidad.registro;

import entidad.persona.Paciente;
import entidad.persona.Sanitario;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/** Apunte en la agenda de un sanitario que tiene resguardo en el expediente */
public class Cita {

  /**
   * Horario de la cita. Puede ser de mañana o de tarde.
   * Mañana (6am a 1pm) -> M
   * Tarde (1pm a 10pm) -> T
   * Noche (10pm a 6am) -> N
   */
  public enum Horario {
    M,
    T,
    N
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

  /** Indica si la cita ha vencido. */
  private boolean vencida;

  /**
   * Constructor simple de Cita, donde se inserta la fecha de creación en el momento de la creación
   * y se inicializa la lista de sanitarios.
   *
   * @param fechaCreacion Fecha de creación.
   * @param fechaCita Fecha de la cita.
   */
  public Cita(ZonedDateTime fechaCreacion, ZonedDateTime fechaCita) {
    this.fechaCreacion = ZonedDateTime.now();
    this.fechaCita = fechaCita;
    this.sanitarios = new ArrayList<>();
    this.vencida = false;
  }

  /**
   * Constructor completo de Cita, donde se inserta la fecha de creación en el momento de la
   * creación y se inicializa la lista de sanitarios.
   *
   * @param fechaCreacion Fecha de creación.
   * @param fechaCita Fecha de la cita.
   * @param paciente Paciente.
   * @param sanitarios Sanitarios.
   */
  public Cita(
      ZonedDateTime fechaCreacion,
      ZonedDateTime fechaCita,
      Paciente paciente,
      List<Sanitario> sanitarios) {
    this.fechaCreacion = ZonedDateTime.now();
    this.fechaCita = fechaCita;
    this.paciente = paciente;
    this.sanitarios = new ArrayList<>();
    this.vencida = false;
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
