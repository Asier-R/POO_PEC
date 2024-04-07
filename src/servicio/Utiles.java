package servicio;

import entidad.persona.Administrativo;
import enumerado.CodigoActividadEnum;
import enumerado.CodigoAreaEnum;
import enumerado.CodigoEspecialidadEnum;
import enumerado.CodigoUnidadEnum;

import java.util.Scanner;

public final class Utiles {

    static final String STR_NIF = "NIF";
    static final String STR_NOMBRE = "Nombre";
    static final String STR_APELLIDO1 = "Primer apellido";
    static final String STR_APELLIDO2 = "Segundo apellido";
    static final String STR_COD_UNIDAD = "Código unidad";
    static final String STR_COD_AREA = "Código área";
    static final String STR_COD_ACTIVIDAD = "Código actividad";
    static final String STR_COD_ESPECIALIDAD = "Especialidad";
    static final String STR_COD_SEGUNDAESPECIALIDAD = "Segunda especialidad";
    static final String STR_COD_GRUPO = "Grupo administrativo";
    static final String STR_EXPERIENCIA = "Experiencia";
    static final String STR_CENTRO = "Nombre del centro";
    static final String SI = "S";

    /** Lector de input de usuario. */
    private static Scanner reader;

    /**
     * Constructor privado de Utiles.
     */
    private Utiles(){
        // Constructor privado
    }

    static void abrirLectorDeEntradas(){
        reader = new Scanner(System.in);
    }

    static void cerrarLectorDeEntradas(){
        reader.close();
    }

    /**
     * Método común para leer input de usuario.
     *
     * @return Cadena de texto del input de usuario.
     */
    static String leerLinea() {
        return reader.nextLine();
    }

    /**
     * Método común para leer input de usuario.
     *
     * @return Cadena de texto del input de usuario.
     */
    static int leerNumero() {
        int num = -1;
        try {
            num = reader.nextInt();
        } catch (Exception e) {
            System.out.println("> Opción no válida...");
        }
        return num;
    }

    /** Método para obtener el NIF de la persona. */
    static String inputNIF() {
        PantallasTerminalDatos.pantallaIntroducirDato(STR_NIF);
        return leerLinea().toUpperCase();
    }

    /** Método para obtener el nombre de la persona. */
    static String inputNombre() {
        PantallasTerminalDatos.pantallaIntroducirDato(STR_NOMBRE);
        return leerLinea();
    }

    /** Método para obtener el primer apellido de la persona. */
    static String inputApellido1() {
        PantallasTerminalDatos.pantallaIntroducirDato(STR_APELLIDO1);
        return leerLinea();
    }

    /** Método para obtener el segundo apellido de la persona. */
    static String inputApellido2() {
        PantallasTerminalDatos.pantallaIntroducirDato(STR_APELLIDO2);
        return leerLinea();
    }

    /** Método para obtener el nombre del centro. */
    static String inputNombreCentro() {
        PantallasTerminalDatos.pantallaIntroducirDato(STR_CENTRO);
        return leerLinea();
    }

    /** Método para obtener la experiencia del sanitario. */
    static int inputExperiencia() {
        PantallasTerminalDatos.pantallaIntroducirDato(STR_EXPERIENCIA);
        return leerNumero();
    }

    /** Método para obtener el código de unidad. */
    static CodigoUnidadEnum inputCodUnidad() {
        PantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_UNIDAD);
        CodigoUnidadEnum.mostrarPorPantalla();
        int opt = leerNumero();
        return CodigoUnidadEnum.getFromId(opt);
    }

    /** Método para obtener el código de área. */
    static CodigoAreaEnum inputCodArea() {
        PantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_AREA);
        CodigoAreaEnum.mostrarPorPantalla();
        int opt = leerNumero();
        return CodigoAreaEnum.getFromId(opt);
    }

    /** Método para obtener el código de área. */
    static CodigoActividadEnum inputCodActividad() {
        PantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_AREA);
        CodigoActividadEnum.mostrarPorPantalla();
        int opt = leerNumero();
        return CodigoActividadEnum.getFromId(opt);
    }

    /** Método para obtener el código de especialidad. */
    static CodigoEspecialidadEnum inputCodEspecialidad() {
        PantallasTerminalDatos.pantallaSeleccionarCodigo(STR_COD_ESPECIALIDAD);
        CodigoEspecialidadEnum.mostrarPorPantalla();
        int opt = leerNumero();
        return CodigoEspecialidadEnum.getFromId(opt);
    }

    /** Método para obtener el grupo administrativo. */
    static Administrativo.Grupo inputGrupoAdmin() {
        PantallasTerminalDatos.pantallaIntroducirDato(STR_COD_GRUPO);
        Administrativo.Grupo.mostrarPorPantalla();
        int opt = leerNumero();
        return Administrativo.Grupo.getFromId(opt);
    }

}
