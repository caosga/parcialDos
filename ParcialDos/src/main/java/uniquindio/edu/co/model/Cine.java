package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    //Metodo para agregar una Pelicula
        public String agregarPelicula(Pelicula agregaPeli){
         for(Pelicula p:listCinePelicula){
             if(p.getCodigoPel().equalsIgnoreCase(agregaPeli.getCodigoPel())){
                 return "Ya existe";}
         }
         this.listCinePelicula.add(agregaPeli);
            return "Agregada exitosamente.";
        }

     //Metodo para agregar un Cliente
        public String agregarCliente(Cliente nuevoCliente) {
            for (Persona p : listCinePersona) {
                if(p.getDocumento().equalsIgnoreCase(nuevoCliente.getDocumento())){
                    return "Este documento ya se encuentra registrado";
                }
            }
        this.listCinePersona.add(nuevoCliente);
        return "Cliente registrado exitosamente";
    }

    //Metodo para programar una funcion
        public String programaFuncion(Funcion nuevaFuncion){

            LocalDateTime horaFuncion=nuevaFuncion.getHora();
            LocalDate fechaFuncion=nuevaFuncion.getFecha();

            Sala salaNueva=nuevaFuncion.getTheSala();
            Pelicula peliculaNueva=nuevaFuncion.getThePelicula();
        //calcula la duracion de la pelicula
            int duracionPel=peliculaNueva.getDuracion();
            LocalDateTime finPeli=horaFuncion.plusMinutes(duracionPel);
        //verifica que la sala y pelicula existan
            if(salaNueva==null||peliculaNueva==null){
                return "No hay una sala o pelicula asociada a esta funcion";
            }

        for(Funcion f:listCineFuncion){
        //compara la sala y la fecha
            if(f.getTheSala().getCodigoSala().equalsIgnoreCase(salaNueva.getCodigoSala())
                    && f.getFecha().equals(fechaFuncion)){
                LocalDateTime horaActual=f.getHora();
                int duracionActual=f.getThePelicula().getDuracion();
                LocalDateTime finActual=horaActual.plusMinutes(duracionActual);
           //Compara las horas
                if(horaActual.isBefore(finActual)&&horaActual.isBefore(finPeli)){
                    return "La sala ocupada, no disponible.";
                }
            }
        }
        this.listCineFuncion.add(nuevaFuncion);
            return "Funcion programa exitosamente.";
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
