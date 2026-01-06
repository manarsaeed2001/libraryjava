package library_system.Classes;

public class StudentMember extends Member {

    public StudentMember(String name, String id, String contactInfo) {
        super(name, id, contactInfo, "Student");
    }

    // ===== Polymorphism =====
    // الطلاب يحصلون على خصم 50%
    @Override
    public double calculateFee(int daysLate) {
        return super.calculateFee(daysLate) * 0.5;
    }
}
