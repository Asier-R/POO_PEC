package servicio;

import entidad.persona.*;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.List;
import java.util.stream.Collectors;

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
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p.getNIF().toUpperCase().contains(NIF.toUpperCase()))
            .collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por nombre. */
  static void consultarPorNombre(String nombre) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p.getNombre().toUpperCase().contains(nombre.toUpperCase()))
            .collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por primer apellido. */
  static void consultarPorPrimerApellido(String apellido) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p.getApellido1().toUpperCase().contains(apellido.toUpperCase()))
            .collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
  }

  /** Consulta por segundo apellido. */
  static void consultarPorSegundoApellido(String apellido) {
    List<Personal> personal =
        LogicaTerminalDatos.getHospital().getPersonal().stream()
            .filter(p -> p.getApellido2().toUpperCase().contains(apellido.toUpperCase()))
            .collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Consultas::presentar);
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

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  private static void presentar(Persona persona) {
    System.out.println(persona.toString().replace("\n", "  "));
  }
}
