 

import entidad.Hospital;
import enumerado.CodigoUnidadEnum;
import servicio.terminalDatos.LogicaTerminalDatos;

import static servicio.LecturaEscrituraFichero.iniciarHospital;

public class Main {

  public static void main(String[] args) {
    // Se genera javadoc con opciones: -encoding utf8 -docencoding utf8 -charset utf8
    System.out.println("Inicio de Hospital");

    CodigoUnidadEnum.mostrarPorPantalla();

    final Hospital hospital = iniciarHospital();

    final LogicaTerminalDatos programa = new LogicaTerminalDatos();

    // TODO: instanciar la consola con la que interactua el usuario
    // TODO: añadir las pantallas de las funcionalidades
    // TODO: crear lógica de navegación entre pantallas

    System.out.println();
//    hospital
//        .getPersonal()
//        .forEach(personal -> System.out.println(">>> Personal\n" + personal.toString() + "\n"));
//
//    hospital
//        .getPacientes()
//        .forEach(paciente -> System.out.println(">>> Paciente\n" + paciente.toString() + "\n"));

//    final Estudiante estudiante =
//        new Estudiante(
//            "NIF",
//            "NOMBRE",
//            "APELLIDO1",
//            "APELLIDO2",
//            CodigoAreaEnum.CLASE,
//            CodigoActividadEnum.CLASE,
//            CodigoEspecialidadEnum.TRAUMATOLOGIA,
//            0,
//            "UNIVERSIDAD");
//    grabarPersona(estudiante);


  }
}
