package co.edu.usbbog.swm.view;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.helperclasses.HelperDB;

public class especificaciones_ingresos extends AppCompatActivity {

    TextView viewIngresos;
    Button btnGfijos;
    BottomSheetDialog gastosFijosDialog;
    TextInputLayout txtLayoutPeriodo, txtLayoutValor;
    EditText edtGFijo, edtPeriodo, edtValor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_especificaciones_ingresos);

        viewIngresos = findViewById(R.id.viewIngresos);
        btnGfijos = findViewById(R.id.btnGFijos);

         edtGFijo = findViewById(R.id.edtGFijo);
         edtPeriodo = findViewById(R.id.edtPeriodo);
         edtValor = findViewById(R.id.edtValor);

         txtLayoutPeriodo = findViewById(R.id.txtLayoutPeriodo);
         txtLayoutValor = findViewById(R.id.txtLayoutValor);

        gastosFijosDialog = new BottomSheetDialog(this);
        //INFLATE VIEW
        onCreateDialog();

        btnGfijos.setOnClickListener((View v) -> {
            gastosFijosDialog.show();
        });

        gastosFijosDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

    }


    private void onCreateDialog(){
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null, false);
        Button btnInsert = view.findViewById(R.id.btnIndicarGasto);
        TextInputLayout layout = view.findViewById(R.id.txtLayoutFijos);
        //EditText edtGFijo = view.findViewById(R.id.edtGFijo);

        btnInsert.setOnClickListener((View view1)->{
            gastosFijosDialog.dismiss();
            //Toast.makeText(especificaciones_ingresos.this, edtGFijo.getText().toString(), Toast.LENGTH_SHORT);
            register();
            Intent i = new Intent(especificaciones_ingresos.this, ShowMExpenses.class);
            startActivity(i);
        });

        gastosFijosDialog.setContentView(view);

    }


    /*private void showData(){
        DatabaseHelper cData = new DatabaseHelper(this);
        cData.open();
        ArrayList<Clasificacion> list = cData.getClasificacion();
        cData.close();
        for(Clasificacion c: list){
            Log.i("CLAS", String.valueOf(c.getId()));
            Log.i("CLAS", c.getTipo());
            Log.i("CLAS", c.getPeriodo());
            Log.i("CLAS", c.getValor());
            
        }
    }*/

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

    }

}