package autonoma.pe.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import autonoma.pe.practice.semana07.CalculadoraActivity;
import autonoma.pe.practice.semana07.CalculoNotasActivity;
import autonoma.pe.practice.semana07.CalculoSueldo2Activity;
import autonoma.pe.practice.semana07.CalculoSueldoActivity;
import autonoma.pe.practice.semana07.MultiplicacionActivity;
import autonoma.pe.practice.semana07.TodoBaratoActivity;
import autonoma.pe.practice.utils.ActionBarUtils;

public class EjerciciosSem7Activity extends AppCompatActivity {

    Button btnAppCalculoNotas, btnCalculadora, btnAppCalculoSueldo, btnAppCalculoSueldo2, btnAppTodoBarato, btnAppMultiplicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_sem7);

        ActionBarUtils.setCustomTitle(
                this,
                "EJERCICIOS - SEMANA 07",
                ""
        );

        btnAppCalculoNotas = findViewById(R.id.btnAppCalculoNotas);
        btnCalculadora = findViewById(R.id.btnCalculadora);
        btnAppCalculoSueldo = findViewById(R.id.btnAppCalculoSueldo);
        btnAppCalculoSueldo2 = findViewById(R.id.btnAppCalculoSueldo2);
        btnAppTodoBarato = findViewById(R.id.btnAppTodoBarato);
        btnAppMultiplicacion = findViewById(R.id.btnAppMultiplicacion);

        btnAppCalculoNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjerciciosSem7Activity.this, CalculoNotasActivity.class));
            }
        });

        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjerciciosSem7Activity.this, CalculadoraActivity.class));
            }
        });

        btnAppCalculoSueldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjerciciosSem7Activity.this, CalculoSueldoActivity.class));
            }
        });
        btnAppCalculoSueldo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjerciciosSem7Activity.this, CalculoSueldo2Activity.class));
            }
        });

        btnAppTodoBarato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjerciciosSem7Activity.this, TodoBaratoActivity.class));
            }
        });

        btnAppMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjerciciosSem7Activity.this, MultiplicacionActivity.class));
            }
        });

    }
}