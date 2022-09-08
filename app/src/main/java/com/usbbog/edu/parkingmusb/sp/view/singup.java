package com.usbbog.edu.parkingmusb.sp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.usbbog.edu.parkingmusb.sp.R;

public class singup extends AppCompatActivity {
    Button btnRegistrar, btnIniSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnIniSesion = (Button) findViewById(R.id.btnIniSesion);


        btnRegistrar.setOnClickListener(view -> {
            Intent i = new Intent(singup.this, login.class);
            startActivity(i);
            //finish();
        });

        btnIniSesion.setOnClickListener(view -> {
            Intent j = new Intent(singup.this, login.class);
            startActivity(j);
            finish();
        });

    }
}