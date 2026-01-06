package library_system.Classes;

public class StudentMember extends Member {

    public StudentMember(String name, String id, String contactInfo) {
        super(name, id, contactInfo, "Student");
    }

    // ===== Polymorphism =====
    // الطلاب يدفعون أقل
    @Override
    public double calculateFee(int daysLate) {
        return daysLate * 1.0;
    }
}
