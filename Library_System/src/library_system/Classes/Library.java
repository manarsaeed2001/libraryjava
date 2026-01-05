package library_system.Classes;

import java.util.*;
import javax.swing.JOptionPane;
import java.io.Serializable;



public class Library implements Serializable{
        static public ArrayList<Item> items;
        static  public ArrayList<Member> members;
        static  public ArrayList<Employee> employees;
            private static final long serialVersionUID = 1L;

    public Library(ArrayList<Item> items_,ArrayList<Member> members_,ArrayList<Employee> emp) {
        items = items_;
        members = members_;
        employees = emp;
    }



    public void addItem(Item item) {
        items.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String displayAllItems() {
        String result = "";
        for (Item item : items) {
          result= result + item.info() + "\n";
        }
        return result;
    }

    public String displayAllMembers() {
       String membtotal = "";
        for (Member member : members) {          
            membtotal = membtotal + member.info()+"\n";
        }
        return membtotal;
    }

    public String displayAllEmployees() {
       String Emp_total = "";
        for (Employee employee : employees) {
            Emp_total = Emp_total + employee.info()+"\n";
        }
        return Emp_total;
    }

    public String borrowItem(String itemId, String memberId) {
       String result = "";
        Item item = findItemById(itemId);
        Member member = findMemberById(memberId);
        
        if (item instanceof Borrowable && member != null) {
            Borrowable borrowableItem = (Borrowable) item;
            if (!borrowableItem.isBorrowed()) {
                borrowableItem.borrowItem(member.getName());
              result=  "Item borrowed successfully.";
            } else {
              result=  "Item is already borrowed.";
            }
        } else {
          result="Invalid item or member.";
        }
        return result;
    }

    public String returnItem(String itemId) {
       String result = "";
        Item item = findItemById(itemId);
        
        if (item instanceof Borrowable) {
            Borrowable borrowableItem = (Borrowable) item;
            if (borrowableItem.isBorrowed()) {
                borrowableItem.returnItem();
              result=  "Item returned successfully.";
            } else {
             result =  "Item is not currently borrowed.";
            }
        } else {
           result="Invalid item.";
        }
        
        return result;
    }

    public Item findItemById(String itemId) {
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
       
    public boolean Log_in_Member(String name ,String memberId) {
       boolean found = false ;
          for (Member member : members) {
            if (member.getId().equals(memberId) && member.getName().equals(name)) {
                found = true;
                return found;
            }
        }
        return found;
    }     
      
    public boolean Log_in_Emp(String name ,String memberId) {
       boolean found = false ;
          for (Employee emp : employees) {
            if (emp.getId().equals(memberId) && emp.getName().equals(name)) {
                found = true;
                return found;
            }
        }
        return found;
    }

   
    
    public static String deleteEmployeeById(String Id) {
      String result = "";
        Employee empToRemove = null;
        for (Employee emplo : employees) {
            if (emplo.getId().equals(Id)) {
                empToRemove = emplo;
                break;
            }
        }
        if (empToRemove != null) {
            employees.remove(empToRemove);
         result =  "Employee with ID " + Id + " has been removed.";
        } else {
         result=  "Employee with ID " + Id + " not found.";
        }
        return result;
    }
         
    public static String deleteMemebrById(String Id) {
       String result = "";
        Member memToRemove = null;
        for (Member member : members) {
            if (member.getId().equals(Id)) {
                memToRemove = member;
                break;
            }
        }
        if (memToRemove != null) {
            members.remove(memToRemove);
         result=   "Member with ID " + Id + " has been removed.";
        } else {
         result= "Member with ID " + Id + " not found.";
        }
        
        return result;
        

       }
    
         public void saveToFile(String fileName,Library library) {
        FileManager.writeLibraryToFile(fileName, this);
    }

   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Items:\n");
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        sb.append("\nMembers:\n");
        for (Member member : members) {
            sb.append(member).append("\n");
        }
        sb.append("\nEmployees:\n");
        for (Employee employee : employees) {
            sb.append(employee).append("\n");
        }
        return sb.toString();
    }

}

   