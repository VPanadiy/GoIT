package Java_Core.Collection;

import Java_Core.Collection.Person;
import Java_Core.Crypt.Caesar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Splayd on 04.12.2016.
 */
public class PersonExample {
    public static void main(String[] args) {
        final List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", "Doe", (byte)24));
        personList.add(new Person("Eric", "Cartman", (byte)6));
        personList.add(new Person("Alis", "Nyy", (byte)16));

        for (Person person: personList) {
            System.out.println(person);
        }

        personList
                .stream()
                .map(person -> person.getFirstName())
                .forEach(person -> System.out.println(person));
        personList
                .stream()
                .map(person -> person.getFirstName())
                .forEach(person -> System.out.println(Caesar.Crypt(person,1)));

    }


}
