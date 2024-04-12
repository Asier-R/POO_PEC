package servicio;

import entidad.persona.*;
import entidad.registro.Cita;
import entidad.unidad.Unidad;
import enumerado.CodigoActividadEnum;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

/** Clase encargada de implementar las operaciones o actividades llevadas a cabo por gerencia. */
public final class Gerencia {

  /** Variable temporal para conservar la fecha de la cita. */
  static ZonedDateTime fechaCita;

  static Cita tmpCita;

  static void iniciarCita(){
    tmpCita = new Cita(ZonedDateTime.now(), ZonedDateTime.now(), null, null);
  }

  static void seleccionarFechaCita(){
    tmpCita.setFechaCita(Utiles.inputFecha());
  }

  static void seleccionarPaciente() {
    String nif = Utiles.inputNIF(); // Obtener nif
    try {
      Paciente pct =
          LogicaTerminalDatos.getHospital().getPacientes().stream()
              .filter(p -> p.getNIF().equals(nif))
              .findFirst()
              .orElseThrow();

      Utiles.mostrarDatosPersona(pct);

      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        tmpCita.setPaciente(pct);
      }
    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
    LTDGerencia.pantallaSeleccionarPaciente();
  }

  static void seleccionarPersonal() {
    String nif = Utiles.inputNIF(); // Obtener nif
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
        tmpCita.addSanitario((Sanitario) sanitario);
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
    tmpCita.setUbicacion(unidad);
  }

  static void crearCita(){
    String falta = "";
    falta = validarCita(falta);

    if (falta.isEmpty()) {
      PantallasTerminalDatos.pantallaConfirmacion();

      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        asignarCita();
        LTDGerencia.pantallaCrearCita();
        return;
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaCrearCita();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  private static String validarCita(String falta) {
    falta = Utiles.validarCampoFecha(tmpCita.getFechaCita(), falta, Utiles.STR_FECHA_CITA);
    falta = Utiles.validarCampoPersona(tmpCita.getPaciente(), falta, Utiles.STR_PACIENTE);
    falta = Utiles.validarCampoPersona(tmpCita.getSanitarios(), falta, Utiles.STR_SANITARIO);
    falta = Utiles.validarCampoUnidad(tmpCita.getUbicacion(), falta, Utiles.STR_COD_ACTIVIDAD);
    return falta;
  }

  static void mostrarDatosCita() {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(tmpCita);
  }

  private static void asignarCita(){
    tmpCita.getPaciente().setCita(tmpCita);
    tmpCita.getSanitarios().forEach(s -> s.getCitas().add(tmpCita));
  }

}
