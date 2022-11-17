package com.Tsega.tsega;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static android.os.Environment.DIRECTORY_MUSIC;

@SuppressWarnings("ALL")
public class Rec extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_AUDIO_CODE = 101;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    ImageView ibRecord;
    ImageView ibPlay;
    TextView tvTime;
    TextView ivpath;
    ImageView iVisibility;
    boolean isrecording = false;
    boolean isplaying = false;

    int seconds=0;
    View path = null;
    LottieAnimationView lavPlaying;
    int dummySecond = 0;
    int playableSecond = 0;
    Handler handler;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);
        getSupportActionBar().hide();

        ibRecord = findViewById(R.id.rec_ina);
        ibPlay = findViewById(R.id.play_ina);
        tvTime = findViewById(R.id.tvl);
        path = findViewById(R.id.recPath);

        //lavPlaying = findViewById(R.id.rec_ina);


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        mediaPlayer = new MediaPlayer();



    }

private void runTimer()
{
    handler = new Handler();
    handler.post(new Runnable() {
        @Override
        public void run() {
         int minutes =(seconds%3600)/60;
         int secs = seconds%60;
         String time = String.format(Locale.getDefault(), "%02d:%02d", minutes,secs);
         tvTime.setText(time);

         if (isrecording || (isplaying && playableSecond !=-1))
         {
             seconds++;
             playableSecond--;

             if (playableSecond==-1 && isplaying)
             {
                 mediaPlayer.stop();
                 mediaPlayer.release();
                 mediaPlayer=null;
                 mediaPlayer = new MediaPlayer();
                 playableSecond=dummySecond;
                 seconds=0;
                 handler.removeCallbacksAndMessages(null);
                 lavPlaying.setVisibility(View.GONE);
                 ibPlay.setImageDrawable(ContextCompat.getDrawable(Rec.this, R.drawable.play));
                 return;
             }
         }

         handler.postDelayed(this,1000);
        }
    });
}

    private void requestRecordingPermission()
    {
        ActivityCompat.requestPermissions(Rec.this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_PERMISSION_AUDIO_CODE);
    }

    public boolean checkRecordingPermission()
    {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)== PackageManager.PERMISSION_DENIED)
        {
          requestRecordingPermission();
          return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSION_AUDIO_CODE)
        {
            if (grantResults.length>0)
            {
                boolean permissionToRecord=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                if(permissionToRecord)
                {
                    Toast.makeText(getApplicationContext(), "Permission Given", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}