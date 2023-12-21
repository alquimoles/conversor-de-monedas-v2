package br.com.alura.conversormoeda;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {

    public static void exibirMenu() {
        System.out.println("""
				*******************************************************
				Seja bem-vindo/a ao Conversor de Moeda =]
				
				1) Dólar =>> Peso argentino
				2) Peso argentino =>> Dólar
				3) Dólar =>> Real brasileiro
				4) Real brasileiro =>> Dólar
				5) Dólar =>> Peso colombiano
				6) Peso colombiano =>> Dólar					
				7) Sair
				Escolha uma opção válida:
				*******************************************************
				""");
    }
    public static void escolhaUserMenu() throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        String origem;
        String destino;
        String url;
        double taxa = 0.0;

        while(opcao != 7) {
            exibirMenu();
            opcao = teclado.nextInt();
            switch(opcao) {
                case 1:
                    origem = "USD";
                    destino = "ARS";
                    url = preparaUrlparaBusca(origem, destino);
                    taxa = ConversorApp.obterTaxa(url);
                    conversaoFinal(teclado, taxa, origem, destino);
                    break;
                case 2:
                    origem = "ARS";
                    destino = "USD";
                    url = preparaUrlparaBusca(origem, destino);
                    taxa = ConversorApp.obterTaxa(url);
                    conversaoFinal(teclado, taxa, origem, destino);
                    break;
                case 3:
                    origem = "USD";
                    destino = "BRL";
                    url = preparaUrlparaBusca(origem, destino);
                    taxa = ConversorApp.obterTaxa(url);
                    conversaoFinal(teclado, taxa, origem, destino);
                    break;
                case 4:
                    origem = "BRL";
                    destino = "USD";
                    url = preparaUrlparaBusca(origem, destino);
                    taxa = ConversorApp.obterTaxa(url);
                    conversaoFinal(teclado, taxa, origem, destino);
                    break;
                case 5:
                    origem = "USD";
                    destino = "COP";
                    url = preparaUrlparaBusca(origem, destino);
                    taxa = ConversorApp.obterTaxa(url);
                    conversaoFinal(teclado, taxa, origem, destino);
                    break;
                case 6:
                    origem = "COP";
                    destino = "USD";
                    url = preparaUrlparaBusca(origem, destino);
                    taxa = ConversorApp.obterTaxa(url);
                    conversaoFinal(teclado, taxa, origem, destino);
                    break;
                case 7:
                    System.out.println("Que pena! Saindo do programa...");
                    break;
                default:
                    System.out.println("O número " + opcao + " não é válido. Digite una opção válida! =]");
            }
        }

    }
    public static String preparaUrlparaBusca(String origem, String destino) {
        String urlBase = "https://v6.exchangerate-api.com/v6/febfbc2f3940eaca892fca4e/pair/";
        return urlBase + origem + "/" + destino;
    }
    private static void conversaoFinal(Scanner teclado, double taxa, String origem, String destino) {
        System.out.println("Digite o valor que deseja converter: ");
        double input = teclado.nextDouble();
        double valorFinal = input * taxa;
        System.out.println("Valor " + input + " [" + origem + "]" + " corresponde ao valor final de =>>> " + valorFinal + " [" + destino + "]");
    }
}

