package com.example.kwizy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new CountDownTimer(900, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                startMain();
            }
        }.start();
        ImageView kwizy = (ImageView)findViewById(R.id.kwizy_txt);
        kwizy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMain();
            }
        });
    }

    public void startMain () {
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        startActivity(intent);
    }
}