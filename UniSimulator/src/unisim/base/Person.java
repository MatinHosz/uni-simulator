package unisim.base;

import java.util.ArrayList;

public class Person {
    public int id;
    public static ArrayList<Person> personList;
    public String name;
    public String nationalID;

    public Person(String Name, String NationalID) {
        this.name = Name;
        this.nationalID = NationalID;
        personList.add(this);
        id = personList.size();
    }

    public static Person findByID(int id) {
        for (Person person : personList) {
            if (person.id == id)
                return person;
        }
        return null;
    }
}