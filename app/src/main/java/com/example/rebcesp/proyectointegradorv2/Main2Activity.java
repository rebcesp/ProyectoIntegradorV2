package com.example.rebcesp.proyectointegradorv2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

        Button btnSignIn,btnSignUp;
//        TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);


//        txtInfo = (TextView)findViewById(R.id.txtInfo);
//
//        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/NABILA.TTF");
//        txtInfo.setTypeface(face);



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp = new Intent(Main2Activity.this, com.example.rebcesp.proyectointegradorv2.SignUp.class);
                startActivity(SignUp);

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignIn = new Intent(Main2Activity.this, com.example.rebcesp.proyectointegradorv2.SignIn.class);
                startActivity(SignIn);

            }
        });
    }
}
