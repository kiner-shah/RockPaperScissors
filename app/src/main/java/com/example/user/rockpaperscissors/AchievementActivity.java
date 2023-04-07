package com.example.user.rockpaperscissors;

/**
 * Created by Kiner Shah on 01-01-2017.
 */
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AchievementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("AchievementActivity", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
    }
    @Override
    protected void onStart() {
        Log.i("Achievement Activity", "onStart()"); super.onStart();
    }
    @Override
    protected void onResume() {
        Log.i("Achievement Activity", "onResume()"); super.onResume();
    }
    /*@Override
    protected void onRestart() {
        super.onRestart();
    }*/
    @Override
    protected void onStop() {
        Log.i("Achievement Activity", "onStop()"); super.onStop();
    }
    @Override
    protected void onPause() {
        Log.i("Achievement Activity", "onPause()"); super.onPause();
    }
    @Override
    protected void onDestroy() {
        Log.i("Achievement Activity", "onDestroy()"); super.onDestroy();
    }
}
