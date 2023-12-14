package autonoma.pe.practice.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import autonoma.pe.practice.ApiService;
import autonoma.pe.practice.R;
import autonoma.pe.practice.crud.model.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {
    private ApiService apiService;
    private EditText etFirstName;
    private EditText etLastName;
    private Button btnForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize ApiService
        apiService = ApiService.Factory.create();

        // Initialize views
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        btnForm = findViewById(R.id.btnForm);

        // Get the value of "isEditing" from the intent
        boolean isEditing = getIntent().getBooleanExtra("isEditing", false);
        Person person = getIntent().getParcelableExtra("person");

        // If isEditing is true, you are editing a person, show the existing data
        if (isEditing && person != null) {
            etFirstName.setText(person.getFirst_name());
            etLastName.setText(person.getLast_name());

            // Change the button text to "Update"
            btnForm.setText("Actualizar");
            btnForm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = person.getId();
                    // Execute the update method
                    executeMethodUpdate(id);
                }
            });
        } else {
            // If not editing, you are creating a new person, set up the button
            // to execute the create method
            btnForm.setText("Crear");
            btnForm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Call your create method here
                    executeMethodCreate();
                }
            });
        }
    }

    private void executeMethodCreate() {
        String first_name = etFirstName.getText().toString();
        String last_name = etLastName.getText().toString();

        Call<Void> call = apiService.postPerson(first_name, last_name);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(FormActivity.this, PersonActivity.class);
                    Toast.makeText(FormActivity.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                } else {
                    // Handle errors in the response
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle request errors
            }
        });
    }

    private void executeMethodUpdate(int id) {
        String first_name = etFirstName.getText().toString().trim();
        String last_name = etLastName.getText().toString().trim();

        Call<Void> call = apiService.updatePerson(id, first_name, last_name);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(FormActivity.this, PersonActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Error handling
                    String errorMessage = "";
                    switch (response.code()) {
                        case 401:
                            errorMessage = "No autorizado";
                            break;
                        case 404:
                            errorMessage = "Proveedor no encontrado";
                            break;
                        case 500:
                            errorMessage = "Error interno del servidor";
                            break;
                        default:
                            errorMessage = "Error desconocido";
                            break;
                    }
                    Toast.makeText(FormActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle failure
            }
        });
    }
}