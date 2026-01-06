package library_system;

import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import library_system.Classes.Book;
import library_system.Classes.Employee;
import library_system.Classes.FileManager;
import library_system.Classes.Item;
import library_system.Classes.Library;
import library_system.Classes.Member;

public class The_Main {
    
    public static void main(String[] args) {
        ArrayList<Member> member = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Employee> emp = new ArrayList<>();
        
        // حاول تحميل البيانات من الملف المحفوظ إذا كان موجود
        File file = new File("A new file.txt");
        if (file.exists()) {
            Library loadedLibrary = FileManager.loadLibrary("A new file.txt");
            if (loadedLibrary != null) {
                // إذا كان هناك ملف محفوظ، استخدم بياناته
                member.addAll(loadedLibrary.getMembers());
                items.addAll(loadedLibrary.getItems());
                emp.addAll(loadedLibrary.getEmployees());
            }
        }
        
        final ArrayList<Member> finalMember = member;
        final ArrayList<Item> finalItems = items;
        final ArrayList<Employee> finalEmp = emp;
        
        SwingUtilities.invokeLater(() -> {
           Log_in Log_in1 = new Log_in (finalItems, finalMember, finalEmp);
            Log_in1.setVisible(true);
        });

        

    }
}
