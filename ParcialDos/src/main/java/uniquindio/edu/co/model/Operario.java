package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Operario extends Persona {
    private String codigoEmpleado;
    private LocalDate fechaContratacion;
    private double salario;

    //relaciones de la clase Operario
    private List<Venta> listVentaOperario;

    /**
     * Metodo constructor de la clase Operario
     * @param documento
     * @param nombre
     * @param correo
     * @param codigoEmpleado
     * @param fechaContratacion
     * @param salario
     * @param listVentaOperario
     */
    public Operario(String documento, String nombre, String correo, String codigoEmpleado,
                    LocalDate fechaContratacion, double salario, List<Venta> listVentaOperario) {
        super(documento, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.listVentaOperario = new ArrayList<>();
    }

    //Metodo para que el operador registre ventas
    public Venta registrarVenta() {
        return null;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Venta> getListVentaOperario() {
        return listVentaOperario;
    }

    public void setListVentaOperario(List<Venta> listVentaOperario) {
        this.listVentaOperario = listVentaOperario;
    }
}
