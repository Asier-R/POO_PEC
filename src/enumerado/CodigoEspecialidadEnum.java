package enumerado;

import entidad.persona.*;

/**
 * Clase enum que define las especialidades de médicos {@link Medico}, enfermeros {@link Enfermero}
 * y estudiantes {@link Estudiante}
 */
public enum CodigoEspecialidadEnum {
  APARATO_DIGESTIVO(8, "APARATO DIGESTIVO"),
  CARDIOLOGIA(8, "CARDIOLOGÍA"),
  CIRUGIA_GENERAL(8, "CIRUGÍA GENERAL"),
  DERMATOLOGIA(8, "DERMATOLOGIA"),
  MEDICINA_INTERNA(8, "MEDICINA INTERNA"),
  ONCOLOGIA(8, "ONCOLOGÍA"),
  OFTALMOLOGIA(8, "OFTALMOLOGÍA"),
  PSIQUIATRIA(8, "PSIQUIATRÍA"),
  TRAUMATOLOGIA(8, "TRAUMATOLOGÍA");

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
