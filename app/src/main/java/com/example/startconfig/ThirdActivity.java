package com.example.startconfig;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.startconfig.services.MediaPlayerService;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> stats;
    private String status;
    private static final String SAVED_EXTRA_THIRD = "savedExtraThird";

    private Button startButton, stopButton;
    private MediaPlayerService musicSrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        startButton = (Button) findViewById(R.id.startButtonService);
        stopButton = (Button) findViewById(R.id.stopButtonService);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

        stopButton.setVisibility(View.INVISIBLE);




        stats = new ArrayList<>();
        status = " -3 OnCreate";
        Log.i("Activity",status);
        stats.add(status);

    }


    @Override
    protected void onStart() {
        super.onStart();
        status = " -3 OnStart";
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onResume() {
        super.onResume();

        status = " -3 Onresume";
        Log.i("Activity",status);
        stats.add(status);

    }

    @Override
    protected void onPause() {
        super.onPause();

        status = " -3 OnPause";
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onStop() {
        super.onStop();
        status  = " -3 OnStop";
        Log.i("Activity",status);
        stats.add(status);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        status = " -3 OnRestart";
        Log.i("Activity",status);
        stats.add(status);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        status = " -3 OnDestroy";
        Log.i("Activity",status);
        stats.add(status);
    }
    public void firstActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
    public void secondActivity(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putStringArrayListExtra(SAVED_EXTRA_THIRD, stats);
        setResult(Activity.RESULT_OK, returnIntent);

        finish();
    }
    public void fourthctivity(View view) {
        startActivity(new Intent(this, FourthActivity.class));
    }


    @Override
    public void onClick(View view) {
        if(view == startButton) {
            Intent intent = new Intent(this, MediaPlayerService.class);
            startService(intent);

            startButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.VISIBLE);

        } else if (view == stopButton) {
            stopService(new Intent(this, MediaPlayerService.class));
            startButton.setVisibility(View.VISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }
    }
}
