import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("\n Hola, Soy tu convetirdor de moneda, que vas a convertir hoy");
            System.out.println("1. Convertir Moneda");
            System.out.println("2. Salir");
            System.out.println("Lista de monedas https://www.wikilengua.org/index.php/Lista_de_monedas");
            String opcionPrincipal = entrada.nextLine();
            int opcion;
            try{
                opcion = Integer.parseInt(opcionPrincipal);
            }catch (NumberFormatException e){
                System.out.println("Opcion invalida, vuelva a intentar Por Favor =)...");
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Vamos a convetir, Ejemplo EUR a USD" +
                            "\nDE:");
                    Scanner entradaDe = new Scanner(System.in);
                    String monedaDe =entradaDe.nextLine();
                    System.out.println("A:");
                    Scanner entradaA = new Scanner(System.in);
                    String monedaA = entradaA.nextLine();
                    System.out.println("Ingrese el monto a Convetir: ");
                    Scanner entradaCuanto = new Scanner(System.in);
                    String cuanto = entradaCuanto.nextLine();
                    ConvertidorMoneda consulta = new ConvertidorMoneda();
                    Conversor conversor = consulta.conversorMoneda(monedaDe,monedaA,cuanto);
                    System.out.println(conversor);

                    GeneradorDeArchivo generador = new GeneradorDeArchivo();
                    generador.guardarJson(conversor);
                    break;
                    case 2:
                        System.out.println("¡Hasta Luego Amigo!");
                        System.exit(0);
                        break;
                        default:
                            System.out.println("Opción desconocida, vuelva a intentar Por Favor =)");
                            break;
            }
        }
    }
}
