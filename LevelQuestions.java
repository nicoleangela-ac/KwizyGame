package com.example.kwizy;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LevelQuestions {

    Button answerBtn1;
    Button answerBtn2;
    Button answerBtn3;
    Button answerBtn4;
    TextView questionTxt;
    TextView countLabel;

    Context context;
    private String rightAnswer;
    public int quizCount = 1;
    public int rightAnswerCount = 0;
    public boolean status;
    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLayout(TextView countLabel, TextView questionTxt, Button answerBtn1, Button answerBtn2, Button answerBtn3, Button answerBtn4) {
        this.countLabel = (TextView) countLabel.findViewById(countLabel.getId());
        this.questionTxt = (TextView) questionTxt.findViewById(questionTxt.getId());
        this.answerBtn1 = (Button) answerBtn1.findViewById(answerBtn1.getId());
        this.answerBtn2 = (Button) answerBtn2.findViewById(answerBtn2.getId());
        this.answerBtn3 = (Button) answerBtn3.findViewById(answerBtn3.getId());
        this.answerBtn4 = (Button) answerBtn4.findViewById(answerBtn4.getId());
    }

    public void getDataToArray(List<Question> questionList) {
        for (int i = 0; i < 15; i++) {
            Question currentQuestion = questionList.get(i);
            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(currentQuestion.getQuestion()); //Question
            tmpArray.add(currentQuestion.getOption1()); //Right Answer
            tmpArray.add(currentQuestion.getOption2()); //Choice1
            tmpArray.add(currentQuestion.getOption3()); //Choice2
            tmpArray.add(currentQuestion.getOption4()); //Choice3

            //add tmpArray to quizArray
            quizArray.add(tmpArray);
        }

    }

    public void displayQuestion() {

        countLabel.setText("QUESTION " + quizCount + " OF 15");

        //generate random number between 0 to 14 (quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //pick one quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        //set question and right answer
        questionTxt.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        //remove question from quiz and shuffle choices
        quiz.remove(0);
        Collections.shuffle(quiz);

        //set choices
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        //remove current quiz from quizArray
        quizArray.remove(randomNum);
        quizCount++;
    }

    public void checkAnswer(View view) {
        //Button Clicked Listener
        final MediaPlayer click = MediaPlayer.create(context, R.raw.click);
        click.start();

        Button answerBtn = (Button) view.findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        if (btnText.equals(rightAnswer)) {
            PopUpFeature.correctAnswer(context);
            rightAnswerCount++;
        } else {
            PopUpFeature.wrongAnswer(context);
        }
    }

    public boolean PassFail () {
            if (rightAnswerCount > 8 ){
                this.status = true;
            }
            else {
                this.status = false;
            }
        return status;
    }

    public int getQuizCount () {
        return quizCount; }


}

