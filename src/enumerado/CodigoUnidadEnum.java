package enumerado;

import entidad.unidad.Unidad;

/** Clase enum que define los códigos de unidad de las distintas unidades {@link Unidad} */
public enum CodigoUnidadEnum {
  SERVICIOS(1, "SERVICIOS"),
  MEDICINA(2, "MEDICINA"),
  FORMACION(3, "FORMACION");

  /** Id del enumerado. */
  private int id;

  /** Texto descriptivo del enumerado. */
  private String descripcion;

  /**
   * Constructor de CodigoUnidadEnum.
   *
   * @param id Id.
   * @param descripcion Descripción.
   */
  private CodigoUnidadEnum(int id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }

  /**
   * Devuelve el ID del enumerado.
   *
   * @return id
   */
  public int getId() {
    return this.id;
  }

  /**
   * Devuelve el texto descriptivo del enumerado.
   *
   * @return descripción de la unidad.
   */
  public String getDescripcion() {
    return this.descripcion;
  }

  /**
   * Devuelve un Código de Unidad en función de la descripción.
   *
   * @param descripcion descripción.
   * @return código de unidad correspondiente al código de entrada.
   */
  public static CodigoUnidadEnum getFromDescripcion(String descripcion) {
    for (CodigoUnidadEnum c : values()) {
      if (c.descripcion.equals(descripcion)) {
        return c;
      }
    }
    return null;
  }

  /**
   * Devuelve un Código de Unidad en función del ID.
   *
   * @param id Id del código a obtener.
   * @return código de unidad correspondiente al código de entrada.
   */
  public static CodigoUnidadEnum getFromId(int id) {
    for (CodigoUnidadEnum c : values()) {
      if (c.getId() == id) {
        return c;
      }
    }
    return null;
  }

  /**
   * Muestra por pantalla los diferentes códigos del enumerado.
   */
  public static void mostrarPorPantalla() {
    for (CodigoUnidadEnum c : values()) {
      System.out.println("> " + c.getId() + ". " + c.getDescripcion());
    }
  }

}
