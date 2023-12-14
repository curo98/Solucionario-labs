package autonoma.pe.practice.semana13;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class CuadroDialogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadro_dialogo);

        ActionBarUtils.setCustomTitle(
                this,
                "Cuadro de dialogo",
                ""
        );

        //Creamos un objeto de la clase AlertDialog a través de la clase Builder:
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        //Configuramos el título del diálogo:
        dialogo1.setTitle("Importante");
        // Configuramos el mensaje del diálogo:
        dialogo1.setMessage("¿ Acepta la ejecución de este programa en modo prueba ?");
        // Evitamos que el diálogo sea salteado por cualquier medio distinto a presionar alguno de los dos botones:
        dialogo1.setCancelable(false);
        // Llamamos al método setPositiveButton indicando el texto a mostrar en el botón
        // y la clase anónima que capturará el evento clic del botón:
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        // De forma similar procedemos con el botón de cancelar:
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        // Mostramos el diálogo:
        dialogo1.show();
    }
    // Definimos los métodos del Activity que se llamaran desde las clases anónimas:
    public void aceptar() {
        Toast t=Toast.makeText(this,"Bienvenido a probar el programa.", Toast.LENGTH_SHORT);
        t.show();
    }
    public void cancelar() {
        finish(); }
}