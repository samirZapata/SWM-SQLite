package com.usbbog.edu.parkingmusb.sp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.usbbog.edu.parkingmusb.sp.R;

public class splash_screen extends AppCompatActivity {

    private final static int SPLASH_SCREEN = 3000;

    //VARIABLES
    Animation topAnim, bottomAnim;

    ImageView bot;
    TextView viewFirst, viewSecond;

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //ANIMATION
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        bot = findViewById(R.id.imgBot);
        viewFirst = findViewById(R.id.TVfirts);
        viewSecond = findViewById(R.id.TVsecond);

        bot.setAnimation(topAnim);
        viewFirst.setAnimation(bottomAnim);
        viewSecond.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //CONDICIONES DE ONBOARDING POR SI EL USUARIO ES NUEVO O VIEJO
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);
                if (isFirstTime){

                    SharedPreferences.Editor editor = onBoardingScreen.edit(); //PERMITIR QUE LAS PREFERENCIAS COMPARTIDAS CAMBIEN EL ESTADO DE SUS VARIABLES
                    editor.putBoolean("firstTime",false);
                    editor.commit(); //CONFIRMAR CAMBIOS

                    Intent i = new Intent(splash_screen.this, onboarding.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(splash_screen.this, login.class);
                    startActivity(i);
                    finish();
                }


            }
        },SPLASH_SCREEN);

    }
}