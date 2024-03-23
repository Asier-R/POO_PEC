package entidad.registro;

import entidad.persona.Paciente;
import entidad.persona.Sanitario;

import java.time.ZonedDateTime;
import java.util.List;

/** Apunte en la agenda de un sanitario que tiene resguardo en el expediente */
public class Cita {

  /**
   * Fecha en la que se ha creado la cita.
   */
  private ZonedDateTime fechaCreacion;

  /**
   * Fecha en la que se cita al paciente en una unidad junto con el sanitario que le atiende.
   */
  private ZonedDateTime fechaCita;

  /**
   * Paciente citado para recibir la atención sanitaria
   */
  private Paciente paciente;

  /**
   * Personal sanitario implicado en la cita. Pueden ser médicos, enfermeros o estudiantes.
   */
  private List<Sanitario> sanitarios;


  //TODO: constructor

}
