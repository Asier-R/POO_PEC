package entidad.registro;

import entidad.persona.Paciente;
import entidad.persona.Sanitario;
import entidad.unidad.Unidad;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/** Apunte en la agenda de un sanitario que tiene resguardo en el expediente */
public class Cita implements Comparable<Cita> {

  final String STR_FORMATO_FECHA = "HH:mm:ss dd-MM-uuuu";

  /**
   * Horario de la cita. Puede ser de mañana o de tarde. Mañana (M) de 6am a 2pm, Tarde (T) de 2pm a
   * 10pm y Noche (N) de 10pm a 6am.
   */
  public enum Horario {
    M(6, "Mañana"),
    T(13,"Tarde"),
    N(22, "Noche");

    /** Hora inicial rango. */
    private final int inicio;
    private final String descripcion;

    /**
     * Constructor de Horario.
     *
     * @param inicio Hora inicial.
     */
    private Horario(int inicio, String descripcion) {
      this.inicio = inicio;
      this.descripcion = descripcion;
    }
  }

  /** Horario en el que se cita al paciente y a los sanitarios. */
  private Horario horario;

  /** Fecha en la que se ha creado la cita. */
  private final ZonedDateTime fechaCreacion;

  /** Fecha en la que se cita al paciente en una unidad junto con el sanitario que le atiende. */
  private ZonedDateTime fechaCita;

  /** Paciente citado para recibir la atención sanitaria */
  private Paciente paciente;

  /** Personal sanitario implicado en la cita. Pueden ser médicos, enfermeros o estudiantes. */
  private final List<Sanitario> sanitarios;

  /** Unidad destíno de la cita. */
  private Unidad ubicacion;

  /** Indica si la cita ha vencido. */
  private boolean vencida;

  /**
   * Constructor de Cita, donde se inserta la fecha de creación en el momento de la creación, se
   * inicializa la lista de sanitarios y se determina el horario.
   *
   * @param fechaCreacion Fecha de creación.
   * @param fechaCita Fecha de la cita.
   * @param paciente Paciente.
   */
  public Cita(
      ZonedDateTime fechaCreacion, ZonedDateTime fechaCita, Paciente paciente, Unidad ubicacion) {
    this.fechaCreacion = ZonedDateTime.now();
    this.fechaCita = fechaCita;
    this.paciente = paciente;
    this.sanitarios = new ArrayList<>();
    this.vencida = false;
    this.ubicacion = ubicacion;
    determinarHorario(fechaCreacion);
  }

  private void determinarHorario(ZonedDateTime fechaCreacion) {
    final int hora = fechaCreacion.getHour();
    if (Horario.M.inicio <= hora && hora < Horario.T.inicio) this.horario = Horario.M;
    else if (Horario.T.inicio <= hora && hora < Horario.N.inicio) this.horario = Horario.T;
    else this.horario = Horario.N;
  }

  public ZonedDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public ZonedDateTime getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(ZonedDateTime fechaCita){
    this.fechaCita = fechaCita;
    if(this.fechaCita!=null)determinarHorario(this.fechaCita);
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente){
    this.paciente = paciente;
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

  public Horario getHorario() {
    return horario;
  }

  public Unidad getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(Unidad ubicacion){
    this.ubicacion = ubicacion;
  }

  public boolean isVencida() {
    return vencida;
  }

  @Override
  public int compareTo(Cita c) {
    return this.getFechaCita().compareTo(c.getFechaCita());
  }

  @Override
  public String toString() {
    return "Cita: "
            + "\n"
            + "Fecha Creación: " + (printFecha(this.getFechaCreacion()))
            + "\n"
            + "Fecha Cita: " + (printFecha(this.getFechaCita()))
            + "\n"
            + "Horario: " + printHorario()
            + "\n"
            + "Vencida: " + this.isVencida()
            + "\n"
            + "Ubicación: " + (this.getUbicacion()==null?"":this.getUbicacion().getNombre())
            + "\n"
            + "Paciente: " + printPaciente()
            + "\n"
            + "Sanitarios: " + printSanitarios();
  }

  public String printHorario(){
    if(this.getHorario()!= null) return this.getHorario().descripcion;
    else return "";
  }

  public String printPaciente(){
    String paciente = "";
    if(this.getPaciente()!=null) paciente = this.getPaciente().toString().replace("\n","  ");
    return paciente;
  }

  public String printSanitarios(){
    StringBuilder sanitarios = new StringBuilder("\n");
    if(this.getSanitarios()!=null)this.getSanitarios().forEach(s -> sanitarios.append(s.toString().replace("\n","  ")).append("\n"));
    return sanitarios.toString();
  }

  public String printFecha(ZonedDateTime fecha){
    if(fecha != null){
      return fecha.format(DateTimeFormatter.ofPattern(STR_FORMATO_FECHA));
    }else {
      return "";
    }
  }
}
