package library_system.Classes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MemberFeeTest {

    // اختبار تعدد الأشكال (Polymorphism)
    // نتأكد أن الطالب يدفع رسوم أقل من العضو العادي
    @Test
    void testStudentMemberFee() {

        Member normal = new Member("Ali", "M1", "0555", "Normal");
        Member student = new StudentMember("Sara", "S1", "0666");

        double normalFee = normal.calculateFee(4);
        double studentFee = student.calculateFee(4);

        assertTrue(studentFee < normalFee);
    }
}
