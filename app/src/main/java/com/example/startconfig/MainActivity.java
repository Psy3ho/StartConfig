package com.example.startconfig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.startconfig.fragments.FirstFragment;
import com.example.startconfig.fragments.SecondFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String SAVED_EXTRA_FIRST = "savedExtraFirst";
    //stats and snackbar
    private Snackbar snackbar;
    private String snackbarHide;
    private String statsSnackbar = "";

    //fragments
    private BottomNavigationView bottomNavigationView;
    private FirstFragment firstFragment = new FirstFragment();
    private SecondFragment secondFragment = new SecondFragment();

    private ArrayList<String> stats;
    private String status;
    private static final String SAVED_EXTRA_THIRD = "savedExtraThird";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }

        Context context;



        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        initializeFragments();

        snackbarHide = getString(R.string.hide_snackbar);

        stats = new ArrayList<>();
        status = " -1 OnCreate";
        Log.i("Activity",status);
        stats.add(status);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()) {
                    case R.id.firstFragmentItem:
                        replaceFragment(firstFragment);
                        return true;
                    case R.id.secondFragmentItem:
                        replaceFragment(secondFragment);
                        return true;


                    default:
                        return false;


                }
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        status = " -1 OnStart";
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.showSnackbar("Test Snackbar");
        status = (" -1 Onresume");
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onPause() {
        super.onPause();

        status = " -1 OnPause";
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onStop() {
        super.onStop();
        status = " -1 OnStop";
        Log.i("Activity",status);
        stats.add(status);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        status = " -1 OnRestart";
        Log.i("Activity",status);
        stats.add(status);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        status = " -1 OnDestroy";
        Log.i("Activity",status);
        stats.add(status);
    }

    public void nextActivity(View view) {
        Intent returnIntent = new Intent(this, SecondActivity.class);
        startActivity(returnIntent);
    }

    public void clearSnackbar(View view){
        statsSnackbar = "";
        this.showSnackbar(statsSnackbar);
    }

    public void fifthActivity(View view) {
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }




    // show snackbar with minimal stats about lifecycle of activity
    private void showSnackbar(String paStats) {
        snackbar = Snackbar.make(findViewById(android.R.id.content), paStats, Snackbar.LENGTH_INDEFINITE).setAction(snackbarHide,new View.OnClickListener(){

            public  void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    //inicialization fragments , first show up and second hide
    private void initializeFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, firstFragment);
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
       /* if(fragment == firstFragment) {
            transaction.hide(secondFragment);
        } else if(fragment == secondFragment) {
            transaction.hide(firstFragment);
        }
        transaction.show(fragment);
*/
        transaction.replace(R.id.fragmentContainer,fragment);
        transaction.commit();

    }

}
