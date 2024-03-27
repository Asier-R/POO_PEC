import servicio.DiagnosticoTratamiento;

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
        int hora = ZonedDateTime.now().minusHours(12).getHour();

        System.out.println("UTC: "+ahora.toString());
        System.out.println("UTC+1: "+ahora2.toString());
        System.out.println("Hora: "+hora);

        DiagnosticoTratamiento.DiagnosticosTratamientos diag = DiagnosticoTratamiento.getDiagnostico();
        for(int i=0; i<=10; i++){
            System.out.println(i+"-Diagnostico: "+diag.getDiagnostico());
            System.out.println(i+"-Tratamiento: "+diag.getTratamiento());
            System.out.println(i+"-Origen: "+diag.getUnidadOrigen().getDescripcion());
            System.out.println(i+"-Destino: "+(diag.getUnidadDestino()==null?"n/a":diag.getUnidadDestino().getDescripcion()));
            System.out.println(i+"-Sanitario: "+diag.getSanitario()+"\n");
            diag = DiagnosticoTratamiento.getDiagnostico();
        }



        // TODO-ASIER: crear CSVs (desordenados) para los datos a insertar en el pre-inicio de la aplicación.
        // TODO-ASIER: implementar Hashmap<String, Integer> para dar pesos a los caracteres.
        // TODO-ASIER: revisar si es necesario implementar un comparator o con el hashmap solo es suficiente.
        // TODO-ASIER: los datos se insertan de forma ordenada en listas.

    }
}