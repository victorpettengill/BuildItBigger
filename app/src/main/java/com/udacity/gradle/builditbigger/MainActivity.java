package com.udacity.gradle.builditbigger;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.backend.jokeApi.model.Joke;
import com.udacity.gradle.builditbigger.listeners.JokeListener;
import com.udacity.gradle.builditbigger.tasks.JokeAsyncTask;

import br.com.grupoimagetech.jokeviewr.JokeViewActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button tellJokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        tellJokeButton = (Button) findViewById(R.id.tell_joke_button);

    }

    public void tellJoke(View view) {

        tellJokeButton.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        new JokeAsyncTask(new JokeListener() {
            @Override
            public void onResult(Joke joke) {

                tellJokeButton.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);

                if(joke != null) {

                    Intent i = new Intent(MainActivity.this, JokeViewActivity.class);
                    i.putExtra(JokeViewActivity.JOKE_TITLE, joke.getTitle());
                    i.putExtra(JokeViewActivity.JOKE_TEXT, joke.getText());
                    startActivity(i);

                } else {

                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage(R.string.erroe_jokes)
                            .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.dismiss();

                                }
                            }).show();

                }

            }
        }).execute();

    }



}
