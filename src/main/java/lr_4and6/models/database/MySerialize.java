package lr_4and6.models.database;

import lr_4and6.models.application.User;

import java.io.*;
import java.util.ArrayList;

public class MySerialize {

    public static void writeUsers(ArrayList<User> users) {
        try {
            FileOutputStream file_out_stream = new FileOutputStream("src/main/java/lr_4and6/models/database/Users.txt");
            ObjectOutputStream object_out_stream = new ObjectOutputStream(file_out_stream);
            for (User user : users) {
                try {
                    object_out_stream.writeObject(user);
                } catch (NotSerializableException e) {
                    System.out.println("Error serialization");
                }
            }
            object_out_stream.close();
            file_out_stream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public static ArrayList<User> readUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileInputStream file_in_stream = new FileInputStream("src/main/java/lr_4and6/models/database/Users.txt");
            ObjectInputStream object_in_stream = new ObjectInputStream(file_in_stream);
            while(true) {
                try {
                    users.add((User) object_in_stream.readObject());
                }
                catch(IOException e) {
                    break;
                }
            }
            object_in_stream.close();
            file_in_stream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
