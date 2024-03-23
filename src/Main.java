import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Hospital!");

        List<String> lista = new ArrayList<>(List.of("uno","dos"));
        lista.add(1,"X");
        lista.forEach(System.out::println);

        Instant ahora = Instant.now();
        ZonedDateTime ahora2 = ZonedDateTime.now();

        System.out.println("UTC: "+ahora.toString());
        System.out.println("UTC+1: "+ahora2.toString());

        // TODO-ASIER: crear CSVs (desordenados) para los datos a insertar en el pre-inicio de la aplicación.
        // TODO-ASIER: implementar Hashmap<String, Integer> para dar pesos a los caracteres.
        // TODO-ASIER: revisar si es necesario implementar un comparator o con el hashmap solo es suficiente.
        // TODO-ASIER: los datos se insertan de forma ordenada en listas.

    }
}