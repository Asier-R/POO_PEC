package servicio;

import entidad.persona.*;
import entidad.registro.Cita;
import entidad.registro.Expediente;
import entidad.unidad.Unidad;
import entidad.unidad.formacion.Formacion;
import enumerado.CodigoActividadEnum;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/** Clase encargada de implementar las operaciones o actividades llevadas a cabo por gerencia. */
public final class Gerencia {

  /** Variable temporal para la cita. */
  static Cita tmpCita;

  /** Variable temporal para el instructor de una unidad de formación. */
  static Sanitario instructor;

  /** Variable temporal para los estudiantes de una unidad de formación. */
  static List<Estudiante> estudiantes;

  /** Variable temporal para la ubicación de la formación */
  static Formacion ubicacion;

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS PARA LA CREACIÓN DE CITAS
  ------------------------------------------------------------------------------------------------------------------ */

  /** Inicializa la cita temporal. */
  static void iniciarCita() {
    tmpCita = new Cita(ZonedDateTime.now(), null, null);
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
      if (sanitario.getCitas().isEmpty()) {
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

  /** Permite seleccionar por NIF un instructor. */
  static void seleccionarInstructor() {
    PantallasTerminalDatos.pantallaInfoInstructor();
    String nif = Utiles.inputNIF(); // Obtener nif
    try {
      Sanitario sanitario =
          (Sanitario)
              LogicaTerminalDatos.getHospital().getPersonal().stream()
                  .filter(
                      p -> {
                        if (p instanceof Medico || p instanceof Enfermero)
                          return p.getNIF().equals(nif);
                        else return false;
                      })
                  .findFirst()
                  .orElseThrow();

      Utiles.mostrarDatosPersona(sanitario);

      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        instructor = sanitario;
      }
    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
    LTDGerencia.pantallaPrepararFormacionEstudiantes();
  }

  /** Permite seleccionar por NIF un instructor. */
  static void seleccionarEstudiante() {
    String nif = Utiles.inputNIF(); // Obtener nif
    try {
      Estudiante estudiante =
          (Estudiante)
              LogicaTerminalDatos.getHospital().getPersonal().stream()
                  .filter(
                      p -> {
                        if (p instanceof Estudiante) return p.getNIF().equals(nif);
                        else return false;
                      })
                  .findFirst()
                  .orElseThrow();

      Utiles.mostrarDatosPersona(estudiante);

      PantallasTerminalDatos.pantallaConfirmacion();
      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        if (estudiantes == null) estudiantes = new ArrayList<>();

        if(estudiantes.contains(estudiante)) PantallasTerminalDatos.pantallaAvisoEstudianteYaAsignado();
        else estudiantes.add(estudiante);
      }
    } catch (NoSuchElementException e) {
      PantallasTerminalDatos.pantallaAvisoPersonaNoEncontrada(nif);
    }
    LTDGerencia.pantallaPrepararFormacionEstudiantes();
  }

  /** Permite seleccionar la ubicación de la formación. */
  static void seleccionarUbicacionFormacion() {
    PantallasTerminalDatos.pantallaSeleccionarUnidadFormacion();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Laboratorio
        ubicacion =
                (Formacion) LogicaTerminalDatos.getHospital().getUnidades().stream()
                    .filter(u -> u.getCodigoActividad().equals(CodigoActividadEnum.LABORATORIO))
                    .findFirst()
                    .orElse(null);
        break;
      case "2": // 2. Clase
        ubicacion =
                (Formacion) LogicaTerminalDatos.getHospital().getUnidades().stream()
                    .filter(u -> u.getCodigoActividad().equals(CodigoActividadEnum.CLASE))
                    .findFirst()
                    .orElse(null);
        break;
      default: // Permanecer en la pantalla
        seleccionarUbicacionFormacion();
        break;
    }
  }

  /** Asigna el instructor y los estudiantes a una unidad de formación */
  static void prepararFormacion(){
    String falta = "";
    falta = validarFormacion(falta);

    if (falta.isEmpty()) {
      PantallasTerminalDatos.pantallaConfirmacion();

      if (Utiles.leerLinea().equalsIgnoreCase(Utiles.SI)) {
        ubicacion.setInstructor(instructor);
        ubicacion.setEstudiantes(estudiantes);
        instructor.setCodigoActividad(ubicacion.getCodigoActividad());
        instructor.setCodigoArea(ubicacion.getCodigoArea());
        estudiantes.forEach(e -> {
          e.setCodigoActividad(ubicacion.getCodigoActividad());
          e.setCodigoArea(ubicacion.getCodigoArea());
        });
        PantallasTerminalDatos.pantallaDatosGrabados();
      }
    } else {
      System.out.println("Faltan los siguientes campos: " + falta);
    }
    LTDGerencia.pantallaPrepararFormacionEstudiantes();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS PARA GESTIÓN CONTABLE
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Prepara y emite facturas para los pacientes dados de alta y sin seguridad social.
   */
  static void prepararEmitirFacturas(){
    PantallasTerminalDatos.pantallaInfoEmisionFactura();
    List<Paciente> pacientes = LogicaTerminalDatos.getHospital().getPacientes();
    Expediente expediente;
    for(Paciente paciente : pacientes){
      expediente = paciente.getExpediente();
      if(expediente.tieneSeguridadSocial() && expediente.getEstado().equals(Expediente.Estado.SANO)) presentarFactura(paciente);
    }
  }

  private static void presentarFactura(Paciente paciente){
    PantallasTerminalDatos.separarPantallaSimple();
    System.out.println("> PACIENTE: " + paciente.toString().replace("\n", "  "));
  }

  /* ------------------------------------------------------------------------------------------------------------------
     MÉTODOS AUXILIARES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Validaciones de la cita temporal.
   *
   * @param falta Texto informativo que contendrá los campos que faltan de informar en la cita
   *     temporal.
   * @return Texto con los campos que faltan de informar en la cita temporal.
   */
  private static String validarCita(String falta) {
    falta = Utiles.validarCampoFecha(tmpCita.getFechaCita(), falta, Utiles.STR_FECHA_CITA);
    falta = Utiles.validarCampoPersona(tmpCita.getPaciente(), falta, Utiles.STR_PACIENTE);
    falta = Utiles.validarCampoPersona(tmpCita.getSanitarios(), falta, Utiles.STR_SANITARIO);
    falta = Utiles.validarCampoUnidad(tmpCita.getUbicacion(), falta, Utiles.STR_COD_ACTIVIDAD);
    return falta;
  }

  /**
   * Validaciones de la formación.
   *
   * @param falta Texto informativo que contendrá los campos que faltan para preparar la formación.
   * @return Texto con los campos que faltan para preparar la formación.
   */
  private static String validarFormacion(String falta) {
    falta = Utiles.validarCampoPersona(instructor, falta, Utiles.STR_SANITARIO);
    falta = Utiles.validarCampoPersona(estudiantes, falta, Utiles.STR_ESTUDIANTE);
    falta = Utiles.validarCampoUnidad(ubicacion, falta, Utiles.STR_UBICACION);
    return falta;
  }

  /** Muestra por pantalla los datos de la cita. */
  static void mostrarDatosCita() {
    PantallasTerminalDatos.separarPantalla();
    System.out.println(tmpCita);
  }

  /** Asigna la cita al paciente y los sanitarios implicados en la cita. */
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
   *
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
   *
   * @param cita Cita a comparar.
   * @return True si las citas coinciden en fecha y hora.
   */
  private static boolean ocupado(Cita cita) {
    return tmpCita.compareTo(cita) == 0;
  }
}
