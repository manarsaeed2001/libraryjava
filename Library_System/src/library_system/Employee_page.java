package library_system;

import library_system.Classes.*;
import javax.swing.*;
import java.util.ArrayList;

public class Employee_page extends javax.swing.JFrame {

    ArrayList<Item> items;
    ArrayList<Member> members;
    ArrayList<Employee> emp;

    public Employee_page(ArrayList<Item> items_,
                         ArrayList<Member> members_,
                         ArrayList<Employee> emp_) {
    	   super();
        initComponents();
        items = items_;
        members = members_;
        emp = emp_;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Library lib = new Library();
        JOptionPane.showMessageDialog(rootPane, lib.displayAllItems());
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String itemId = JOptionPane.showInputDialog("Item ID:");
        String memberId = JOptionPane.showInputDialog("Member ID:");

        Library lib = new Library();
        JOptionPane.showMessageDialog(rootPane,
                lib.borrowItem(itemId, memberId));
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String itemId = JOptionPane.showInputDialog("Item ID to return:");

        Library lib = new Library();
        JOptionPane.showMessageDialog(rootPane,
                lib.returnItem(itemId));
    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        Log_in log = new Log_in(items, members, emp);
        log.setVisible(true);
    }
}
