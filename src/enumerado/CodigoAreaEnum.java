package enumerado;

/**
 * Clase enum que define los códigos de las áreas a las que pertenecen las unidades {@link entidad.Unidad}
 */
public enum CodigoAreaEnum {
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
     * @return descripcion.
     */
    public String getDescripcion(){
        return this.descripcion;
    }
}
