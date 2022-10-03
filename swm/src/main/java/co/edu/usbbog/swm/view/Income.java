package co.edu.usbbog.swm.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.model.Ingresos;
import co.edu.usbbog.swm.model.Model;

public class Income extends AppCompatActivity {

    EditText edtIncome;
    Button btnIndicar;
    Ingresos dto = new Ingresos();
    Model obj = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_income);
        btnIndicar = findViewById(R.id.btnIndicar);

        edtIncome = findViewById(R.id.edtIngresos);

        btnIndicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String incomeValue = edtIncome.getText().toString();
                income(incomeValue);

                Intent i = new Intent(Income.this, especificaciones_ingresos.class);
                i.putExtra("value", obj.queryIncome(Income.this, dto));
                startActivity(i);
            }
        });
    }

    private void income(String value) {

        dto.setIngresos(value);
        int resInsert = obj.insertIncome(this, dto);
        if (resInsert == 1) {
            Toast.makeText(this, "OK :)", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "AUCH :(", Toast.LENGTH_SHORT).show();
        }

    }

}