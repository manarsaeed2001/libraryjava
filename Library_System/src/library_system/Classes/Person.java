package library_system.Classes;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    private String id;
    private String contactInfo;

    public Person(String name, String id, String contactInfo) {
        this.name = name;
        this.id = id;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getContactInfo() {
        return contactInfo;
    }
//
    public abstract void displayInfo();
}
