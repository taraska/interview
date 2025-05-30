package de.agoda.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

record Schema(String name, String runtime_of_series, String certificate, String runtime_of_episodes, String genre,
              Number imdb_rating, String overview, Number no_of_votes, Number id) {
}

record Body(Number page, Number per_page, Number total, Number total_pages, Schema[] data) {
}

public class RequestHTTPGet {

    @Test
    public void testAPI() {
        String s = RequestHTTPGet.bestInGenre("Animation");
        System.out.println(s);
        assertThat("Avatar: The Last Airbender".equals(s));
    }

    public static String bestInGenre(String genre) {

        class ResultValue {
            Number rating;
            String name;

            public Double getRatingDouble() {

                return this.rating.doubleValue();
            }
        }

        boolean req = true;
        // Write your code here
        List<ResultValue> val = new ArrayList();
        HttpClient client = HttpClient.newHttpClient();
        int requestNum = 1;
        while (req) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonmock.hackerrank.com/api/tvseries?page=" + requestNum)).GET().build();

            try {
                HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString()
                );

                String body = response.body();

                Body l = new ObjectMapper().readValue(body, Body.class);
                if (l.data().length > 0) {
                    for (Schema s : l.data()) {
                        String[] split = s.genre().split(",");
                        List<String> split1 = List.of(split);
                        if (split1.size() > 0 && split1.contains(genre)) {
                            var r = new ResultValue();
                            r.name = s.name();
                            r.rating = s.imdb_rating();
                            val.add(r);
                        }
                    }
                } else {
                    req = false;
                }
                //parse the body, collect all data by genre
            } catch (Exception e) {
                req = false;
            }
            requestNum++;
        }
        List<ResultValue> collect = val.stream()
            .sorted(Comparator.comparingDouble(ResultValue::getRatingDouble)
                .reversed())
            .collect(Collectors.toList());

        return collect.get(0).name;


    }
}
