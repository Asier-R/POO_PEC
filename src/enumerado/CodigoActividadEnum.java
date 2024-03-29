package enumerado;

import entidad.unidad.Unidad;

/** Clase enum que define los códigos de actividad de las distintas unidades {@link Unidad} */
public enum CodigoActividadEnum {
  CONTABILIDAD(1, "CONTABILIDAD"),
  DIRECCION(2, "DIRECCION"),
  DOC_CLINICA(3, "DOCUMENTACION CLINICA"),
  MANTENIMIENTO(4, "MANTENIMIENTO"),
  LIMPIEZA(5, "LIMPIEZA"),
  RRHH(6, "RRHH"),
  SEGURIDAD(7, "SEGURIDAD"),
  UCI(8, "UCI"),
  EN_PLANTA(8, "EN PLANTA"),
  CONSULTA_APARATO_DIGESTIVO(8, "APARATO DIGESTIVO"),
  CONSULTA_CARDIOLOGIA(8, "CARDIOLOGIA"),
  CONSULTA_CIRUGIA_GENERAL(8, "CIRUGIA GENERAL"),
  CONSULTA_DERMATOLOGIA(8, "DERMATOLOGIA"),
  CONSULTA_MEDICINA_INTERNA(8, "MEDICINA INTERNA"),
  CONSULTA_ONCOLOGIA(8, "ONCOLOGIA"),
  CONSULTA_OFTALMOLOGIA(8, "OFTALMOLOGIA"),
  CONSULTA_PRIMARIA(8, "CONSULTA PRIMARIA"),
  CONSULTA_PSIQUIATRIA(8, "PSIQUIATRIA"),
  CONSULTA_TRAUMATOLOGIA(8, "TRAUMATOLOGIA"),
  CAFETERIA(8, "CAFETERIA"),
  APARCAMIENTO(8, "APARCAMIENTO"),
  CLASE(8, "CLASE"),
  LABORATORIO(8, "LABORATORIO"),
  QUIROFANO(8, "QUIROFANO"),
  ATENCION_URGENCIAS(8, "ATENCION DE URGENCIAS");

  /** Id del enumerado. */
  private int id;

  /** Texto descriptivo del enumerado. */
  private String descripcion;

  /**
   * Constructor de CodigoActividadEnum.
   * @param id Id.
   * @param descripcion Descripción.
   */
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
