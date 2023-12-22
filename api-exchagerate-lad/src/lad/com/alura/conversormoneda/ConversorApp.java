package lad.com.alura.conversormoneda;

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
        Conversor.eleccionUserMenu();
    }
    public static double obtenerTasa(String urlFinal) throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder(URI.create(urlFinal)).build();
        HttpResponse<String> respuesta = cliente.
                send(solicitud, HttpResponse.BodyHandlers.ofString());

        // Conversão para JSON
        JsonElement elemento = JsonParser.parseString(respuesta.body());
        JsonObject objectRoot = elemento.getAsJsonObject();

        // Accessando o JsonObject
        double tasa = objectRoot.get("conversion_rate").getAsDouble();
        return tasa;
    }

}
