package Clases.Producto;

import Interfaces.ProductoImp;

public abstract class Bebida implements ProductoImp {

    //Atributos
    private int identificador;
    private double litros;
    private double precioBase;
    public static final double IVA = 1.21;
    private String marca;

    //Método
    public Bebida(int identificador, double litros, double precioBase, String marca) {
        this.identificador = identificador;
        this.litros = litros;
        this.precioBase = precioBase;
        this.marca = marca;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getPrecioBase() {
        return Math.round (precioBase*100.0)/100.0;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public static double getIVA() {
        return IVA;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }




    public abstract double getPrecioTotal();
    @Override
    public String toString() {
        return "***************************************************************" +
                "\nIdentificador: " + identificador +
                "\nMarca: " + marca +
                "\nLitros: " + litros +
                "\nPrecio Base: " + this.getPrecioBase () + "€" ;
    }
}
