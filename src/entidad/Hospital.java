package entidad;

import entidad.persona.Paciente;
import entidad.persona.Personal;
import entidad.unidad.Unidad;

import java.util.List;

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

  /** Constructor de hospital. */
  public Hospital(List<Unidad> unidades, List<Paciente> pacientes, List<Personal> personal) {
    this.unidades = unidades;
    this.pacientes = pacientes;
    this.personal = personal;
  }

  /** Añade una unidad al hospital. */
  public void registrarUnidad(Unidad unidad) {
    this.unidades.add(unidad);
  }

  /** Añade un paciente al hospital. */
  public void registrarPaciente(Paciente paciente) {
    this.pacientes.add(paciente);
  }

  /** Añade personal al hospital. */
  public void registrarPersonal(Personal personal) {
    this.personal.add(personal);
  }
}
