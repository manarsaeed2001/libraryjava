package library_system.Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    // ====== Lists ======
    private ArrayList<Item> items;
    private ArrayList<Member> members;
    private ArrayList<Employee> employees;
    private ArrayList<Loan> loans;

    // ====== Constructor ======
    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        employees = new ArrayList<>();
        loans = new ArrayList<>();
    }

    // ====== Getters (مهمة للـ GUI و FileManager) ======
    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // ====== Items ======
    public void addItem(Item item) {
        items.add(item);
    }

    public Item findItemById(String itemId) {
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    public String displayAllItems() {
        if (items.isEmpty()) {
            return "No items in library.";
        }

        String result = "";
        for (Item item : items) {
            result += item.info() + "\n";
        }
        return result;
    }

    // ====== Members ======
    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public String displayAllMembers() {
        if (members.isEmpty()) {
            return "No members found.";
        }

        String result = "";
        for (Member m : members) {
            result += m.info() + "\n";
        }
        return result;
    }

    public boolean Log_in_Member(String name, String id) {
        for (Member m : members) {
            if (m.getName().equals(name) && m.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // ====== Employees ======
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String displayAllEmployees() {
        if (employees.isEmpty()) {
            return "No employees found.";
        }

        String result = "";
        for (Employee e : employees) {
            result += e.info() + "\n";
        }
        return result;
    }

    public boolean Log_in_Emp(String name, String id) {
        for (Employee e : employees) {
            if (e.getName().equals(name) && e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // ====== Borrow / Return ======
    public String borrowItem(String itemId, String memberId) {
        Item item = findItemById(itemId);
        Member member = findMemberById(memberId);

        if (item == null || member == null) {
            return "Invalid item or member.";
        }

        for (Loan loan : loans) {
            if (loan.getItem().equals(item) && !loan.isReturned()) {
                return "Item already borrowed.";
            }
        }

        loans.add(new Loan(item, member));
        return "Item borrowed successfully.";
    }

    public String returnItem(String itemId) {
        Item item = findItemById(itemId);

        if (item == null) {
            return "Item not found.";
        }

        for (Loan loan : loans) {
            if (loan.getItem().equals(item) && !loan.isReturned()) {
                loan.returnItem();
                return "Item returned successfully.";
            }
        }

        return "Item was not borrowed.";
    }

    // ====== Delete ======
    public String deleteMemberById(String id) {
        for (Member m : members) {
            if (m.getId().equals(id)) {
                members.remove(m);
                return "Member deleted successfully.";
            }
        }
        return "Member not found.";
    }

    public String deleteEmployeeById(String id) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                employees.remove(e);
                return "Employee deleted successfully.";
            }
        }
        return "Employee not found.";
    }
}
