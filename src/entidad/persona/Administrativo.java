package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/** Subclase de {@link Personal} que representa a un administrativo de un Hospital. */
public class Administrativo extends Personal {

  /** Enum de los grupos administrativos. */
  public enum Grupo {
    A1(1, "A1"),
    A2(2, "A2"),
    B(3, "B"),
    C1(4, "C1"),
    C2(5, "C2");

    /** Id del grupo. */
    private int id;

    /** Código del grupo. */
    private String codigo;

    /**
     * Constructor de Grupo.
     * @param id Id del grupo.
     * @param codigo Código del grupo.
     */
    private Grupo(int id, String codigo) {
      this.id = id;
      this.codigo = codigo;
    }

    /**
     * Devuelve un Grupo en función del código.
     *
     * @param codigo código.
     * @return grupo correspondiente al código de entrada.
     */
    public static Grupo getFromCodigo(String codigo) {
      for (Grupo g : values()) {
        if (g.codigo.equals(codigo)) {
          return g;
        }
      }
      return null;
    }

    /**
     * Devuelve el Grupo a partir del ID.
     *
     * @param id Id del código a obtener.
     * @return Grupo.
     */
    public static Grupo getFromId(int id) {
      for (Grupo c : values()) {
        if (c.getId() == id) {
          return c;
        }
      }
      return null;
    }

    /** Muestra por pantalla los diferentes códigos del enumerado. */
    public static void mostrarPorPantalla() {
      for (Grupo c : values()) {
        System.out.println("> " + c.getId() + ". " + c.getCodigo());
      }
    }

    /**
     * Devuelve el id del grupo.
     *
     * @return Id del grupo.
     */
    public int getId() {
      return this.id;
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
        + "Grupo: "
        + (this.getGrupo() != null ? this.getGrupo().getCodigo() : "");
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
        + this.getCodigoUnidad().name()
        + ","
        + this.getCodigoArea().name()
        + ","
        + this.getCodigoActividad().name()
        + ","
        + this.getGrupo().name();
  }
}
