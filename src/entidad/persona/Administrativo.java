package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Clase que representa a un administrativo de un Hospital. */
public class Administrativo extends Personal {

    /**
     * Enum de los grupos administrativos.
     */
    enum Grupo{
        A1,
        A2,
        C1,
        C2
    }

    /**
     * Grupo al que pertenece el administrativo.
     */
    private Grupo grupo;

    /**
     * Constructor con los campos heredados de Personal {@link Personal}.
     *
     * @param NIF NIF.
     * @param nombre Nombre.
     * @param apellido1 Primer apellido.
     * @param apellido2 Segundo apellido.
     */
    public Administrativo(String NIF, String nombre, String apellido1, String apellido2) {
        super(NIF, nombre, apellido1, apellido2);
    }

    /**
     * Constructor con los campos heredados de Personal {@link Personal}.
     *
     * @param NIF NIF.
     * @param nombre Nombre.
     * @param apellido1 Primer apellido.
     * @param apellido2 Segundo apellido.
     * @param codigoUnidad Código de la unidad.
     * @param codigoArea Código del área.
     * @param codigoActividad Código de actividad.
     */
    public Administrativo(
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
        super(NIF, nombre, apellido1, apellido2, codigoUnidad, codigoArea, codigoActividad);
        this.grupo = grupo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return null;
    }
}
