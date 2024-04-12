package entidad.persona;

import entidad.registro.Cita;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.ArrayList;
import java.util.List;

/** Subclase abstracta de {@link Personal} para representar el personal Sanitario de un Hospital. */
public abstract class Sanitario extends Personal {

  /** Tipos de sanitarios existentes. */
  public enum TipoSanitario {
    ENFERMERO("Enfermero"),
    MEDICO("Médico"),
    ESTUDIANTE("Estudiante");

    /** Descripción del tipo de sanitario. */
    private String descripcion;

    /**
     * Constructor privado de Tipo de Sanitario.
     *
     * @param descripcion descripción.
     */
    TipoSanitario(String descripcion) {
      this.descripcion = descripcion;
    }

    /**
     * Devuelve la descripción del tipo de sanitario.
     *
     * @return descripción.
     */
    public String getDescripcion() {
      return descripcion;
    }
  }

  /** El tipo de sanitario. */
  private TipoSanitario tipoSanitario;

  /** Código de la especialidad del Sanitario. */
  private CodigoEspecialidadEnum codigoEspecialidad;

  /** Años de experiencia del sanitario. */
  private int experiencia;

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
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param experiencia Experiencia.
   */
  protected Sanitario(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      TipoSanitario tipoSanitario,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      int experiencia) {
    super(
        NIF, nombre, apellido1, apellido2, CodigoUnidadEnum.MEDICINA, codigoArea, codigoActividad);
    this.experiencia = experiencia;
    this.tipoSanitario = tipoSanitario;
    this.codigoEspecialidad = codigoEspecialidad;
    this.citas = new ArrayList<>();
  }

  /**
   * Devuelve el código de la especialidad del sanitario.
   *
   * @return Código especialidad.
   */
  public CodigoEspecialidadEnum getCodigoEspecialidad() {
    return codigoEspecialidad;
  }

  /**
   * Establece el código de especialidad del sanitario.
   *
   * @param codigoEspecialidad Código de especialidad.
   */
  public void setCodigoEspecialidad(CodigoEspecialidadEnum codigoEspecialidad) {
    this.codigoEspecialidad = codigoEspecialidad;
  }

  /**
   * Devuelve los años de experiencia del sanitario.
   * @return Años de experiencia.
   */
  public int getExperiencia() {
    return experiencia;
  }

  /**
   * Establece los años de experiencia del sanitario.
   * @param experiencia Años de experiencia.
   */
  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }

  /**
   * Devuelve las citas del sanitario.
   *
   * @return Lista de citas.
   */
  public List<Cita> getCitas() {
    return citas;
  }

  /**
   * Establece las citas del sanitario.
   *
   * @param cita Lista de citas.
   */
  public void setCitas(List<Cita> cita) {
    this.citas = cita;
  }

  /**
   * Devuelve el tipo de sanitario.
   *
   * @return Tipo de sanitario.
   */
  public TipoSanitario getTipoSanitario() {
    return tipoSanitario;
  }
}
