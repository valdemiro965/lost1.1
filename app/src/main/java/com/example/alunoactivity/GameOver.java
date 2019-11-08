package com.example.alunoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView scoreLabel, highScoreLabel;
    Button btn_sair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        btn_sair = (Button) findViewById(R.id.btn_sair);
        scoreLabel= (TextView)findViewById(R.id.scoreLabel);
        highScoreLabel=(TextView)findViewById(R.id.highScoreLabel);


        btn_sair.setOnClickListener(onContinue);

        int resultado = getIntent().getIntExtra("Score",0);
        scoreLabel.setText(resultado+"");

        SharedPreferences settings = getSharedPreferences("GAME_DATA" , Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE",0);

        if (resultado > highScore) {
            highScoreLabel.setText("hight_Score: " +resultado);

            // save

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("HIGH_SCORE: " , resultado);
        editor.commit();
    } else {
          highScoreLabel.setText("hight_Score: " + highScore);
        }
    }

    View.OnClickListener onContinue = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

}
