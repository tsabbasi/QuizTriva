package com.example.jay.quiztriv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class QuizTrivia extends AppCompatActivity {


    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button quitButton;

    private String mAnswer;
    private int mScore=0;
    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_trivia);

        System.out.println("made it 1");
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        quitButton = (Button)findViewById(R.id.quit);

        updateQuestion();

        //Start of Button Listener for Button 1

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                if(mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizTrivia.this, "CORRECT", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(QuizTrivia.this, "YOU'RE WRONG BOI!!!!!!!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listener for Button 1

        //Start of Button Listener for Button 2

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                if(mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizTrivia.this, "CORRECT", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(QuizTrivia.this, "YOU'RE WRONG BOI!!!!!!!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listener for Button 2

        //Start of Button Listener for Button 3

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                if(mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizTrivia.this, "CORRECT", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(QuizTrivia.this, "YOU'RE WRONG BOI!!!!!!!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listener for Button 3

        quitButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent i = new Intent(QuizTrivia.this, EndPage.class);
                startActivity(i);
                finish();
            }
        });
    }




    private void updateQuestion(){
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswers(mQuestionNumber);
            mQuestionNumber++;

            if(mQuestionNumber > mQuestionLibrary.getMQLength()){
                Intent i = new Intent(QuizTrivia.this, EndPage.class);
                startActivity(i);
                finish();
            }


        }

        private void updateScore(int point){
            mScoreView.setText("" + mScore);
        }

    }

