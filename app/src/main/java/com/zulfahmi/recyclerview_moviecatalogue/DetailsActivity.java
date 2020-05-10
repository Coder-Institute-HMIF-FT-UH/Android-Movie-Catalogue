package com.zulfahmi.recyclerview_moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public final static String EXTRA_MOVIE = "extra_movie";

    TextView tvTitle, tvDate, tvDesc;
    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgPoster = findViewById(R.id.img_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvDate = findViewById(R.id.tv_date);
        tvDesc = findViewById(R.id.tv_desc);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        imgPoster.setImageResource(movie.getPoster());
        tvTitle.setText(movie.getTitle());
        tvDate.setText(movie.getDate());
        tvDesc.setText(movie.getDesc());

    }
}
