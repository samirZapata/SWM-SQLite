package co.edu.usbbog.swm.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.usbbog.swm.R;

public class ShowMExpenses extends AppCompatActivity {

    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_mexpenses);

        temp = findViewById(R.id.temp);

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String item = intent.getStringExtra("data");
            temp.setText(item);
        }
    }
}