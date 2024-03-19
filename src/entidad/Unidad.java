package entidad;

import enumerado.CodigoAreaEnum;

/**
 * Clase abstracta para representar todas las unidades de un hospital.
 */
public abstract class Unidad {

    /**
     * Código único que identifica el área a la que pertenece la unidad. {@link CodigoAreaEnum}
     */
    private CodigoAreaEnum codigoArea;

    /**
     * Nombre completo que recibe la unidad.
     */
    private String nombre;

    public Unidad(CodigoAreaEnum codigoArea, String nombre){
        this.nombre = nombre;
        this.codigoArea = codigoArea;
    }

    public String toString(){
        return codigoArea + " - " +nombre;
    }
}
