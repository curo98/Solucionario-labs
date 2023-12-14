package autonoma.pe.practice.semana07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class MultiplicacionActivity extends AppCompatActivity {

    EditText etVal1, etVal2;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion);

        ActionBarUtils.setCustomTitle(
                this,
                "CALCULO - MULTIPLICACION",
                ""
        );

        etVal1 = findViewById(R.id.etVal1);
        etVal2 = findViewById(R.id.etVal2);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplicar();
            }
        });
    }

    private void multiplicar() {
        String val1Str = etVal1.getText().toString();
        String val2Str = etVal2.getText().toString();

        if (!val1Str.isEmpty() && !val2Str.isEmpty()) {
            double val1 = Double.parseDouble(val1Str);
            double val2 = Double.parseDouble(val2Str);

            double resultado = val1 * val2;

            Toast.makeText(getApplicationContext(), "El resultado de la multiplicación es: " + resultado, Toast.LENGTH_SHORT).show();
        } else {
            // Handle empty input fields
            Toast.makeText(getApplicationContext(), "Ingrese ambos valores", Toast.LENGTH_SHORT).show();
        }
    }
}