import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConvertidorMoneda {
    public Conversor conversorMoneda(String monedaPaisDe, String monedaPaisA, String montoAConvetir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b7b6b5d8784949cb93f37171/pair/"+monedaPaisDe+"/"+monedaPaisA+"/"+montoAConvetir);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre el país, para poder convertir...");
        }
    }
}
