package autonoma.pe.practice.semana07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class TodoBaratoActivity extends AppCompatActivity {

    EditText etImporte;
    Button btnCalcular, btnLimpiar;
    TextView tvImporte, tvImpuesto, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_barato);

        ActionBarUtils.setCustomTitle(
                this,
                "APP - TOPO BARATO",
                ""
        );

        etImporte = findViewById(R.id.etImporte);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        tvImporte = findViewById(R.id.tvImporte);
        tvImpuesto = findViewById(R.id.tvImpuesto);
        tvTotal = findViewById(R.id.tvTotal);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPedido();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });
    }

    private void calcularPedido() {
        if (etImporte.getText().toString().isEmpty()) {
            // Handle the case where importe is not provided
            return;
        }

        double importe = Double.parseDouble(etImporte.getText().toString());
        double impuesto = calcularImpuesto(importe);
        double total = importe + impuesto;

        mostrarResultados(importe, impuesto, total);
    }

    private double calcularImpuesto(double importe) {
        // Impuesto es el 18% del importe del pedido
        return 0.18 * importe;
    }

    private void mostrarResultados(double importe, double impuesto, double total) {
        tvImporte.setText("Importe: " + importe);
        tvImpuesto.setText("Impuesto: " + impuesto);
        tvTotal.setText("Total: " + total);
    }

    private void limpiarCampos() {
        etImporte.setText("");
        tvImporte.setText("Importe:");
        tvImpuesto.setText("Impuesto:");
        tvTotal.setText("Total:");
    }
}