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
            .filter(p -> p.getNIF().equalsIgnoreCase(NIF)).collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Persona::toString);
  }

  /** Consulta por nombre. */
  static void consultarPorNombre(String nombre) {
    List<Personal> personal =
            LogicaTerminalDatos.getHospital().getPersonal().stream()
                    .filter(p -> p.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Persona::toString);
  }

  /** Consulta por primer apellido. */
  static void consultarPorPrimerApellido(String apellido) {
    List<Personal> personal =
            LogicaTerminalDatos.getHospital().getPersonal().stream()
                    .filter(p -> p.getApellido1().equalsIgnoreCase(apellido)).collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Persona::toString);
  }

  /** Consulta por segundo apellido. */
  static void consultarPorSegundoApellido(String apellido) {
    List<Personal> personal =
            LogicaTerminalDatos.getHospital().getPersonal().stream()
                    .filter(p -> p.getApellido2().equalsIgnoreCase(apellido)).collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Persona::toString);
  }

  /** Consulta por código unidad. */
  static void consultarPorCodigoUnidad(CodigoUnidadEnum codigo) {
    List<Personal> personal =
            LogicaTerminalDatos.getHospital().getPersonal().stream()
                    .filter(p -> p.getCodigoUnidad().equals(codigo)).collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Persona::toString);
  }

  /** Consulta por código área. */
  static void consultarPorCodigoArea(CodigoAreaEnum codigo) {
    List<Personal> personal =
            LogicaTerminalDatos.getHospital().getPersonal().stream()
                    .filter(p -> p.getCodigoArea().equals(codigo)).collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Persona::toString);
  }

  /** Consulta por código actividad. */
  static void consultarPorCodigoActividad(CodigoActividadEnum codigo) {
    List<Personal> personal =
            LogicaTerminalDatos.getHospital().getPersonal().stream()
                    .filter(p -> p.getCodigoActividad().equals(codigo)).collect(Collectors.toList());

    if (personal.isEmpty()) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else personal.forEach(Persona::toString);
  }
}
