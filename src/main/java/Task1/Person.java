package Task1;

import java.util.Objects;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        return age > 0;
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void happyBirthday() {
        if (hasAge()) {
            setAge( ++age );
            System.out.printf("Happy Birthday, %s ! You are %d years old! \n", name, age);
        }
    }

    @Override
    public String toString() {
        return name + " " + surname +
                (hasAge() ? ", " + age : "") +
                ( hasAddress() ? ", " + address : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
