package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Clase que representa a un administrativo de un Hospital. */
public class Administrativo extends Personal {

  /** Enum de los grupos administrativos. */
  public enum Grupo {
    A1,
    A2,
    C1,
    C2
  }

  /** Código de la unidad a la que está asignada la Persona. */
  private CodigoUnidadEnum codigoUnidad;

  /** Código del área a la que está asignada la Persona. */
  private CodigoAreaEnum codigoArea;

  /** Código de la actividad que realiza la Persona. */
  private CodigoActividadEnum codigoActividad;

  /** Grupo al que pertenece el administrativo. */
  private Grupo grupo;

  /**
   * Constructor con los campos heredados de Personal {@link Personal} y los campos propios de
   * Administrativo.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoUnidad Código de la unidad.
   * @param codigoArea Código del área.
   * @param codigoActividad Código de actividad.
   * @param grupo Grupo.
   */
  public Administrativo(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoUnidadEnum codigoUnidad,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad,
      Grupo grupo) {
    super(NIF, nombre, apellido1, apellido2);
    this.codigoUnidad = codigoUnidad;
    this.codigoArea = codigoArea;
    this.codigoActividad = codigoActividad;
    this.grupo = grupo;
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

  public Grupo getGrupo() {
    return grupo;
  }

  @Override
  public String toString() {
    return null;
  }
}
