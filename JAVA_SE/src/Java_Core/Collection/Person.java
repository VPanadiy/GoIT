package Java_Core.Collection;

/**
 * Created by Splayd on 04.12.2016.
 */
public class Person {
    private String firstName;
    private String secondName;
    private byte age;

    public Person(String firstName, String secondName, byte age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
