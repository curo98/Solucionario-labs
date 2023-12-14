package autonoma.pe.practice.crud;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import autonoma.pe.practice.R;
import autonoma.pe.practice.crud.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<Person> filteredList = new ArrayList<>();
    private Person selectedPerson;

    public void updatePersons(List<Person> newPersons) {
        persons.clear();
        persons.addAll(newPersons);
        filterPersons(""); // Limpia el filtro al actualizar los usuarios
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterPersons(String query) {
        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(persons);
        } else {
            for (Person person : persons) {
                if (person.getFirst_name().toLowerCase().contains(query)) {
                    filteredList.add(person);
                }
            }
        }

        notifyDataSetChanged();
    }

    public void setNewSelectedPerson(Person person) {
        selectedPerson = person;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void removePerson(int position) {
        if (position >= 0 && position < persons.size()) {
            persons.remove(position);
            notifyItemRemoved(position);
        }
    }

    public int getPosition(Person person) {
        if (person != null) {
            for (int index = 0; index < persons.size(); index++) {
                if (persons.get(index).equals(person)) {
                    return index;
                }
            }
        }
        return -1; // Usuario no encontrado en la lista
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Person person) {
            TextView tvId = itemView.findViewById(R.id.tvId);
            TextView tvFirstName = itemView.findViewById(R.id.tvFirstName);
            TextView tvLastName = itemView.findViewById(R.id.tvLastName);
            TextView tvAge = itemView.findViewById(R.id.tvAge);
            TextView tvGender = itemView.findViewById(R.id.tvGender);
            TextView tvAddress = itemView.findViewById(R.id.tvAddress);

            // Asignar los valores de la instancia de Person a las vistas
            tvId.setText("ID: " + person.getId());
            tvFirstName.setText("First Name: " + person.getFirst_name());
            tvLastName.setText("Last Name: " + person.getLast_name());
            tvAge.setText("Age: " + person.getAge());
            tvGender.setText("Gender: " + person.getGender());
            tvAddress.setText("Address: " + person.getAddress());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = filteredList.get(position);
        holder.bind(person);

        holder.itemView.setOnLongClickListener(view -> {
            setNewSelectedPerson(person);
            view.showContextMenu();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }
}

