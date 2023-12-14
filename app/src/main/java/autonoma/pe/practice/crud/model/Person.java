package autonoma.pe.practice.crud.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private final int id;
    private final String first_name;
    private final String last_name;
    private final String age;
    private final String gender;
    private final String address;

    public Person(int id, String first_name, String last_name, String age, String gender, String address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    protected Person(Parcel in) {
        id = in.readInt();
        first_name = in.readString();
        last_name = in.readString();
        age = in.readString();
        gender = in.readString();
        address = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(first_name);
        dest.writeString(last_name);
        dest.writeString(age);
        dest.writeString(gender);
        dest.writeString(address);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
}

