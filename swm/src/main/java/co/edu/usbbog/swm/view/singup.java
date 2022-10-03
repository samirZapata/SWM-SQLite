package co.edu.usbbog.swm.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.model.Usuarios;

public class singup extends AppCompatActivity {


    EditText edtNombre, edtTelefono, edtEmail, edtUsuario, edtClave;
    Button btnRegistrar, btnIniSesion;

    Usuarios dto = new Usuarios();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnIniSesion = (Button) findViewById(R.id.btnIniSesion);
        edtNombre = findViewById(R.id.edtName);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtEmail = findViewById(R.id.edtMail);
        edtUsuario = findViewById(R.id.edtUser);
        edtClave = findViewById(R.id.edtPass);


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

    private void userEntry(){
        String nombre = edtNombre.getText().toString();
        String telefono = edtTelefono.getText().toString();
        String  email = edtEmail.getText().toString();
        String usuario = edtUsuario.getText().toString();
        String clave = edtClave.getText().toString();

        dto.setNombre(nombre);
        dto.setTelefono(telefono);
        dto.setEmail(email);
        dto.setUsuario(usuario);
        dto.setClave(clave);


    }

}