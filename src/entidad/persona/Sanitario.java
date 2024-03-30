package entidad.persona;

import entidad.registro.Cita;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.List;

/** Clase abstracta para representar el personal Sanitario de un Hospital. */
public abstract class Sanitario extends Personal {

  /** Tipos de sanitarios existentes. */
  public enum TipoSanitario {
    ENFERMERO("Enfermero"),
    MEDICO("Médico"),
    ESTUDIANTE("Estudiante");

    /** Descripción del tipo de sanitario. */
    private String descripcion;

    private TipoSanitario(String descripcion) {
      this.descripcion = descripcion;
    }
  }

  /** El tipo de sanitario. */
  private TipoSanitario tipoSanitario;

  /** Código de la unidad a la que está asignada la Persona. */
  private CodigoUnidadEnum codigoUnidad;

  /** Código del área a la que está asignada la Persona. */
  private CodigoAreaEnum codigoArea;

  /** Código de la actividad que realiza la Persona. */
  private CodigoActividadEnum codigoActividad;

  /** Código de la especialidad del Sanitario. */
  private CodigoEspecialidadEnum codigoEspecialidad;

  /** Citas asignadas al Sanitario. */
  private List<Cita> citas;

  /**
   * Constructor con los campos heredados de Personal {@link Personal} y los campos propios de
   * Sanitario.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param tipoSanitario Tipo de sanitario.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   */
  protected Sanitario(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      TipoSanitario tipoSanitario,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad) {
    super(NIF, nombre, apellido1, apellido2);
    this.tipoSanitario = tipoSanitario;
    this.codigoUnidad = codigoUnidad;
    this.codigoArea = codigoArea;
    this.codigoActividad = codigoActividad;
    this.codigoEspecialidad = codigoEspecialidad;
  }

  public CodigoEspecialidadEnum getCodigoEspecialidad() {
    return codigoEspecialidad;
  }

  public void setCodigoEspecialidad(CodigoEspecialidadEnum codigoEspecialidad) {
    this.codigoEspecialidad = codigoEspecialidad;
  }

  public List<Cita> getCitas() {
    return citas;
  }

  public void setCitas(List<Cita> cita) {
    this.citas = cita;
  }

  public TipoSanitario getTipoSanitario() {
    return tipoSanitario;
  }
}
