package co.edu.usbbog.swm.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.model.Model;
import co.edu.usbbog.swm.model.Usuarios;

public class singup extends AppCompatActivity {


    EditText edtNombre, edtTelefono, edtEmail, edtUsuario, edtClave;
    Button btnRegistrar, btnIniSesion;
    TextView txtMsj;
    ImageView img;

    Usuarios dto = new Usuarios();
    Model obj = new Model();

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
        txtMsj = findViewById(R.id.txtMsj);
        img = findViewById(R.id.img);


        //TOAST
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout));
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);



        btnRegistrar.setOnClickListener(view -> {
            //toast.show();
            String nombre = edtNombre.getText().toString();
            String telefono = edtTelefono.getText().toString();
            String email = edtEmail.getText().toString();
            String usuario = edtUsuario.getText().toString();
            String clave = edtClave.getText().toString();

            Intent i = new Intent(singup.this, login.class);

            userEntry(nombre, telefono, email, usuario, clave);
            startActivity(i);
            //finish();
        });

        btnIniSesion.setOnClickListener(view -> {
            Intent j = new Intent(singup.this, login.class);
            startActivity(j);
            finish();
        });

    }

    private void userEntry(String nombre, String telefono, String email, String usuario, String clave) {

        dto.setNombre(nombre);
        dto.setTelefono(telefono);
        dto.setEmail(email);
        dto.setUsuario(usuario);
        dto.setClave(clave);

        Log.i("DATA", nombre);
        Log.i("DATA", telefono);
        Log.i("DATA", email);
        Log.i("DATA", usuario);
        Log.i("DATA", clave);

        int resInsert = obj.registerUser(this, dto);
        if (resInsert == 1){
            Toast.makeText(this, "OK :)", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "NEL :(", Toast.LENGTH_SHORT).show();
        }

    }

}