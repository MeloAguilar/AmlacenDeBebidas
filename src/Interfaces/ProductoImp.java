package Interfaces;

import static Clases.Producto.Bebida.IVA;

public interface ProductoImp {

    //Método que establece el precio total de un producto
    //sumándole el IVA correspondiente y haciendo lo
    //pertinente en cada descendiente de ProductoImp.
    double getPrecioTotal();

    //Método toString.
    String toString();


}
