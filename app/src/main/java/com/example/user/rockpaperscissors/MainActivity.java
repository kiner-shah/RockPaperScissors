package com.example.user.rockpaperscissors;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Kiner Shah on 29-12-2016.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Main Activity", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Play = (Button) findViewById(R.id.PlayButton);
        final Button Achievements = (Button) findViewById(R.id.AchievementsButton);
        final Button Credits = (Button) findViewById(R.id.CreditsButton);
    }
    @Override
    protected void onStart() {
        Log.i("Main Activity", "onStart()"); super.onStart();
    }
    @Override
    protected void onResume() {
        Log.i("Main Activity", "onResume()"); super.onResume();
    }
    /*@Override
    protected void onRestart() {
        super.onRestart();
    }*/
    @Override
    protected void onStop() {
        Log.i("Main Activity", "onStop()"); super.onStop();
    }
    @Override
    protected void onPause() {
        Log.i("Main Activity", "onPause()"); super.onPause();
    }
    @Override
    protected void onDestroy() {
        Log.i("Main Activity", "onDestroy()"); super.onDestroy();
    }

    public void playAction(View v) {
        Log.i("Main Activity", "playAction()");
        Intent i = new Intent(v.getContext(), PlayActivity.class);
        v.getContext().startActivity(i);
    }
    public void achievementAction(View v) {
        Log.i("Main Activity", "achievementAction()");
        Intent i = new Intent(v.getContext(), AchievementActivity.class);
        v.getContext().startActivity(i);
    }
    public void creditAction(View v) {
        Log.i("Main Activity", "creditAction");
        final Dialog creditsDialog = new Dialog(this);
        creditsDialog.setContentView(R.layout.credits);
        creditsDialog.setTitle("Credits");
        Button close = (Button) creditsDialog.findViewById(R.id.credits_close);
        close.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.i("Main Activity", "Credits Dialog Close Button Pressed");
                    creditsDialog.dismiss();
                }
        });
        creditsDialog.show();
    }
    public void statsAction(View v) {
        Log.i("Main Activity", "statsAction");
        // COMPLETE THIS
        final Dialog statsDialog = new Dialog(this);
        statsDialog.setContentView(R.layout.activity_stats);
        statsDialog.setTitle("Statistics");
        Button close = (Button) statsDialog.findViewById(R.id.stats_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statsDialog.dismiss();
            }
        });
        statsDialog.show();
    }
}
