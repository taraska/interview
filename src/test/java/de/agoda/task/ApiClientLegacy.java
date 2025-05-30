package de.agoda.task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClientLegacy {
    public static void main(String[] args) {
        String apiUrl = "https://api.example.com/data";
        String apiKey = "your-api-key"; // Consider using environment variables

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configure connection
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setConnectTimeout(10000); // 10 seconds
            connection.setReadTimeout(10000);    // 10 seconds

            // Get response
            int status = connection.getResponseCode();

            try (BufferedReader in = new BufferedReader(
                new InputStreamReader(status < 400 ?
                    connection.getInputStream() :
                    connection.getErrorStream()))) {

                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Handle response
                if (status == 200) {
                    System.out.println("Response: " + response);
                } else {
                    System.err.println("Error: " + status + " - " + response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
