package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

/** Clase que representa a un estudiante de medicína o enfermería. */
public class Estudiante extends Sanitario {
  /** Nombre del centro de estudios de procedencia. */
  private String nombreCentro;

  /**
   * Constructor con los campos heredados de {@link Sanitario} y los campos propios de Estudiante.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param nombreCentro Código de actividad.
   */
  public Estudiante(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      String nombreCentro) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        TipoSanitario.ESTUDIANTE,
        codigoUnidad,
        codigoArea,
        codigoActividad,
        codigoEspecialidad);
    this.nombreCentro = nombreCentro;
  }

  public String getNombreCentro() {
    return nombreCentro;
  }

  @Override
  public String toString() {
    return null;
  }
}
