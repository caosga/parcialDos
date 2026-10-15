package uniquindio.edu.co;
import javax.swing.JOptionPane;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 9) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese una opción\n" +
                            "1. Registrar películas\n" +
                            "2. Registrar clientes\n" +
                            "3. Registrar operarios\n" +
                            "4. Registrar Programar funciones\n" +
                            "5. Vender boletas\n" +
                            "6. Ver ocupación de las salas\n" +
                            "7. Revisar ingresos por función\n" +
                            "8. Calcular el valor total de una venta\n" +
                            "9. Salir\n"));
            switch (opcion) {

                case 1:
                    JOptionPane.showMessageDialog(null,
                            "Registrando Peliculas");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Registrando clientes");
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

