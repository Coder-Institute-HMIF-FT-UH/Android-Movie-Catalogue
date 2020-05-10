package com.zulfahmi.recyclerview_moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        String[] dataTitle = getResources().getStringArray(R.array.movie_title);
        String[] dataDate = getResources().getStringArray(R.array.movie_release_date);
        String[] dataDesc = getResources().getStringArray(R.array.movie_desc);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.movie_poster);

        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i <dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDate(dataDate[i]);
            movie.setDesc(dataDesc[i]);
            movies.add(movie);
        }

        MovieAdapter movieAdapter = new MovieAdapter(this);
        movieAdapter.setListMovies(movies);
        recyclerView.setAdapter(movieAdapter);

        movieAdapter.notifyDataSetChanged();


    }
}
