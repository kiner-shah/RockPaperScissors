package com.example.user.rockpaperscissors;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
//import android.support.v4.app.NotificationCompat;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

/**
 * Created by Kiner Shah on 29-12-2016.
 */
// 0 for rock, 1 for paper, 2 for scissors
public class PlayActivity extends AppCompatActivity {
    ImageView player, computer;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    TextView pscore, cscore;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Play Activity", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        player = (ImageView) findViewById(R.id.playerMove);
        computer = (ImageView) findViewById(R.id.compMove);
        pscore = (TextView) findViewById(R.id.player_score);
        cscore = (TextView) findViewById(R.id.comp_score);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onStart() {
        Log.i("Play Activity", "onStart()");
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Play Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.user.rockpaperscissors/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    protected void onResume() {
        Log.i("Play Activity", "onResume()");
        super.onResume();
    }

    /*@Override
    protected void onRestart() {
        super.onRestart();
    }*/
    @Override
    protected void onStop() {
        Log.i("Play Activity", "onStop()");
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Play Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.user.rockpaperscissors/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    @Override
    protected void onPause() {
        Log.i("Play Activity", "onPause()");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.i("Play Activity", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void chosePaper(View v) {
        player.setImageResource(R.mipmap.paper_image_large);
        Random r = new Random();
        int cmove = r.nextInt(3);
        doNecessaryComputation(cmove, 1);
    }

    public void choseScissors(View v) {
        player.setImageResource(R.mipmap.scissors_image_large);
        Random r = new Random();
        int cmove = r.nextInt(3);
        doNecessaryComputation(cmove, 2);
    }

    public void choseRock(View v) {
        player.setImageResource(R.mipmap.rock_image_large);
        Random r = new Random();
        int cmove = r.nextInt(3);
        doNecessaryComputation(cmove, 0);
    }
    private void doNecessaryComputation(int cmove, int pmove) {
        if(cmove == 0) computer.setImageResource(R.mipmap.rock_image_large);
        else if(cmove == 1) computer.setImageResource(R.mipmap.paper_image_large);
        else if(cmove == 2) computer.setImageResource(R.mipmap.scissors_image_large);
        int ps = Integer.parseInt(pscore.getText().toString());
        int cs = Integer.parseInt(cscore.getText().toString());
        //Log.i("PlayActivity", String.valueOf(ps));
        //Log.i("PlayActivity", String.valueOf(cs));
        if(cmove != pmove) {
            if(cmove == 0 && pmove == 1) ps++;
            else if(cmove == 0 && pmove == 2) cs++;
            else if(cmove == 1 && pmove == 0) cs++;
            else if(cmove == 1 && pmove == 2) ps++;
            else if(cmove == 2 && pmove == 0) ps++;
            else if(cmove == 2 && pmove == 1) cs++;
            if(ps == 5 || cs == 5) {
                final Dialog winLoseStatus = new Dialog(this);
                winLoseStatus.setContentView(R.layout.win_lose_status);
                winLoseStatus.setTitle("Results");
                TextView cfs = (TextView) winLoseStatus.findViewById(R.id.comp_final_score);
                TextView pfs = (TextView) winLoseStatus.findViewById(R.id.player_final_score);
                TextView status = (TextView) winLoseStatus.findViewById(R.id.win_lose);
                Button play_again = (Button) winLoseStatus.findViewById(R.id.play_again);
                Button exit = (Button) winLoseStatus.findViewById(R.id.exit);
                ImageView smiley = (ImageView) winLoseStatus.findViewById(R.id.smiley);
                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // winLoseStatus.dismiss();
                        finish();
                    }
                });
                play_again.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(PlayActivity.this, PlayActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
                cfs.setText(String.valueOf(cs));
                pfs.setText(String.valueOf(ps));
                if(ps < cs) {
                    status.setText("You Lose!");
                    smiley.setImageResource(R.mipmap.sad_smiley_large);

                }
                else {
                    status.setText("You Win!");
                    smiley.setImageResource(R.mipmap.cool_smiley_large);
                }
                winLoseStatus.show();
                sendNotification("Won");
            }
            pscore.setText(String.valueOf(ps));
            cscore.setText(String.valueOf(cs));
            // sendNotification();
        }
    }
    // https://developer.android.com/training/basics/data-storage/shared-preferences.html
    private void checkAchievements() {
        // COMPLETE THIS
        // 1. Get the statistical values using SharedPreferences
        // 2. Check for achievement condition
        // 3. Modify layout if condition's satisfied and call sendNotification()
    }
    // https://developer.android.com/training/notify-user/build-notification.html
    private void sendNotification(String achievementText) {
        final String CHANNEL_ID = "RPS_CHANNEL_ID_1";
        final String CHANNEL_NAME = "RPS_ACHIEVEMENTS";

        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        mNotifyMgr.createNotificationChannel(channel);

        Intent resultIntent = new Intent(this, AchievementActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.game_logo_large)
                .setContentTitle("Achievement unlocked!")
                .setContentText(achievementText)
                .setContentIntent(resultPendingIntent)
                .setAutoCancel(true);
        int notificationID = 001;

        mNotifyMgr.notify(notificationID, mBuilder.build());
    }
}
