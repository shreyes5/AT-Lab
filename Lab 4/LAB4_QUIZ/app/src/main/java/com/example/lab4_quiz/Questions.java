package com.example.lab4_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;

    String[] questions = {
            "Name of Arsenal's all time leading goalscorer",
            "Where was the first modern Olympic Games held? ",
            "What was the clothing company Nike originally called?",
            "Who invented the World Wide Web, and when?",
            "What happened on July 20th, 1969?",
            "Until 1923, what was the Turkish city of Istanbul called?",
            "What’s the national animal of Australia?",
            "What is the slang name for New York City, used by locals?",
            "Which artist painted the ceiling of the Sistine Chapel in Rome?",
            "Name Disney’s first film?"

    };

    String[] answers = {"Thierry Henry","Athens","Blue Ribbon Sports","Tim Berners Lee- 1990","Apollo 11 landed on the Moon","Constantinople","Red Kangaroo","Gotham","Michelangelo","Snow White"};
    String[] opt = {
            "Aaron Ramsey","Thierry Henry","Aubameyang","Bukayo Saka",
            "Athens","India","England","Haiti",
            "Blue Ribbon Sprts","Adidas","Puma","Dua Sports",
            "Tim Berners Lee-1990","someone","maybe","not me",
            "Apollo 11 landed on the Moon","you","do not","know lol",
            "Constantinople","Galatasaray*","Mumbai*","Manipal",
            "bird","their PM","not me","Red Kangaroo",
            "Gotham","dont","live","in NYC",
            "Da vinci","Michelangelo","Di Caprio","so jaa bro",
            "Snow White","some other white","Tottenham","Batman"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");


//        if (name.trim().equals(""))
//            textView.setText("Hello User");
//        else
//            textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),Result.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Result.class);
                startActivity(intent);
            }
        });
    }
}