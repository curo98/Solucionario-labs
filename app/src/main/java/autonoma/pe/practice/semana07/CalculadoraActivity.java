package autonoma.pe.practice.semana07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class CalculadoraActivity extends AppCompatActivity {
    EditText etVal1, etVal2;
    RadioButton rbSum, rbRes, rbMul, rbDiv;
    Button btnCalcular;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        ActionBarUtils.setCustomTitle(
                this,
                "CALCULADORA",
                ""
        );

        etVal1 = findViewById(R.id.etVal1);
        etVal2 = findViewById(R.id.etVal2);
        rbSum = findViewById(R.id.rbSum);
        rbRes = findViewById(R.id.rbRes);
        rbMul = findViewById(R.id.rbMult);
        rbDiv = findViewById(R.id.rbDiv);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultado=0;

                if (rbSum.isChecked()){
                    resultado = Double.parseDouble(etVal1.getText().toString()) + Double.parseDouble(etVal2.getText().toString());
                }
                if (rbRes.isChecked()){
                    resultado = Double.parseDouble(etVal1.getText().toString()) - Double.parseDouble(etVal2.getText().toString());
                }
                if (rbMul.isChecked()){
                    resultado = Double.parseDouble(etVal1.getText().toString()) * Double.parseDouble(etVal2.getText().toString());
                }
                if (rbDiv.isChecked()){
                    resultado = Double.parseDouble(etVal1.getText().toString()) / Double.parseDouble(etVal2.getText().toString());
                }
                tvResultado.setText("El resultado es: " + resultado);
            }
        });



    }
}