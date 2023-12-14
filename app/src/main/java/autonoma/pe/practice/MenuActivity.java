package autonoma.pe.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import autonoma.pe.practice.semana13.AplicacionComidaActivity;
import autonoma.pe.practice.semana13.CuadroDialogoActivity;
import autonoma.pe.practice.semana13.OperacionesAritmeticasActivity;
import autonoma.pe.practice.semana13.ProductoCreditoActivity;
import autonoma.pe.practice.utils.ActionBarUtils;

public class MenuActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBarUtils.setCustomTitle(
                this,
                "EJERCICIOS",
                ""
        );

        Button btnSem7 = findViewById(R.id.btnSem7);
        btnSem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, EjerciciosSem7Activity.class);
                startActivity(intent);
            }
        });

        Button btnSem13 = findViewById(R.id.btnSem13);
        btnSem13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, EjerciciosSem13Activity.class);
                startActivity(intent);
            }
        });
    }
}