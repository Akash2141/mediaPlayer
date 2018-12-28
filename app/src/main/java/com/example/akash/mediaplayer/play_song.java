package com.example.akash.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class play_song extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    Intent intent;
    MediaPlayer player;
    String song;
    SeekBar seekBar;
    TextView SongName;

    Runnable run = new Runnable() {
        @Override
        public void run() {
            seekUpdation();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        intent = getIntent();
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        Handler handler = new Handler();
        seekBar.setOnSeekBarChangeListener(this);

        initialize();
        seekUpdation();
        player.start();
    }

    private void initialize() {
        intent=getIntent();
        song = intent.getStringExtra("song");
        SongName=(TextView)findViewById(R.id.SongName);
        Toast.makeText(this, song, Toast.LENGTH_SHORT).show();
        if (song.equals("loveme")) {
            SongName.setText(song);
            player = MediaPlayer.create(this, R.raw.loveme);
        } else if (song.equals("girlslikeyou")) {
            SongName.setText(song);
            player = MediaPlayer.create(this, R.raw.girlslikeyou);
        } else if (song.equals("letyouberight")) {
            SongName.setText(song);
            player = MediaPlayer.create(this, R.raw.letyouberight);
        } else if (song.equals("backtoyou")) {
            SongName.setText(song);
            player = MediaPlayer.create(this, R.raw.backtoyou);
        } else if (song.equals("scaredtobelonely")) {
            SongName.setText(song);
            player = MediaPlayer.create(this, R.raw.scaredtobelonely);
        }
        seekBar.setMax(player.getDuration());
    }

    public void seekUpdation() {
        seekBar.setProgress(player.getCurrentPosition());
        seekBar.postDelayed(run, 1000);
    }

    public void start(View view) {
        if (player.isPlaying() == false) {
            player.start();
        } else {
            seekBar.setProgress(0);
        }

    }

    public void pause(View view) {
        player.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.pause();
    }

    public void stop(View view) {
        player.stop();
        initialize();
        seekUpdation();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        try {
            if (player.isPlaying() || player != null) {
                if (fromUser) {
                    player.seekTo(progress);
                    player.start();
                }

            } else if (player == null) {
                Toast.makeText(this, "song is not running", Toast.LENGTH_SHORT).show();
                seekBar.setProgress(0);
            }
        } catch (Exception e) {
            seekBar.setEnabled(false);
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
