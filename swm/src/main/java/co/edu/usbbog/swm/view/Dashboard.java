package co.edu.usbbog.swm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import co.edu.usbbog.swm.R;

public class Dashboard extends AppCompatActivity {
Button btnIndicar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        btnIndicar = findViewById(R.id.btnIndicar);


        btnIndicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, especificaciones_ingresos.class);
                startActivity(i);

            }
        });
    }
}