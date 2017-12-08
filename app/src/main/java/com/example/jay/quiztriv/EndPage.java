package com.example.jay.quiztriv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.example.kermenjy.quiztrivia.R;

public class EndPage extends AppCompatActivity {


    private Button restart;
    private Button quit;
    private Button shareScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page2);

        restart = (Button)findViewById(R.id.restart);
        quit = (Button)findViewById(R.id.quit);
        shareScore = (Button)findViewById(R.id.share);


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

    }
}
