package uniquindio.edu.co;
import javax.swing.JOptionPane;
import uniquindio.edu.co.model.Pelicula;
import uniquindio.edu.co.model.Cliente;
import uniquindio.edu.co.model.Genero;
import uniquindio.edu.co.model.Clasificacion;
import uniquindio.edu.co.model.Cine;
import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cine cine = new Cine(
                "CinePlus",
                "647756644",
                "Armenia, Quindío",
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );



        int opcion = 0;

        while (opcion != 9) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese una opción\n" +
                            "1. Registrar películas\n" +
                            "2. Registrar clientes\n" +
                            "3. Registrar operarios\n" +
                            "4. Programar funciones\n" +
                            "5. Vender boletas\n" +
                            "6. Ver ocupación de las salas\n" +
                            "7. Revisar ingresos por función\n" +
                            "8. Calcular el valor total de una venta\n" +
                            "9. Salir\n"));
            switch (opcion) {



                case 1:
                    String codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la película:");

                    String titulo = JOptionPane.showInputDialog(null, "Ingrese el título de la película:");

                    int duracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la duración en minutos:"));


                    String generoTexto = JOptionPane.showInputDialog(null,
                            "Ingrese el género de la película:\n" +
                                    "\n" +
                                    "1. ACCION\n" +
                                    "2. TERROR\n" +
                                    "3. ANIME");

                    Genero genero = Genero.ACCION;

                    if (generoTexto.equals("2")) {
                        genero = Genero.TERROR;
                    } else if (generoTexto.equals("3")) {
                        genero = Genero.ANIME;
                    }

                    String clasificacionTexto = JOptionPane.showInputDialog(null,
                            "Ingrese la clasificación:\n" +
                                    "\n" +
                                    "1. ADULTOS\n" +
                                    "2. ADOLESCENTES\n" +
                                    "3. NINIO");

                    Clasificacion clasif = Clasificacion.ADULTOS;

                    if (clasificacionTexto.equals("2")) {
                        clasif = Clasificacion.ADOLESCENTES;
                    } else if (clasificacionTexto.equals("3")) {
                        clasif = Clasificacion.NINIO;
                    }

                    Pelicula pelicula = new Pelicula(
                            codigo, titulo, genero, new ArrayList<>(), clasif);

                    pelicula.setDuracion(duracion);

                    String respuesta = cine.agregarPelicula(pelicula);

                    JOptionPane.showMessageDialog(null, respuesta);

                    break;



                case 2:

                    String documento = JOptionPane.showInputDialog(null, "Ingrese el documento del cliente:");

                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del cliente:");

                    String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electronico del cliente:");

                    String codigoAfiliacion = JOptionPane.showInputDialog(null, "Ingrese el codigo de afiliacion:");

                    double compra = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de las compras del cliente:"));

                    Cliente nuevoCliente = new Cliente(
                            documento, nombre, correo, codigoAfiliacion, compra);

                    String resultado = cine.agregarCliente(nuevoCliente);

                    JOptionPane.showMessageDialog(null, resultado);

                    break;


                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Registrando operarios");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Programando funciones");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Vendiendo boletas");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,
                            "Viendo ocupación de las salas");
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null,
                            "Revisando ingresos por función");
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null,
                            "Calculando el valor total de una venta");
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null,
                            "Finalizando programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción incorrecta. Intente con otro número válido");
                    break;
            }
        }
    }
}

