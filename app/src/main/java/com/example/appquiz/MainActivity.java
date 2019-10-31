package com.example.appquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] question_init = getResources().getStringArray(R.array.questions);
        TextView vx = findViewById(R.id.text_view);
        vx.setText(question_init[0]);
        Button bx = findViewById(R.id.previous_button);
        bx.setText("min");
    }

    public void method_true(View view) {
        String[] question = getResources().getStringArray(R.array.questions);
        String[] answers = getResources().getStringArray(R.array.answers);
        if (answers[index].equals("true")) {
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG).show();
            if (index >= question.length - 1) {
                Button bx = findViewById(R.id.next_button);
                bx.setText("max");
            }else{
                index = index + 1;
                TextView vx = findViewById(R.id.text_view);
                vx.setText(question[index]);
            }

        } else {
            Toast.makeText(MainActivity.this, "Incorrect... try again", Toast.LENGTH_LONG).show();
        }

    }

    public void method_false(View view) {
        String[] question = getResources().getStringArray(R.array.questions);
        String[] answers = getResources().getStringArray(R.array.answers);
        if (answers[index].equals("false")) {
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG).show();
            if (index >= question.length - 1) {
                Button bx = findViewById(R.id.next_button);
                bx.setText("max");
            }else {
                index = index + 1;
                TextView vx = findViewById(R.id.text_view);
                vx.setText(question[index]);
            }
        } else {
            Toast.makeText(MainActivity.this, "Incorrect... try again", Toast.LENGTH_LONG).show();
        }
    }

    public void method_next(View view) {
        String[] question = getResources().getStringArray(R.array.questions);
        if (index >= question.length - 1) {
            Button bx = findViewById(R.id.next_button);
            bx.setText("max");
        } else {
            index = index + 1;
            TextView vx = findViewById(R.id.text_view);
            vx.setText(question[index]);
            Button bx = findViewById(R.id.next_button);
            bx.setText("Next");
        }
        if (index != 0) {
            Button bx = findViewById(R.id.previous_button);
            bx.setText("Previous");
        }
    }

    public void method_previous(View view) {
        String[] question = getResources().getStringArray(R.array.questions);
        if (index < 1) {
            Button bx = findViewById(R.id.previous_button);
            bx.setText("min");
        } else {
            index = index - 1;
            TextView vx = findViewById(R.id.text_view);
            vx.setText(question[index]);
            Button bx = findViewById(R.id.previous_button);
            bx.setText("Previous");
        }
        if (index != question.length - 1) {
            Button bx = findViewById(R.id.next_button);
            bx.setText("Next");
        }
    }
}
