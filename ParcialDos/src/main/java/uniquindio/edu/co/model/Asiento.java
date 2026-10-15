package uniquindio.edu.co.model;

public class Asiento {
    private String codigoAsiento;
    private boolean ocuapado;
    private String fila;
    private int columna;


    /**
     * Metodo constructor de la clase Asiento
     * @param codigoAsiento
     * @param fila
     * @param ocuapado
     * @param columna
     */
    public Asiento(String codigoAsiento, String fila, boolean ocuapado, int columna) {
        this.codigoAsiento = codigoAsiento;
        this.fila = fila;
        this.ocuapado = ocuapado;
        this.columna = columna;
    }

    public String getCodigoAsiento() {
        return codigoAsiento;
    }

    public void setCodigoAsiento(String codigoAsiento) {
        this.codigoAsiento = codigoAsiento;
    }

    public boolean isOcuapado() {
        return ocuapado;
    }

    public void setOcuapado(boolean ocuapado) {
        this.ocuapado = ocuapado;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
