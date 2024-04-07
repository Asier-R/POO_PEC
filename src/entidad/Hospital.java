package entidad;

import entidad.persona.Paciente;
import entidad.persona.Personal;
import entidad.unidad.Unidad;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa a un hospital junto a todas sus unidades, pacientes y personal del hospital.
 */
public class Hospital {

  /** Las unidades del hospital. */
  private List<Unidad> unidades;

  /** Pacientes del hospital. */
  private List<Paciente> pacientes;

  /** Personal que trabaja en el hospital. */
  private List<Personal> personal;

  /** Constructor vacío de hospital. */
  public Hospital() {
    // Constructor vacío
  }

  /**
   * Constructor de hospital.
   * @param unidades unidades.
   * @param pacientes pacientes.
   * @param personal personal.
   */
  public Hospital(List<Unidad> unidades, List<Paciente> pacientes, List<Personal> personal) {
    this.unidades = unidades;
    this.pacientes = pacientes;
    this.personal = personal;
  }

  /**
   * Añade una unidad al hospital.
   * @param unidad unidad a añadir.
   */
  public void registrarUnidad(Unidad unidad) {
    this.unidades.add(unidad);
    this.unidades.sort(Unidad::compareTo);
  }

  /**
   * Añade un paciente al hospital.
   * @param paciente paciente a añadir.
   */
  public void registrarPaciente(Paciente paciente) {
    this.pacientes.add(paciente);
    this.pacientes.sort(Paciente::compareTo);
  }

  /**
   * Borra un paciente del hospital.
   * @param paciente Paciente a borrar.
   */
  public void borrarPaciente(Paciente paciente) {
    this.pacientes = this.pacientes.stream().filter(p -> !p.equals(paciente)).collect(Collectors.toList());
    this.pacientes.sort(Paciente::compareTo);
  }

  /**
   * Añade personal al hospital.
   * @param personal personal a añadir.
   */
  public void registrarPersonal(Personal personal) {
    this.personal.add(personal);
    this.personal.sort(Personal::compareTo);
  }

  /**
   * Borra un miembro del personal del hospital.
   * @param personal Miembro del personal a borrar.
   */
  public void borrarPersonal(Personal personal) {
    this.personal = this.personal.stream().filter(p -> !p.equals(personal)).collect(Collectors.toList());
    this.personal.sort(Personal::compareTo);
  }

  /**
   * Devuelve las unidades del hospital.
   * @return Lista de unidades.
   */
  public List<Unidad> getUnidades() {
    return unidades;
  }

  /**
   * Devuelve los pacientes del hospital.
   * @return Lista de pacientes.
   */
  public List<Paciente> getPacientes() {
    return pacientes;
  }

  /**
   * Devuelve el personal del hospital.
   * @return Lista de personal.
   */
  public List<Personal> getPersonal() {
    return personal;
  }
}
