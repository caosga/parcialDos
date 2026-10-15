package uniquindio.edu.co.model;

import java.time.LocalDate;

public class Venta {
    private String CodigoVenta;
    private LocalDate fecha;

    //relaciones de la clase Venta
    private Funcion theFuncion;
    private Cliente theCliente;
    private Operario theOperario;
    private Boleto boletoVenta;

    /**
     * Metodo constructor de la clase Venta
     * @param codigoVenta
     * @param theCliente
     * @param fecha
     * @param theFuncion
     * @param theOperario
     * @param boletoVenta
     */
    public Venta(String codigoVenta, Cliente theCliente, LocalDate fecha, Funcion theFuncion, Operario theOperario, Boleto boletoVenta) {
        CodigoVenta = codigoVenta;
        this.theCliente = theCliente;
        this.fecha = fecha;
        this.theFuncion = theFuncion;
        this.theOperario = theOperario;
        this.boletoVenta = boletoVenta;
    }

    public String getCodigoVenta() {
        return CodigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        CodigoVenta = codigoVenta;
    }

    public Funcion getTheFuncion() {
        return theFuncion;
    }

    public void setTheFuncion(Funcion theFuncion) {
        this.theFuncion = theFuncion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getTheCliente() {
        return theCliente;
    }

    public void setTheCliente(Cliente theCliente) {
        this.theCliente = theCliente;
    }

    public Operario getTheOperario() {
        return theOperario;
    }

    public void setTheOperario(Operario theOperario) {
        this.theOperario = theOperario;
    }

    public Boleto getBoletoVenta() {
        return boletoVenta;
    }

    public void setBoletoVenta(Boleto boletoVenta) {
        this.boletoVenta = boletoVenta;
    }
}
