package com.example.palindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mInput;
    TextView mResult;
    Button mReverseBtn, mPalindromeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInput = findViewById(R.id.enterString);
        mResult = findViewById(R.id.result);
        mReverseBtn = findViewById(R.id.reverse);
        mPalindromeBtn = findViewById(R.id.palindrome);


        mReverseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = mInput.getText().toString().trim();
                StringBuilder input1 = new StringBuilder();
                input1.append(input);
                input1.reverse();
                mResult.setText(input1);
            }
        });

        mPalindromeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = mInput.getText().toString().trim();
               String rev = "";
               int length = input.length();
               for(int i = length-1; i>=0; i--) {
                   rev= rev+ input.charAt(i);
               }
               if(input.equals(rev)){
                   mResult.setText("Palindrome");
               }
               else {
                   mResult.setText("Not palindrome");
               }


            }
        });
    }
}