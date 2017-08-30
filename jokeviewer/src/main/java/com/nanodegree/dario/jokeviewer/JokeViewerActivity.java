package com.nanodegree.dario.jokeviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeViewerActivity extends AppCompatActivity {

    public static final String JOKE = "JOKE";
    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        jokeTextView = (TextView) findViewById(R.id.joke_text_view);

        String joke = getIntent().getStringExtra(JOKE);

        if (joke != null) {
            jokeTextView.setText(joke);
        }

    }
}
