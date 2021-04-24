package Menu;

import Clases.Producto.Agua;
import Clases.Producto.Bebida;
import Clases.Producto.BebidaAzucarada;

import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner (System.in);
    public static final String MENSAJE_INICIAL = "Escribe:\n1 --> Agregar ProductoImp.\n2 --> Calcular Precio Almacén." +
            "\n3 --> Calcular Precio de una Marca en concreto.\n4 --> Calcular precio total de una estantería." +
            "\n5 --> Mostrar Inventario.\n6 --> Ampliar Almacén.";
    public static final String MENSAJE_PEDIR_DATO = "Escribe aquí ";


    /**
     * Método que pide el dato especificado por parámetro al usuario y los devuelve
     * Precondiciones: ninguna.
     * Postcondiciones: Se devolverá un String introducido por teclado por el usuario
     * @param quePedir: String que muestra que tipo de dato e le pide introducir al usuario
     * @return: String introducido por el usuario
     */
    public static String pedirDato(String quePedir) {
        System.out.print (MENSAJE_PEDIR_DATO + quePedir);
        return sc.nextLine ( );
    }

    /**
     * Método que valida que un String se puede convertir en un entero y lo devuelve
     * Precondiciones: ninguna
     * Postcondiciones: devuelve el valor númerico de el parámetro cadena
     *
     * @param cadena
     * @return: entero valor
     */
    public static int parseInt(String cadena) {
        int valor;
        try {
            valor = Integer.parseInt (cadena);
        } catch (IllegalArgumentException e) {
            valor = 0;
        }
        return valor;
    }

    public static double parseDouble(String cadena) {
        double valor;
        try {
            valor = Double.parseDouble (cadena);
        } catch (IllegalArgumentException e) {
            valor = 0;
        }
        return valor;
    }


    /**
     * Método que crea una bebida a partir de datos introducidos por el usuario.
     * Valida los datos introducidos, cra una bebida del tipo que el usuario especifique y después
     * la introduce en el Array de bebidas introducido como parámetro.
     * Precondiciones: bebidas debe ser un array construido.
     * Postcondiciones: Se devolverá la bebida que se acaba de crear.
     * @param bebidas array en el que se guardarán las bebidas.
     * @return bebida
     */
    public static Bebida crearBebida(Bebida[][] bebidas) {
        int identificador = parseInt (pedirDato ("el número identificador del producto"));
        double litros = parseDouble (pedirDato ("la cantidad de litros del producto"));
        double precioBase = parseDouble (pedirDato ("el precio base del producto"));
        String marca = pedirDato ("la marca del producto");
        Bebida bebida = null;
        boolean exit = false;
        do {
            String tipo = pedirDato ("\nAgua\nBebida azucarada").toLowerCase ( );
            if (tipo.equals ("agua")) {
                String nombreManantial = pedirDato ("el nombre del manantial del que procede el agua");
                bebida = new Agua (identificador, litros, precioBase, marca, nombreManantial);
                exit = true;
            } else if (tipo.equals ("bebida azucarada")) {
                double porcentajeAzucar = parseDouble (pedirDato ("el porcentaje de azucar del producto"));
                String decidir;
                do {
                    decidir = pedirDato ("\nsi --> El producto tiene promoción.\nno --> El producto no tiene promoción.").toLowerCase ( );
                } while (!(decidir.equals ("si") || decidir.equals ("no")));
                boolean tienePromocion = comprobarPromocion (decidir);
                bebida = new BebidaAzucarada (identificador, litros, precioBase, marca, porcentajeAzucar, tienePromocion);
                exit = true;
            }
        }while(!exit);
        boolean salir = false;
        for(int i = 0; i < bebidas.length && !salir; i++){
            for(int j = 0; j < bebidas[i].length && !salir; j++){
                if(bebidas[i][j] == null){
                    bebidas[i][j] = bebida;
                    salir = true;
                }
            }
        }
        return bebida;
    }

    /**
     * Método que comprueba que la inserción por parte del usuario de el string eleccion esté entre las dos opciones
     * posibles para un booleano(si o no).
     * Precondiciones: eleccion solo tiene dos opciones posibles -> si o no
     * Postcondiciones: Devolverá el booleano promocion = true si la repuesta es distinta de no
     * @param eleccion
     * @return promocion.
     */
    public static boolean comprobarPromocion(String eleccion) {
        boolean promocion = true;
        if (eleccion.equals ("no")) {
            promocion = false;
        }
        return promocion;
    }

}