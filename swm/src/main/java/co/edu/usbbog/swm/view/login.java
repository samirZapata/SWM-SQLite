package co.edu.usbbog.swm.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.model.Model;
import co.edu.usbbog.swm.model.Usuarios;

public class login extends AppCompatActivity {

    EditText edtUser, edtPass;
    Button btnLogin, btnRegister;
    Intent j;

    Usuarios dto = new Usuarios();
    Model obj = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);


        btnLogin.setOnClickListener(view -> {
            login();
            Intent i = new Intent(login.this, Income.class);
            /*CharSequence text = "Bienvenido";
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            toast.show();*/
            startActivity(i);
            finish();
        });

        btnRegister.setOnClickListener(view -> {
            j = new Intent(login.this, singup.class);
            startActivity(j);
        });
    }

    private void login() {
        String usr = edtUser.getText().toString();
        String pass = edtPass.getText().toString();

        dto.getUsuario();
        dto.getClave();
        try {
            Cursor cursor = obj.login(this, usr, pass);

            if (cursor.getCount() > 0) {
                Toast.makeText(this, "Si :)", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "No :(", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        //String u = obj.login(this, usr,pass);

    }

}