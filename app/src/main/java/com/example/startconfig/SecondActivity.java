package com.example.startconfig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.startconfig.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerViewAdapter recycleViewAdapter;
    private ArrayList<String> stats;
    private ArrayList<String> statsExtra;
    private String status;
    private static final String SAVED_BUNDLE_ARRAYLISTSTRING = "savedArraylist";
    private static final String SAVED_EXTRA_THIRD = "savedExtraThird";
    private static final String SAVED_EXTRA_FOURTH = "savedExtraFourth";
    private static final String SAVED_EXTRA_FIRST = "savedExtraFirst";
    private Context context;
    public Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bundle = new Bundle();




        RecyclerView recyclerView = findViewById(R.id.recycleView);
        stats = new ArrayList<>();
        statsExtra = new ArrayList<>();


        status = " -2 OnCreate";
        Log.i("Activity",status);
        stats.add(status);

        recycleViewAdapter = new RecyclerViewAdapter(stats);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recycleViewAdapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
        status = " -2 OnStart";
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onResume() {
        super.onResume();

        status = " -2 Onresume";
        Log.i("Activity",status);
        stats.add(status);

        recycleViewAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();

        status = " -2 OnPause";
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onStop() {
        super.onStop();
        status  = " -2 OnStop";
        Log.i("Activity",status);
        stats.add(status);
        bundle.putStringArrayList(SAVED_BUNDLE_ARRAYLISTSTRING, stats);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Intent intent = getIntent();
        String statsExtras =(intent.getStringExtra(SAVED_EXTRA_FOURTH));
        if(statsExtra != null){
            stats.add(statsExtras);
        }
        status = " -2 OnRestart";
        Log.i("Activity",status);
        stats.add(status);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        status = " -2 OnDestroy";
        Log.i("Activity",status);
        stats.add(status);




    }


    public void firstActivity(View view) {
        startActivityForResult(new Intent(this, MainActivity.class),1);
    }
    public void thirdActivity(View view) {
        startActivityForResult(new Intent(this, ThirdActivity.class),3);
    }
    public void fourthctivity(View view) {
        startActivityForResult(new Intent(this, FourthActivity.class),4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                statsExtra = data.getStringArrayListExtra(SAVED_EXTRA_FIRST);
                if (statsExtra != null) {
                    stats.addAll(statsExtra);

                    recycleViewAdapter.notifyDataSetChanged();
                }
            }
        }*/
        if(requestCode == 3) {
            if (resultCode == RESULT_OK) {
                statsExtra = data.getStringArrayListExtra(SAVED_EXTRA_THIRD);
                if (statsExtra != null) {
                    stats.addAll(statsExtra);

                    recycleViewAdapter.notifyDataSetChanged();
                }
            }
        }
        /*
        if(requestCode == 4) {
            if (resultCode == RESULT_OK) {
                statsExtra = data.getStringArrayListExtra(SAVED_EXTRA_FOURTH);
                if (statsExtra != null) {
                    stats.addAll(statsExtra);

                    recycleViewAdapter.notifyDataSetChanged();
                }
            }
        }*/

    }

    public class MyObserver implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void connectListener() {

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void disconnectListener() {

        }
    }

}
