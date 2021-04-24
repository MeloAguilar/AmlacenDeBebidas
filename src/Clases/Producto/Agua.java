package Clases.Producto;

/**
 * Clase de tipo Bebida que gestiona los objetos de tipo Agua y sus propiedades
 *
 * Métodos --> Método heredado getPrecioTotal() que nos muestra el precio del producto sumándole el IVA
 *              toString() que muestra las propiedades de la Bebida Agua.
 */
public class Agua extends Bebida {

    //Atributos
    private String nombreManantial;



    //Métodos
    public Agua(int identificador, double litros, double precioBase, String marca, String nombreManantial) {
        super (identificador, litros, precioBase, marca);
        this.nombreManantial = nombreManantial;
    }

    public String getNombreManantial() {
        return nombreManantial;
    }

    public void setNombreManantial(String nombreManantial) {
        this.nombreManantial = nombreManantial;
    }



    @Override
    public double getPrecioTotal() {
        return Math.round((getPrecioBase ()*IVA)*100.0)/100.0;
    }

    @Override
    public String toString() {
        return super.toString () +
                "\nPVP Final: " + this.getPrecioTotal () + "€" +
                "\nNombre del Manantial: " + nombreManantial;
    }
}
