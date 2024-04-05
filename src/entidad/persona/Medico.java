package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;

/** Subclase de {@link Sanitario} que representa a un médico. */
public class Medico extends Sanitario {

  /** Segunda especialidad del médico. */
  private CodigoEspecialidadEnum segundaEspecialidad;

  /**
   * Constructor con los campos heredados de {@link Sanitario} y los campos propios de Médico.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
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
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      CodigoEspecialidadEnum segundaEspecialidad,
      int experiencia) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        TipoSanitario.MEDICO,
        codigoArea,
        codigoActividad,
        codigoEspecialidad,
        experiencia);
    this.segundaEspecialidad = segundaEspecialidad;
  }

  public CodigoEspecialidadEnum getSegundaEspecialidad() {
    return segundaEspecialidad;
  }

  @Override
  public String toString() {
    return "Médico: "
        + this.getTipoSanitario()
        + "\n"
        + "NIF: "
        + this.getNIF()
        + "\n"
        + "Nombre: "
        + this.getNombre()
        + "\n"
        + "Primer apellido: "
        + this.getApellido1()
        + "\n"
        + "Segundo apellido: "
        + this.getApellido2()
        + "\n"
        + "Unidad: "
        + this.getCodigoUnidad().getDescripcion()
        + "\n"
        + "Area: "
        + this.getCodigoArea().getDescripcion()
        + "\n"
        + "Actividad: "
        + this.getCodigoActividad().getDescripcion()
        + "\n"
        + "Especialidad: "
        + this.getCodigoEspecialidad().getDescripcion()
        + "\n"
        + "Segunda especialidad: "
        + (this.getSegundaEspecialidad()==null?"no":this.getSegundaEspecialidad().getDescripcion())
        + "\n"
        + "Experiencia: "
        + this.getExperiencia();
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
            + this.getCodigoArea().getDescripcion()
            + ","
            + this.getCodigoActividad().getDescripcion()
            + ","
            + this.getCodigoEspecialidad().getDescripcion()
            + ","
            + this.getSegundaEspecialidad().getDescripcion()
            + ","
            + this.getExperiencia();
  }

}
