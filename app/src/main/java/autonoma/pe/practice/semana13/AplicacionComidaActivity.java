package autonoma.pe.practice.semana13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import autonoma.pe.practice.R;
import autonoma.pe.practice.utils.ActionBarUtils;

public class AplicacionComidaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spnProducto;
    EditText edtCantidad;
    TextView tvPrecio, tvDescuento, tvTotal, tvTotalPagar;
    CheckBox chkDelivery;
    Button btnCalcular;

    double precio;
    int delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion_comida);

        ActionBarUtils.setCustomTitle(
                this,
                "App comida",
                ""
        );

        spnProducto = findViewById(R.id.spnProducto);
        edtCantidad = findViewById(R.id.edtCantidad);
        tvPrecio = findViewById(R.id.tvPrecio);
        tvDescuento = findViewById(R.id.tvDescuento);
        tvTotal = findViewById(R.id.tvTotal);
        tvTotalPagar = findViewById(R.id.tvTotalPagar);
        chkDelivery = findViewById(R.id.chkDelivery);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);
        spnProducto.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnCalcular){
            int can;
            double total, des, tPagar;

            can = Integer.parseInt(edtCantidad.getText().toString());
            total = precio*can;

            if (chkDelivery.isChecked()){
                delivery=10;
            }
            else
                delivery=0;

            if (total > 60){
                des = 5;
            }
            else
                des = 0;

            tPagar = (total + delivery) - des;
            tvTotal.setText("S/. "+total);
            tvDescuento.setText("S/. "+des);
            tvTotalPagar.setText("S/. "+tPagar);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                precio = 0;
                break;
            case 1:
                precio = 65.50;
                break;
            case 2:
                precio = 34.50;
                break;
            case 3:
                precio = 18.50;
                break;
            case 4:
                precio = 17.50;
                break;
            case 5:
                precio = 21.50;
                break;
        }

        tvPrecio.setText("S/. " + precio);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}