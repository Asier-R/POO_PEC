package enumerado;

import entidad.unidad.Unidad;

/** Clase enum que define los códigos de área de las distintas unidades {@link Unidad} */
public enum CodigoAreaEnum {//implements CodigosEnum{
  ADMINISTRACION(1, "ADMINISTRACION"),
  ALIMENTACION(2, "ALIMENTACION"),
  GARAJE(3, "GARAJE"),
  HABITACION(4, "HABITACION"),
  OPERATORIO(5, "OPERATORIO"),
  URGENCIAS(6, "URGENCIAS"),
  CONSULTA(7, "CONSULTA"),
  CLASE(8, "CLASE"),
  LABORATORIO(9, "LABORATORIO");

  /** Id del enumerado. */
  private int id;

  /** Texto descriptivo del enumerado. */
  private String descripcion;

  /**
   * Constructor de CodigoAreaEnum
   *
   * @param id Id.
   * @param descripcion Descripción.
   */
  private CodigoAreaEnum(int id, String descripcion) {
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
   * @return descripción del área.
   */
  public String getDescripcion() {
    return this.descripcion;
  }

  /**
   * Devuelve un Código de Área en función de la descripción.
   *
   * @param descripcion descripción.
   * @return código de área correspondiente al código de entrada.
   */
  public static CodigoAreaEnum getFromDescripcion(String descripcion) {
    for (CodigoAreaEnum c : values()) {
      if (c.descripcion.equals(descripcion)) {
        return c;
      }
    }
    return null;
  }

  /**
   * Devuelve un Código de Área en función del ID.
   *
   * @param id Id del código a obtener.
   * @return código de área correspondiente al código de entrada.
   */
  public static CodigoAreaEnum getFromId(int id) {
    for (CodigoAreaEnum c : values()) {
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
    for (CodigoAreaEnum c : values()) {
      System.out.println("> " + c.getId() + ". " + c.getDescripcion());
    }
  }
}
