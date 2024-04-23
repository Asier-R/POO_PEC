package servicio;

import entidad.persona.Sanitario;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoPruebaMedicaEnum;

import java.util.Random;

import static entidad.persona.Sanitario.TipoSanitario.*;
import static enumerado.CodigoActividadEnum.*;
import static enumerado.CodigoPruebaMedicaEnum.*;

/** Clase que representa los diagnósticos, tratamientos y las relaciones entre ambos. */
public final class DiagnosticoTratamiento {

  /** Constructor vacío de la clase. */
  private DiagnosticoTratamiento() {
    // Constructor vacío
  }

  /**
   * Genera un diagnostico para un paciente que acude a consulta primaria.
   * @return DiagnosticoTratamiento.
   */
  public static DiagnosticosTratamientos diagnosticar(){
    Random random = new Random();
    int numero = random.nextInt(DiagnosticosTratamientos.values().length);
    return DiagnosticosTratamientos.values()[numero];
  }

  /** Todos los diagnósticos y sus tratamientos. */
  public enum DiagnosticosTratamientos {
    ACIDEZ(     "Acidez",     CONSULTA_APARATO_DIGESTIVO, null, "Prescripción de anti-ácidos",                    null,      ENFERMERO),
    DIARREA(    "Diarrea",    CONSULTA_APARATO_DIGESTIVO, null, "Prescripción de antibióticos",                   null,      MEDICO),
    ULCERA(     "Ulcera",     CONSULTA_APARATO_DIGESTIVO, ECOGRAFIA, "Prescripción de bloqueadores de receptores H2",              null,      MEDICO),
    ARRITMIA(   "Arritmia",   CONSULTA_CARDIOLOGIA,       null, "Intervención quirúrgica",                                    QUIROFANO, MEDICO),
    CARDIOPATIA("Cardiopatía",CONSULTA_CARDIOLOGIA,       ECOGRAFIA, "Recomendación de cambios cardio-saludables y prescripción de medicamentos", null, MEDICO),
    TROMBOSIS(  "Trombosis",  CONSULTA_CARDIOLOGIA,       null, "Prescripción de anticoagulantes",                null,      ENFERMERO),
    ACALASIA(   "Acalasia",   CONSULTA_CIRUGIA_GENERAL,   null, "Intervención quirúrgica",                                    QUIROFANO, MEDICO),
    LINFOMA(    "Linfoma",    CONSULTA_CIRUGIA_GENERAL,   null, "Derivación a hospital especializado",            null,      MEDICO),
    HERNIA(     "Hernia",     CONSULTA_CIRUGIA_GENERAL,   null, "Inyección de cortisona",                         null,      ENFERMERO),
    ACNE(       "Acné",       CONSULTA_DERMATOLOGIA,      ANALITICA, "Drenaje y extracción",                                       null,      ENFERMERO),
    PSORIASIS(  "Psoriasis",  CONSULTA_DERMATOLOGIA,      null, "Prescripción de corticoides",                    null,      MEDICO),
    VITILIGIO(  "Vitíligo",   CONSULTA_DERMATOLOGIA,      null, "Tratamiento de fototerapia",                     null,      MEDICO),
    ICTUS(      "Ictus",      CONSULTA_MEDICINA_INTERNA,  RESONANCIA_MAGNETICA, "Ingreso en unidad de cuidados intensivos",                    UCI,       ENFERMERO),
    NEUMONIA(   "Neumonía",   CONSULTA_MEDICINA_INTERNA,  null, "Ingreso en planta",                                          EN_PLANTA, ENFERMERO),
    GANGLIO(    "Ganglión",   CONSULTA_MEDICINA_INTERNA,  null, "Drenaje del quiste",                             null,      ENFERMERO),
    CARCINOMA(  "Carcinoma",  CONSULTA_ONCOLOGIA,         null, "Intervención quirúrgica",                                    QUIROFANO, MEDICO),
    MELANOMA(   "Melanoma",   CONSULTA_ONCOLOGIA,         null, "Intervención quirúrgica",                                    QUIROFANO, MEDICO),
    LEUCEMIA(   "Leucemia",   CONSULTA_ONCOLOGIA,         null, "Derivación a hospital especializado",            null,      MEDICO),
    CATARATAS(  "Cataratas",  CONSULTA_OFTALMOLOGIA,      null, "Intervención quirúrgica",                                    QUIROFANO, MEDICO),
    GLAUCOMA(   "Glaucoma",   CONSULTA_OFTALMOLOGIA,      null, "Prescripción de prostaglandinas",                null,      ENFERMERO),
    PRESBICIA(  "Presbicia",  CONSULTA_OFTALMOLOGIA,      null, "Prescripción de lentes",                         null,      MEDICO),
    ANSIEDAD(   "Ansiedad",   CONSULTA_PSIQUIATRIA,       null, "Asesoramiento psicológico",                      null,      MEDICO),
    TRASTORNO_ALIMENTARIO("Trastorno alimentario",        CONSULTA_PSIQUIATRIA, ANALITICA, "Asesoramiento y terapia psicológica",  null,      MEDICO),
    DEPRESION(  "Depresión",  CONSULTA_PSIQUIATRIA,       null, "Prescripción de antidepresivos",                 null,      MEDICO),
    ARTROSIS(   "Artrosis",   CONSULTA_TRAUMATOLOGIA,     RESONANCIA_MAGNETICA, "Fisioterapia",                                    null,      ENFERMERO),
    LUMBALGIA(  "Lumbalgia",  CONSULTA_TRAUMATOLOGIA,     null, "Asesoramiento en medidas no farmacológicas",     null,      ENFERMERO),
    ESCOLIOSIS( "Escoliosis", CONSULTA_TRAUMATOLOGIA,     RAYOS_X, "Derivación a especialista externo en ortopedia",               null,      MEDICO),
    POSTCIRUGIA( "Post-cirugía", QUIROFANO, null, "Ingreso en planta",                                                        EN_PLANTA, ENFERMERO);

    /** Descripción del diagnóstico. */
    private String diagnostico;

    /** Descripción del tratamiento. */
    private String tratamiento;

    /** Especialidad de la medicína que tratará la afección diagnosticada. */
    private CodigoActividadEnum unidadOrigen;

    /** Código de actividad que indica donde se realiza el tratamiento. */
    private CodigoActividadEnum unidadDestino;

    /** Código de prueba médica que se le realiza al paciente. */
    private CodigoPruebaMedicaEnum codigoPruebaMedica;

    /** Sanitario que realiza el tratamiento. */
    private Sanitario.TipoSanitario sanitario;

    /**
     * Constructor del enumerado.
     * @param diagnostico Diagnostico.
     * @param unidadOrigen Unidad origen.
     * @param codigoPruebaMedica Prueba médica.
     * @param tratamiento Tratamiento.
     * @param unidadDestino Unidad destino.
     * @param sanitario Tipo de sanitario.
     */
    private DiagnosticosTratamientos(
        String diagnostico,
        CodigoActividadEnum unidadOrigen,
        CodigoPruebaMedicaEnum codigoPruebaMedica,
        String tratamiento,
        CodigoActividadEnum unidadDestino,
        Sanitario.TipoSanitario sanitario) {
      this.diagnostico = diagnostico;
      this.tratamiento = tratamiento;
      this.unidadOrigen = unidadOrigen;
      this.codigoPruebaMedica = codigoPruebaMedica;
      this.unidadDestino = unidadDestino;
      this.sanitario = sanitario;
    }

    /**
     * Devuelve el diagnostico.
     * @return Diagnostico.
     */
    public String getDiagnostico() {
      return diagnostico;
    }

    /**
     * Establece el diagnóstico.
     * @param diagnostico Diagnóstico.
     */
    public void setDiagnostico(String diagnostico) {
      this.diagnostico = diagnostico;
    }

    /**
     * Devuelve el tratamiento.
     * @return Tratamiento.
     */
    public String getTratamiento() {
      return tratamiento;
    }

    /**
     * Establece el tratamiento.
     * @param tratamiento Tratamiento.
     */
    public void setTratamiento(String tratamiento) {
      this.tratamiento = tratamiento;
    }

    /**
     * Devuelve la unidad de origen.
     * @return Unidad de origen.
     */
    public CodigoActividadEnum getUnidadOrigen() {
      return unidadOrigen;
    }

    /**
     * Establece la unidad de origen.
     * @param unidadOrigen Unidad de origen.
     */
    public void setUnidadOrigen(CodigoActividadEnum unidadOrigen) {
      this.unidadOrigen = unidadOrigen;
    }

    /**
     * Devuelve la unidad destino.
     * @return Devuelve la unidad destino.
     */
    public CodigoActividadEnum getUnidadDestino() {
      return unidadDestino;
    }

    /**
     * Establece la unidad destino.
     * @param unidadDestino Unidad destino.
     */
    public void setUnidadDestino(CodigoActividadEnum unidadDestino) {
      this.unidadDestino = unidadDestino;
    }

    /**
     * Establece la prueba médica.
     * @return Prueba médica.
     */
    public CodigoPruebaMedicaEnum getCodigoPruebaMedica() {
      return codigoPruebaMedica;
    }

    /**
     * Establece la prueba médica.
     * @param codigoPruebaMedica Prueba médica.
     */
    public void setCodigoPruebaMedica(CodigoPruebaMedicaEnum codigoPruebaMedica) {
      this.codigoPruebaMedica = codigoPruebaMedica;
    }

    /**
     * Devuelve el tipo de sanitario.
     * @return Tipo de sanitario.
     */
    public Sanitario.TipoSanitario getSanitario() {
      return sanitario;
    }

    /**
     * Establece el tipo de sanitario.
     * @param sanitario Tipo de sanitario.
     */
    public void setSanitario(Sanitario.TipoSanitario sanitario) {
      this.sanitario = sanitario;
    }
  }
}
