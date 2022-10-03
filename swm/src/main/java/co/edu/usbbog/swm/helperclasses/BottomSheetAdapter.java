package co.edu.usbbog.swm.helperclasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import co.edu.usbbog.swm.R;
import co.edu.usbbog.swm.model.Clasificacion;
import co.edu.usbbog.swm.model.Model;
import co.edu.usbbog.swm.view.ShowMExpenses;

public class BottomSheetAdapter extends BottomSheetDialogFragment {

    EditText edtGFijo, edtPeriodo, edtValor;
    Button btnInsert;
    Model obj = new Model();
    Clasificacion dto = new Clasificacion();

    public BottomSheetAdapter() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.bottom_sheet, container, false);

        btnInsert = view.findViewById(R.id.btnIndicarGasto);
        edtGFijo = view.findViewById(R.id.edtGFijo);
        edtPeriodo = view.findViewById(R.id.edtPeriodo);
        edtValor = view.findViewById(R.id.edtValor);

        btnInsert.setOnClickListener((View view1)->{
            String type = edtGFijo.getText().toString();
            String range = edtPeriodo.getText().toString();
            String value = edtValor.getText().toString();

            ifs(type, range, value);

            Intent i = new Intent(getContext(), ShowMExpenses.class);
            i.putExtra("data", obj.queryClasification(getContext(), dto));
            startActivity(i);
        });

        return view;
    }

    private void ifs(String type, String range, String value) {
        //SEND VALUES TO DTO
        //dto.setId();
        dto.setTipo(type);
        dto.setPeriodo(range);
        dto.setValor(value);
        int resInsert = obj.insertClasification(getContext(), dto);
        if (resInsert == 1) {
            Toast.makeText(getContext(), "OK :)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "EFE :(", Toast.LENGTH_SHORT).show();
        }

    }
}
