package autonoma.pe.practice.semana07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class CalculoNotasActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvPromedio, tvCondicion;
    EditText etName, etNota1, etNota2, etNota3, etNota4;
    Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_notas);

        ActionBarUtils.setCustomTitle(
                this,
                "CALCULADORA DE NOTAS",
                ""
        );

        tvPromedio = findViewById(R.id.tvPromedio);
        tvCondicion = findViewById(R.id.tvCondicion);
        etName = findViewById(R.id.etName);
        etNota1 = findViewById(R.id.etNota1);
        etNota2 = findViewById(R.id.etNota2);
        etNota3 = findViewById(R.id.etNota3);
        etNota4 = findViewById(R.id.etNota4);
        btnProcesar = findViewById(R.id.btnProcesar);

        btnProcesar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnProcesar) {
            // Obtener el nombre ingresado
            String nombreAlumno = etName.getText().toString();

            // Obtener las notas ingresadas
            double nota1 = Double.parseDouble(etNota1.getText().toString());
            double nota2 = Double.parseDouble(etNota2.getText().toString());
            double nota3 = Double.parseDouble(etNota3.getText().toString());
            double nota4 = Double.parseDouble(etNota4.getText().toString());

            // Calcular el promedio
            double promedio = (nota1 + nota2 + nota3 + nota4) / 4;

            // Mostrar el promedio en tvPromedio con el nombre del alumno
            tvPromedio.setText("El promedio del alumno "+ nombreAlumno + " es: "+ promedio);

            // Determinar la condición (aprobado o desaprobado)
            String condicion = (promedio >= 10.5) ? "Aprobado" : "Desaprobado";

            // Mostrar la condición en tvCondicion
            tvCondicion.setText("El alumno " + nombreAlumno + " ha sido " + condicion);
        }
    }
}