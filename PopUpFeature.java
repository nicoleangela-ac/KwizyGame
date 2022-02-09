package com.example.kwizy;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class PopUpFeature {

    public static void showAboutUs (Context context, View view) {
       final MediaPlayer click = MediaPlayer.create(context, R.raw.click);
        click.start();
        final Dialog dialog = new  Dialog (context);
        dialog.setContentView(R.layout.about_us);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        Button closeBtn = (Button) dialog.findViewById(R.id.abt_close);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public static void correctAnswer (Context context) {
        final Dialog dialog = new  Dialog (context);
        dialog.setContentView(R.layout.check);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        new CountDownTimer(400, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                dialog.dismiss();
            }
        }.start();
    }

    public static void wrongAnswer (Context context) {
        final Dialog dialog = new  Dialog (context);
        dialog.setContentView(R.layout.wrong);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        new CountDownTimer(400, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                dialog.dismiss();
            }
        }.start();
    }


    public static void showGameMech (Context context, View view) {
        final MediaPlayer click = MediaPlayer.create(context, R.raw.click);
        click.start();
        final Dialog dialog = new  Dialog (context);
        dialog.setContentView(R.layout.mechanics);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        Button closeBtn = (Button) dialog.findViewById(R.id.mechclose);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}
