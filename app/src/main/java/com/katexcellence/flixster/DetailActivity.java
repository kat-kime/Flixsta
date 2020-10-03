package com.katexcellence.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.katexcellence.flixster.models.Movie;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvOverview;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        ratingBar = findViewById(R.id.ratingBar);

        // Unwrapping the movie
        Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
        if (movie != null) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            ratingBar.setRating((float) movie.getRating());
        }


    }
}