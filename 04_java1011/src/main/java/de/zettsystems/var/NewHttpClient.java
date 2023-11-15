package de.zettsystems.var;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class NewHttpClient {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        useNewJava11HttpApi();
        useOldJavaApi();
        useApacheHttpClient();
    }

    private static void useApacheHttpClient() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://postman-echo.com/get");

            try (CloseableHttpResponse response = client.execute(request)) {
                // Antwortstatus erhalten
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("Status Code: " + statusCode);

                // Antwortinhalt als String
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response Body: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void useOldJavaApi() throws IOException {
        URL url = new URL("https://postman-echo.com/get");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Setzen der Methode auf GET
        connection.setRequestMethod("GET");

        // Setzen des Timeouts
        connection.setConnectTimeout(20000);
        connection.setReadTimeout(20000);

        // Lesen der Antwort
        int status = connection.getResponseCode();
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        if (status > 299) {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        }

        System.out.println(responseContent);

        connection.disconnect();
    }

    private static void useNewJava11HttpApi() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
