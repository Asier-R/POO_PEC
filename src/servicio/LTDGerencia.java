package servicio;

import entidad.persona.*;

/**
 * Clase encargada de la lógica de interacción entre pantallas de Gerencia del terminal de datos.
 */
public final class LTDGerencia {

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE PERSONAL
  ------------------------------------------------------------------------------------------------------------------ */

  /** Lógica de pantalla 1.1. GESTIÓN DEL PERSONAL */
  static void pantallaGestionPersonal() {
    PantallasTerminalDatos.pantallaGestionPersonal();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Alta
        pantallaGestionPersonalAlta();
        break;
      case "2": // 2. Baja
        pantallaGestionBajaPersonal();
        break;
      case "3": // 3. Gestión
        pantallaGestionDatosPersonal();
        break;
      case "X": // X. Volver a 1. GERENCIA
        LogicaTerminalDatos.pantallaGerencia();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaGestionPersonal();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaGestionPersonal();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1. GESTIÓN DE ALTAS DE PERSONAL */
  static void pantallaGestionPersonalAlta() {
    PantallasTerminalDatos.pantallaGestionPersonalAlta();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Alta de administrativos
        pantallaAltaAdministrativo();
        break;
      case "2": // 2. Alta de personal de mantenimiento y servicio
        pantallaAltaMantenimientoServicio();
        break;
      case "3": // 3. Alta de estudiantes
        pantallaAltaEstudiante();
        break;
      case "4": // 4. Alta de enfermeros
        pantallaAltaEnfermero();
        break;
      case "5": // 5. Alta de médicos
        pantallaAltaMedico();
        break;
      case "X": // X. Volver a 1.1. GESTIÓN DEL PERSONAL
        pantallaGestionPersonal();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaGestionPersonalAlta();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaGestionPersonalAlta();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1.1. ALTAS DE ADMINISTRATIVO */
  static void pantallaAltaAdministrativo() {
    PantallasTerminalDatos.pantallaAltaAdministrativo();
    AltaBajaPersona.iniciarAdmin(); // Se inicia tipo de persona para poder mostrar sus datos
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        AltaBajaPersona.NIF = Utiles.inputNIF();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        AltaBajaPersona.nombre = Utiles.inputNombre();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        AltaBajaPersona.apellido1 = Utiles.inputApellido1();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        AltaBajaPersona.apellido2 = Utiles.inputApellido2();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código actividad
        AltaBajaPersona.codigoActividad = Utiles.inputCodActividad();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar grupo administrativo
        AltaBajaPersona.grupo = Utiles.inputGrupoAdmin();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Mostrar datos
        AltaBajaPersona.mostrarDatosPersona();
        pantallaAltaAdministrativo(); // Se vuelve a la pantalla
        break;
      case "8": // 8. Finalizar Alta
        AltaBajaPersona.validarGrabarAdministrador(); // Validación y alta
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaAltaAdministrativo();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaAltaAdministrativo();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1.2. ALTAS DE PERSONAL DE MANTENIMIENTO Y SERVICIO */
  static void pantallaAltaMantenimientoServicio() {
    PantallasTerminalDatos.pantallaAltaMantenimientoServicio();
    AltaBajaPersona.iniciarMantenimientoServicio();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        AltaBajaPersona.NIF = Utiles.inputNIF();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        AltaBajaPersona.nombre = Utiles.inputNombre();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        AltaBajaPersona.apellido1 = Utiles.inputApellido1();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        AltaBajaPersona.apellido2 = Utiles.inputApellido2();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código área
        AltaBajaPersona.codigoArea = Utiles.inputCodArea();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar código actividad
        AltaBajaPersona.codigoActividad = Utiles.inputCodActividad();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Mostrar datos
        AltaBajaPersona.mostrarDatosPersona();
        pantallaAltaMantenimientoServicio(); // Se vuelve a la pantalla
        break;
      case "8": // 8. Finalizar Alta
        AltaBajaPersona.validarGrabarMantenimientoServicio(); // Validación y alta
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaAltaMantenimientoServicio();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaAltaMantenimientoServicio();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1.3. ALTAS DE ESTUDIANTE */
  static void pantallaAltaEstudiante() {
    PantallasTerminalDatos.pantallaAltaEstudiante();
    AltaBajaPersona.iniciarEstudiante();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        AltaBajaPersona.NIF = Utiles.inputNIF();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        AltaBajaPersona.nombre = Utiles.inputNombre();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        AltaBajaPersona.apellido1 = Utiles.inputApellido1();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        AltaBajaPersona.apellido2 = Utiles.inputApellido2();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código área
        AltaBajaPersona.codigoArea = Utiles.inputCodArea();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar código actividad
        AltaBajaPersona.codigoActividad = Utiles.inputCodActividad();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Seleccionar código especialidad
        AltaBajaPersona.codigoEspecialidad = Utiles.inputCodEspecialidad();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "8": // 8. Introducir experiencia
        AltaBajaPersona.experiencia = Utiles.inputExperiencia();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "9": // 9. Introducir nombre de centro
        AltaBajaPersona.nombreCentro = Utiles.inputNombreCentro();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "10": // 10. Mostrar datos
        AltaBajaPersona.mostrarDatosPersona();
        pantallaAltaEstudiante(); // Se vuelve a la pantalla
        break;
      case "11": // 11. Finalizar Alta
        AltaBajaPersona.validarGrabarEstudiante(); // Validación y alta
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaAltaEstudiante();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaAltaEstudiante();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1.4. ALTAS DE ENFERMERO */
  static void pantallaAltaEnfermero() {
    PantallasTerminalDatos.pantallaAltaEnfermero();
    AltaBajaPersona.iniciarEnfermero();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        AltaBajaPersona.NIF = Utiles.inputNIF();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        AltaBajaPersona.nombre = Utiles.inputNombre();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        AltaBajaPersona.apellido1 = Utiles.inputApellido1();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        AltaBajaPersona.apellido2 = Utiles.inputApellido2();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código área
        AltaBajaPersona.codigoArea = Utiles.inputCodArea();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar código actividad
        AltaBajaPersona.codigoActividad = Utiles.inputCodActividad();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Seleccionar código especialidad
        AltaBajaPersona.codigoEspecialidad = Utiles.inputCodEspecialidad();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "8": // 8. Introducir experiencia
        AltaBajaPersona.experiencia = Utiles.inputExperiencia();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "9": // 9. Mostrar datos
        AltaBajaPersona.mostrarDatosPersona();
        pantallaAltaEnfermero(); // Se vuelve a la pantalla
        break;
      case "10": // 10. Finalizar Alta
        AltaBajaPersona.validarGrabarEnfermero(); // Validación y alta
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaAltaEnfermero();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaAltaEnfermero();
        break;
    }
  }

  /** Lógica de pantalla 1.1.1.5. ALTAS DE MÉDICO */
  static void pantallaAltaMedico() {
    PantallasTerminalDatos.pantallaAltaMedico();
    AltaBajaPersona.iniciarMedico();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Introducir NIF
        AltaBajaPersona.NIF = Utiles.inputNIF();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "2": // 2. Introducir nombre
        AltaBajaPersona.nombre = Utiles.inputNombre();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "3": // 3. Introducir primer apellido
        AltaBajaPersona.apellido1 = Utiles.inputApellido1();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "4": // 4. Introducir segundo apellido
        AltaBajaPersona.apellido2 = Utiles.inputApellido2();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "5": // 5. Seleccionar código área
        AltaBajaPersona.codigoArea = Utiles.inputCodArea();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "6": // 6. Seleccionar código actividad
        AltaBajaPersona.codigoActividad = Utiles.inputCodActividad();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "7": // 7. Seleccionar código especialidad
        AltaBajaPersona.codigoEspecialidad = Utiles.inputCodEspecialidad();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "8": // 8. Seleccionar código segunda especialidad
        AltaBajaPersona.codigoSegundaEspecialidad = Utiles.inputCodEspecialidad();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "9": // 8. Introducir experiencia
        AltaBajaPersona.experiencia = Utiles.inputExperiencia();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "10": // 10. Mostrar datos
        AltaBajaPersona.mostrarDatosPersona();
        pantallaAltaMedico(); // Se vuelve a la pantalla
        break;
      case "11": // 11. Finalizar Alta
        AltaBajaPersona.validarGrabarMedico(); // Validación y alta
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaAltaMedico();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaAltaMedico();
        break;
    }
  }

  /** Lógica de pantalla 1.1.2. GESTIÓN DE BAJAS DE PERSONAL */
  static void pantallaGestionBajaPersonal() {
    PantallasTerminalDatos.pantallaGestionBajaPersonal();
    AltaBajaPersona.iniciarMedico();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Baja por NIF
        PantallasTerminalDatos.pantallaBajaPersonal(); // 1.1.2.1. BAJA DE PERSONAL
        AltaBajaPersona.bajaPorNIFPersona();
        break;
      case "2": // 2. Consultar personal
        LTDConsulta.pantallaConsultaCualquierPersona();
        pantallaGestionBajaPersonal();
        break;
      case "X": // X. Volver a 1.1.1. GESTIÓN DE ALTAS DE PERSONAL
        pantallaGestionPersonalAlta();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaGestionBajaPersonal();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaGestionBajaPersonal();
        break;
    }
  }

  /** Lógica de pantalla 1.1.3. GESTIÓN DE DATOS DEL PERSONAL */
  static void pantallaGestionDatosPersonal() {
    PantallasTerminalDatos.pantallaGestionDatosPersonal();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Crear Cita
        Gerencia.iniciarCita();
        pantallaCrearCita();
        break;
      case "2": // 2. Consultar agenda del personal sanitario
        pantallaConsultaAgenda();
        break;
      case "3": // 3. Modificar agenda del personal sanitario
        // TODO: crear modificación de citas
        // TODO: probar pantallaConsulta
        pantallaModificacionAgenda();

        break;
      case "X": // X. Volver a 1.1. GESTIÓN DEL PERSONAL
        pantallaGestionPersonal();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaGestionDatosPersonal();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaGestionDatosPersonal();
        break;
    }
  }

  /** Lógica de pantalla 1.1.3.1. CREAR CITA */
  static void pantallaCrearCita() {
    PantallasTerminalDatos.pantallaCrearCita();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Seleccionar Paciente
        pantallaSeleccionarPaciente();
        break;
      case "2": // 2. Seleccionar Sanitario
        pantallaSeleccionarPersonal();
        break;
      case "3": // 3. Introducir fecha
        Gerencia.seleccionarFechaCita();
        pantallaCrearCita();
        break;
      case "4": // 4. Seleccionar lugar de la cita
        Gerencia.seleccionarUbicacion();
        pantallaCrearCita();
        break;
      case "5": // 5. Crea cita
        Gerencia.crearCita();
        break;
      case "6": // 6. Consultar
        Gerencia.mostrarDatosCita();
        pantallaCrearCita();
        break;
      case "X": // X. Volver a 1.1. GESTIÓN DEL PERSONAL
        pantallaGestionDatosPersonal();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaGestionDatosPersonal();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaCrearCita();
        break;
    }
  }

  /** Lógica de selección de paciente */
  static void pantallaSeleccionarPaciente() {
    PantallasTerminalDatos.pantallaBuscarPersona();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Seleccionar por NIF
        Gerencia.seleccionarPaciente();
        pantallaSeleccionarPaciente();
        break;
      case "2": // 2. Consultar personas
        LTDConsulta.pantallaConsultaCualquierPersona();
        pantallaSeleccionarPaciente();
        break;
      case "X": // X. Volver a 1.1.3.1. CREAR CITA
        pantallaCrearCita();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaSeleccionarPaciente();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaSeleccionarPaciente();
        break;
    }
  }

  /** Lógica de selección de personal */
  static void pantallaSeleccionarPersonal() {
    PantallasTerminalDatos.pantallaBuscarPersona();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Seleccionar por NIF
        Gerencia.seleccionarPersonal();
        pantallaSeleccionarPersonal();
        break;
      case "2": // 2. Consultar personas
        LTDConsulta.pantallaConsultaCualquierPersona();
        pantallaSeleccionarPersonal();
        break;
      case "X": // X. Volver a 1.1.3.1. CREAR CITA
        pantallaCrearCita();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaSeleccionarPersonal();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaSeleccionarPersonal();
        break;
    }
  }

  /** Lógica de consulta de agenda */
  static void pantallaConsultaAgenda(){
    PantallasTerminalDatos.pantallaBuscarPersona();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Seleccionar por NIF
        Consultas.consultarAgendaPorNIF(Utiles.inputNIF());
        pantallaConsultaAgenda();
        break;
      case "2": // 2. Consultar personas
        LTDConsulta.pantallaConsultaCualquierPersona();
        pantallaConsultaAgenda();
        break;
      case "X": // X. Volver
        pantallaGestionDatosPersonal();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaConsultaAgenda();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaConsultaAgenda();
        break;
    }

  }

  /** Lógica de pantalla de modificación de agenda. */
  static void pantallaModificacionAgenda(){
    PantallasTerminalDatos.pantallaBuscarPersona();
    String opt = Utiles.leerLinea().toUpperCase();

    switch (opt) {
      case "1": // 1. Seleccionar por NIF
        Gerencia.borrarCitaSanitario();
        pantallaModificacionAgenda();
        break;
      case "2": // 2. Consultar personas
        LTDConsulta.pantallaConsultaCualquierPersona();
        pantallaModificacionAgenda();
        break;
      case "X": // X. Volver
        pantallaGestionDatosPersonal();
        break;
      case "Z": // Z. Finalizar
        if (!LogicaTerminalDatos.finPrograma()) pantallaModificacionAgenda();
        PantallasTerminalDatos.pantallaCierre();
        break;
      default: // Permanecer en la pantalla
        pantallaModificacionAgenda();
        break;
    }
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE PACIENTES
  ------------------------------------------------------------------------------------------------------------------ */

}
