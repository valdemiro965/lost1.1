package com.example.alunoactivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class Tela2Activity extends AppCompatActivity {

    MediaPlayer porta;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private TextView Score, Score1, Score2, Score3, Score4, Score_Tot;

    int figuras[] = {R.drawable.laranja, R.drawable.amarela, R.drawable.vermelha, R.drawable.verde, R.drawable.azul,
            R.drawable.vermelha, R.drawable.laranja, R.drawable.amarela, R.drawable.vermelha, R.drawable.azul,
            R.drawable.verde, R.drawable.laranja, R.drawable.amarela, R.drawable.vermelha, R.drawable.verde,
            R.drawable.azul, R.drawable.vermelha, R.drawable.laranja, R.drawable.amarela, R.drawable.verde,
            R.drawable.azul, R.drawable.verde, R.drawable.amarela, R.drawable.laranja, R.drawable.azul
    };

    int i = 0;
    int ccam = 0;
    int ccvr = 0;
    int ccve = 0;
    int ccaz = 0;
    int ccl = 0;
    int Total = 0;
    boolean resulatado = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);


        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final ImageView image3 = (ImageView) findViewById(R.id.image3);
        final ImageView image4 = (ImageView) findViewById(R.id.image4);
        final ImageView image5 = (ImageView) findViewById(R.id.image5);

        final TextView Score = (TextView) findViewById(R.id.Score);
        final TextView Score1 = (TextView) findViewById(R.id.Score1);
        final TextView Score2 = (TextView) findViewById(R.id.Score2);
        final TextView Score3 = (TextView) findViewById(R.id.Score3);
        final TextView Score4 = (TextView) findViewById(R.id.Score4);
        final TextView Score_Tot = (TextView) findViewById(R.id.Score_Tot);

        final Button botao1 = (Button) findViewById(R.id.botao1);
        final Button botao2 = (Button) findViewById(R.id.botao2);
        final Button botao3 = (Button) findViewById(R.id.botao3);
        final Button botao4 = (Button) findViewById(R.id.botao4);
        final Button botao5 = (Button) findViewById(R.id.botao5);
        final Button entrar = (Button) findViewById(R.id.btn_cadastrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(in);
            }
        });

        //Fim do botão 1
        //======================//======================//===================//
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setImageResource(figuras[ccaz]);
                i++;
                ccaz++;
                combinarPortas();
                gameOver();
                Score.setText("" + ccaz);
                Score_Tot.setText("" + Total);
                if (i == figuras.length) {
                    i = 0;
                    ccaz = 0;
                }
                if (Total == 5) {
                    image1.setImageResource(R.drawable.comb1);
                    image2.setImageResource(R.drawable.comb2);
                    image3.setImageResource(R.drawable.comb3);
                    image4.setImageResource(R.drawable.comb4);
                    image5.setImageResource(R.drawable.comb5);
                    Toast.makeText(Tela2Activity.this,"Sucesso ",Toast.LENGTH_LONG).show();
                }

            }
        });
        // Inico do botao verde 2

        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image2.setImageResource(figuras[i]);
                i++;
                ccve++;
                Score1.setText("" + ccve);
                Score_Tot.setText("" + Total);
                combinarPortas();
                gameOver();
                if (i == figuras.length) {
                    i = 0;
                    ccve = 0;
                }
                if (Total == 5) {
                    image1.setImageResource(R.drawable.comb1);
                    image2.setImageResource(R.drawable.comb2);
                    image3.setImageResource(R.drawable.comb3);
                    image4.setImageResource(R.drawable.comb4);
                    image5.setImageResource(R.drawable.comb5);
                    Toast.makeText(Tela2Activity.this,"Sucesso ",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Fim do botão 2
        //======================//======================//===================//
        // Inico do botao 3
        botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image3.setImageResource(figuras[ccam]);
                i++;
                ccam++;
                gameOver();
                combinarPortas();
                Score_Tot.setText("" + Total);
                Score2.setText("" + ccam);
                if (i == figuras.length) {
                    i = 0;
                    ccam = 0;
                }
                if (Total == 5) {
                    image1.setImageResource(R.drawable.comb1);
                    image2.setImageResource(R.drawable.comb2);
                    image3.setImageResource(R.drawable.comb3);
                    image4.setImageResource(R.drawable.comb4);
                    image5.setImageResource(R.drawable.comb5);
                    Toast.makeText(Tela2Activity.this,"Sucesso ",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Fim do botão 3
        //======================//======================//===================//
        // Inico do botao 4
        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image4.setImageResource(figuras[ccl]);
                i++;
                ccl++;
                gameOver();
                combinarPortas();
                Score3.setText("" + ccl);
                Score_Tot.setText("" + Total);
                if (i == figuras.length) {
                    i = 0;
                    ccl = 0;
                }
                if (Total == 5) {
                    image1.setImageResource(R.drawable.comb1);
                    image2.setImageResource(R.drawable.comb2);
                    image3.setImageResource(R.drawable.comb3);
                    image4.setImageResource(R.drawable.comb4);
                    image5.setImageResource(R.drawable.comb5);
                    Toast.makeText(Tela2Activity.this,"Sucesso ",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Fim do botão 4
        //======================//======================//===================//

        // Inico do botao 5

        botao5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image5.setImageResource(figuras[ccvr]);
                i++;
                ccvr++;
                gameOver();
                combinarPortas();
                Score4.setText("" + ccvr);
                Score_Tot.setText("" + Total);
                if (i == figuras.length) {
                    i = 0;
                    ccvr = 0;
                }
                if (Total == 5) {
                    image1.setImageResource(R.drawable.comb1);
                    image2.setImageResource(R.drawable.comb2);
                    image3.setImageResource(R.drawable.comb3);
                    image4.setImageResource(R.drawable.comb4);
                    image5.setImageResource(R.drawable.comb5);
                    Toast.makeText(Tela2Activity.this,"Sucesso ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void combinarPortas() {


        if (ccaz == 10 && ccve == 10 && ccam == 10 && ccl == 10 && ccvr == 5) {
            Toast.makeText(Tela2Activity.this, "Azul Ok", Toast.LENGTH_SHORT).show();
            Total++;

        } else if (ccaz == 4 && ccve == 4 && ccam == 4 && ccl == 4 && ccvr == 4) {
            Toast.makeText(Tela2Activity.this, "Verde Ok", Toast.LENGTH_SHORT).show();
            Total++;
        } else if (ccve == 2 && ccaz == 2 && ccvr == 2 && ccl == 2) {
            Toast.makeText(Tela2Activity.this, "AmareloOk", Toast.LENGTH_SHORT).show();
            Total++;

        } else if (ccaz == 7 && ccve == 7 && ccam == 7 && ccl == 7 && ccvr == 7) {
            Toast.makeText(Tela2Activity.this, "Laranja Ok", Toast.LENGTH_SHORT).show();
            Total++;
        } else if (ccaz == 3 && ccve == 3 && ccam == 3 && ccl == 3 && ccvr == 3) {
            Toast.makeText(Tela2Activity.this, "Vermelho Ok", Toast.LENGTH_SHORT).show();
            Total++;
        } else
            Toast.makeText(Tela2Activity.this, "Continue Tentando", Toast.LENGTH_SHORT).show();
    }


        public void gameOver(){

            if (i>=35 || ccaz==25 || ccve==25 || ccl==25||ccam==25||ccvr==25){
                ccaz=0; ccve=0; ccl=0;ccam=0;ccvr=0;
                   Intent intent = new Intent(getApplicationContext(), GameOver.class);
                   intent.putExtra("Score",i);
                   startActivity(intent);

                }
            }
        }


















