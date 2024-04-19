package entidad.unidad.medica.habitacion;

import enumerado.CodigoActividadEnum;

import java.util.ArrayList;

/** Subclase de {@link Habitacion} que representa una habitación de ingreso en planta. */
public class EnPlanta extends Habitacion {

  /** Número máximo de habitaciones. */
  private final int CAPACIDAD = 90;

  /**
   * Constructor de habitaciones para ingresos en planta.
   *
   * @param nombre nombre de la unidad.
   */
  public EnPlanta(String nombre) {
    super(CodigoActividadEnum.EN_PLANTA, nombre);
    this.pacientes = new ArrayList<>(CAPACIDAD);
  }

  @Override
  public String toString() {
    return this.getNombre()
        + "  Capacidad: "
        + CAPACIDAD
        + "  Ocupación: "
        + (this.pacientes.size());
  }

}
