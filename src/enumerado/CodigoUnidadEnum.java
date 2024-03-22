package enumerado;

import entidad.unidad.Unidad;

/**
 * Clase enum que define los códigos de unidad de las distintas unidades {@link Unidad}
 */
public enum CodigoUnidadEnum {
    SERVICIOS(1,"SERVICIOS"),
    MEDICINA(2, "MEDICINA"),
    FORMACION(3, "FORMACIÓN");

    /**
     * Id del enumerado.
     */
    private int id;

    /**
     * Texto descriptivo del enumerado.
     */
    private String descripcion;

    private CodigoUnidadEnum(int id, String descripcion){
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
     * @return descripción de la unidad.
     */
    public String getDescripcion(){
        return this.descripcion;
    }
}
