package servicio;

import entidad.persona.Persona;
import entidad.persona.Personal;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
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

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  private static void presentar(Persona persona){
    System.out.println(persona.toString().replace("\n", "  "));
  }

}
