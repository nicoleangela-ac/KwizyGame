package com.example.kwizy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class GameComplete extends AppCompatActivity {
    static int level;
    BackgroundSoundService bgMusic = new BackgroundSoundService();
MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_complete);
        bgMusic.onCreate(this);
        click = MediaPlayer.create(this, R.raw.click);

        //gets level value passed by previous activity
        Intent i = getIntent();
        if (null != i) {
            int levelStatus = 0;
            level = i.getIntExtra("levelStat", levelStatus);
        }
    }

    public void returnToMain (View view) {
        click.start();
        int levelStatus = level;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("levelStat", levelStatus);
        startActivity(intent);
        startActivity(new Intent(this, MainActivity.class));
    }

    //Background Music
    public void PlayBackgroundSound(View view) {
        bgMusic.backgMusic(view);
    }

    //show game mechanics
    public void gameMechanics (View view) {
        PopUpFeature.showGameMech(this, view);
    }
    //show about us
    public void aboutUs (View view) {
        PopUpFeature.showAboutUs(this, view);
    }
}