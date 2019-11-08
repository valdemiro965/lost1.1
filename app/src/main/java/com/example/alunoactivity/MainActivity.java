package com.example.alunoactivity;



import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final int Timer_Runnable = 9000;
    private ImageView imagePrincipal;
    private TextView texto;
    private ProgressBar mprogress;
    int timer = 0;
    MediaPlayer suspense;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //================//=======================//==================//====
        imagePrincipal = (ImageView) findViewById(R.id.imagePrincipal);
        texto = (TextView) findViewById(R.id.texto);
        mprogress = (ProgressBar) findViewById(R.id.barrinha);
        suspense = MediaPlayer.create(MainActivity.this, R.raw.supense);
        updatePlay();
        //==============//======================//================//========

        Thread th = new Thread() {

            @Override
            public void run() {
                try {

                    for (timer = 0; timer < 1; timer++) {

                        int waited = 0;
                        while (waited < Timer_Runnable) {

                            try {

                                Thread.sleep(200);
                                waited += 200;
                                updateProgress(waited);


                            } catch (Exception e) {
                            }

                            if ((waited == Timer_Runnable) ) {

                                pararSuspense();
                                waited=100000;
                                Intent intent = new Intent(getApplicationContext(), Tela2Activity.class);
                                startActivity(intent);
                            }
                        }

                    }

                } catch(Exception e) {

                    e.printStackTrace();
                }
            }
        };
        th.start();

    }

    public void updateProgress(final int timerPassed) {

        if (null != mprogress) {
            final int progress = mprogress.getMax() * timerPassed / Timer_Runnable;
            mprogress.setProgress(progress);
        }
    }
    public void pararSuspense(){
        if (suspense!=null) {
            suspense.release();
            suspense = null;
        }
    }

    public  void updatePlay(){
        suspense.start();
        suspense.setLooping(true);


    }
    @Override
    protected void onStop() {
        super.onStop();
        pararSuspense();
    }

}



