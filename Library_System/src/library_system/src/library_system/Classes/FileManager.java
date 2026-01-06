package library_system.Classes;

import java.io.*;

public class FileManager {

    public static void saveLibrary(String fileName, Library library) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library loadLibrary(String fileName) {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            return (Library) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
