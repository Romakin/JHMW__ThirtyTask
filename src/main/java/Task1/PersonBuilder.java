package Task1;

public class PersonBuilder {

    private String personName;
    private String personSurname;
    private String personAddress;
    private int personAge = -1;

    public PersonBuilder setName(String name) {
        personName = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        personSurname = surname;
        return this;
    }
    
    public PersonBuilder setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age must be more than 0");
        personAge = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address == null || "".equals(address.trim()))
            throw new IllegalArgumentException("Address can not be empty or null");
        personAddress = address;
        return this;
    }

    public Person build() {
        if (personName != null && personSurname != null)
            throw new IllegalStateException("Build failed: name and surname is null");
        Person result;
        if (personAge > 0) {
            result = new Person(personName, personSurname, personAge);
        } else {
            result =  new Person(personName, personSurname);
        }
        if (personAddress != null) result.setAddress(personAddress);
        return result;
    }
}
