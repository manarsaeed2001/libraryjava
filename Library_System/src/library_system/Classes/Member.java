package library_system.Classes;

public class Member extends Person {

    private String membershipType;
    private static final long serialVersionUID = 1L;

    public Member(String name, String id, String contactInfo, String membershipType) {
        super(name, id, contactInfo);
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return membershipType;
    }

    // ===== Base method for Polymorphism =====
    // الأعضاء العاديين يدفعون رسوم أعلى
    public double calculateFee(int daysLate) {
        return daysLate * 2.0;
    }

    public void displayInfo() {
        System.out.println("Member Name: " + getName());
        System.out.println("Member ID: " + getId());
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Membership Type: " + membershipType);
    }

    public String info() {
        return "Member Name: " + getName() + "  " +
               "Member ID: " + getId() + "  " +
               "Contact Info: " + getContactInfo() + "  " +
               "Membership Type: " + membershipType;
    }

    public static Member fromString(String str) {
        String[] parts = str.split(" ");
        String name = parts[2];
        String id = parts[4];
        String contactInfo = parts[7];
        String membershipType = parts[10];
        return new Member(name, id, contactInfo, membershipType);
    }
}
