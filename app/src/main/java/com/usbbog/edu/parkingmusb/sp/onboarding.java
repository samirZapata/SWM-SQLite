package com.usbbog.edu.parkingmusb.sp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.usbbog.edu.parkingmusb.sp.HelperClasses.SliderAdapter;

public class onboarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button empezar;
    Animation btnAnimated;

    int cPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_onboarding);

        //Hooks
        viewPager = (ViewPager) findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        empezar = findViewById(R.id.btnStart);


        //Call adapter
        sliderAdapter = new SliderAdapter(this);
        addDots(0);
        viewPager.addOnPageChangeListener(onPageChangeListener);

        viewPager.setAdapter(sliderAdapter);

        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(onboarding.this, login.class);
                startActivity(i);
                finish();
            }
        });
    }


    public void next (View view){
        viewPager.setCurrentItem(cPosition + 1);
    }

    private void addDots(int position){

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0){
            dots[position].setTextColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary_dark));
        }

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            cPosition = position;
            if (position == 0){
                empezar.setVisibility(View.INVISIBLE);
            }else if(position == 1){
                empezar.setVisibility(View.INVISIBLE);
            }else if(position == 2){
                btnAnimated = AnimationUtils.loadAnimation(onboarding.this, R.anim.btn_animation);
                empezar.setAnimation(btnAnimated);
                empezar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}