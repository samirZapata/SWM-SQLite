package com.usbbog.edu.parkingmusb.sp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.usbbog.edu.parkingmusb.sp.R;
import com.usbbog.edu.parkingmusb.sp.helperclasses.swmHelper;
import com.usbbog.edu.parkingmusb.sp.model.clasificacion;

import java.util.ArrayList;

public class especificaciones_ingresos extends AppCompatActivity {

    TextView viewIngresos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_especificaciones_ingresos);

        viewIngresos = findViewById(R.id.viewIngresos);


        this.showData();

    }


    private void showData(){
        swmHelper cData = new swmHelper(this);
        cData.open();
        ArrayList<clasificacion> list = cData.getClasificacion();
        cData.close();
        for(clasificacion c: list){
            Log.i("CLAS", String.valueOf(c.getId()));
            Log.i("CLAS", c.getTipo());
            Log.i("CLAS", c.getPeriodo());
            Log.i("CLAS", c.getValor());
            
        }
    }

}