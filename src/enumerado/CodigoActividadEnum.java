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
  EN_PLANTA(9, "EN PLANTA"),
  CONSULTA_APARATO_DIGESTIVO(10, "APARATO DIGESTIVO"),
  CONSULTA_CARDIOLOGIA(11, "CARDIOLOGIA"),
  CONSULTA_CIRUGIA_GENERAL(12, "CIRUGIA GENERAL"),
  CONSULTA_DERMATOLOGIA(13, "DERMATOLOGIA"),
  CONSULTA_MEDICINA_INTERNA(14, "MEDICINA INTERNA"),
  CONSULTA_ONCOLOGIA(15, "ONCOLOGIA"),
  CONSULTA_OFTALMOLOGIA(16, "OFTALMOLOGIA"),
  CONSULTA_PRIMARIA(17, "CONSULTA PRIMARIA"),
  CONSULTA_PSIQUIATRIA(18, "PSIQUIATRIA"),
  CONSULTA_TRAUMATOLOGIA(19, "TRAUMATOLOGIA"),
  CAFETERIA(20, "CAFETERIA"),
  APARCAMIENTO(21, "APARCAMIENTO"),
  CLASE(22, "CLASE"),
  LABORATORIO(23, "LABORATORIO"),
  QUIROFANO(24, "QUIROFANO"),
  ATENCION_URGENCIAS(25, "ATENCION DE URGENCIAS");

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

  /**
   * Devuelve un Código de Actividad en función de la descripción.
   *
   * @param descripcion descripción.
   * @return código de actividad correspondiente al código de entrada.
   */
  public CodigoActividadEnum getFromDescripcion(String descripcion) {
    for (CodigoActividadEnum c : values()) {
      if (c.descripcion.equals(descripcion)) {
        return c;
      }
    }
    return null;
  }
}
