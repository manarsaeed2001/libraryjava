package library_system.Classes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BorrowInvalidItemTest {

    // اختبار استعارة عنصر غير موجود في المكتبة
    @Test
    void testBorrowInvalidItem() {

        // إنشاء مكتبة جديدة
        Library lib = new Library();

        // إنشاء عضو فقط (بدون إضافة أي كتاب)
        Member m = new Member("Ali", "M1", "0555", "Normal");
        lib.addMember(m);

        // محاولة استعارة عنصر غير موجود
        String result = lib.borrowItem("X1", "M1");

        // التحقق من رسالة الخطأ
        assertEquals("Invalid item or member.", result);
    }
}