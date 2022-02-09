package com.example.kwizy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class NextLevelUnlock extends AppCompatActivity {
    int level;
    BackgroundSoundService bgMusic = new BackgroundSoundService();
    MediaPlayer click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_level_unlock);
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
        bgMusic.mediaPlayer.stop();
        click.start();
        int levelStatus = level;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("levelStat", levelStatus);
        startActivity(intent);
    }

    //transfer Activity Level
    public void checkLevelStatus(View view) {
        bgMusic.mediaPlayer.stop();
        click.start();
        switch (level) {
            case 2 :
                callActivity(LevelTwo.class);
                break;
            case 3:
              callActivity(LevelThree.class);
                break;
            case 4:
                callActivity(LevelFour.class);
                break;
            case 5:
                callActivity(LevelFive.class);
                break;
            case 6:
                callActivity(GameComplete.class);
                break;
        }
      }
    //method for calling Activity class
    void callActivity(Class className)  {
        Intent intent = new Intent(this,className);
        startActivity(intent);
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