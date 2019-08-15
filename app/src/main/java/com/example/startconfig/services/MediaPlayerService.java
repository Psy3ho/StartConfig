package com.example.startconfig.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.startconfig.R;
import com.example.startconfig.ThirdActivity;

public class MediaPlayerService extends Service {

    MediaPlayer mediaPlayer;
    private final IBinder musicBind = new Binder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.stop();
        mediaPlayer.release();
        return false;
    }


    public static final String CHANNEL_ID = "ForegroundServiceChannel";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"service created", Toast.LENGTH_SHORT).show();

        createNotificationChannel();
        Intent notificatIntent =new Intent(this, ThirdActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificatIntent, 0);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.service_music_bckgrnd);
        mediaPlayer.setLooping(true);

        mediaPlayer.start();

        String musicName = String.valueOf((R.raw.service_music_bckgrnd));

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Music")
                .setContentText(musicName)
                .setSmallIcon(R.drawable.ic_play_circle_filled_black_24dp)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

        return START_STICKY;
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"service stopped", Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }



/*
    //playback methods
    public int getPosn(){
        return mediaPlayer.getCurrentPosition();
    }

    public int getDur(){
        return mediaPlayer.getDuration();
    }

    public boolean isPng(){
        return mediaPlayer.isPlaying();
    }

    public void pausePlayer(){
        mediaPlayer.pause();
    }

    public void seek(int posn){
        mediaPlayer.seekTo(posn);
    }

    public void go(){
        mediaPlayer.start();
    }
*/

}
