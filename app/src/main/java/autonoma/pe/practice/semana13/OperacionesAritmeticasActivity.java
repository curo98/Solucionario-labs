package autonoma.pe.practice.semana13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class OperacionesAritmeticasActivity extends AppCompatActivity implements View.OnClickListener  {
    EditText edtN1, edtN2;
    TextView tvResultado;
    Button btnSuma, btnResta, btnMultiplicacion, btnDivision,btnLimpiar;
    Double n1,n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones_aritmeticas);

        ActionBarUtils.setCustomTitle(
                this,
                "Operaciones aritmeticas",
                ""
        );

        edtN1 = findViewById(R.id.edtN1);
        edtN2 = findViewById(R.id.edtN2);
        tvResultado = findViewById(R.id.tvResultado);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);
        btnLimpiar= findViewById(R.id.btnlimpiar);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMultiplicacion.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        n1=Double.parseDouble(edtN1.getText().toString());
        n2=Double.parseDouble(edtN2.getText().toString());
        if(v == btnSuma){
            tvResultado.setText(n1+n2+"");
        }
        if(v == btnResta){
            tvResultado.setText(n1-n2+"");
        }
        if(v == btnMultiplicacion){
            tvResultado.setText(n1*n2+"");
        }
        if(v == btnDivision){
            tvResultado.setText(n1 / n2+"");
        }
        if(v == btnLimpiar){
            edtN1.setText("");
            edtN2.setText("");
            tvResultado.setText("");
            tvResultado.setText("");
        }
    }
}