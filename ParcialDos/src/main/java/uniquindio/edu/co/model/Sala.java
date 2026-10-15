package uniquindio.edu.co.model;
import java.util.List;

public class Sala {
    private String codigoSala, nombre;
    private int capacidad;
    private TipoSala tipo;

    //Relaciones de la clase Sala
    private List<Funcion>listFuncionSala;
    private List <Asiento>listAsiento;

    /**
     * Metodo constrictor de la clase Sala
     * @param codigoSala
     * @param nombre
     * @param capacidad
     * @param tipo
     * @param listFuncionSala
     * @param listAsiento
     */
    public Sala(String codigoSala, String nombre, int capacidad, TipoSala tipo, List<Funcion> listFuncionSala,
                List<Asiento> listAsiento) {
        this.codigoSala = codigoSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.listFuncionSala = listFuncionSala;
        this.listAsiento = listAsiento;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Funcion> getListFuncionSala() {
        return listFuncionSala;
    }

    public void setListFuncionSala(List<Funcion> listFuncionSala) {
        this.listFuncionSala = listFuncionSala;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public List<Asiento> getListAsiento() {
        return listAsiento;
    }

    public void setListAsiento(List<Asiento> listAsiento) {
        this.listAsiento = listAsiento;
    }
}
