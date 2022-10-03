package co.edu.usbbog.swm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import co.edu.usbbog.swm.R;

public class login extends AppCompatActivity {

    Button btnLogin, btnRegister;
    Intent j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);


        btnLogin.setOnClickListener(view -> {
            Intent i = new Intent(login.this, Income.class);
            CharSequence text = "Bienvenido";
            Toast toast =  Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            toast.show();
            startActivity(i);
            finish();
        });

        btnRegister.setOnClickListener(view -> {
          j = new Intent(login.this, singup.class);
            startActivity(j);
        });
    }


}