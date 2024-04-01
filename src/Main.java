import entidad.Hospital;

import static servicio.LecturaEscrituraFichero.grabarPersona;
import static servicio.LecturaEscrituraFichero.iniciarHospital;

public class Main {

  public static void main(String[] args) {
    // Se genera javadoc con opciones: -encoding utf8 -docencoding utf8 -charset utf8
    System.out.println("Inicio de Hospital");
    final Hospital hospital = iniciarHospital();

    hospital
        .getPersonal()
        .forEach(personal -> System.out.println(">>> Personal\n" + personal.toString() + "\n"));

    hospital
            .getPacientes()
            .forEach(paciente -> System.out.println(">>> Paciente\n" + paciente.toString() + "\n"));




    //grabarPersona();

    // TODO: agregar ordenados Pacientes y Personal
    // TODO: implementar Hashmap<String, Integer> para dar pesos a los caracteres.
    // TODO: revisar si es necesario implementar un comparator o con el hashmap solo es suficiente.
    // TODO: los datos se insertan de forma ordenada en listas.

  }

}
