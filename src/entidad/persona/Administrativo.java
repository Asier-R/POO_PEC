package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Subclase de {@link Personal} que representa a un administrativo de un Hospital. */
public class Administrativo extends Personal {

  /** Enum de los grupos administrativos. */
  public enum Grupo {
    A1("A1"),
    A2("A2"),
    B("B"),
    C1("C1"),
    C2("C2");

    /** Código del grupo. */
    private String codigo;

    /**
     * Constructor de Grupo.
     *
     * @param codigo código.
     */
    private Grupo(String codigo) {
      this.codigo = codigo;
    }

    /**
     * Devuelve un Grupo en función del código.
     *
     * @param codigo código.
     * @return grupo correspondiente al código de entrada.
     */
    public Grupo getFromCodigo(String codigo) {
      for (Grupo g : values()) {
        if (g.codigo.equals(codigo)) {
          return g;
        }
      }
      return null;
    }

    /**
     * Devuelve el código del grupo.
     *
     * @return Código del grupo.
     */
    public String getCodigo() {
      return this.codigo;
    }
  }

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
   * @param codigoActividad Código de actividad.
   * @param grupo Grupo.
   */
  public Administrativo(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoActividadEnum codigoActividad,
      Grupo grupo) {
    super(
        NIF,
        nombre,
        apellido1,
        apellido2,
        CodigoUnidadEnum.SERVICIOS,
        CodigoAreaEnum.ADMINISTRACION,
        codigoActividad);
    this.grupo = grupo;
  }

  public Grupo getGrupo() {
    return grupo;
  }

  @Override
  public String toString() {
    return "NIF: "
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
        + "Grupo: "
        + this.getGrupo().getCodigo();
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
        + this.getCodigoUnidad().getDescripcion()
        + ","
        + this.getCodigoArea().getDescripcion()
        + ","
        + this.getCodigoActividad().getDescripcion()
        + ","
        + this.getGrupo().getCodigo();
  }
}
