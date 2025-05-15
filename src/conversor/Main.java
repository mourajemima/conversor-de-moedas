package conversor;

import com.google.gson.Gson;
import conversor.modelo.ExchangeRateResposta;
import conversor.servico.MenuDeConversao;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String apiKey = props.getProperty("API_KEY");

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "latest/USD";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ExchangeRateResposta dados = gson.fromJson(httpResponse.body(), ExchangeRateResposta.class);

        MenuDeConversao.inicia(dados);

    }
}
