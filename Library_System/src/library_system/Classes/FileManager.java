package library_system.Classes;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
   
  static  ArrayList<Item> items_;
  static  ArrayList<Member> members_;
  static  ArrayList<Employee> emp_;
    
    
    public static void writeLibraryToFile(String fileName, Library library) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Items:\n");
            for (Item item : library.items) {
                writer.write(item.info() + "\n");
            }
            writer.write("\nMembers:\n");
            for (Member memb : library.members) {
                writer.write(memb.info() + "\n");
            }
            writer.write("\nEmployees:\n");
            for (Employee employee : library.employees) {
                writer.write(employee.info() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library readLibraryFromFile(String fileName,Library lib) {
                   try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String currentSection = "";
            while ((line = reader.readLine()) != null) {
                if (line.equals("Items:")) {
                    currentSection = "Items";
                } else if (line.equals("Members:")) {
                    currentSection = "Members";
                } else if (line.equals("Employees:")) {
                    currentSection = "Employees";
                } else if (!line.trim().isEmpty()) {
                    switch (currentSection) {
                        case "Items":
                            if (line.startsWith("Book Title:")) {
                                lib.addItem(Book.fromString(line));
                            } else if (line.startsWith("Magazine Title:")) {
                                lib.addItem(Magazine.fromString(line));
                            }
                            break;
                        case "Members":
                            lib.addMember(Member.fromString(line));
                            break;
                        case "Employees":
                            lib.addEmployee(Employee.fromString(line));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lib;
    }


}
