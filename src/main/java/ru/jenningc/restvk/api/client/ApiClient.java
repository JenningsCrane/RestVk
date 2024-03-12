package ru.jenningc.restvk.api.client;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Slf4j
public class ApiClient {

    public static JSONArray getJsonData(String url) throws IOException, ParseException {
        HttpURLConnection connection = fetchApiResponse(url);

        StringBuilder resultJson = new StringBuilder();
        Scanner scanner = new Scanner(connection.getInputStream());

        while(scanner.hasNext()) {
            resultJson.append(scanner.nextLine());
        }

        scanner.close();
        connection.disconnect();

        JSONParser parser = new JSONParser();

        return (JSONArray) parser.parse(String.valueOf(resultJson));

    }

    public static HttpURLConnection fetchApiResponse(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.connect();

            if (connection.getResponseCode() != 200) {
                log.error("Error: Could not connect to API");
                return null;
            }

            return connection;
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return null;
    }
}
