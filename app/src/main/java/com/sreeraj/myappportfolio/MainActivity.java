package com.sreeraj.myappportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String POPULAR_MOVIES_APP = "com.sreeraj.popularmovies";
    private Button spotifyStreamerButton;
    private Button scoresAppButton;
    private Button libraryAppButton;
    private Button buildItBiggerButton;
    private Button xyzReaderButton;
    private Button capstoneProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
        setListeners();
    }

    private void initViews() {
        spotifyStreamerButton = (Button) findViewById(R.id.spotify_streamer_button);
        scoresAppButton = (Button) findViewById(R.id.scores_app_button);
        libraryAppButton = (Button) findViewById(R.id.library_app_button);
        buildItBiggerButton = (Button) findViewById(R.id.build_it_bigger_app_button);
        xyzReaderButton = (Button) findViewById(R.id.xyz_reader_app_button);
        capstoneProjectButton = (Button) findViewById(R.id.capstone_button);

    }

    private void setListeners() {
        spotifyStreamerButton.setOnClickListener(this);
        scoresAppButton.setOnClickListener(this);
        libraryAppButton.setOnClickListener(this);
        buildItBiggerButton.setOnClickListener(this);
        xyzReaderButton.setOnClickListener(this);
        capstoneProjectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent launchIntent = new Intent();
        int id = v.getId();
        switch (id) {
            case R.id.spotify_streamer_button:
                launchIntent = getPackageManager().getLaunchIntentForPackage(POPULAR_MOVIES_APP);
                showToast(getString(R.string.popular_movies_app_toast));
                break;
            case R.id.scores_app_button:
                showToast(getString(R.string.scores_app_toast));
                break;
            case R.id.library_app_button:
                showToast(getString(R.string.library_app_toast));
                break;
            case R.id.build_it_bigger_app_button:
                showToast(getString(R.string.build_it_bigger_app_toast));
                break;
            case R.id.xyz_reader_app_button:
                showToast(getString(R.string.xyz_reader_app_toast));
                break;
            case R.id.capstone_button:
                showToast(getString(R.string.capstone_project_toast));
                break;
            default:
                break;
        }
        startActivity(launchIntent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
}
