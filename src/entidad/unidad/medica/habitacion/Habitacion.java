package entidad.unidad.medica.habitacion;

import entidad.persona.Paciente;
import entidad.unidad.medica.Medica;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;

import java.util.List;

/**
 * Subclase abstracta de {@link Medica} que se utiliza para definir las unidades que se ocupan de
 * alojar a los pacientes en el hospital.
 */
public abstract class Habitacion extends Medica {

  /** Lista de pacientes ingresados. */
  List<Paciente> pacientes;

  /** Código de la actividad que se realiza en la unidad. */
  private CodigoActividadEnum codigoActividad;

  /**
   * Constructor de unidades de Habitación.
   *
   * @param codigoActividad código del área al que pertenece la Unidad.
   * @param nombre nombre de la unidad.
   */
  public Habitacion(CodigoActividadEnum codigoActividad, String nombre) {
    super(CodigoAreaEnum.HABITACION, nombre);
    this.codigoActividad = codigoActividad;
  }

  /**
   * Ingresa a un paciente en la habitación.
   *
   * @param paciente Paciente a ingresar.
   */
  public void ingresarPaciente(Paciente paciente) {
    if(!this.pacientes.contains(paciente)) this.pacientes.add(paciente);
  }

  @Override
  public CodigoActividadEnum getCodigoActividad() {
    return codigoActividad;
  }

  @Override
  public String toString() {
    return this.getNombre() + "  Ocupación: " + (this.pacientes.size());
  }
}
