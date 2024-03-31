package enumerado;

import entidad.persona.*;

/**
 * Clase enum que define las especialidades de médicos {@link Medico}, enfermeros {@link Enfermero}
 * y estudiantes {@link Estudiante}
 */
public enum CodigoEspecialidadEnum {
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
   * Devuelve el id del enumerado.
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
}
