package uniquindio.edu.co.model;

import java.util.List;

public class Pelicula {
    private String codigoPel, titulo;
    private Genero genero;
    private Clasificacion clasif;
    private int duracion;

    //Relacion de la clase Pelicula
    private List<Funcion> listFuncionPelicula;

    /**
     * Metodo constructor para la clase Pelicula
     * @param codigoPel
     * @param titulo
     * @param genero
     * @param listFuncionPelicula
     * @param clasif
     */
    public Pelicula(String codigoPel, String titulo, Genero genero, List<Funcion> listFuncionPelicula, Clasificacion clasif) {
        this.codigoPel = codigoPel;
        this.titulo = titulo;
        this.genero = genero;
        this.listFuncionPelicula = listFuncionPelicula;
        this.clasif = clasif;
    }

    public String getCodigoPel() {
        return codigoPel;
    }

    public void setCodigoPel(String codigoPel) {
        this.codigoPel = codigoPel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Clasificacion getClasif() {
        return clasif;
    }

    public void setClasif(Clasificacion clasif) {
        this.clasif = clasif;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Funcion> getListFuncionPelicula() {
        return listFuncionPelicula;
    }

    public void setListFuncionPelicula(List<Funcion> listFuncionPelicula) {
        this.listFuncionPelicula = listFuncionPelicula;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
