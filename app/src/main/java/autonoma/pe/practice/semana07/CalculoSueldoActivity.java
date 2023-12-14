package autonoma.pe.practice.semana07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class CalculoSueldoActivity extends AppCompatActivity {
    EditText etApellido,etDiasTrab,etSueldo;
    TextView tvResultado;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_sueldo);

        ActionBarUtils.setCustomTitle(
                this,
                "CALCULO DE SUELDO V1.0",
                ""
        );

        etApellido=findViewById(R.id.etApellido);
        etDiasTrab=findViewById(R.id.etDiasTrab);
        etSueldo=findViewById(R.id.etSueldo);
        btnCalcular=findViewById(R.id.btnCalcular);
        tvResultado=findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ape=etApellido.getText().toString();
                double dias=Double.parseDouble(etDiasTrab.getText().toString());
                double sueldo=Double.parseDouble(etSueldo.getText().toString());
                double imp=sueldo/30*dias;
                double bnf1=sueldo*0.10;
                double bnf2=sueldo*0.15;
                double resu=imp+bnf1+bnf2;
                String mensaje="El total es "+resu;
                tvResultado.setText("El total de "+ape+" es: "+resu);
                Toast toast = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }
}