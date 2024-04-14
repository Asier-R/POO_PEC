package enumerado;

/**
 * Clase que define las diferentes pruebas que se le pueden realizar a un paciente {@link
 * entidad.persona.Paciente}
 */
public enum CodigoPruebaMedicaEnum {
  ANALITICA(1, "Analítica"),
  RAYOS_X(2, "Rayos X"),
  RESONANCIA_MAGNETICA(3, "Resonancia magenética"),
  ECOGRAFIA(4, "Ecografia");

  /** Id del enumerado. */
  private int id;

  /** Texto descriptivo del enumerado. */
  private String descripcion;

  /**
   * Constructor de CodigoPruebaMedicaEnum
   *
   * @param id Id.
   * @param descripcion Descripción.
   */
  private CodigoPruebaMedicaEnum(int id, String descripcion) {
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
   * Devuelve un Código de Prueba Médica en función de la descripción.
   *
   * @param descripcion descripción.
   * @return código de prueba médica correspondiente al código de entrada.
   */
  public static CodigoPruebaMedicaEnum getFromDescripcion(String descripcion) {
    for (CodigoPruebaMedicaEnum c : values()) {
      if (c.descripcion.equals(descripcion)) {
        return c;
      }
    }
    return null;
  }

  /**
   * Devuelve un Código de Prueba Médica en función del ID.
   *
   * @param id Id del código a obtener.
   * @return código de prueba médica correspondiente al código de entrada.
   */
  public static CodigoPruebaMedicaEnum getFromId(int id) {
    for (CodigoPruebaMedicaEnum c : values()) {
      if (c.getId() == id) {
        return c;
      }
    }
    return null;
  }

  /** Muestra por pantalla los diferentes códigos del enumerado. */
  public static void mostrarPorPantalla() {
    for (CodigoPruebaMedicaEnum c : values()) {
      System.out.println("> " + c.getId() + ". " + c.getDescripcion());
    }
  }
}
