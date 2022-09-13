package co.edu.usbbog.swm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.helperclasses.SwmHelper;
import co.edu.usbbog.swm.model.Clasificacion;

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
        SwmHelper cData = new SwmHelper(this);
        cData.open();
        ArrayList<Clasificacion> list = cData.getClasificacion();
        cData.close();
        for(Clasificacion c: list){
            Log.i("CLAS", String.valueOf(c.getId()));
            Log.i("CLAS", c.getTipo());
            Log.i("CLAS", c.getPeriodo());
            Log.i("CLAS", c.getValor());
            
        }
    }

}