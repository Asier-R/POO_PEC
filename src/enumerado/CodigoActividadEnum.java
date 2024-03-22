package enumerado;

import entidad.unidad.Unidad;

/** Clase enum que define los códigos de actividad de las distintas unidades {@link Unidad} */
public enum CodigoActividadEnum {
  CONTABILIDAD(1, "CONTABILIDAD"),
  DIRECCION(2, "DIRECCION"),
  DOC_CLINICA(3, "DOCUMENTACIÓN CLINICA"),
  MANTENIMIENTO(4, "MANTENIMIENTO"),
  LIMPIEZA(5, "LIMPIEZA"),
  RRHH(6, "RRHH"),
  SEGURIDAD(7, "SEGURIDAD"),
  UCI(8, "UCI"),
  EN_PLANTA(8, "EN PLANTA"),
  APARATO_DIGESTIVO(8, "APARATO DIGESTIVO"),
  CARDIOLOGIA(8, "CARDIOLOGÍA"),
  CIRUGIA_GENERAL(8, "CIRUGÍA GENERAL"),
  DERMATOLOGIA(8, "DERMATOLOGIA"),
  MEDICINA_INTERNA(8, "MEDICINA INTERNA"),
  ONCOLOGIA(8, "ONCOLOGÍA"),
  OFTALMOLOGIA(8, "OFTALMOLOGÍA"),
  PSIQUIATRIA(8, "PSIQUIATRÍA"),
  TRAUMATOLOGIA(8, "TRAUMATOLOGÍA"),
  CAFETERIA(8, "CAFETERIA"),
  APARCAMIENTO(8, "APARCAMIENTO"),
  CLASE(8, "CLASE"),
  LABORATORIO(8, "LABORATORIO");

  /** Id del enumerado. */
  private int id;

  /** Texto descriptivo del enumerado. */
  private String descripcion;

  private CodigoActividadEnum(int id, String descripcion) {
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
