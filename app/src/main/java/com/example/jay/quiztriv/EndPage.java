package com.example.jay.quiztriv;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.jay.quiztriv.QuizTrivia;

//import com.example.kermenjy.quiztrivia.R;

public class EndPage extends AppCompatActivity {

    private Button restart;
    private Button quit;
    private Button show_results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page2);

        restart = (Button)findViewById(R.id.restart);
        quit = (Button)findViewById(R.id.quit);
        show_results = (Button)findViewById(R.id.show_results);


        restart.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent i = new Intent(EndPage.this, QuizTrivia.class);
                startActivity(i);
                finish();
            }
        });

        quit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                finish();
                System.exit(0);
            }
        });

        show_results.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                ShowRecords();
            }
        });

    }

    public void ShowRecords() {

        Cursor c;
        String temp;
        String data;
        data = "";

        c = QuizTrivia.db.rawQuery("Select * from MyTable;", null);

        c.moveToFirst();

        for (int i = 0; c.moveToPosition(i); i++) {
            data += "Question: ";
            temp = c.getString(0); // column index = 0 i.e. question
            data += temp + "\n";
            temp = c.getString(1); // column index = 1 i.e. user choice
            data += "User's Choice: " + temp + "\n";
            temp = c.getString(2); // column index = 2 i.e. correct answer
            data += "Correct Answer: " + temp + "\n";
            data += "=====================================\n";
        }

        ((TextView)findViewById(R.id.results)).setText(data);

    }

}
