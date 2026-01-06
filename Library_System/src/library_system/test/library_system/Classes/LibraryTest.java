package library_system.Classes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* * هذا التست معناه ان كلاس المكتبه و داله ادد ممبر و برو ايتم شغالين
 *  كلاس LibraryTest
 * هذا الكلاس مخصص لاختبار كلاس Library باستخدام JUnit 5
 */
public class LibraryTest {

    /*
     * اختبار إضافة عضو جديد إلى المكتبة
     * الهدف: التأكد أن addMember() تضيف العضو فعلاً
     */
    @Test
    void testAddMember() {

        // إنشاء مكتبة جديدة (فارغة)
        Library lib = new Library();

        // إنشاء عضو جديد
        Member m = new Member("Sara", "M1", "0555", "Normal");

        // إضافة العضو إلى المكتبة
        lib.addMember(m);

        // التحقق أن عدد الأعضاء أصبح 1
        assertEquals(1, lib.getMembers().size());
    }

    /*
     * اختبار عملية استعارة كتاب
     * الهدف: التأكد أن العضو يستطيع استعارة كتاب موجود
     */
    @Test
    void testBorrowItem() {

        // إنشاء مكتبة جديدة
        Library lib = new Library();

        // إنشاء كتاب
        Book b = new Book("Java", "Ali", "B1", 300);

        // إنشاء عضو
        Member m = new Member("Sara", "M1", "0555", "Normal");

        // إضافة الكتاب والعضو إلى المكتبة
        lib.addItem(b);
        lib.addMember(m);

        // تنفيذ عملية الاستعارة
        String result = lib.borrowItem("B1", "M1");

        // التحقق من أن النتيجة صحيحة
        assertEquals("Item borrowed successfully.", result);
    }
}
