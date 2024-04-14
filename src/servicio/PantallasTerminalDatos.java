package servicio;

/** Clase encargada de mostrar en pantalla la información ofrecida y solicitada a/por el usuario. */
public final class PantallasTerminalDatos {

  private static final String SEPARADOR = "--------------------------------------------";

  /** Constructor de la terminal de datos. */
  PantallasTerminalDatos() {
    System.out.println(">>>>>> INICIO DE TERMINAL DE DATOS <<<<<<");
  }

  /** Pantalla de inicio con las opciones disponibles. */
  static void pantallaInicio() {
    separarPantalla();
    System.out.println(">>> 0. INICIO");
    System.out.println("> 1. Gerencia y Administración");
    System.out.println("> 2. Servicios de Mantenimiento");
    System.out.println("> 3. Servicios Médicos");
    opcionesComunes();
  }

  /** Pantalla de gerencia con las opciones disponibles. */
  static void pantallaGerencia() {
    separarPantalla();
    System.out.println(">>> 1. GERENCIA");
    System.out.println("> 1. Gestión del personal");
    System.out.println("> 2. Gestión de pacientes");
    System.out.println("> 3. Gestión Contable");
    System.out.println("> 4. Gestión mantenimiento");
    opcionesComunes();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE PERSONAL
  ------------------------------------------------------------------------------------------------------------------ */

  /** Pantalla de gestión del personal con las opciones disponibles. */
  static void pantallaGestionPersonal() {
    separarPantalla();
    System.out.println(">>> 1.1. GESTIÓN DE PERSONAS");
    System.out.println("> 1. Alta");
    System.out.println("> 2. Baja");
    System.out.println("> 3. Gestión");
    opcionesComunes();
  }

  /** Pantalla de gestión de altas de personal con las opciones disponibles. */
  static void pantallaGestionPersonalAlta() {
    separarPantalla();
    System.out.println(">>> 1.1.1. GESTIÓN DE ALTAS DE PERSONAL");
    System.out.println("> 1. Alta de administrativos");
    System.out.println("> 2. Alta de personal de mantenimiento y servicio");
    System.out.println("> 3. Alta de estudiantes");
    System.out.println("> 4. Alta de enfermeros");
    System.out.println("> 5. Alta de médicos");
    opcionesComunes();
  }

  /** Pantalla de altas de administrativos. */
  static void pantallaAltaAdministrativo() {
    separarPantalla();
    System.out.println(">>> 1.1.1.1. ALTAS DE ADMINISTRATIVO");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código actividad");
    System.out.println("> 6. Seleccionar grupo administrativo");
    System.out.println("> 7. Mostrar datos");
    System.out.println("> 8. Finalizar Alta");
    opcionesComunes();
  }

  /** Pantalla de altas de personal de mantenimiento y servicio. */
  static void pantallaAltaMantenimientoServicio() {
    separarPantalla();
    System.out.println(">>> 1.1.1.2. ALTAS DE PERSONAL DE MANTENIMIENTO Y SERVICIO");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    System.out.println("> 7. Mostrar datos");
    System.out.println("> 8. Finalizar Alta");
    opcionesComunes();
  }

  /** Pantalla de altas de estudiantes. */
  static void pantallaAltaEstudiante() {
    separarPantalla();
    System.out.println(">>> 1.1.1.3. ALTAS DE ESTUDIANTE");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    System.out.println("> 7. Seleccionar código especialidad");
    System.out.println("> 8. Introducir experiencia");
    System.out.println("> 9. Introducir nombre de centro");
    System.out.println("> 10. Mostrar datos");
    System.out.println("> 11. Finalizar Alta");
    opcionesComunes();
  }

  /** Pantalla de altas de enfermeros. */
  static void pantallaAltaEnfermero() {
    separarPantalla();
    System.out.println(">>> 1.1.1.4. ALTAS DE ENFERMERO");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    System.out.println("> 7. Seleccionar código especialidad");
    System.out.println("> 8. Introducir experiencia");
    System.out.println("> 9. Mostrar datos");
    System.out.println("> 10. Finalizar Alta");
    opcionesComunes();
  }

  /** Pantalla de altas de médicos. */
  static void pantallaAltaMedico() {
    separarPantalla();
    System.out.println(">>> 1.1.1.5. ALTAS DE MÉDICO");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    System.out.println("> 7. Seleccionar código especialidad");
    System.out.println("> 8. Seleccionar código segunda especialidad");
    System.out.println("> 9. Introducir experiencia");
    System.out.println("> 10. Mostrar datos");
    System.out.println("> 11. Finalizar Alta");
    opcionesComunes();
  }

  /** Pantalla de gestión de bajas de personal con las opciones disponibles. */
  static void pantallaGestionBajaPersonas() {
    separarPantalla();
    System.out.println(">>> 1.1.2. GESTIÓN DE BAJAS DE PERSONAS");
    System.out.println("> 1. Baja por NIF");
    System.out.println();
    System.out.println("> 2. Consultar personas");
    opcionesComunes();
  }

  /** Pantalla de baja de personal administrativo. */
  static void pantallaBajaPersonas() {
    separarPantalla();
    System.out.println(">>> 1.1.2.1. BAJA DE PERSONAS");
    System.out.println("> Introduzca el NIF de la persona a dar de baja...");
    System.out.println();
  }

  /** Pantalla de gestión de personal administrativo. */
  static void pantallaGestionDatosPersonas() {
    separarPantalla();
    System.out.println(">>> 1.1.3. GESTIÓN DE PERSONAS");
    System.out.println("> 1. Crear Cita");
    System.out.println("> 2. Consultar agenda del personal sanitario");
    System.out.println("> 3. Modificar agenda del personal sanitario");
    System.out.println("> 4. Preparar formación de estudiantes");
    System.out.println();
    opcionesComunes();
  }

  /** Pantalla para la creación de citas. */
  static void pantallaCrearCita() {
    separarPantalla();
    System.out.println(">>> 1.1.3.1. CREAR CITA");
    System.out.println("> 1. Seleccionar Paciente");
    System.out.println("> 2. Seleccionar Sanitario");
    System.out.println("> 3. Introducir fecha");
    System.out.println("> 4. Seleccionar lugar de la cita");
    System.out.println("> 5. Crea cita");
    System.out.println("> 6. Consultar");
    opcionesComunes();
  }

  /** Pantalla para la preparación de la formación de estudiantes. */
  static void pantallaPrepararFormacionEstudiantes() {
    separarPantalla();
    System.out.println(">>> 1.1.4.1. PREPARAR FORMACIÓN DE ESTUDIANTES");
    System.out.println("> 1. Seleccionar Instructor");
    System.out.println("> 2. Seleccionar Estudiantes");
    System.out.println("> 3. Seleccionar lugar de la formación");
    System.out.println("> 4. Preparar formación");
    System.out.println("> 5. Consultar");
    opcionesComunes();
  }

  /** Pantalla para seleccionar unidad de formación. */
  static void pantallaSeleccionarUnidadFormacion() {
    separarPantalla();
    System.out.println(">> UNIDADES DE FORMACIÓN");
    System.out.println("> 1. Laboratorio");
    System.out.println("> 2. Clase");
  }

  /** Pantalla selección de cita */
  static void pantallaSeleccionarCita() {
    System.out.println("> Seleccione el número de cita a borrar...");
  }

  /** Pantalla de aviso selección de cita */
  static void pantallaAvisoSeleccionCita() {
    System.out.println("> Número de cita no válido...");
  }

  /** Pantalla de info instructor. */
  static void pantallaInfoInstructor() {
    System.out.println("> INFO: Un instructor solo puede ser un médico o un enfermero.");
  }

  /** Pantalla de aviso no creación de cita. */
  static void pantallaAvisoCitaNoCreada() {
    System.out.println("> AVISO: No se ha creado la cita...");
  }

  /** Pantalla de aviso sanitario ya asignado. */
  static void pantallaAvisoSanitarioYaAsignado() {
    System.out.println("> AVISO: El sanitario ya ha sido asignado previamente...");
  }

  /** Pantalla de aviso estudiante ya asignado. */
  static void pantallaAvisoEstudianteYaAsignado() {
    System.out.println("> AVISO: El estudiante ya ha sido asignado previamente...");
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE CONSULTA
  ------------------------------------------------------------------------------------------------------------------ */

  /** Pantalla común de selección de personas a consultar */
  static void pantallaConsultaCualquierPersona() {
    System.out.println(">> Consultar personal");
    System.out.println("> 1. Consultar personal administrativo");
    System.out.println("> 2. Consultar personal de mantenimiento y servicio");
    System.out.println("> 3. Consultar estudiantes");
    System.out.println("> 4. Consultar enfermeros");
    System.out.println("> 5. Consultar médicos");
    System.out.println("> 6. Consultar pacientes");
    System.out.println("> 7. Otros Criterios");
    opcionesComunes();
  }

  /** Pantalla común de consulta de personas */
  static void pantallaConsultaPersonas() {
    System.out.println(">> Criterios de consulta de personas");
    System.out.println("> 1. NIF");
    System.out.println("> 2. Nombre");
    System.out.println("> 3. Primer apellido");
    System.out.println("> 4. Segundo apellido");
    System.out.println("> 5. Código unidad");
    System.out.println("> 6. Código área");
    System.out.println("> 7. Código actividad");
    System.out.println("> 8. Código especialidad");
    System.out.println("> 9. Código segunda especialidad");
    System.out.println("> 10. Experiencia");
    System.out.println("> 11. Nombre centro");
    opcionesComunes();
  }

  /** Pantalla búsqueda de personas. */
  static void pantallaBuscarPersona() {
    separarPantalla();
    System.out.println(">>> PANTALLA DE SELECCIÓN");
    System.out.println("> 1. Seleccionar por NIF");
    System.out.println();
    System.out.println("> 2. Consultar personas");
    opcionesComunes();
  }

  /** Pantalla informativa de agenda vacía. */
  static void pantallaConsultaAgendaVacia() {
    System.out.println("> INFO: Este sanitario tiene la agenda vacía.");
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE PACIENTES
  ------------------------------------------------------------------------------------------------------------------ */

  /** Pantalla de gestión de pacientes con las opciones disponibles. */
  static void pantallaGestionPacientes() {
    separarPantalla();
    System.out.println(">>> 1.2. GESTIÓN DE PACIENTES");
    System.out.println("> 1. Alta de nuevo paciente");
    System.out.println("> 2. Baja de paciente");
    System.out.println("> 3. Crear cita");
    opcionesComunes();
  }

  /** Pantalla de altas de administrativos. */
  static void pantallaAltaPaciente() {
    separarPantalla();
    System.out.println(">>> 1.2.1. ALTA PACIENTE");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Introducir edad");
    System.out.println("> 6. Seleccionar sexo");
    System.out.println("> 7. Mostrar datos");
    System.out.println("> 8. Finalizar Alta");
    opcionesComunes();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE CONTABLE
  ------------------------------------------------------------------------------------------------------------------ */

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE MANTENIMIENTO
  ------------------------------------------------------------------------------------------------------------------ */

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS COMUNES
  ------------------------------------------------------------------------------------------------------------------ */

  /** Introduce salto de línea y elementos repetidos para separar las pantallas. */
  static void separarPantalla() {
    System.out.println(SEPARADOR);
  }

  /** Pantalla introducción de datos */
  static void pantallaIntroducirDato(String texto) {
    System.out.println("> Introduzca " + texto + "...");
  }

  /** Pantalla selección de código */
  static void pantallaSeleccionarCodigo(String texto) {
    System.out.println("> Seleccione " + texto + "...");
  }

  /** Pantalla aviso fin de programa */
  static void pantallaFin() {
    System.out.println("> AVISO: se va a finalizar el programa...");
  }

  /** Pantalla cierre de programa */
  static void pantallaCierre() {
    System.out.println("> ...programa cerrado");
  }

  /** Pantalla aviso de grabado de datos */
  static void pantallaAvisoGrabado() {
    System.out.println("> AVISO: se van a grabar los datos...");
  }

  /** Pantalla aviso de borrado de datos */
  static void pantallaAvisoBorrado() {
    System.out.println("> AVISO: se van a borrar los datos...");
  }

  /** Pantalla aviso persona no encontrada */
  static void pantallaAvisoPersonaNoEncontrada(String nif) {
    System.out.println("> AVISO: No se ha encontrado la persona con NIF " + nif);
  }

  /** Pantalla aviso de no disponibilidad de agenda */
  static void pantallaAvisoAgendaOcupada() {
    System.out.println("> AVISO: Ya existe una cita para esa fecha...");
  }

  /** Pantalla aviso sin resultados */
  static void pantallaConsultaSinResultados() {
    System.out.println("> AVISO: No se han encontrado resultados...");
  }

  /** Pantalla aviso de formato de fecha errónea */
  static void pantallaAvisoFormatoErroneo() {
    System.out.println("> AVISO: formato de fecha no válido...vuelva a intentarlo...");
  }

  /** Pantalla datos grabados */
  static void pantallaDatosGrabados() {
    System.out.println("> ÉXITO: ...se han grabado los datos");
  }

  /** Pantalla datos borrados */
  static void pantallaDatosBorrados() {
    System.out.println("> ÉXITO: ...se han borrado los datos");
  }

  /** Pantalla de confirmación */
  static void pantallaConfirmacion() {
    System.out.println("> Confirmar operación... Sí(S)  No(N)");
  }

  /** Muestra las opciones comunes en todas las pantallas. */
  private static void opcionesComunes() {
    System.out.println();
    System.out.println("> X. Volver");
    System.out.println("> Z. Finalizar programa");
  }
}
