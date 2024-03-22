package enumerado;

import entidad.unidad.Unidad;

/**
 * Clase enum que define los códigos de área de las distintas unidades {@link Unidad}
 */
public enum CodigoAreaEnum {
    ADMINISTRACION(1, "ADMINISTRACION"),
    ALIMENTACION(2, "ALIMENTACION"),
    GARAJE(3, "GARAJE"),
    HABITACION(4, "HABITACION"),
    QUIROFANO(5, "QUIROFANO"),
    CONSULTA(6, "CONSULTA"),
    CLASE(7, "CLASE"),
    LABORATORIO(8, "LABORATORIO");

    /**
     * Id del enumerado.
     */
    private int id;

    /**
     * Texto descriptivo del enumerado.
     */
    private String descripcion;

    private CodigoAreaEnum(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el id del enumerado.
     * @return id
     */
    public int getId(){
        return this.id;
    }

    /**
     * Devuelve el texto descriptivo del enumerado.
     * @return descripción del área.
     */
    public String getDescripcion(){
        return this.descripcion;
    }
}
