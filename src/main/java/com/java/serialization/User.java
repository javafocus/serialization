package com.java.serialization;

import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 123L;

    private int minimumAge = 25;

    public String name;

    public Integer age;

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeInt(age);

        validateData(); // add a validation during deserialization if required
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF(); // will make sure data is not tampered if you have created name with UTF-8 characters.
        age = in.readInt();
    }

    private void validateData() {
        if (age < minimumAge) {
            throw new RuntimeException("minimum age not met");
        }

    }
}
