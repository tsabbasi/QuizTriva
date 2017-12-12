package com.example.jay.quiztriv;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class WelcomePage extends AppCompatActivity {

    // Global Variables

    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        https://github.com/JayDavi/QuizTriva.git

        start = (Button)findViewById(R.id.welcome);

        start.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent i = new Intent(WelcomePage.this, QuizTrivia.class);
                startActivity(i);
                finish();
            }
        });
    }
}
