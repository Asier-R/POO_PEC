package entidad.registro;

import servicio.DiagnosticoTratamiento.DiagnosticosTratamientos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Clase que representa el historial clínico de un paciente. */
public class Historial {

  /** Historial cronológicamente ordenado de citas. */
  private List<Cita> citas;

  /** Historial cronológicamente ordenado de diagnósticos y tratamientos recibidos. */
  private List<DiagnosticosTratamientos> diagnosticosTratamientos;

  /** Cada cita se enlaza a un diagnostico. */
  private Map<Cita, DiagnosticosTratamientos> citaDiagnostico;

  /** Constructor de Historial. */
  public Historial() {
    this.citas = new ArrayList<>();
    this.diagnosticosTratamientos = new ArrayList<>();
    this.citaDiagnostico = new HashMap<>();
  }

  /**
   * Graba los datos del expediente en el historial.
   * @param expediente Expediente del que se obtienen los datos.
   */
  public void grabarDatos(Expediente expediente){
    final Cita cita = expediente.getCita();
    if (cita != null) {
      cita.setVencida();
      this.citas.add(cita);
      this.diagnosticosTratamientos.add(expediente.getDiagnostico());
      this.citaDiagnostico.put(expediente.getCita(), expediente.getDiagnostico());
      this.citas.sort(Cita::compareTo);
    }
  }

  /**
   * Devuelve las citas del historial.
   * @return Lista cronológicamente ordenada de citas.
   */
  public List<Cita> getCitas() {
    return citas;
  }

  /**
   * Devuelve el DiagnosticoTratamiento de una cita determinada.
   * @param cita Cita cuyo DiagnosticoTratamiento se quiere obtener.
   * @return DiagnosticoTratamiento.
   */
  public DiagnosticosTratamientos getDiagnosticoTratamiento(Cita cita){
    return citaDiagnostico.get(cita);
  }
}
