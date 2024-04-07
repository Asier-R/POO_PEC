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
    System.out.println(">>> 1.1. GESTIÓN DEL PERSONAL");
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
  static void pantallaAltaMantServ() {
    separarPantalla();
    System.out.println(">>> 1.1.1.2. ALTAS DE PERSONAL DE MANTENIMIENTO Y SERVICIO");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    opcionesComunes();
  }

  /** Pantalla de altas de estudiantes. */
  static void pantallaAltaEstudiantes() {
    separarPantalla();
    System.out.println(">>> 1.1.1.2. ALTAS DE ESTUDIANTE");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    System.out.println("> 7. Seleccionar código especialidad");
    opcionesComunes();
  }

  /** Pantalla de altas de enfermeros. */
  static void pantallaAltaEnfermero() {
    separarPantalla();
    System.out.println(">>> 1.1.1.2. ALTAS DE ENFERMERO");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    System.out.println("> 7. Seleccionar código especialidad");
    System.out.println("> 8. Introducir experiencia");
    opcionesComunes();
  }

  /** Pantalla de altas de médicos. */
  static void pantallaAltaMedicos() {
    separarPantalla();
    System.out.println(">>> 1.1.1.2. ALTAS DE MÉDICO");
    System.out.println("> 1. Introducir NIF");
    System.out.println("> 2. Introducir nombre");
    System.out.println("> 3. Introducir primer apellido");
    System.out.println("> 4. Introducir segundo apellido");
    System.out.println("> 5. Seleccionar código área");
    System.out.println("> 6. Seleccionar código actividad");
    System.out.println("> 7. Seleccionar código especialidad");
    System.out.println("> 8. Seleccionar código segunda especialidad");
    System.out.println("> 9. Introducir experiencia");
    opcionesComunes();
  }

  /** Pantalla común de selección de personal a consultar */
  static void pantallaConsultaSeleccionPersonal() {
    System.out.println(">> Consultar personal");
    System.out.println("> 2. Consultar personal administrativos");
    System.out.println("> 3. Consultar personal de mantenimiento y servicio");
    System.out.println("> 4. Consultar estudiantes");
    System.out.println("> 2. Consultar enfermeros");
    System.out.println("> 5. Consultar médicos");
  }

  /** Pantalla de gestión de bajas de personal con las opciones disponibles. */
  static void pantallaGestionPersonalBaja() {
    separarPantalla();
    System.out.println(">>> 1.1.2. GESTIÓN DE BAJAS DE PERSONAL");
    System.out.println("> 1. Baja por NIF");
    System.out.println();
    pantallaConsultaSeleccionPersonal();
    opcionesComunes();
  }

  /** Pantalla de baja de personal administrativo. */
  static void pantallaBajaPersonal() {
    separarPantalla();
    System.out.println(">>> 1.1.2.1. BAJA DE PERSONAL");
    System.out.println("> Introduzca el NIF del empleado o estudiante a dar de baja...");
    System.out.println();
    System.out.println();
    opcionesComunes();
  }

  /** Pantalla de baja de personal administrativo. */
  static void pantallaGestionDatosPersonal() {
    separarPantalla();
    System.out.println(">>> 1.1.3. GESTIÓN DE DATOS DEL PERSONAL");
    System.out.println("> 1. Selección por NIF");
    System.out.println();
    pantallaConsultaSeleccionPersonal();
    opcionesComunes();
  }

  /** Pantalla de baja de personal administrativo. */
  static void pantallaSeleccionarPersonal2() {
    separarPantalla();
    System.out.println(">>> 1.1.3.1. GESTIÓN DE PERSONAL");
    System.out.println("> Introduzca el NIF del empleado o estudiante a gestionar...");
    System.out.println();
    System.out.println();
    opcionesComunes();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE PACIENTES
  ------------------------------------------------------------------------------------------------------------------ */

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

  /** Pantalla aviso de grabado de datos */
  static void pantallaAvisoGrabado() {
    System.out.println("> AVISO: se van a grabar los datos...");
  }

  /** Pantalla datos grabados */
  static void pantallaDatosGrabados() {
    System.out.println("> ÉXITO: ...se han grabado los datos");
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
