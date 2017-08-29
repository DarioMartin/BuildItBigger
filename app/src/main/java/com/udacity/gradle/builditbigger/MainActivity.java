package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.nanodegree.builditbigger.backend.myApi.MyApi;
import com.nanodegree.dario.jokeviewer.JokeViewerActivity;
import com.udacity.gradle.builditbigger.idlingResources.SimpleIdlingResource;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    @Nullable
    private SimpleIdlingResource idlingResource;

    private ProgressBar progressBar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        button = (Button) findViewById(R.id.joke_button);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        getIdlingResource();
        if (idlingResource != null) idlingResource.setIdleState(false);
        new GetJokeAsyncTask().execute();
    }

    private class GetJokeAsyncTask extends AsyncTask<Void, Void, String> {
        private MyApi myApiService = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            button.setEnabled(false);
        }

        @Override
        protected String doInBackground(Void... params) {
            if (myApiService == null) {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://builditbigger-178310.appspot.com/_ah/api/");
                myApiService = builder.build();
            }

            try {
                return myApiService.tellAJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            onJokeReceived(result);
            progressBar.setVisibility(View.GONE);
            button.setEnabled(true);
            if (idlingResource != null) idlingResource.setIdleState(true);
        }
    }

    protected void onJokeReceived(String joke) {
        Intent intent = new Intent(MainActivity.this, JokeViewerActivity.class);
        intent.putExtra(JokeViewerActivity.JOKE, joke);
        startActivity(intent);
    }


    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (idlingResource == null) {
            idlingResource = new SimpleIdlingResource();
        }
        return idlingResource;
    }

}
