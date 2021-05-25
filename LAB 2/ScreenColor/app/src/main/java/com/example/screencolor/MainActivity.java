package com.example.screencolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b1 = (Button)findViewById(R.id.btnRed);
        final Button b2 = (Button)findViewById(R.id.btnBlue);
        final Button b3 = (Button)findViewById(R.id.btnGreen);
        final Button b4 = (Button)findViewById(R.id.btnYellow);
        final Button b5 = (Button)findViewById(R.id.btnCyan);
        final Button b6 = (Button)findViewById(R.id.btnMagenta);
        final Button b7 = (Button)findViewById(R.id.btnBlack);
        final Button b8 = (Button)findViewById(R.id.btnTransparent);
        final Button b9 = (Button)findViewById(R.id.btnGray);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.RED);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.BLUE);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.GREEN);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.YELLOW);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.CYAN);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.MAGENTA);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.BLACK);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.WHITE);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenColor(Color.GRAY);
            }
        });


    }

    public void setScreenColor(int color){
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}