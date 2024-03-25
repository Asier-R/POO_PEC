package servicio;

import entidad.persona.Sanitario;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoEspecialidadEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static enumerado.CodigoEspecialidadEnum.*;

/**
 * Clase que representa los diagnósticos, tratamientos, las relaciones entre estos y actualiza el
 * expediente y su historial.
 */
public final class DiagnosticoTratamiento {

  /** Todos los diagnósticos posibles. */
  public enum Diagnostico {
    ACIDEZ("Acidez", APARATO_DIGESTIVO),
    DIARREA("Diarrea", APARATO_DIGESTIVO),
    ULCERA("Ulcera", APARATO_DIGESTIVO),
    ARRITMIA("Arritmia", CARDIOLOGIA),
    CARDIOPATIA("Cardiopatía", CARDIOLOGIA),
    TROMBOSIS("Trombosis", CARDIOLOGIA),
    ACALASIA("Acalasia", CIRUGIA_GENERAL),
    LINFOMA("Linfoma", CIRUGIA_GENERAL),
    HERNIA("Hernia", CIRUGIA_GENERAL),
    ACNE("Acné", DERMATOLOGIA),
    PSORIASIS("Psoriasis", DERMATOLOGIA),
    VITILIGIO("Vitíligo", DERMATOLOGIA),
    ICTUS("Ictus", MEDICINA_INTERNA),
    NEUMONIA("Neumonía", MEDICINA_INTERNA),
    GANGLIO("Ganglión", MEDICINA_INTERNA),
    CARCINOMA("Carcinoma", ONCOLOGIA),
    MELANOMA("Melanoma", ONCOLOGIA),
    LEUCEMIA("Leucemia", ONCOLOGIA),
    CATARATAS("Cataratas", OFTALMOLOGIA),
    GLAUCOMA("Glaucoma", OFTALMOLOGIA),
    PRESBICIA("Presbicia", OFTALMOLOGIA),
    ANSIEDAD("Ansiedad", PSIQUIATRIA),
    TRASTORNO_ALIMENTARIO("Trastorno alimentario", PSIQUIATRIA),
    DEPRESION("Depresión", PSIQUIATRIA),
    ARTROSIS("Artrosis", TRAUMATOLOGIA),
    Lumbalgia("Lumbalgia", TRAUMATOLOGIA),
    ESCOLIOSIS("Escoliosis", TRAUMATOLOGIA);

    /** Descripción del diagnóstico. */
    private String descripcion;

    /** Especialidad de la medicína que tratará la afección diagnosticada. */
    private CodigoEspecialidadEnum especialidad;

    private Diagnostico(String descripcion, CodigoEspecialidadEnum especialidad) {
      this.descripcion = descripcion;
      this.especialidad = especialidad;
    }
  }

  /** Todos los tratamientos posibles. */
  public enum Tratamiento {
      ANTI_ACIDOS("Prescribir anti-ácidos", null, Sanitario.TipoSanitario.ENFERMERO),
      DIARREA("Diarrea", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      ULCERA("Ulcera", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      ARRITMIA("Arritmia", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      CARDIOPATIA("Cardiopatía", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      TROMBOSIS("Trombosis", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      ACALASIA("Acalasia", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      LINFOMA("Linfoma", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      HERNIA("Hernia", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      ACNE("Acné", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      PSORIASIS("Psoriasis", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      VITILIGIO("Vitíligo", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      ICTUS("Ictus", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      NEUMONIA("Neumonía", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      GANGLIO("Ganglión", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      CARCINOMA("Carcinoma", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      MELANOMA("Melanoma", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      LEUCEMIA("Leucemia", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      CATARATAS("Cataratas", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      GLAUCOMA("Glaucoma", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO),
      PRESBICIA("Presbicia", CodigoActividadEnum.CARDIOLOGIA, Sanitario.TipoSanitario.ENFERMERO);

      /** Descripción del diagnóstico. */
      private String descripcion;

      /** Código de actividad que indica donde se realiza el tratamiento. */
      private CodigoActividadEnum actividad;

      /** Sanitario que realiza el tratamiento. */
      private Sanitario.TipoSanitario sanitario;

      private Tratamiento(String descripcion, CodigoActividadEnum actividad, Sanitario.TipoSanitario sanitario) {
          this.descripcion = descripcion;
          this.actividad = actividad;
          this.sanitario = sanitario;
      }
  }

  private static Map<Diagnostico, Tratamiento> diagnosticoTratamientoMap = new HashMap<>();

  private DiagnosticoTratamiento(){
      Arrays.stream(Diagnostico.values()).forEach(diagnostico -> {
          diagnosticoTratamientoMap.put(diagnostico, Tratamiento.ACNE);//TODO: pensar mejor
      });
  }


}
