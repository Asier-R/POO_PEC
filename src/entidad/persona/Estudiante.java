package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;

/** Subclase de {@link Sanitario} que representa a un estudiante de medicína o enfermería. */
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
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param experiencia Experiencia.
   * @param nombreCentro Código de actividad.
   */
  public Estudiante(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      int experiencia,
      String nombreCentro) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        TipoSanitario.ESTUDIANTE,
        codigoArea,
        codigoActividad,
        codigoEspecialidad,
        experiencia);
    this.nombreCentro = nombreCentro;
  }

  /**
   * Devuelve el nombre del centro de estudios de procedencia del estudiante.
   *
   * @return Nombre del centro.
   */
  public String getNombreCentro() {
    return nombreCentro;
  }

  @Override
  public String toString() {
    return "Sanitario: "
        + (this.getTipoSanitario() != null ? this.getTipoSanitario().getDescripcion() : "")
        + "\n"
        + "NIF: "
        + (this.getNIF() != null ? this.getNIF() : "")
        + "\n"
        + "Nombre: "
        + (this.getNombre() != null ? this.getNombre() : "")
        + "\n"
        + "Primer apellido: "
        + (this.getApellido1() != null ? this.getApellido1() : "")
        + "\n"
        + "Segundo apellido: "
        + (this.getApellido2() != null ? this.getApellido2() : "")
        + "\n"
        + "Unidad: "
        + (this.getCodigoUnidad() != null ? this.getCodigoUnidad().getDescripcion() : "")
        + "\n"
        + "Area: "
        + (this.getCodigoArea() != null ? this.getCodigoArea().getDescripcion() : "")
        + "\n"
        + "Actividad: "
        + (this.getCodigoActividad() != null ? this.getCodigoActividad().getDescripcion() : "")
        + "\n"
        + "Especialidad: "
        + (this.getCodigoEspecialidad() != null
            ? this.getCodigoEspecialidad().getDescripcion()
            : "")
        + "\n"
        + "Experiencia: "
        + this.getExperiencia()
        + "\n"
        + "Centro: "
        + (this.getNombreCentro() != null ? this.getNombreCentro() : "");
  }

  @Override
  public String generarCadenaCSV() {
    return this.getNIF()
        + ","
        + this.getNombre()
        + ","
        + this.getApellido1()
        + ","
        + this.getApellido2()
        + ","
        + this.getCodigoArea().name()
        + ","
        + this.getCodigoActividad().name()
        + ","
        + this.getCodigoEspecialidad().name()
        + ","
        + this.getExperiencia()
        + ","
        + this.getNombreCentro();
  }
}
