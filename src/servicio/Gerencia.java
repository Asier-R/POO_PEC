package servicio;

import entidad.persona.*;
import entidad.registro.Cita;
import entidad.unidad.Unidad;
import enumerado.CodigoActividadEnum;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/** Clase encargada de implementar las operaciones o actividades llevadas a cabo por gerencia. */
public final class Gerencia {

  /** Variable temporal para conservar el horario de la cita. */
  static Cita.Horario horario;

  /** Variable temporal para conservar la fecha de creación de la cita. */
  static ZonedDateTime fechaCreacion;

  /** Variable temporal para conservar la fecha de la cita. */
  static ZonedDateTime fechaCita;

  /** Variable temporal para conservar el paciente de la cita. */
  static Paciente paciente;

  /** Variable temporal para conservar los sanitarios de la cita. */
  static List<Sanitario> sanitarios;

  /** Variable temporal para conservar el lugar de la cita. */
  static Unidad ubicacion;

  /** Variable temporal para conservar el estado de la cita. */
  static boolean vencida;

  static Cita tmpCita;

  static void seleccionarPaciente() {
    String nif = Utiles.leerLinea(); // Obtener nif
    try {
      Paciente pct =
          LogicaTerminalDatos.getHospital().getPacientes().stream()
              .filter(p -> p.getNIF().equals(nif))
              .findFirst()
              .orElseThrow();

      Utiles.mostrarDatosPersona(pct);

      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        paciente = pct;
      }
    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
    LTDGerencia.pantallaSeleccionarPaciente();
  }

  static void seleccionarPersonal() {
    String nif = Utiles.leerLinea(); // Obtener nif
    try {
      Personal sanitario =
          LogicaTerminalDatos.getHospital().getPersonal().stream()
              .filter(
                  p -> {
                    if (p instanceof Sanitario) return p.getNIF().equals(nif);
                    else return false;
                  })
              .findFirst()
              .orElseThrow();

      Utiles.mostrarDatosPersona(sanitario);

      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        if (sanitarios == null) sanitarios = new ArrayList<>();
        sanitarios.add((Sanitario) sanitario);
      }
    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
    LTDGerencia.pantallaSeleccionarPersonal();
  }

  static void seleccionarUbicacion() {
    CodigoActividadEnum cod = Utiles.inputCodActividad();
    Unidad unidad =
        LogicaTerminalDatos.getHospital().getUnidades().stream()
            .filter(u -> u.getCodigoActividad().equals(cod))
            .findFirst()
            .orElseThrow();
    ubicacion = unidad;
  }



  static void crearCita(){
    tmpCita = new Cita(fechaCreacion, fechaCita, paciente, ubicacion);
    String falta = "";
    falta = validarCita(falta);
    // TODO: terminar creación de citas

//    if (falta.isEmpty()) {
//      iniciarEstudiante();
//      PantallasTerminalDatos.pantallaConfirmacion();
//      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
//        AltaBajaPersona.grabarPersona();
//        LTDGerencia.pantallaGestionPersonalAlta();
//        return;
//      }
//    } else {
//      System.out.println("Faltan los siguientes campos: " + falta);
//    }
//    LTDGerencia.pantallaAltaEstudiante();

  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  private static String validarCita(String falta) {
    falta = Utiles.validarCampoFecha(fechaCita, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoPersona(paciente, falta, Utiles.STR_COD_ACTIVIDAD);
    falta = Utiles.validarCampoPersona(sanitarios, falta, Utiles.STR_COD_ACTIVIDAD);
    return falta;
  }

}
