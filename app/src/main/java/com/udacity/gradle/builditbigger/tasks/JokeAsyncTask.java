package com.udacity.gradle.builditbigger.tasks;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.backend.jokeApi.model.Joke;
import com.udacity.gradle.builditbigger.listeners.JokeListener;

import java.io.IOException;


/**
 * Created by appimagetech on 03/01/18.
 */

public class JokeAsyncTask extends AsyncTask<Void, Void, Joke> {

    private JokeApi api;
    private JokeListener listener;

    public JokeAsyncTask(JokeListener listener) {
        this.listener = listener;
    }

    @Override
    protected Joke doInBackground(Void... params) {

        JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

        api = builder.build();

        try {
            return api.getJoke().execute();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Joke joke) {
        super.onPostExecute(joke);

        listener.onResult(joke);

    }

}
