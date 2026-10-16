package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Funcion {
    private String codigoFunc;
    private LocalDate fecha;
    private LocalDateTime hora;
    private double precioBase;

    //Relaciones de la Clase Funcion
    private Pelicula thePelicula;
    private Sala theSala;
    private List<Venta> listVentaFuncion;

    /**
     * Metodo Constructor para la clase Funcion
     * @param codigoFunc
     * @param fecha
     * @param hora
     * @param thePelicula
     * @param listVentaFuncion
     * @param theSala
     */
    public Funcion(String codigoFunc, LocalDate fecha, LocalDateTime hora, Pelicula thePelicula, List<Venta> listVentaFuncion, Sala theSala) {
        this.codigoFunc = codigoFunc;
        this.fecha = fecha;
        this.hora = hora;
        this.thePelicula = thePelicula;
        this.listVentaFuncion = listVentaFuncion;
        this.theSala = theSala;
        this.precioBase=precioBase;
    }

    public String getCodigoFunc() {
        return codigoFunc;
    }

    public void setCodigoFunc(String codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Pelicula getThePelicula() {
        return thePelicula;
    }

    public void setThePelicula(Pelicula thePelicula) {
        this.thePelicula = thePelicula;
    }

    public Sala getTheSala() {
        return theSala;
    }

    public void setTheSala(Sala theSala) {
        this.theSala = theSala;
    }

    public List<Venta> getListVentaFuncion() {
        return listVentaFuncion;
    }

    public void setListVentaFuncion(List<Venta> listVentaFuncion) {
        this.listVentaFuncion = listVentaFuncion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}
