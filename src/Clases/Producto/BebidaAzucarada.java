package Clases.Producto;

/**
 * Clase de tipo Bebida que se encarga de gestionar estos objetos
 * Atributos --> Atributos de la clase Bebida
 *               porcentajeAzucar: double que muestra el porcentaje de azucar de la Bebida Azucarada
 *               tienePromocion: booleano que muestra si la Bebida Azucarada tiene promoción
 *               PROMOCION: atributo final y estático que será el descuento por promoción
 *
 * Atributos Derivados --> PrecioFinal: Atributo que se calcula multiplicando el precio base por el
 *                              atributo IVA y, si tienePromocion = true, (PROMOCION*precioBase) se restará del precio final
 *
 * Métodos --> Getters n' Setters de los atributos.
 *              getPrecioTotal: Método abstracto hereddo de Bebida que calcula el precio Final del producto.
 *              MostrarTienePromocion: Método privado que convierte false o true en una cadena para que el
 *                  usuario lo pueda entender al mostrarse por pantalla.
 *              toString: Método que devuelve el valor de los atributos de la BebidaAzucarada.
 */
public class BebidaAzucarada extends Bebida {

    //Atributyos
    private double porcentajeAzucar;
    private boolean tienePromocion;
    public static final double PROMOCION = 0.10;


    //Métodos
    public BebidaAzucarada(int identificador, double litros, double precioBase, String marca, double porcentajeAzucar
            , boolean tienePromocion) {
        super (identificador, litros, precioBase, marca);
        this.porcentajeAzucar = porcentajeAzucar;
        this.tienePromocion = tienePromocion;
        if (tienePromocion)
            this.setPrecioBase (getPrecioBase ( ) + (getPrecioBase ( ) * PROMOCION));
    }

    public double getPorcentajeAzucar() {
        return porcentajeAzucar;
    }

    public void setPorcentajeAzucar(double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }

    public boolean isTienePromocion() {
        return tienePromocion;
    }

    public void setTienePromocion(boolean tienePromocion) {
        this.tienePromocion = tienePromocion;
    }

    private String MostrartienePromocion() {
        String cadenaSalida = "";
        if (this.tienePromocion) {
            cadenaSalida = "Está en Promoción";
        } else {
            cadenaSalida = "No está en Promoción";
        }
        return cadenaSalida;
    }

    @Override
    public double getPrecioTotal() {
        double precio;
        if (this.isTienePromocion ( )) {
            precio = (getPrecioBase ( ) * IVA) - (getPrecioBase ( ) * PROMOCION);
        }else
            precio = (getPrecioBase ( ) * IVA);

        return Math.round(precio*100.0)/100.0;
    }

    @Override
    public String toString() {
        return super.toString ( ) +
                "\nPVP Final: " + this.getPrecioTotal () + "€" +
                "\nPorcentaje de Azucar: " + porcentajeAzucar + "%" +
                "\n" + MostrartienePromocion ( ) +
                "\n***************************************************************";
    }
}
