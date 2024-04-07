package enumerado;

import entidad.persona.*;

/**
 * Clase enum que define las especialidades de médicos {@link Medico}, enfermeros {@link Enfermero}
 * y estudiantes {@link Estudiante}
 */
public enum CodigoEspecialidadEnum {//implements CodigosEnum{
  APARATO_DIGESTIVO(1, "APARATO DIGESTIVO"),
  CARDIOLOGIA(2, "CARDIOLOGIA"),
  CIRUGIA_GENERAL(3, "CIRUGIA GENERAL"),
  DERMATOLOGIA(4, "DERMATOLOGIA"),
  MEDICINA_INTERNA(5, "MEDICINA INTERNA"),
  MEDICINA_GENERAL(6, "MEDICINA GENERAL"),
  ONCOLOGIA(7, "ONCOLOGIA"),
  OFTALMOLOGIA(8, "OFTALMOLOGIA"),
  PSIQUIATRIA(9, "PSIQUIATRIA"),
  TRAUMATOLOGIA(10, "TRAUMATOLOGIA");

  /** Id del enumerado. */
  private int id;

  /** Texto descriptivo del enumerado. */
  private String descripcion;

  /**
   * Constructor de CodigoEspecialidadEnum.
   *
   * @param id Id.
   * @param descripcion Descripción.
   */
  private CodigoEspecialidadEnum(int id, String descripcion) {
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
   * Devuelve un Código de especialidad en función del ID.
   *
   * @param id Id del código a obtener.
   * @return código de especialidad correspondiente al código de entrada.
   */
  public static CodigoEspecialidadEnum getFromId(int id) {
    for (CodigoEspecialidadEnum c : values()) {
      if (c.getId() == id) {
        return c;
      }
    }
    return null;
  }

  /**
   * Devuelve un Código de especialidad en función de la descripción.
   *
   * @param descripcion descripción.
   * @return código de especialidad correspondiente al código de entrada.
   */
  public static CodigoEspecialidadEnum getFromDescripcion(String descripcion) {
    for (CodigoEspecialidadEnum c : values()) {
      if (c.descripcion.equals(descripcion)) {
        return c;
      }
    }
    return null;
  }

  /**
   * Muestra por pantalla los diferentes códigos del enumerado.
   */
  public static void mostrarPorPantalla() {
    for (CodigoEspecialidadEnum c : values()) {
      System.out.println("> " + c.getId() + ". " + c.getDescripcion());
    }
  }
}
