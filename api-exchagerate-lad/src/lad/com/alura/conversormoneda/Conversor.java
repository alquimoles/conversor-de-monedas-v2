package lad.com.alura.conversormoneda;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {

    public static void exibirMenu() {
        System.out.println("""
				*******************************************************
				Sea bienvenido/a al Conversor de Moneda =]
				
				1) Dólar =>> Peso argentino
				2) Peso argentino =>> Dólar
				3) Dólar =>> Real brasileño
				4) Real brasileño =>> Dólar
				5) Dólar =>> Peso colombiano
				6) Peso colombiano =>> Dólar		
				7) Salir
				Elija una opción válida:
				*******************************************************
				""");
    }
    public static void eleccionUserMenu() throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String origen;
        String destino;
        String url;
        double tasa = 0.0;

        while(opcion != 7) {
            exibirMenu();
            opcion = teclado.nextInt();
            switch(opcion) {
                case 1:
                    origen = "USD";
                    destino = "ARS";
                    url = preparaUrlparaBusqueda(origen, destino);
                    tasa = ConversorApp.obtenerTasa(url);
                    conversaoFinal(teclado, tasa, origen, destino);
                    break;
                case 2:
                    origen = "ARS";
                    destino = "USD";
                    url = preparaUrlparaBusqueda(origen, destino);
                    tasa = ConversorApp.obtenerTasa(url);
                    conversaoFinal(teclado, tasa, origen, destino);
                    break;
                case 3:
                    origen = "USD";
                    destino = "BRL";
                    url = preparaUrlparaBusqueda(origen, destino);
                    tasa = ConversorApp.obtenerTasa(url);
                    conversaoFinal(teclado, tasa, origen, destino);
                    break;
                case 4:
                    origen = "BRL";
                    destino = "USD";
                    url = preparaUrlparaBusqueda(origen, destino);
                    tasa = ConversorApp.obtenerTasa(url);
                    conversaoFinal(teclado, tasa, origen, destino);
                    break;
                case 5:
                    origen = "USD";
                    destino = "COP";
                    url = preparaUrlparaBusqueda(origen, destino);
                    tasa = ConversorApp.obtenerTasa(url);
                    conversaoFinal(teclado, tasa, origen, destino);
                    break;
                case 6:
                    origen = "COP";
                    destino = "USD";
                    url = preparaUrlparaBusqueda(origen, destino);
                    tasa = ConversorApp.obtenerTasa(url);
                    conversaoFinal(teclado, tasa, origen, destino);
                    break;
                case 7:
                    System.out.println("Qué pena! Saliendo del programa...");
                    break;
                default:
                    System.out.println("El número " + opcion + " no es válido. Ingrese una opção válida! =]");
            }
        }

    }
    public static String preparaUrlparaBusqueda(String origen, String destino) {
        String urlBase = "https://v6.exchangerate-api.com/v6/febfbc2f3940eaca892fca4e/pair/";
        return urlBase + origen + "/" + destino;
    }
    private static void conversaoFinal(Scanner teclado, double tasa, String origen, String destino) {
        System.out.println("Ingrese el valor que deseas converter: ");
        double input = teclado.nextDouble();
        double valorFinal = input * tasa;
        System.out.println("El valor " + input + " [" + origen + "]" + " corresponde al valor final de =>>> " + valorFinal + " [" + destino + "]");
    }
}
