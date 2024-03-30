package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Clase abstracta para representar el personal implicado en un Hospital. */
public abstract class Personal extends Persona {

  /**
   * Constructor con los campos heredados de Persona {@link Persona} y los campos propios de
   * Personal.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   */
  protected Personal(String NIF, String nombre, String apellido1, String apellido2) {
    super(NIF, nombre, apellido1, apellido2);
  }

  public abstract CodigoUnidadEnum getCodigoUnidad();

  public abstract CodigoAreaEnum getCodigoArea();

  public abstract CodigoActividadEnum getCodigoActividad();
}
