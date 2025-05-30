package de.agoda.task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class RequestTechLatam {
    public static List<String> getAuthorHistory(String author) {
        List<String> history = new ArrayList<>();

        try {
            // Step 1: Fetch author information
            Optional<String> about = fetchAuthorAbout(author);
            about.ifPresent(history::add);

            // Step 2: Fetch all articles with pagination
            fetchAllArticles(author, history);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return history.stream().filter(Predicate.not(String::isEmpty)).collect(Collectors.toList());
    }

    private static Optional<String> fetchAuthorAbout(String author) throws Exception {
        String url = "https://jsonmock.hackerrank.com/api/article_users?username=" + author;
        Optional<JSONObject> response = fetchJsonResponse(url);

        if (response.isPresent() && response.get().has("data")) {
            JSONArray data = response.get().getJSONArray("data");
            if (data.length() > 0) {
                JSONObject authorData = data.getJSONObject(0);
                if (authorData.has("about") && !authorData.isNull("about")) {
                    return Optional.ofNullable(authorData.getString("about"));
                }
            }
        }
        return Optional.empty();
    }

    private static void fetchAllArticles(String author, List<String> history) throws Exception {
        int page = 1;
        int totalPages = 1;

        do {
            String url = "https://jsonmock.hackerrank.com/api/articles?author=" + author + "&page=" + page;
            Optional<JSONObject> response = fetchJsonResponse(url);

            if (response.isEmpty()) break;

            totalPages = response.get().getInt("total_pages");
            JSONArray articles = response.get().getJSONArray("data");

            for (int i = 0; i < articles.length(); i++) {
                JSONObject article = articles.getJSONObject(i);
                Optional<String> title = getValidTitle(article);
                title.ifPresent(history::add);
            }

            page++;
        } while (page <= totalPages);
    }

    private static Optional<String> getValidTitle(JSONObject article) throws JSONException {
        if (article.has("title") && !article.isNull("title") && !article.getString("title").isEmpty()) {
            return Optional.ofNullable(article.getString("title"));
        }
        if (article.has("story_title") && !article.isNull("story_title") && !article.getString("story_title").isEmpty()) {
            return Optional.ofNullable(article.getString("story_title"));
        }
        return Optional.empty();
    }

    private static Optional<JSONObject> fetchJsonResponse(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Optional.of(new JSONObject(response.toString()));
        }
        return Optional.empty();
    }

    @Test
    public void test() {
        List<String> history = getAuthorHistory("panny");
        System.out.println("Author History:");
        StringBuilder finalStr = new StringBuilder();
        for (String item : history) {
            finalStr.append(item);
        }
        System.out.println(history.size());
    }
}
