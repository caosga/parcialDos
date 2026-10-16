package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private String codigoAfiliacion;
    private double compra;

    //relaciones de la clase Cliente
    private List<Venta> listVentaCliente;

    /**
     * Metodo constructor para la clase Persona
     * @param documento
     * @param nombre
     * @param correo
     * @param codigoAfiliacion
     * @param compra
     */
    public Cliente(String documento, String nombre, String correo, String codigoAfiliacion, double compra) {
        super(documento, nombre, correo);
        this.codigoAfiliacion = codigoAfiliacion;
        this.compra = compra;
        this.listVentaCliente=new ArrayList<>();
    }

    //metodo para calcular porcentaje de descuento del cliente
    public double calcularDescuento() {
        if (this.compra> 50000) {
            return 0.2; // 20%
        } else if (this.compra > 20000) {
            return 0.1; // 10%
        }
        return 0;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public double getCompra() {
        return compra;
    }

    public void setCompra(double compra) {
        this.compra = compra;
    }
}
