package com.example.kwizy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.kwizy.QuizContract.*;
import java.util.List;

public class LevelFour extends AppCompatActivity {

    BackgroundSoundService bgMusic = new BackgroundSoundService();
    Timer timer;
    LevelQuestions levelQ = new LevelQuestions();
    CountDownTimer countDownTimer;
    private static final long COUNTDOWN_IN_MILLIS = 10000;
    public long timeLeftInMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);
        bgMusic.onCreate(this);

        //Activity layout
        TextView textViewCountdown = (TextView) findViewById(R.id.textViewCountdown);
        TextView countLabel = (TextView) findViewById(R.id.question_id);
        TextView questionLabel = (TextView) findViewById(R.id.question_txt);
        Button answerBtn1 = (Button) findViewById(R.id.choice_1_btn);
        Button answerBtn2 = (Button) findViewById(R.id.choice_2_btn);
        Button answerBtn3 = (Button) findViewById(R.id.choice_3_btn);
        Button answerBtn4 = (Button) findViewById(R.id.choice_4_btn);

        levelQ.setLayout(countLabel, questionLabel, answerBtn1, answerBtn2, answerBtn3, answerBtn4);
        levelQ.setContext(this);

        //Start Timer
        timer = new Timer(textViewCountdown);
        startTimer();


        // Get Database content
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        List<Question> questionList = dbHelper.getAllQuestions(QTfour.TABLE_NAME4, QTfour.COLUMN_QUESTION, QTfour.COLUMN_OPTION1, QTfour.COLUMN_OPTION2, QTfour.COLUMN_OPTION3, QTfour.COLUMN_OPTION4);

        //Database content to array
        levelQ.getDataToArray(questionList);
        showNextQuiz();
    }

    public void showNextQuiz() {
        countDownTimer.cancel();
        startTimer();
        levelQ.displayQuestion();
    }

    public void checkAnswer(View view) {
        levelQ.checkAnswer(view);
        if (levelQ.getQuizCount() == 15){
            levelStatus();
        }
        showNextQuiz();
    }

    public void levelStatus () {
        if (levelQ.PassFail()) {
            nextActivity(5, NextLevelUnlock.class);
        }
        else {
            nextActivity(4, RepeatLevel.class);
        }
    }

    public void nextActivity (int lvlStat, Class className) {
        bgMusic.mediaPlayer.stop();
        int levelStatus = lvlStat;
        Intent intent = new Intent(this, className);
        intent.putExtra("levelStat", levelStatus);
        startActivity(intent);
    }
    //Background Music
    public void PlayBackgroundSound(View view) {
        bgMusic.backgMusic(view);
    }

    public void gameMechanics (View view) {
        PopUpFeature.showGameMech(this, view);
    }

    public void aboutUs (View view) {
        PopUpFeature.showAboutUs(this, view);
    }

    public void startTimer () {
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                timer.updateCountDownText(timeLeftInMillis, "#5d6af7");
            }

            public void onFinish() {
                timeLeftInMillis= 0;
                timer.updateCountDownText(timeLeftInMillis, "#5d6af7");
                showNextQuiz();
            }
        }.start();
    }
}