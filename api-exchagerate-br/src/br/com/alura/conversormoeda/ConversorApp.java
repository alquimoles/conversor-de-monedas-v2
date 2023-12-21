package br.com.alura.conversormoeda;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException  {
        Conversor.escolhaUserMenu();
    }
    public static double obterTaxa(String urlFinal) throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder(URI.create(urlFinal)).build();
        HttpResponse<String> resposta = cliente.
                send(requisicao, HttpResponse.BodyHandlers.ofString());

        // Conversão para JSON
        JsonElement elemento = JsonParser.parseString(resposta.body());
        JsonObject objectRoot = elemento.getAsJsonObject();

        // Accessando o JsonObject
        double taxa = objectRoot.get("conversion_rate").getAsDouble();
        return taxa;
    }

}