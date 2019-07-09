package com.example.fragmentdestresser;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class Dashboard extends AppCompatActivity {

    private static final String TAG = "Dashboard";

    @BindView(R.id.tv_count)
    TextView tvCount;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        Log.d(TAG, "onCreate");


        //declare and init fragmentmanager
        FragmentManager manager = getSupportFragmentManager();

        //declare and init fragment transaction
        FragmentTransaction transaction = manager.beginTransaction();

        //declare and init fragment
        com.example.fragmentdestresser.DynamicFragment dynamicFragment = new com.example.fragmentdestresser.DynamicFragment();

        //add fragment to layout
        transaction.add(R.id.frame_layout, dynamicFragment, "").commit();


        ButterKnife.bind(this);
        tvCount.setText(String.valueOf(0));  //initial value is 0, set this count as 0
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }


}