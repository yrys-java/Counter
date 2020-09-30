package com.example.counter;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int counter;
    String time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            time = savedInstanceState.getString("time");
            counter = savedInstanceState.getInt("count");
            display(counter);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("time", time);
        outState.putInt("count", counter);
    }

    public void button(View view) {
        if (counter < 1000) {
            counter += 1;
            display(counter);
        }
    }


    public void display(int score) {
        TextView scoreView = (TextView) findViewById(R.id.textView);
        time = String.format(Locale.getDefault(), "%04d", score);
        scoreView.setText(time);
    }
}