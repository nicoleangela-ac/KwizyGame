package com.example.kwizy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    int level;
    BackgroundSoundService bgMusic = new BackgroundSoundService();
    ImageButton level1;
    ImageButton level2;
    ImageButton level3;
    ImageButton level4;
    ImageButton level5;
     MediaPlayer click;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = MediaPlayer.create(this, R.raw.click);
         bgMusic.onCreate(this);

         level1 = (ImageButton) findViewById(R.id.lv1_btn);
         level2 = (ImageButton) findViewById(R.id.lv2_btn);
         level3 = (ImageButton) findViewById(R.id.lv3_btn);
         level4 = (ImageButton) findViewById(R.id.lv4_btn);
         level5 = (ImageButton) findViewById(R.id.lv5_btn);

         //Change to black Image
        level2.setImageResource(R.drawable.level_2_locked);
        level3.setImageResource(R.drawable.level_3_locked);
        level4.setImageResource(R.drawable.level_4_locked);
        level5.setImageResource(R.drawable.level_5_locked);

        //start level 1
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unlockLevel(LevelOne.class);
            }
        });

        //gets level value passed by previous activity
        Intent i = getIntent();
        if (null != i) {
            int levelStatus = 0;
            level = i.getIntExtra("levelStat", levelStatus);
        }



        gameLevels();
    }

    //unlock levels & change to colored buttons
    public void gameLevels (){
        switch (level) {
            case 2:
                level2.setImageResource(R.drawable.level_2_button);
                level3.setImageResource(R.drawable.level_3_locked);
                level4.setImageResource(R.drawable.level_4_locked);
                level5.setImageResource(R.drawable.level_5_locked);

                level2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
unlockLevel(LevelTwo.class);
                    }
                });
                break;
            case 3:
                level2.setImageResource(R.drawable.level_2_button);
                level3.setImageResource(R.drawable.level_3_button);
                level4.setImageResource(R.drawable.level_4_locked);
                level5.setImageResource(R.drawable.level_5_locked);

                level2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {unlockLevel(LevelTwo.class); }
                });
                level3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { unlockLevel( LevelThree.class); }
                });
                break;

            case 4:
                level2.setImageResource(R.drawable.level_2_button);
                level3.setImageResource(R.drawable.level_3_button);
                level4.setImageResource(R.drawable.level_4_button);
                level5.setImageResource(R.drawable.level_5_locked);

                level2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { unlockLevel( LevelTwo.class); }
                });
                level3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { unlockLevel( LevelThree.class); }
                });
                level4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { unlockLevel( LevelFour.class); }
                });
                break;
            case 5:
                level2.setImageResource(R.drawable.level_2_button);
                level3.setImageResource(R.drawable.level_3_button);
                level4.setImageResource(R.drawable.level_4_button);
                level5.setImageResource(R.drawable.level_5_button);

                level2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {unlockLevel( LevelTwo.class); }
                });
                level3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {unlockLevel( LevelThree.class); }
                });
                level4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {unlockLevel( LevelFour.class); }
                });
                level5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {unlockLevel( LevelFive.class); }
                });
                break;
        }

    }

    //Open Activity Level
    public void unlockLevel (Class classname) {
        bgMusic.mediaPlayer.stop();
        click.start();
        Intent intent = new Intent(this,classname);
        startActivity(intent);
    }

    //Background Music
    public void PlayBackgroundSound(View view) {
        bgMusic.backgMusic(view);
    }

    //show game mechanics
    public void gameMechanics (View view) { PopUpFeature.showGameMech(this, view);
    }
    //show about us
    public void aboutUs (View view) {
        PopUpFeature.showAboutUs(this, view);
    }


}