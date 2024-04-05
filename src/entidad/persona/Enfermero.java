package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;

/** Subclase de {@link Sanitario} que representa a un enfermero. */
public class Enfermero extends Sanitario {

  /**
   * Constructor con los campos heredados de {@link Sanitario} y los campos propios de Enfermero.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param codigoEspecialidad Código de especialidad.
   * @param experiencia Experiencia.
   */
  public Enfermero(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      CodigoEspecialidadEnum codigoEspecialidad,
      int experiencia) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        TipoSanitario.ENFERMERO,
        codigoArea,
        codigoActividad,
        codigoEspecialidad, experiencia);
  }

  @Override
  public String toString() {
    return "Enfermero: "
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
            + this.getExperiencia();
  }

}
