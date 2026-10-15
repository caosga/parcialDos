package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

    public class Cine {
    private String nombreCine, nit, direccion;

    //Relaciones de la clase Cine
    private List<Sala>listCineSala;
    private List<Funcion>listCineFuncion;
    private List<Venta>listCineVenta;
    private List<Persona>listCinePersona;
    private List<Pelicula>listCinePelicula;

    /**
     * Metodo constructor para la clase Cine
     * @param nombreCine
     * @param nit
     * @param direccion
     * @param listCineSala
     * @param listCineFuncion
     * @param listCineVenta
     * @param listCinePersona
     */
    public Cine(String nombreCine, String nit, String direccion, List<Sala> listCineSala,
                List<Funcion> listCineFuncion, List<Venta> listCineVenta, List<Persona> listCinePersona) {
        this.nombreCine = nombreCine;
        this.nit = nit;
        this.direccion = direccion;
        this.listCineSala = new ArrayList<>();
        this.listCineFuncion = new ArrayList<>();
        this.listCineVenta = new ArrayList<>();
        this.listCinePersona = new ArrayList<>();
        this.listCinePelicula=new ArrayList<>();
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sala> getListCineSala() {
        return listCineSala;
    }

    public void setListCineSala(List<Sala> listCineSala) {
        this.listCineSala = listCineSala;
    }

    public List<Funcion> getListCineFuncion() {
        return listCineFuncion;
    }

    public void setListCineFuncion(List<Funcion> listCineFuncion) {
        this.listCineFuncion = listCineFuncion;
    }

    public List<Venta> getListCineVenta() {
        return listCineVenta;
    }

    public void setListCineVenta(List<Venta> listCineVenta) {
        this.listCineVenta = listCineVenta;
    }

    public List<Persona> getListCinePersona() {
        return listCinePersona;
    }

    public void setListCinePersona(List<Persona> listCinePersona) {
        this.listCinePersona = listCinePersona;
    }

    public List<Pelicula> getListCinePelicula() {
            return listCinePelicula;
        }

    public void setListCinePelicula(List<Pelicula> listCinePelicula) {
            this.listCinePelicula = listCinePelicula;
        }
    }
