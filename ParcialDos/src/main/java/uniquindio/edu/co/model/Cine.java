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
                return "No hay una sala o pelicula asociada a esta funcion"; }

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


    //Metodo para procesar una venta
        public String procesarVenta(Operario operario, Venta nuevaVenta, Funcion funcion, List<String> codigosAsiento) {
            Sala estaSala = funcion.getTheSala();
            Cliente esteCliente=nuevaVenta.getTheCliente();
            List<Asiento> asientosAComprar = new ArrayList<>();
            TipoSala tipo=funcion.getTheSala().getTipo();
            double precioBase=funcion.getPrecioBase();

            double recargo=0;
            switch (tipo) {
                case TRADICIONAL:
                    recargo = 0;
                    break;
                case VIP:
                    recargo = 0.3;
                    break;
                case SALA_3D:
                    recargo = 0.4;
                default:

                    break;
            }
            double valorFinalPorAsiento = esteCliente.calcularDescuento(precioBase, recargo);

            //Busca el asiento comparando el codigo que ingresó el usuario
            for (String codigo : codigosAsiento) {
                for (Asiento a : estaSala.getListAsiento()) {
                    if (a.getCodigoAsiento().equalsIgnoreCase(codigo)) {
                        asientosAComprar.add(a);
                        break;
                    }
                }
            }
            //Valida si el asiento está ocupado
            for (Asiento a : asientosAComprar) {
                if (a.isOcupado()) {
                    return "El asiento " + a.getCodigoAsiento() + " ya está ocupado.";
                }
            }
            //Cambiar estado de asientos a ocupados
            for (Asiento a : asientosAComprar) {
                a.setOcupado(true);
            }
            //Asocia el operario y agrega la venta a la lista cineVenta
            nuevaVenta.setTheOperario(operario);
            operario.getListVentaOperario().add(nuevaVenta);
            this.listCineVenta.add(nuevaVenta);

            //creacion del boleto
            for (Asiento a : asientosAComprar) {
                Boleto unBoleto = new Boleto(
                        nuevaVenta.getCodigoVenta(),
                        funcion.getFecha().toString(),
                        funcion.getThePelicula().getTitulo(),
                        funcion.getTheSala().getCodigoSala(),
                        a.getCodigoAsiento(),
                        valorFinalPorAsiento
                );
            }

            return "Venta registrada con éxito.\nAtendido por: " + operario.getNombre();

        }

    //Metodo para calcular total de venta
        public double calcularTotalVenta(String codigoVenta) {
            Venta ventaEncontrada = null;

            //Busca la venta por su código en la lista de ventas del cine
            for (Venta v : listCineVenta) {
                if (v.getCodigoVenta().equalsIgnoreCase(codigoVenta)) {
                    ventaEncontrada = v;
                    break;
                }
            }

            //Sumar los valores individuales de las boletas adquiridas
            double totalVenta = 0.0;
            for (Boleto b : ventaEncontrada.getBoletoVenta()) {
                totalVenta += b.valorPagado();
            }
            return totalVenta;
        }


    //Metodo para calcular el porcentaje de ocupacion de una funcion
        public double calcularPorcentajeOcupacion(Funcion funcion) {
            Sala sala=funcion.getTheSala();
            double capacidadMax= sala.getCapacidad();

            // Cuenta cuantos asientos están ocupados en la sala de esta función
            int asientoOcupados=0;
            for (Asiento a: sala.getListAsiento()) {
                if (a.isOcupado()) {
                    asientoOcupados++;
                }
            }
            return (asientoOcupados / capacidadMax) * 100.0;
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
