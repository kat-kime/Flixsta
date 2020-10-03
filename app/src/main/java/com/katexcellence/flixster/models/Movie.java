package com.katexcellence.flixster.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;
    int movieId;
    double rating;

    // Empty constructor needed by Parcel
    public Movie() { }

    /*
        Creating the constructor that takes in a json object
        Whoever calls this method will need to handle the JSON exception
     */
    public Movie (JSONObject jsonObject) throws JSONException {

        // Parsing the JSON object and assigning them to instance variables
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");

    }

    /*
        Takes a movie JSON array and returns a list of movie objects
     */
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<Movie>();

        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }

        return movies;

    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropPath);
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
