package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

/** Subclase de {@link Sanitario} que representa a un médico. */
public class Medico extends Sanitario {

  /** Código de la unidad a la que está asignada la Persona. */
  private CodigoUnidadEnum codigoUnidad;

  /** Código del área a la que está asignada la Persona. */
  private CodigoAreaEnum codigoArea;

  /** Código de la actividad que realiza la Persona. */
  private CodigoActividadEnum codigoActividad;

  /** Años de experiencia del médico. */
  private int experiencia;

  /** Segunda especialidad del médico. */
  private CodigoEspecialidadEnum segundaEspecialidad;

  /**
   * Constructor con los campos heredados de {@link Sanitario} y los campos propios de Médico.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param experiencia Experiencia.
   * @param segundaEspecialidad Especialidades.
   */
  public Medico(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      int experiencia,
      CodigoEspecialidadEnum segundaEspecialidad) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        TipoSanitario.MEDICO,
        codigoUnidad,
        codigoArea,
        codigoActividad,
        codigoEspecialidad);
    this.experiencia = experiencia;
    this.segundaEspecialidad = segundaEspecialidad;
  }

  public int getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }

  public CodigoEspecialidadEnum getSegundaEspecialidad() {
    return segundaEspecialidad;
  }

  @Override
  public CodigoUnidadEnum getCodigoUnidad() {
    return codigoUnidad;
  }

  @Override
  public CodigoAreaEnum getCodigoArea() {
    return codigoArea;
  }

  @Override
  public CodigoActividadEnum getCodigoActividad() {
    return codigoActividad;
  }

  @Override
  public String toString() {
    return null;
  }
}
