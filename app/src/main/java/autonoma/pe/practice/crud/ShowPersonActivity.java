package autonoma.pe.practice.crud;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import autonoma.pe.practice.R;
import autonoma.pe.practice.crud.model.Person;

public class ShowPersonActivity extends AppCompatActivity {

    private TextView tvFirstName, tvLastName;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);

        // Initialize views
        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        btnReturn = findViewById(R.id.btnReturn);

        // Recuperar los datos del proveedor del Intent
        Person person = getIntent().getParcelableExtra("person_details");

        if (person != null) {
            String personName = person.getFirst_name();
            String personLastName = person.getLast_name();

            tvFirstName.setText(personName);
            tvLastName.setText(personLastName);
        }

        btnReturn.setOnClickListener(view -> {
            Intent intent = new Intent(ShowPersonActivity.this, PersonActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
