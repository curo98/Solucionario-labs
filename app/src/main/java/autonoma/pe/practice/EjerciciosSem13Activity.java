package autonoma.pe.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import autonoma.pe.practice.semana13.AplicacionComidaActivity;
import autonoma.pe.practice.semana13.CuadroDialogoActivity;
import autonoma.pe.practice.semana13.OperacionesAritmeticasActivity;
import autonoma.pe.practice.semana13.ProductoCreditoActivity;
import autonoma.pe.practice.utils.ActionBarUtils;

public class EjerciciosSem13Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_sem13);
        ActionBarUtils.setCustomTitle(
                this,
                "EJERCICIOS - SEMANA 13",
                ""
        );

        Button btnOper = findViewById(R.id.btnOper);
        btnOper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EjerciciosSem13Activity.this, OperacionesAritmeticasActivity.class);
                startActivity(intent);
            }
        });

        Button btnDia = findViewById(R.id.btnDia);
        btnDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EjerciciosSem13Activity.this, CuadroDialogoActivity.class);
                startActivity(intent);
            }
        });

        Button btnAppFood = findViewById(R.id.btnAppFood);
        btnAppFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EjerciciosSem13Activity.this, AplicacionComidaActivity.class);
                startActivity(intent);
            }
        });

        Button btnProductoCredito = findViewById(R.id.btnProductoCredito);
        btnProductoCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EjerciciosSem13Activity.this, ProductoCreditoActivity.class);
                startActivity(intent);
            }
        });
    }
}