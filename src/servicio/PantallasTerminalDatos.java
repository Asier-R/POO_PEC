package servicio;

import enumerado.CodigoActividadEnum;

/** Clase encargada de mostrar en pantalla la información ofrecida y solicitada a/por el usuario. */
public final class PantallasTerminalDatos {

  private static final String SEPARADOR = "----------------------";
  private static final String SEPARADOR_SIMPLE = "............................................";

  /** Constructor de la terminal de datos. */
  PantallasTerminalDatos() {
    System.out.println(">>>>>> INICIO DE TERMINAL DE DATOS <<<<<<");
  }

  /** Pantalla de inicio con las opciones disponibles. */
  static void pantallaInicio() {
    separarPantalla();
    System.out.println(">>> 0. INICIO");
    System.out.println("> 1. Gerencia y Administración");
    System.out.println("> 2. Servicios Médicos");
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
    System.out.println("> 5. Consultar empleados del sistema");
    opcionesComunes();
  }

  /** Pantalla de servicios médicos con las opciones disponibles. */
  static void pantallaServiciosMedicos() {
    separarPantalla();
    System.out.println(">>> 2. SERVICIOS MÉDICOS");
    System.out.println("> 1. Atender nuevos pacientes");
    System.out.println("> 2. Actualizar expedientes");
    System.out.println("> 3. Consultar ocupación");
    System.out.println("> 4. Consultar pacientes ingresados");
    System.out.println("> 5. Consultar pacientes con cita en consulta externa");
    System.out.println("> 6. Consultar pacientes con cita con un especialista");
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

  /** Pantalla de baja de consulta de empleados del sistema. */
  static void pantallaConsultarEmpleadosDelSistema() {
    separarPantalla();
    System.out.println(">>> 5. CONSULTAR EMPLEADOS DEL SISTEMA");
    System.out.println();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE SERVICIOS MÉDICOS
  ------------------------------------------------------------------------------------------------------------------ */

  /** Pantalla de atención de pacientes. */
  static void pantallaAtenderPacientes() {
    separarPantalla();
    System.out.println(">>> 2.1. ATENDER NUEVOS PACIENTES");
    System.out.println("> INFO: Se va a dar cita a los nuevos pacientes para atención primaria.");
    System.out.println();
  }

  /** Pantalla de aviso no se puede atender de pacientes. */
  static void pantallaAvisoSinMedicoPrimaria() {
    separarPantalla();
    System.out.println(
        "> AVISO: No se puede atender a los nuevos pacientes sin un médico presente en consulta primaria...");
    System.out.println();
  }

  /**
   * Pantalla de aviso no se puede atender de pacientes.
   *
   * @param descUnidad Descripción de la unidad.
   */
  static void pantallaAvisoSinSanitario(String descUnidad) {
    separarPantalla();
    System.out.println(
        "> AVISO: No se puede atender al paciente sin un sanitario asignado a la unidad "
            + descUnidad
            + "...");
    System.out.println();
  }

  /** Pantalla de aviso no hay camas libres en planta. */
  static void pantallaAvisoSinHabitaciones() {
    separarPantalla();
    System.out.println("> AVISO: No se puede ingresar al paciente, no hay camas libres...");
    System.out.println();
  }

  /** Pantalla de aviso no se puede atender de pacientes. */
  static void pantallaAvisoSinPacientesNuevos() {
    separarPantalla();
    System.out.println("> AVISO: No hay nuevos pacientes que atender...");
    System.out.println();
  }

  /** Pantalla de info cita pacientes nuevos. */
  static void pantallaInfoCitaPacientesNuevos() {
    System.out.println("> INFO: Se ha dado cita a los siguientes pacientes:");
    System.out.println();
  }

  /**
   * Pantalla de info cita pacientes nuevos.
   *
   * @param cod Código de actividad.
   */
  static void pantallaInfoPacientesPermaneceIngresado(CodigoActividadEnum cod) {
    System.out.println(
        "> INFO: El paciente se encuentra ingresado en "
            + cod
            + ", donde permanecerá hasta nuevo aviso.");
    System.out.println();
  }

  /** Pantalla de info actualizar expedientes. */
  static void pantallaInfoActualizarExpedientes() {
    separarPantalla();
    System.out.println(">>> 2.2. ACTUALIZAR EXPEDIENTES");
    System.out.println("> INFO: Actualizar los expedientes requiere avanzar la fecha de sistema.");
    System.out.println(
        ">       Avanzar la fecha mostrará el trabajo realizado por el servicio médico hasta la nueva fecha de sistema.");
    System.out.println(
        ">       Introduzca el número de días que desea avanzar...     (cero para permanecer en la fecha actual)");
    System.out.println();
  }

  /**
   * Pantalla de info actualizar expedientes avanzar días.
   *
   * @param numDias Número de días.
   */
  static void pantallaInfoActualizarExpedientesAvanzarDias(Long numDias) {
    System.out.println(
        "> INFO: ¿Avanzar la fecha de sistema a "
            + Utiles.getFechaSistemaAvanzadaNDias(numDias)
            + "?");
    System.out.println();
  }

  /** Pantalla de aviso no se ha podido citar a paciente. */
  static void pantallaAvisoNoSeHaPodidoCitarPaciente() {
    System.out.println("> AVISO: No se ha podido citar al paciente...");
    System.out.println();
  }

  /**
   * Pantalla de info número de pacientes tratados.
   *
   * @param num Número de pacientes.
   */
  static void pantallaInfoNumPacientesTratados(int num) {
    separarPantallaSimple();
    System.out.println("> INFO: Se han tratado " + num + " pacientes.");
    System.out.println();
  }

  /** Pantalla de consulta de ocupación. */
  static void pantallaConsultarOcupacion() {
    separarPantalla();
    System.out.println(">>> 2.3. CONSULTAR OCUPACIÓN");
    System.out.println();
  }

  /** Pantalla de consulta de pacientes ingresados. */
  static void pantallaConsultarIngresados() {
    separarPantalla();
    System.out.println(">>> 2.4. CONSULTAR INGRESADOS");
    System.out.println();
  }

  /** Pantalla de consulta de pacientes ingresados. */
  static void pantallaConsultarPacientesCitaConsultaExterna() {
    separarPantalla();
    System.out.println(">>> 2.5. CONSULTAR PACIENTES CON CITA PARA CONSULTA EXTERNA");
    System.out.println();
  }

  /** Pantalla de selección de rango de consulta. */
  static void pantallaConsultarPeriodo() {
    System.out.println("> Seleccione rango de consulta: ");
    System.out.println("> 1. Día específico");
    System.out.println("> 2. Semana (un día específico y los siguientes seís)");
    System.out.println("> 3. Entre fechas");
    opcionesComunes();
    System.out.println();
  }

  /** Pantalla de consulta de pacientes con cita con un especialista. */
  static void pantallaConsultarPacientesCitaConEspecialista() {
    separarPantalla();
    System.out.println(">>> 2.6. CONSULTAR PACIENTE CON CITA CON ESPECIALISTA");
    System.out.println("> 1. Seleccionar especialista por NIF");
    System.out.println("> 2. Seleccionar rango de consulta");
    System.out.println("> 3. Ejecutar consulta");
    System.out.println();
    System.out.println("> 4. Consultar personas");
    opcionesComunes();
    System.out.println();
  }

  /** Pantalla de info no hay pacientes ingresados. */
  static void pantallaNoHayIngresados() {
    System.out.println("> INFO: No hay ningún paciente ingresado en el hospital.");
    System.out.println();
  }

  /** Pantalla de info no hay pacientes con consulta externa. */
  static void pantallaNoHayPacientesConCitaConsultaExterna() {
    System.out.println("> INFO: No hay ningún paciente con cita para consulta externa.");
    System.out.println();
  }

  /** Pantalla de info el especialista no tiene pacientes para las fechas seleccionadas. */
  static void pantallaEspecialistaSinPacientesEnRangoFechas() {
    System.out.println(
        "> INFO: El especialista no tiene citas con pacientes en el periodo indicado.");
    System.out.println();
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE CONTABLE
  ------------------------------------------------------------------------------------------------------------------ */

  /** Pantalla de gestión de contable con las opciones disponibles. */
  static void pantallaGestionContable() {
    separarPantalla();
    System.out.println(">>> 1.3. GESTIÓN CONTABLE");
    System.out.println("> 1. Preparar y emitir facturas");
    opcionesComunes();
  }

  /** Pantalla de gestión de contable con las opciones disponibles. */
  static void pantallaInfoEmisionFactura() {
    System.out.println(">> Se emite factura para los siguientes pacientes dados de alta: ");
  }

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS DE GESTIÓN DE MANTENIMIENTO
  ------------------------------------------------------------------------------------------------------------------ */

  /* ------------------------------------------------------------------------------------------------------------------
     PANTALLAS COMUNES
  ------------------------------------------------------------------------------------------------------------------ */

  /**
   * Introduce salto de línea y elementos repetidos para separar las pantallas. Incluye fecha de
   * sistema.
   */
  static void separarPantalla() {
    System.out.println(SEPARADOR + "SysDate " + Utiles.getFechaHoraSistemaFormateada() + SEPARADOR);
  }

  /** Introduce salto de línea y elementos repetidos (simples) para separar las pantallas. */
  static void separarPantallaSimple() {
    System.out.println(SEPARADOR_SIMPLE);
  }

  /**
   * Pantalla introducción de datos.
   *
   * @param texto Texto introducido.
   */
  static void pantallaIntroducirDato(String texto) {
    System.out.println("> Introduzca " + texto + "...");
  }

  /**
   * Pantalla selección de código.
   *
   * @param texto Texto a mostrar.
   */
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

  /**
   * Pantalla aviso persona no encontrada.
   *
   * @param nif NIF de la persona.
   */
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
