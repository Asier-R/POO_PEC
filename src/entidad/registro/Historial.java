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
   * Una vez finalizada una cita se graban los datos de esta junto con su diagnóstico.
   * @param cita Cita.
   * @param diagnostico Diagnostico.
   */
  public void grabarDatos(Cita cita, DiagnosticosTratamientos diagnostico){
    this.citas.add(cita);
    this.diagnosticosTratamientos.add(diagnostico);
    this.citaDiagnostico.put(cita, diagnostico);
    this.citas.sort(Cita::compareTo);
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
