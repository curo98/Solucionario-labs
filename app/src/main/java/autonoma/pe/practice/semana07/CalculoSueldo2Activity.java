package autonoma.pe.practice.semana07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class CalculoSueldo2Activity extends AppCompatActivity {

    EditText etApellido, etDiasTrab;
    TextView tvResultado;
    Spinner spCargos;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_sueldo2);

        ActionBarUtils.setCustomTitle(
                this,
                "CALCULO DE SUELDO V2.0",
                ""
        );

        etApellido = findViewById(R.id.etApellido);
        etDiasTrab = findViewById(R.id.etDiasTrab);
        spCargos = findViewById(R.id.spCargos);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ape = etApellido.getText().toString();
                double dias = Double.parseDouble(etDiasTrab.getText().toString());
                double sueldo = 0;  // Initialize sueldo variable

                // Determine sueldo based on selected cargo
                String selectedCargo = spCargos.getSelectedItem().toString();
                switch (selectedCargo) {
                    case "Analista":
                        sueldo = 4500;
                        break;
                    case "Programador":
                        sueldo = 3500;
                        break;
                    case "Técnico":
                        sueldo = 2500;
                        break;
                    case "Auxiliar":
                        sueldo = 1500;
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Seleccione un cargo válido", Toast.LENGTH_SHORT).show();
                        return;
                }

                double imp = sueldo / 30 * dias;
                double bnf1 = sueldo * 0.10;
                double bnf2 = sueldo * 0.15;
                double resu = imp + bnf1 + bnf2;
                String mensaje = "El total es " + resu;
                tvResultado.setText("El total de " + ape + " es: " + resu);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}