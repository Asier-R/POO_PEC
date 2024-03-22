package entidad.persona;

import entidad.registro.Cita;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.List;

/** Clase que representa a un médico. */
public class Medico extends Sanitario {

  /** Años de experiencia del médico. */
  private int experiencia;

  /** Especialidades del médico. */
  private List<CodigoEspecialidadEnum> especialidades;

  /**
   * Constructor con los campos heredados de Sanitario {@link Sanitario}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   */
  public Medico(String NIF, String nombre, String apellido1, String apellido2) {
    super(NIF, nombre, apellido1, apellido2);
  }

  /**
   * Constructor con los campos heredados de Sanitario {@link Sanitario}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   */
  public Medico(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad) {
    super(NIF, nombre, apellido1, apellido2, codigoUnidad, codigoArea, codigoActividad);
  }

  /**
   * Constructor con los campos heredados de {@link Sanitario}.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param citas Citas.
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
      List<Cita> citas) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        codigoUnidad,
        codigoArea,
        codigoActividad,
        codigoEspecialidad,
        citas);
  }

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
   * @param citas Citas.
   * @param experiencia Experiencia.
   * @param especialidades Especialidades.
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
      List<Cita> citas,
      int experiencia,
      List<CodigoEspecialidadEnum> especialidades) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        codigoUnidad,
        codigoArea,
        codigoActividad,
        codigoEspecialidad,
        citas);
    this.experiencia = experiencia;
    this.especialidades = especialidades;
  }

  public int getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }

  public List<CodigoEspecialidadEnum> getEspecialidades() {
    return especialidades;
  }

  public void setEspecialidades(List<CodigoEspecialidadEnum> especialidades) {
    this.especialidades = especialidades;
  }

  @Override
  public String toString() {
    return null;
  }
}
