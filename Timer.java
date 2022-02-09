package com.example.kwizy;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import java.util.function.Function;

public class Timer {

    private TextView txtView;

    public Timer (TextView txtView) {
        this.txtView = txtView;
    }

    //Timer Change Text
    public void updateCountDownText(long timeLeftInMillis, String color) {

        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        TextView textViewCountdown = (TextView) txtView.findViewById(txtView.getId());
        textViewCountdown.setText(timeFormatted);
        textViewCountdown.setTextColor(Color.parseColor(color));
        if (timeLeftInMillis < 4000) {
            textViewCountdown.setTextColor(Color.RED);
        }

        else {
            textViewCountdown.setTextColor(Color.parseColor(color));
        }
    }
}
