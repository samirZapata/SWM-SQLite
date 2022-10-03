package co.edu.usbbog.swm.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.helperclasses.BottomSheetAdapter;

public class especificaciones_ingresos extends AppCompatActivity {

    TextView viewIngresos;
    Button btnGfijos, btnGVariables;
    BottomSheetDialog gastosFijosDialog;
    TextInputLayout txtLayoutPeriodo, txtLayoutValor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_especificaciones_ingresos);

        viewIngresos = findViewById(R.id.viewIngresos);
        btnGfijos = findViewById(R.id.btnGFijos);
        btnGVariables = findViewById(R.id.btnGVariables);

        txtLayoutPeriodo = findViewById(R.id.txtLayoutPeriodo);
        txtLayoutValor = findViewById(R.id.txtLayoutValor);

        //SHOW INCOME
        reciveIncome();
        //INFLATE BottomSheetDialog
        btnGfijos.setOnClickListener(v -> new BottomSheetAdapter().show(getSupportFragmentManager(), "Show"));
        //END INFLATE VIEW BottomSheetDialog
    }

    /*
    public void register(){
        HelperDB dbHelper = new HelperDB(this, "swm", null, 1);
        //OPEN DB IN WRITE N' READ MODE
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //DATA MANIPULATION
        String edtTipo = edtGFijo.getText().toString();
        String edtDate = edtPeriodo.getText().toString();
        String edtVal = edtValor.getText().toString();

        //INPUT VALIDATION
        if (!edtVal.isEmpty()){
            ContentValues reg = new ContentValues();

            //SETEAR DATA A LA DB
            reg.put("tipo", edtTipo);
            reg.put("periodo", edtDate);
            reg.put("valor", edtVal);

            //INSERT INTO TABLE
            db.insert("clasificacion", null, reg);
            db.close();
            edtGFijo.setText("");
            edtPeriodo.setText("");
            edtValor.setText("");

            Toast.makeText(especificaciones_ingresos.this, "Se agregó un gasto obligatorio", Toast.LENGTH_SHORT).show();
        }else{
            txtLayoutValor.setError("Llenar todos los campos");

        }

    }


    //DELETE
    public void Delete(View view){
        HelperDB dbHelperDelete = new HelperDB(this, "swm",null,1);
        SQLiteDatabase dbD = dbHelperDelete.getWritableDatabase();

        //1. IDENTIFY KEY TO DELETE ITEM
        String periodoKey = edtPeriodo.getText().toString();
        if (!periodoKey.isEmpty()){
            int periodoDel = dbD.delete("clasificacion", "periodo=" + periodoKey, null);
            dbD.close();

            if(periodoDel == 1){
                Toast.makeText(especificaciones_ingresos.this, "Se eliminó el gasto correctamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(especificaciones_ingresos.this, "El gasto no ha sido creado aún", Toast.LENGTH_SHORT).show();
            }
        }else{
            txtLayoutPeriodo.setError("Llenar todos los campos");
        }

    }

    //MODIFY
    public void modify(View view){
        HelperDB dbHelperMod = new HelperDB(this, "swm",null,1);
        SQLiteDatabase dbM = dbHelperMod.getWritableDatabase();

        String concetp = edtGFijo.getText().toString();
        String period = edtPeriodo.getText().toString();
        String val = edtValor.getText().toString();

        if(!period.isEmpty() && !val.isEmpty() ){

            ContentValues register = new ContentValues();
            register.put("concepto", concetp);
            register.put("periodo", period);
            register.put("valor", val);

            int count = dbM.update("clasificacion", register, "periodo=" + period,null);
            dbM.close();

            if(count == 1){
                Toast.makeText(especificaciones_ingresos.this, "Se modificó el gasto correctamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(especificaciones_ingresos.this, "El gasto no ha sido creado aún", Toast.LENGTH_SHORT).show();
            }
        }else{
            txtLayoutPeriodo.setError("Llenar todos los campos");
            txtLayoutValor.setError("Llenar todos los campos");
        }

    }*/

    private void reciveIncome(){
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            String item = intent.getStringExtra("value");
            viewIngresos.setText(item);
        }
    }

}