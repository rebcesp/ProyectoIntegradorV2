package com.example.rebcesp.proyectointegradorv2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ImageView logo; //Declaramos la imagen del logo
    TextView hakana;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logo = (ImageView) findViewById(R.id.logoSplash);
        hakana = (TextView)findViewById(R.id.txtSlogan);


        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);

        //Iniciamos la imagen Animada
        logo.startAnimation(myanim);
        hakana.startAnimation(myanim);

        // final Intent i = new Intent(this,Main2Activity.class); //Iniciamos la segunda activity


    openApp(true); //Lallamos al metodo para el Splash
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);


    }
}



