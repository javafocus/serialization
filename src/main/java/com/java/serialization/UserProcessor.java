package com.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class UserProcessor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.name = "Michael";
        user.age = 25;

        // serialize user
        FileOutputStream fos = new FileOutputStream("user.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
        fos.close();

        user = null;

        // deserialize user
        FileInputStream fis = new FileInputStream("user.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        user = (User)ois.readObject();
        ois.close();
        fis.close();

        System.out.println(user.name);
        System.out.println(user.age);

    }
}
