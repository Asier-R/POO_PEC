package servicio;

import entidad.persona.*;
import entidad.registro.Cita;
import entidad.unidad.Unidad;
import entidad.unidad.formacion.Formacion;
import entidad.unidad.medica.consulta.Primaria;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase encargada de realizar consultas necesarias para complementar a {@link LogicaTerminalDatos}
 * y {@link LTDGerencia} y {@link LTDConsulta}.
 */
public final class Consultas {

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS CONSULTA PERSONA
  ------------------------------------------------------------------------------------------------------------------ */

  /** Consulta por NIF. */
  static void consultarPorNIF(String NIF) {
    List<Persona> personas = obtenerTodasLasPersonas();
    personas =
        personas.stream()
            .filter(p -> p.getNIF().toUpperCase().contains(NIF.toUpperCase()))
            .collect(Collectors.toList());

    if (personas.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personas.forEach(Consultas::presentar);
  }

  /** Consulta por nombre. */
  static void consultarPorNombre(String nombre) {
    List<Persona> personas = obtenerTodasLasPersonas();
    personas =
        personas.stream()
            .filter(p -> p.getNombre().toUpperCase().contains(nombre.toUpperCase()))
            .collect(Collectors.toList());

    if (personas.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personas.forEach(Consultas::presentar);
  }

  /** Consulta por primer apellido. */
  static void consultarPorPrimerApellido(String apellido) {
    List<Persona> personas = obtenerTodasLasPersonas();
    personas =
        personas.stream()
            .filter(p -> p.getApellido1().toUpperCase().contains(apellido.toUpperCase()))
            .collect(Collectors.toList());

    if (personas.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personas.forEach(Consultas::presentar);
  }

  /** Consulta por segundo apellido. */
  static void consultarPorSegundoApellido(String apellido) {
    List<Persona> personas = obtenerTodasLasPersonas();
    personas =
        personas.stream()
            .filter(p -> p.getApellido2().toUpperCase().contains(apellido.toUpperCase()))
            .collect(Collectors.toList());

    if (personas.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personas.forEach(Consultas::presentar);
  }

  /** Consulta por código unidad. */
  static void consultarPorCodigoUnidad(CodigoUnidadEnum codigo) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p.getCodigoUnidad().equals(codigo))
            .collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por código área. */
  static void consultarPorCodigoArea(CodigoAreaEnum codigo) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p.getCodigoArea().equals(codigo))
            .collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por código actividad. */
  static void consultarPorCodigoActividad(CodigoActividadEnum codigo) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p.getCodigoActividad().equals(codigo))
            .collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por experiencia. */
  static void consultarPorExperiencia(int experiencia) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(
                p -> {
                  if (p instanceof Sanitario)
                    return ((Sanitario) p).getExperiencia() == (experiencia);
                  else return false;
                })
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por código especialidad. */
  static void consultarPorCodigoEspecialidad(CodigoEspecialidadEnum codigo) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(
                p -> {
                  if (p instanceof Sanitario)
                    return ((Sanitario) p).getCodigoEspecialidad().equals(codigo);
                  else return false;
                })
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por código segunda especialidad. */
  static void consultarPorCodigoSegundaEspecialidad(CodigoEspecialidadEnum codigo) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(
                p -> {
                  if (p instanceof Medico)
                    return ((Medico) p).getSegundaEspecialidad().equals(codigo);
                  else return false;
                })
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consultar todos los pacientes */
  static void consultarPacientes() {
    List<Paciente> pacientes = LogicaTerminalDatos.getHospital().getPacientes();
    if (pacientes.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else pacientes.forEach(Consultas::presentar);
  }

  /** Consultar todos los administrativos */
  static void consultarAdministrativos() {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p instanceof Administrativo)
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consultar todos los de mantenimiento y servicio */
  static void consultarMantenimientoServicio() {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p instanceof Administrativo)
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consultar todos los estudiantes */
  static void consultarEstudiantes() {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p instanceof Estudiante)
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consultar todos los enfermeros */
  static void consultarEnfermeros() {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p instanceof Enfermero)
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consultar todos los médicos */
  static void consultarMedicos() {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p instanceof Medico)
            .collect(Collectors.toList());
    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /**
   * Devuelve el sanitario cuyo NIF coincida con la entrada.
   *
   * @param NIF NIF del sanitario a obtener.
   * @return Sanitario encontrado o null si no existe.
   */
  static Sanitario obtenerSanitarioPorNIF(String NIF) {
    List<Personal> personal = LogicaTerminalDatos.getHospital().getPersonal();
    return (Sanitario)
        personal.stream()
            .filter(p -> p.getNIF().toUpperCase().contains(NIF.toUpperCase()))
            .findFirst()
            .orElse(null);
  }

  /** Obtener todos los médicos */
  static List<Medico> obtenerMedicos() {
    List<Medico> medicos = new ArrayList<>();
    LogicaTerminalDatos.getHospital()
        .getPersonal()
        .forEach(
            p -> {
              if (p instanceof Medico) medicos.add((Medico) p);
            });
    return medicos;
  }

  /**
   * Consulta por NIF.
   *
   * @param NIF NIF del sanitario.
   */
  static void consultarAgendaPorNIF(String NIF) {
    List<Personal> personal = LogicaTerminalDatos.getHospital().getPersonal();
    Sanitario sanitario =
        (Sanitario)
            personal.stream()
                .filter(p -> p.getNIF().toUpperCase().contains(NIF.toUpperCase()))
                .findFirst()
                .orElse(null);

    if (sanitario == null) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else verAgenda(sanitario);
  }

  /** Consulta de las unidades de formación del hospital. */
  static void consultarUnidadesFormacion() {
    List<Unidad> unidades = LogicaTerminalDatos.getHospital().getUnidades();

    List<Unidad> formacion =
        unidades.stream().filter(u -> u instanceof Formacion).collect(Collectors.toList());

    if (formacion.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else formacion.forEach(f -> presentarFormacion((Formacion) f));
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Muestra por pantalla y en solo una línea los datos de una persona.
   *
   * @param persona Persona cuyos datos se van a mostrar.
   */
  static void presentar(Persona persona) {
    System.out.println(persona.toString().replace("\n", "  "));
  }

  /**
   * Muestra por pantalla y en solo una línea los datos de una unidad de formación.
   *
   * @param formacion Unidad cuyos datos se van a mostrar.
   */
  private static void presentarFormacion(Formacion formacion) {
    String codigo =
        formacion.getCodigoArea() == null ? "" : formacion.getCodigoArea().getDescripcion();
    String instructor =
        formacion.getInstructor() == null
            ? ""
            : formacion.getInstructor().toString().replace("\n", "  ");
    StringBuilder estudiantes = new StringBuilder();
    formacion
        .getEstudiantes()
        .forEach(e -> estudiantes.append(e.toString().replace("\n", "  ")).append("\n"));
    String info =
        "> Unidad: "
            + codigo
            + "\n"
            + "Instructor: "
            + instructor
            + "\n"
            + "Estudiantes:\n"
            + estudiantes;
    System.out.println(info);
  }

  /**
   * Muestra por pantalla las citas (numeradas) de un sanitario.
   *
   * @param sanitario Sanitario cuyas citas se van a mostrar.
   */
  private static void verAgenda(Sanitario sanitario) {
    List<Cita> citas = sanitario.getCitas();
    if (citas != null && !citas.isEmpty()) {
      int contador = 1;
      citas.forEach(c -> printAgenda(String.valueOf(contador), c));
    } else {
      PantallasTerminalDatos.pantallaConsultaAgendaVacia();
    }
  }

  /**
   * Muestra por pantalla, de forma simplificada, una cita numerada.
   *
   * @param contador Número de la cita.
   * @param cita Cita a mostrar.
   */
  static void printAgenda(String contador, Cita cita) {
    System.out.println(
        contador
            + ". Cita -> "
            + "Fecha Cita: "
            + (cita.printFecha(cita.getFechaCita()))
            + "  "
            + "Horario: "
            + cita.printHorario()
            + "  "
            + "Ubicación: "
            + (cita.getUbicacion() == null ? "" : cita.getUbicacion().getNombre())
            + "  "
            + "Paciente: "
            + cita.getPaciente().getNIF());
  }

  /**
   * Devuelve todas las personas de un hospital combinando los pacientes con el personal.
   *
   * @return Lista de personas del hospital.
   */
  private static List<Persona> obtenerTodasLasPersonas() {
    List<Personal> personal = LogicaTerminalDatos.getHospital().getPersonal();
    List<Paciente> pacientes = LogicaTerminalDatos.getHospital().getPacientes();
    return Stream.concat(personal.stream(), pacientes.stream()).collect(Collectors.toList());
  }

  /**
   * Devuelve la unidad de consulta primaria.
   *
   * @return Unidad consulta primaria.
   */
  static Primaria obtenerUnidadConsultaPrimaria() {
    Unidad unidad =
        LogicaTerminalDatos.getHospital().getUnidades().stream()
            .filter(u -> u.getCodigoActividad().equals(CodigoActividadEnum.CONSULTA_PRIMARIA))
            .findFirst()
            .orElse(null);

    return unidad == null ? null : ((Primaria) unidad);
  }

  /**
   * Obtener una unidad a partir de un código de actividad.
   *
   * @param codigoActividad Código de actividad.
   * @return Unidad cuyo código de actividad coincide con la entrada.
   */
  static Unidad obtenerUnidadPorCodActividad(CodigoActividadEnum codigoActividad) {
    List<Unidad> unidades = LogicaTerminalDatos.getHospital().getUnidades();
    for (Unidad unidad : unidades) {
      if (unidad.getCodigoActividad().equals(codigoActividad)) return unidad;
    }
    return null;
  }

  /**
   * Obtener un médico asignado a una consulta determinada.
   *
   * @param codigoConsulta Código de la consulta.
   * @return Médico de la consulta.
   */
  static Medico obtenerMedicoDeConsulta(CodigoActividadEnum codigoConsulta) {
    final List<Personal> personal = LogicaTerminalDatos.getHospital().getPersonal();
    return (Medico)
        personal.stream()
            .filter(p -> (p.getCodigoActividad().equals(codigoConsulta) && p instanceof Medico))
            .findFirst()
            .orElse(null);
  }
}
