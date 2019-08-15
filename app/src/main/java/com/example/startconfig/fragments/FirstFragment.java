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
import android.widget.Button;

import com.example.startconfig.R;


/**
 * A simple {@link Fragment} subclass.
*/
public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    private String status;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status = " -1 onCreate";
        Log.i("Fragment", status);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        status =  " -1 OnAttach";

        Log.i("Fragment",status);
    }

    @Override
    public void onStart() {
        super.onStart();
        status = " -1 OnStart";

        Log.i("Fragment",status);
    }

    @Override
    public void onResume() {
        super.onResume();
        status = " -1 onResume";
        Log.i("Fragment",status);
    }

    @Override
    public void onPause() {
        super.onPause();
        status = " -1 onPause";
        Log.i("Fragment",status);
    }

    @Override
    public void onStop() {
        super.onStop();
        status = " -1 onStop";
        Log.i("Fragment",status);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        status = " -1 onDestroy";
        Log.i("Fragment",status);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        status = " -1 onDetach";
        Log.i("Fragment",status);
    }



}
