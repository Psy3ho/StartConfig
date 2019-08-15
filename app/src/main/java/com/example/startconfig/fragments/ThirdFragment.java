package com.example.startconfig.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.startconfig.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }

    private String status;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status = " -3 onCreate";
        Log.i("Fragment", status);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        status =  " -3 OnAttach";

        Log.i("Fragment",status);
    }

    @Override
    public void onStart() {
        super.onStart();
        status = " -3 OnStart";

        Log.i("Fragment",status);
    }

    @Override
    public void onResume() {
        super.onResume();
        status = " -3 onResume";
        Log.i("Fragment",status);
    }

    @Override
    public void onPause() {
        super.onPause();
        status = " -3 onPause";
        Log.i("Fragment",status);
    }

    @Override
    public void onStop() {
        super.onStop();
        status = " -3 onStop";
        Log.i("Fragment",status);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        status = " -3 onDestroy";
        Log.i("Fragment",status);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        status = " -3 onDetach";
        Log.i("Fragment",status);
    }


}
