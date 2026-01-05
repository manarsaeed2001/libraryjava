package library_system.Classes;

public class StudentMember extends Member {

    public StudentMember(String name, String id, String contactInfo) {
        super(name, id, contactInfo, "Student");
    }

    // ====== Polymorphism ======
    @Override
    public double calculateFee(int daysLate) {
        // Students get 50% discount
        return super.calculateFee(daysLate) * 0.5;
    }
}
