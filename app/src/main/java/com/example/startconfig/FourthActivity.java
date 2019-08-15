package com.example.startconfig;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.startconfig.adapters.TabLayoutAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {

    private ArrayList<String> stats;
    private String status;
    private static final String SAVED_EXTRA_FOURTH = "savedExtraFourth";
    public Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        bundle = new Bundle();

        stats = new ArrayList<>();
        status = " -4 OnCreate";
        stats.add(status);
        Log.i("Activity",status);

        Toolbar toolbar = findViewById(R.id.toolbarView);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabLayoutView);
        tabLayout.addTab(tabLayout.newTab().setText("Fragment 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragment 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragment 3"));

        final ViewPager viewPager = findViewById(R.id.pagerView);
        final PagerAdapter pagerAdapter = new TabLayoutAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }



    @Override
    protected void onStart() {
        super.onStart();
        status = " -4 OnStart";
        stats.add(status);
        Log.i("Activity",status);
    }

    @Override
    protected void onResume() {
        super.onResume();

        status = " -4 Onresume";
        stats.add(status);
        Log.i("Activity",status);

    }

    @Override
    protected void onPause() {
        super.onPause();

        status = " -4 OnPause";
        stats.add(status);
        Log.i("Activity",status);
    }

    @Override
    protected void onStop() {
        super.onStop();
        status  = " -4 OnStop";
        stats.add(status);
        Log.i("Activity",status);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        status = " -4 OnRestart";
        stats.add(status);
        Log.i("Activity",status);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        status = " -4 OnRestart";
        stats.add(status);
        Log.i("Activity",status);
    }


    public void firstActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
    public void secondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SAVED_EXTRA_FOURTH,"hello funguje to");
        startActivity(intent);

    }
    public void thirdhctivity(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

    private void resultStatus() {
        Intent returnIntent = new Intent();
        returnIntent.putStringArrayListExtra(SAVED_EXTRA_FOURTH, stats);
        setResult(Activity.RESULT_OK, returnIntent);
    }
}
