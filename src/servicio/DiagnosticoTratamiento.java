package servicio;

import entidad.persona.Sanitario;
import enumerado.CodigoActividadEnum;

import java.util.Random;

import static entidad.persona.Sanitario.TipoSanitario.*;
import static enumerado.CodigoActividadEnum.*;

/** Clase que representa los diagnósticos, tratamientos y las relaciones entre ambos. */
public final class DiagnosticoTratamiento {

  /** Constructor vacío de la clase. */
  private DiagnosticoTratamiento() {
    // Constructor vacío
  }

  /**
   * Genera un diagnostico para un paciente que acude a consulta primaria
   * @return DiagnosticoTratamiento
   */
  public static DiagnosticosTratamientos diagnosticar(){
    Random random = new Random();
    int numero = random.nextInt(DiagnosticosTratamientos.values().length);
    return DiagnosticosTratamientos.values()[numero];
  }

  /** Todos los diagnósticos y sus tratamientos. */
  public enum DiagnosticosTratamientos {
    ACIDEZ("Acidez", CONSULTA_APARATO_DIGESTIVO, "Prescripción de anti-ácidos", null, ENFERMERO),
    DIARREA("Diarrea", CONSULTA_APARATO_DIGESTIVO, "Prescripción de antibióticos", null, MEDICO),
    ULCERA("Ulcera", CONSULTA_APARATO_DIGESTIVO, "Prescripción de bloqueadores de receptores H2", null, MEDICO),
    ARRITMIA("Arritmia", CONSULTA_CARDIOLOGIA, "Intervención quirúrgica", QUIROFANO, MEDICO),
    CARDIOPATIA("Cardiopatía", CONSULTA_CARDIOLOGIA, "Recomendación de cambios cardio-saludables y prescripción de medicamentos", null, MEDICO),
    TROMBOSIS("Trombosis", CONSULTA_CARDIOLOGIA, "Prescripción de anticoagulantes", null, ENFERMERO),
    ACALASIA("Acalasia", CONSULTA_CIRUGIA_GENERAL, "Intervención quirúrgica", QUIROFANO, MEDICO),
    LINFOMA("Linfoma", CONSULTA_CIRUGIA_GENERAL, "Derivación a hospital especializado", null, MEDICO),
    HERNIA("Hernia", CONSULTA_CIRUGIA_GENERAL, "Inyección de cortisona", null, ENFERMERO),
    ACNE("Acné", CONSULTA_DERMATOLOGIA, "Drenaje y extracción", null, ENFERMERO),
    PSORIASIS("Psoriasis", CONSULTA_DERMATOLOGIA, "Prescripción de corticoides", null, MEDICO),
    VITILIGIO("Vitíligo", CONSULTA_DERMATOLOGIA, "Tratamiento de fototerapia", null, MEDICO),
    ICTUS("Ictus", CONSULTA_MEDICINA_INTERNA, "Ingreso en unidad de cuidados intensivos", UCI, ENFERMERO),
    NEUMONIA("Neumonía", CONSULTA_MEDICINA_INTERNA, "Ingreso en planta", EN_PLANTA, ENFERMERO),
    GANGLIO("Ganglión", CONSULTA_MEDICINA_INTERNA, "Drenaje del quiste", null, ENFERMERO),
    CARCINOMA("Carcinoma", CONSULTA_ONCOLOGIA, "Intervención quirúrgica", QUIROFANO, MEDICO),
    MELANOMA("Melanoma", CONSULTA_ONCOLOGIA, "Intervención quirúrgica", QUIROFANO, MEDICO),
    LEUCEMIA("Leucemia", CONSULTA_ONCOLOGIA, "Derivación a hospital especializado", null, MEDICO),
    CATARATAS("Cataratas", CONSULTA_OFTALMOLOGIA, "Intervención quirúrgica", QUIROFANO, MEDICO),
    GLAUCOMA("Glaucoma", CONSULTA_OFTALMOLOGIA, "Prescripción de prostaglandinas", null, ENFERMERO),
    PRESBICIA("Presbicia", CONSULTA_OFTALMOLOGIA, "Prescripción de lentes", null, MEDICO),
    ANSIEDAD("Ansiedad", CONSULTA_PSIQUIATRIA, "Asesoramiento psicológico", null, MEDICO),
    TRASTORNO_ALIMENTARIO("Trastorno alimentario", CONSULTA_PSIQUIATRIA, "Asesoramiento y terapia psicológica", null, MEDICO),
    DEPRESION("Depresión", CONSULTA_PSIQUIATRIA, "Prescripción de antidepresivos", null, MEDICO),
    ARTROSIS("Artrosis", CONSULTA_TRAUMATOLOGIA, "Fisioterapia", null, ENFERMERO),
    Lumbalgia("Lumbalgia", CONSULTA_TRAUMATOLOGIA, "Asesoramiento en medidas no farmacológicas", null, ENFERMERO),
    ESCOLIOSIS("Escoliosis", CONSULTA_TRAUMATOLOGIA, "Derivación a especialista externo en ortopedia", null, MEDICO);

    /** Descripción del diagnóstico. */
    private String diagnostico;

    /** Descripción del tratamiento. */
    private String tratamiento;

    /** Especialidad de la medicína que tratará la afección diagnosticada. */
    private CodigoActividadEnum unidadOrigen;

    /** Código de actividad que indica donde se realiza el tratamiento. */
    private CodigoActividadEnum unidadDestino;

    /** Sanitario que realiza el tratamiento. */
    private Sanitario.TipoSanitario sanitario;

    private DiagnosticosTratamientos(
        String diagnostico,
        CodigoActividadEnum unidadOrigen,
        String tratamiento,
        CodigoActividadEnum unidadDestino,
        Sanitario.TipoSanitario sanitario) {
      this.diagnostico = diagnostico;
      this.tratamiento = tratamiento;
      this.unidadOrigen = unidadOrigen;
      this.unidadDestino = unidadDestino;
      this.sanitario = sanitario;
    }

    public String getDiagnostico() {
      return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
      this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
      return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
      this.tratamiento = tratamiento;
    }

    public CodigoActividadEnum getUnidadOrigen() {
      return unidadOrigen;
    }

    public void setUnidadOrigen(CodigoActividadEnum unidadOrigen) {
      this.unidadOrigen = unidadOrigen;
    }

    public CodigoActividadEnum getUnidadDestino() {
      return unidadDestino;
    }

    public void setUnidadDestino(CodigoActividadEnum unidadDestino) {
      this.unidadDestino = unidadDestino;
    }

    public Sanitario.TipoSanitario getSanitario() {
      return sanitario;
    }

    public void setSanitario(Sanitario.TipoSanitario sanitario) {
      this.sanitario = sanitario;
    }
  }
}
