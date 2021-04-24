package Main;

import Clases.Producto.Bebida;
import Menu.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Almacen {

    private int idEstanteria = 0;
    private static final int MAX_INICIAL_HUECOS = 6;
    private static final int MAX_INICIAL_ESTANTERIAS = 5;


    public static void main(String[] args) {
        Bebida[][] bebidas = new Bebida[MAX_INICIAL_ESTANTERIAS][MAX_INICIAL_HUECOS];
        boolean salir = false;
        int eleccion;
        do {
            eleccion = Menu.parseInt (Menu.pedirDato (Menu.MENSAJE_INICIAL));
            switch (eleccion) {
                case 1 -> {
                    System.out.println (Menu.crearBebida ( bebidas) );
                }
                case 2 -> {
                    calcularPrecioAlmacen (bebidas);
                }
                case 3 -> {
                    String marca = Menu.pedirDato ("la marca que desea buscar");
                    calcularPrecioPorMarca (bebidas, marca);
                }
                case 4 -> {
                    int estanteria = Menu.parseInt (Menu.pedirDato ("el número de la estantería")) - 1;
                    calcularPrecioEstanteria (bebidas, estanteria);
                }
                case 5 -> {
                    mostrarAlmacen (bebidas);
                }
                case 6 -> {
                    System.out.println ("Good Bye!");
                    salir = true;
                }
            }

        } while (!salir);
    }

    public int getIdEstanteria() {
        return idEstanteria;
    }


    /**
     * Método que recorre un array completo y devuelve otro igual con un índice mayor.
     *
     * @return
     */
    private static Bebida[][] aumentarEspacio(Bebida[][] bebidas) {
        for (int i = 0; i < bebidas.length; i++) {
            if (bebidas[bebidas.length - 1] == null) {
                bebidas = Arrays.copyOf (bebidas, bebidas.length + 1);
            }
        }
        return bebidas;
    }


    private static double calcularPrecioAlmacen(Bebida[][] bebidas) {
        double precioAlmacen = 0;
        for (Bebida[] bebida1 : bebidas) {
            for (Bebida bebida : bebida1) {
                precioAlmacen += bebida.getPrecioTotal ( );
            }
        }
        return precioAlmacen;
    }

    private static double calcularPrecioEstanteria(Bebida[][] bebidas, int estanteria) {
        double precio = 0;
        for (int i = 0; i < bebidas[estanteria].length; i++) {
            precio += bebidas[estanteria][i].getPrecioTotal ( );
        }
        return precio;
    }


    /**
     * Método que cálcula el precio total de las existencias de una marca en concreto.
     * Precondiciones: Ninguna.
     * Postcondiciones: Devolvera el sumatorio de todos los precios de las Bebidas de la misma marca.
     *
     * @param marca: String introducido que se comparará con la marca de cada bebida almacenada.
     * @return precio: El sumatorio del precio final de todos los productos calculado
     */
    private static double calcularPrecioPorMarca(Bebida[][] bebidas, String marca) {
        double precio = 0;
        for (Bebida[] bebida1 : bebidas) {
            for (Bebida bebida : bebida1) {
                if (bebida.getMarca ( ).equals (marca)) {
                    precio += bebida.getPrecioTotal ( );
                }
            }
        }
        return precio;
    }


    private static boolean nuevaBebida(Bebida[][] bebidas, Bebida bebida) {
        boolean check = false;
        for (int i = 0; i < bebidas.length; i++) {
            for (int j = 0; j < i; j++) {
                if (bebidas[i][j] != null) {
                    if (bebidas[i][j].getIdentificador ( ) == bebida.getIdentificador ( )) {
                        check = true;
                    }
                } else if (bebidas[i][j] == null && !check) {
                    bebidas[i][j] = bebida;
                }
            }
        }
        return check;
    }


    private static boolean borrarBebida(Bebida[][] bebidas, Bebida bebida) {
        boolean check = false;
        for (int i = 0; i < bebidas.length && !check; i++) {
            for (int j = 0; j < i && !check; j++) {
                if (bebidas[i][j] != null) {
                    if (bebidas[i][j].getIdentificador ( ) == bebida.getIdentificador ( )) {
                        bebidas[i][j] = null;
                        check = true;
                    }
                }
            }
        }
        return check;
    }


    private static void mostrarAlmacen(Bebida[][] bebidas) {
        String estanteria = "Estantería número ";
        int contador = 1;
        for (Bebida[] bebida1 : bebidas) {
            System.out.println ("*********************************\n" + estanteria + contador +"\n*********************************" );
            contador ++;
            for (Bebida bebida : bebida1) {
                System.out.println (bebida);
            }
        }
    }
}
