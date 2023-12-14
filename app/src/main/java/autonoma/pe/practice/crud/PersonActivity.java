package autonoma.pe.practice.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextWatcher;
import android.widget.Toast;


import java.util.ArrayList;

import autonoma.pe.practice.ApiService;
import autonoma.pe.practice.R;
import autonoma.pe.practice.crud.model.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonActivity extends AppCompatActivity {

    private ApiService apiService;
    private PersonAdapter personAdapter;
    private EditText etSearch;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        apiService = ApiService.Factory.create();
        etSearch = findViewById(R.id.etSearch);
        recyclerView = findViewById(R.id.recyclerView);

        personAdapter = new PersonAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personAdapter);

        registerForContextMenu(recyclerView);
        recyclerView.setLongClickable(true);

        personAdapter.setNewSelectedPerson(null); // Inicializa la persona seleccionada como nula

        loadPeople();

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No necesitas implementar esto
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchText = s.toString().toLowerCase();
                personAdapter.filterPersons(searchText);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No necesitas implementar esto
            }
        });
    }

    private void loadPeople() {
        Call<ArrayList<Person>> call = apiService.getPeople();

        call.enqueue(new Callback<ArrayList<Person>>() {
            @Override
            public void onResponse(Call<ArrayList<Person>> call, Response<ArrayList<Person>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Person> people = response.body();
                    if (people != null) {
                        personAdapter.updatePersons(people);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Person>> call, Throwable t) {
                // Manejar la falla, por ejemplo, mostrar un mensaje de error.
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.recyclerView) {
            menu.setHeaderTitle("Opciones de persona");
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_options, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.show) {
            Person selectedUserShow = personAdapter.getSelectedPerson();
            if (selectedUserShow != null) {
                int id = selectedUserShow.getId();
                // Call the method for the R.id.show option
                showPerson(id);
            }
            return true;
        }

        if (item.getItemId() == R.id.edit) {
            Person selectedUserEdit = personAdapter.getSelectedPerson();
            if (selectedUserEdit != null) {
                int id = selectedUserEdit.getId();

                editPerson(id);
            }
            return true;
        }

        if (item.getItemId() == R.id.trash) {

            Person selectedUserTrash = personAdapter.getSelectedPerson();
            if (selectedUserTrash != null) {
                int id = selectedUserTrash.getId();
                // Call the method for the R.id.trash option
                destroyPerson(id);
            }
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private void showPerson(int id) {
        Call<Person> call = apiService.getPersonDetails(id);

        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if (response.isSuccessful()) {
                    Person person = response.body();

                    if (person != null) {
                        String message = "ID: " + person.getId() + "\n" +
                                "Nombres: " + person.getFirst_name() + "\n" +
                                "Apellidos: " + person.getLast_name() + "\n";

                        // Log the message
                        Log.d("PersonDetails", message);

                        Intent intent = new Intent(PersonActivity.this, ShowPersonActivity.class);
                        intent.putExtra("person_details", person);
                        startActivity(intent);
                    }
                } else {
                    // Handle unsuccessful response, for example, show an error message
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void editPerson(int id) {
        Call<Person> call = apiService.editPerson(id);

        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if (response.isSuccessful()) {
                    Person person = response.body();
                    if (person != null) {
                        String message = "ID: " + person.getId() + "\n" +
                                "Nombres: " + person.getFirst_name() + "\n" +
                                "Apellidos: " + person.getLast_name() + "\n";

                        // Log the message
                        Log.d("PersonDetails", message);

                        Intent intent = new Intent(PersonActivity.this, FormActivity.class);
                        intent.putExtra("person", person);
                        intent.putExtra("isEditing", true);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void destroyPerson(int id) {
        Person selectedPerson = personAdapter.getSelectedPerson();
        int position = personAdapter.getPosition(selectedPerson);

        if (position != -1) {
            Call<Void> call = apiService.destroyPerson(id);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
//                        Toast.makeText(PersonActivity.this, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
//                        personAdapter.removePerson(position);

                        Intent intent = new Intent(PersonActivity.this, PersonActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(PersonActivity.this, "Algo ocurrió mal", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(PersonActivity.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}