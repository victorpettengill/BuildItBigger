package br.com.grupoimagetech.jokeviewr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeViewActivity extends AppCompatActivity {

    public static final String JOKE_TITLE = "title";
    public static final String JOKE_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_view);

        ((TextView)findViewById(R.id.title)).setText(getIntent().getStringExtra(JOKE_TITLE));
        ((TextView)findViewById(R.id.text)).setText(getIntent().getStringExtra(JOKE_TEXT));

        if(getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        finish();

        return super.onOptionsItemSelected(item);
    }
}
