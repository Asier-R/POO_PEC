package servicio;

/**
 * Determina que la entidad que implementa la interfaz es un objeto cuyos datos pueden almacenarse en un fichero.
 */
public interface Grabable {

    /**
     * Genera una cadena de texto con los datos de la entidad en formato csv.
     * @return Cadena de texto.
     */
    String generarCadenaCSV();

}
