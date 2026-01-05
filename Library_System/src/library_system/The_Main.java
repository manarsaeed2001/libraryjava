package library_system;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import library_system.Classes.Book;
import library_system.Classes.Employee;
import library_system.Classes.Item;
import library_system.Classes.Member;

public class The_Main {
    
    public static void main(String[] args) {
        ArrayList<Member> member = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Employee> emp = new ArrayList<>();
        
        SwingUtilities.invokeLater(() -> {
           Log_in Log_in1 = new Log_in (items,member,emp);
            Log_in1.setVisible(true);
        });

        

    }
}
