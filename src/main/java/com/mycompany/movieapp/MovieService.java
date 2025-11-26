package com.mycompany.movieapp;

import java.net.*;
import java.net.http.*;
import java.util.*;
import org.json.*;

public class MovieService {

    private static final String URL = "https://imdb236.p.rapidapi.com/api/imdb/most-popular-movies";
    private static final String HOST = "imdb236.p.rapidapi.com";
    private static final String KEY = "39a3105badmsh7f6d1b787fb6c1bp1b5665jsn0b608edd8c67";

    public List<Movie> fetchTop100() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("x-rapidapi-host", HOST)
                .header("x-rapidapi-key", KEY)
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("API RESPONSE:\n" + response.body());

        JSONArray arr = new JSONArray(response.body());
        List<Movie> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            JSONObject o = arr.getJSONObject(i);
            list.add(new Movie(
                    o.optString("id"),
                    o.optString("primaryTitle"),
                    o.optString("description"),
                    o.optString("primaryImage"),
                    String.valueOf(o.optInt("startYear")),
                    o.optDouble("averageRating")
            ));
        }
        return list;
    }
}
