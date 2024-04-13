package servicio;

import entidad.persona.*;
import entidad.registro.Cita;
import entidad.unidad.Unidad;
import enumerado.CodigoActividadEnum;

import javax.swing.*;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

/** Clase encargada de implementar las operaciones o actividades llevadas a cabo por gerencia. */
public final class Gerencia {

  /** Variable temporal para la cita. */
  static Cita tmpCita;

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS PARA LA CREACIÓN DE CITAS
  ------------------------------------------------------------------------------------------------------------------ */

  /** Inicializa la cita temporal. */
  static void iniciarCita() {
    tmpCita = new Cita(ZonedDateTime.now(), ZonedDateTime.now(), null, null);
  }

  /** Establece la fecha de la cita temporal. */
  static void seleccionarFechaCita() {
    tmpCita.setFechaCita(Utiles.inputFecha());
  }

  /** Permite seleccionar por NIF el paciente de la cita temporal. */
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
    LTDGerencia.pantallaCrearCita();
  }

  /** Permite agregar por NIF un sanitario a la cita temporal. */
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
        if (tmpCita.getSanitarios().contains(sanitario))
          PantallasTerminalDatos.pantallaAvisoSanitarioYaAsignado();
        else tmpCita.addSanitario((Sanitario) sanitario);
      }
    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
    LTDGerencia.pantallaCrearCita();
  }

  /** Permite seleccionar la ubicación de la cita temporal. */
  static void seleccionarUbicacion() {
    CodigoActividadEnum cod = Utiles.inputCodActividad();
    Unidad unidad =
        LogicaTerminalDatos.getHospital().getUnidades().stream()
            .filter(u -> u.getCodigoActividad().equals(cod))
            .findFirst()
            .orElse(null);
    if (unidad == null) PantallasTerminalDatos.pantallaConsultaSinResultados();
    else tmpCita.setUbicacion(unidad);
  }

  /** Convierte la cita temporal en una cita real y asigna la cita a paciente y sanitarios. */
  static void crearCita() {
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

  /** Permite borrar una cita de un sanitario. */
  static void borrarCitaSanitario() {
    String NIF = Utiles.inputNIF();
    Sanitario sanitario = Consultas.obtenerSanitarioPorNIF(NIF);
    Consultas.consultarAgendaPorNIF(NIF);
    if (sanitario != null) {
      if(sanitario.getCitas().isEmpty()){
        PantallasTerminalDatos.pantallaConsultaAgendaVacia();
      } else {
        PantallasTerminalDatos.pantallaSeleccionarCita();
        int numero = Utiles.leerNumero() - 1;
        if (numero > sanitario.getCitas().size()) {
          PantallasTerminalDatos.pantallaAvisoSeleccionCita();
        } else {
          PantallasTerminalDatos.pantallaAvisoBorrado();
          PantallasTerminalDatos.pantallaConfirmacion();
          if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
            sanitario.getCitas().remove(numero);
            PantallasTerminalDatos.pantallaDatosBorrados();
          }
        }
      }
    }
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Validaciones de la cita temporal.
   * @param falta Texto informativo que contendrá los campos que faltan de informar en la cita temporal.
   * @return Texto con los campos que faltan de informar en la cita temporal.
   */
  private static String validarCita(String falta) {
    falta = Utiles.validarCampoFecha(tmpCita.getFechaCita(), falta, Utiles.STR_FECHA_CITA);
    falta = Utiles.validarCampoPersona(tmpCita.getPaciente(), falta, Utiles.STR_PACIENTE);
    falta = Utiles.validarCampoPersona(tmpCita.getSanitarios(), falta, Utiles.STR_SANITARIO);
    falta = Utiles.validarCampoUnidad(tmpCita.getUbicacion(), falta, Utiles.STR_COD_ACTIVIDAD);
    return falta;
  }

  /** Muestra por pantalla los datos de la cita. */
  static void mostrarDatosCita() {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(tmpCita);
  }

  /**
   * Asigna la cita al paciente y los sanitarios implicados en la cita.
   */
  private static void asignarCita() {
    tmpCita.getPaciente().setCita(tmpCita);
    tmpCita
        .getSanitarios()
        .forEach(
            s -> {
              if (comprobarAgenda(s)) s.getCitas().add(tmpCita);
              else PantallasTerminalDatos.pantallaAvisoCitaNoCreada();
            });
  }

  /**
   * Comprueba la disponibilidad de agenda de un sanitario.
   * @param sanitario Sanitario cuya agenda se comprueba.
   * @return True si el sanitario puede acudir a la cita.
   */
  private static boolean comprobarAgenda(Sanitario sanitario) {
    boolean disponible = true;
    for (Cita cita : sanitario.getCitas()) {
      if (ocupado(cita)) {
        PantallasTerminalDatos.pantallaAvisoAgendaOcupada();
        System.out.println(
            "> El sanitario "
                + sanitario.getNIF()
                + " "
                + sanitario.getNombre()
                + " "
                + sanitario.getApellido1()
                + " no puede acudir a la cita...");
        disponible = false;
      }
    }
    return disponible;
  }

  /**
   * Compara la cita temporal con la cita de entrada.
   * @param cita Cita a comparar.
   * @return True si las citas coinciden en fecha y hora.
   */
  private static boolean ocupado(Cita cita) {
    return tmpCita.compareTo(cita) == 0;
  }
}
