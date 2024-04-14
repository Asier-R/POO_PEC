package entidad.unidad.formacion;

import entidad.persona.Estudiante;
import entidad.persona.Sanitario;
import entidad.unidad.Unidad;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoUnidadEnum;
import entidad.persona.Medico;
import entidad.persona.Enfermero;

import java.util.ArrayList;
import java.util.List;

/**
 * Subclase abstracta de Unidad {@link Unidad} que se utiliza para definir las unidades que realizan
 * labores relacionadas con la formación del futuro personal médico {@link Medico} y de enfermería
 * {@link Enfermero}.
 */
public abstract class Formacion extends Unidad {

  /** Código único que identifica el área de la unidad. {@link CodigoUnidadEnum} */
  private CodigoAreaEnum codigoArea;

  /** Sanitario que realiza tareas de formación en la unidad. */
  private Sanitario instructor;

  /** Estudiantes asignados a la unidad de formación. */
  private List<Estudiante> estudiantes;

  /**
   * Constructor de las unidades Formativas.
   *
   * @param codigoArea código del área al que pertenece la Unidad.
   * @param nombre nombre de la unidad.
   */
  public Formacion(CodigoAreaEnum codigoArea, String nombre) {
    super(CodigoUnidadEnum.FORMACION, nombre);
    this.codigoArea = codigoArea;
    this.estudiantes = new ArrayList<>();
  }

  /**
   * Devuelve el código de área.
   *
   * @return Código de area.
   */
  public CodigoAreaEnum getCodigoArea() {
    return codigoArea;
  }

  /**
   * Devuelve el instructor del área de formación.
   *
   * @return Sanitario que realiza las tareas de formación.
   */
  public Sanitario getInstructor() {
    return instructor;
  }

  /**
   * Establece el instructor de la unidad de formación.
   *
   * @param instructor Sanitario que realiza las tareas de formación.
   */
  public void setInstructor(Sanitario instructor) {
    this.instructor = instructor;
  }

  /**
   * Devuelve la lista de estudiantes asignados a la unidad de formación.
   *
   * @return Lista de estudiantes.
   */
  public List<Estudiante> getEstudiantes() {
    return estudiantes;
  }

  /**
   * Establece los estudiantes de la unidad de formación.
   *
   * @param estudiantes Estudiantes a asignar.
   */
  public void setEstudiantes(List<Estudiante> estudiantes) {
    this.estudiantes = estudiantes;
  }

  /**
   * Agrega un estudiante a la unidad de formación.
   *
   * @param estudiante Estudiante que se quiere agregar.
   */
  public void addEstudiante(Estudiante estudiante) {
    this.estudiantes.add(estudiante);
  }
}
