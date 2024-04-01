package entidad.persona;

import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;

/**
 * Subclase de {@link Personal} que representa al personal de mantenimiento de un Hospital. Esta
 * clase engloba al personal de mantenimiento, limpieza, seguridad, cafeteria y aparcamiento.
 */
public class MantenimientoServicio extends Personal {

  /**
   * Constructor con los campos heredados de Personal {@link Personal} y los campos propios de
   * Mantenimiento.
   *
   * @param NIF NIF.
   * @param nombre Nombre.
   * @param apellido1 Primer apellido.
   * @param apellido2 Segundo apellido.
   * @param codigoArea Código del área.
   * @param codigoActividad código de actividad.
   */
  public MantenimientoServicio(
      String NIF,
      String nombre,
      String apellido1,
      String apellido2,
      CodigoAreaEnum codigoArea,
      CodigoActividadEnum codigoActividad) {
    super(
        NIF, nombre, apellido1, apellido2, CodigoUnidadEnum.SERVICIOS, codigoArea, codigoActividad);
  }

  @Override
  public String toString() {
    return "NIF: "
        + this.getNIF()
        + "\n"
        + "Nombre: "
        + this.getNombre()
        + "\n"
        + "Primer apellido: "
        + this.getApellido1()
        + "\n"
        + "Segundo apellido: "
        + this.getApellido2()
        + "\n"
        + "Unidad: "
        + this.getCodigoUnidad().getDescripcion()
        + "\n"
        + "Area: "
        + this.getCodigoArea().getDescripcion()
        + "\n"
        + "Actividad: "
        + this.getCodigoActividad().getDescripcion();
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
            + this.getCodigoUnidad().getDescripcion()
            + ","
            + this.getCodigoArea().getDescripcion()
            + ","
            + this.getCodigoActividad().getDescripcion();
  }
}
