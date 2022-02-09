package com.example.kwizy;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;

public class BackgroundSoundService  {

    Context object;
    MediaPlayer mediaPlayer;

    public void onCreate (Context object) {
        this.object = object;
        mediaPlayer = MediaPlayer.create(object, R.raw.kwizybgm);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
        mediaPlayer.start();
    }

    public void backgMusic(View v) {
        ImageButton soundBtn = (ImageButton) v.findViewById(v.getId());
        // If the music is playing
        if(mediaPlayer.isPlaying() == true) {
            // Pause the music player
            mediaPlayer.pause();
            soundBtn.setImageResource(R.drawable.muted);
        }
        // If it's not playing
        else {
            // Resume the music player
            mediaPlayer.start();
            soundBtn.setImageResource(R.drawable.sound_on);
        }
    }


}