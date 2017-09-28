package Java_Enterprise.Generics;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Vitaliy on 17.01.2017.
 */
public class GenericsExtendsSuper {

    @Test
    public void testPersonList() throws Exception {
        List<Person> persons = Arrays.asList(new Person("Pasha", "Pavel"), new Person("Alison", "Angel"), new Person("Sasha", ""));
        System.out.println(isValidList(persons, new PersonValidator()));
        List<Citizen> citizens = Arrays.asList(new Citizen("Pasha", "Pavel", "Lviv"), new Citizen("Alison", "Angel", ""), new Citizen("Sasha", "", ""));
        System.out.println(isValidList(citizens, new PersonValidator()));

        List<Citizen> filteredCitizens = filterInvalid(citizens, new PersonValidator());
    }

    public boolean isValidList(List<? extends Person> persons, Validator<Person> personValidator) {
        for (Person person : persons) {
            if (personValidator.isValid(person)) {
                return false;
            }
        }
        return true;
    }

    public <T> List<T> filterInvalid(List<T> values, Validator<? super T> validator) {
        List<T> result = new ArrayList<>();
        for (T value : values) {
            if (validator.isValid(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public interface Validator<T> {
        boolean isValid(T value);
    }

    public static class PersonValidator implements Validator<Person> {

        @Override
        public boolean isValid(Person person) {
            return isNotBlank(person.name) && isNotBlank(person.surname);
        }
    }

    public static class Person {
        public String name;
        public String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }

    public static class Citizen extends Person {

        public Citizen(String name, String surname, String address) {
            super(name, surname);
            this.address = address;
        }

        public String address;

        @Override
        public String toString() {
            return "Citizen{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }


    }
}
