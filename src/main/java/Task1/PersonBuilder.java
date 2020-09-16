package Task1;

import java.util.HashMap;

public class PersonBuilder {

    private Person person;
    private HashMap<String, String> personAttrs;
    private int bufAge = -1;

    public PersonBuilder() {
        this.person = null;
        this.personAttrs = new HashMap<>();
    }

    public PersonBuilder setName(String name) {
        personAttrs.put("name", name);
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        personAttrs.put("surname", surname);
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age must be more than 0");
        if (person != null && !person.hasAge()) {
            person.setAge(age);
        } else {
            bufAge = age;
            renderPerson(false);
        }
        return this;
    }
    public PersonBuilder setAddress(String address) {
        if (address == null || "".equals(address.trim()))
            throw new IllegalArgumentException("Address can not be empty or null");
        if (person != null && !person.hasAddress()) {
            person.setAddress(address);
        } else {
            personAttrs.put("address", address);
            renderPerson(false);
        }
        return this;
    }

    private void renderPerson(boolean finalRender) {
        if (person == null &&
                personAttrs.containsKey("name")&&
                personAttrs.containsKey("surname")) {
            if (bufAge < 0) {
                person = new Person(
                        personAttrs.get("name"),
                        personAttrs.get("surname")
                );
            } else {
                person =  new Person(
                        personAttrs.get("name"),
                        personAttrs.get("surname"),
                        bufAge
                );
            }
            if (personAttrs.containsKey("address")) {
                person.setAddress(personAttrs.get("address"));
            }
        } else if (finalRender) throw new IllegalStateException("Build failed: name and surname is null");
    }

    public Person build() {
        if (person == null) renderPerson(true);
        return person;
    }
}
