package library_system;

import java.util.ArrayList;
import library_system.Classes.*;

/**
 * LibraryDemo - برنامج توضيحي يشرح كيفية استخدام LibraryManager
 * يعرض جميع العمليات الأساسية: إضافة، بحث، استعارة، إرجاع
 */
public class LibraryDemo {
    
    public static void main(String[] args) {
        System.out.println("=== 📚 نظام إدارة المكتبة - عرض توضيحي ===\n");
        
        // إنشاء مدير المكتبة
        LibraryManager manager = new LibraryManager();
        
        // ===== 1. إضافة الكتب =====
        System.out.println("1️⃣ إضافة الكتب:");
        System.out.println("-----------");
        
        Book book1 = new Book("Java Programming", "Herbert Schildt", "BOOK001", 500);
        Book book2 = new Book("Data Structures and Algorithms", "Thomas Cormen", "BOOK002", 800);
        Book book3 = new Book("Clean Code", "Robert Martin", "BOOK003", 450);
        Book book4 = new Book("Java Concurrency", "Brian Goetz", "BOOK004", 350);
        
        manager.addBook(book1);
        manager.addBook(book2);
        manager.addBook(book3);
        manager.addBook(book4);
        
        System.out.println("✅ تمت إضافة 4 كتب");
        System.out.println();
        
        // ===== 2. إضافة الأعضاء =====
        System.out.println("2️⃣ إضافة الأعضاء:");
        System.out.println("-----------");
        
        Member member1 = new Member("أحمد علي", "MEM001", "0501234567", "Regular");
        Member member2 = new Member("فاطمة محمد", "MEM002", "0509876543", "Premium");
        StudentMember member3 = new StudentMember("محمود حسن", "MEM003", "0505555555");
        
        manager.addMember(member1);
        manager.addMember(member2);
        manager.addMember(member3);
        
        System.out.println("✅ تمت إضافة 3 أعضاء (عضوين عاديين + طالب بخصم 50%)");
        System.out.println();
        
        // ===== 3. عرض جميع الكتب =====
        System.out.println("3️⃣ حالة الكتب:");
        System.out.println("-----------");
        System.out.println(manager.getAllBooksStatus());
        
        // ===== 4. البحث عن الكتب =====
        System.out.println("4️⃣ البحث عن الكتب:");
        System.out.println("-----------");
        
        System.out.println("البحث عن 'Java':");
        ArrayList<Book> javaBooks = manager.searchBooks("Java");
        for (Book book : javaBooks) {
            System.out.println("  ✓ " + book.info());
        }
        System.out.println();
        
        // ===== 5. استعارة الكتب =====
        System.out.println("5️⃣ استعارة الكتب:");
        System.out.println("-----------");
        
        String borrow1 = manager.borrowBook("BOOK001", "MEM001");
        System.out.println("أحمد يستعير Java Programming: " + borrow1);
        
        String borrow2 = manager.borrowBook("BOOK002", "MEM002");
        System.out.println("فاطمة تستعير Data Structures: " + borrow2);
        
        String borrow3 = manager.borrowBook("BOOK003", "MEM003");
        System.out.println("محمود يستعير Clean Code: " + borrow3);
        
        // محاولة استعارة نفس الكتاب (سيفشل)
        String borrow4 = manager.borrowBook("BOOK001", "MEM002");
        System.out.println("فاطمة تحاول استعارة نفس الكتاب: " + borrow4);
        System.out.println();
        
        // ===== 6. عرض الكتب المتاحة =====
        System.out.println("6️⃣ الكتب المتاحة الآن:");
        System.out.println("-----------");
        ArrayList<Book> available = manager.getAvailableBooks();
        if (available.isEmpty()) {
            System.out.println("❌ لا توجد كتب متاحة حالياً");
        } else {
            for (Book book : available) {
                System.out.println("  ✓ " + book.getTitle());
            }
        }
        System.out.println();
        
        // ===== 7. استعارات العضو =====
        System.out.println("7️⃣ استعارات أحمد (MEM001):");
        System.out.println("-----------");
        ArrayList<Loan> memberLoans = manager.getMemberActiveLoans("MEM001");
        for (Loan loan : memberLoans) {
            System.out.println("  - " + loan.getItem().info());
            System.out.println("    تاريخ الاستعارة: " + loan.getBorrowDate());
        }
        System.out.println();
        
        // ===== 8. إرجاع الكتب =====
        System.out.println("8️⃣ إرجاع الكتب:");
        System.out.println("-----------");
        
        // محاكاة تأخير بحفظ واستعادة التاريخ (في الواقع ستكون أيام فعلية)
        String return1 = manager.returnBook("BOOK001");
        System.out.println("أحمد يرجع Java Programming: " + return1);
        
        String return2 = manager.returnBook("BOOK002");
        System.out.println("فاطمة ترجع Data Structures: " + return2);
        System.out.println();
        
        // ===== 9. عرض الكتب المستعارة الحالية =====
        System.out.println("9️⃣ الكتب المستعارة حالياً:");
        System.out.println("-----------");
        ArrayList<Loan> loans = manager.getLoans();
        int activeLoans = 0;
        for (Loan loan : loans) {
            if (!loan.isReturned()) {
                System.out.println("  - " + loan.getItem().getTitle());
                System.out.println("    من: " + loan.getMember().getName());
                activeLoans++;
            }
        }
        if (activeLoans == 0) {
            System.out.println("لا توجد استعارات نشطة");
        }
        System.out.println();
        
        // ===== 10. حساب الرسوم =====
        System.out.println("🔟 مثال على حساب الرسوم:");
        System.out.println("-----------");
        
        System.out.println("أيام التأخير: 5 أيام");
        System.out.println("للعضو العادي (أحمد): " + member1.calculateFee(5) + " وحدة");
        System.out.println("للطالب (محمود) بخصم 50%: " + member3.calculateFee(5) + " وحدة");
        System.out.println();
        
        // ===== 11. حذف الكتاب =====
        System.out.println("1️⃣1️⃣ حذف الكتاب:");
        System.out.println("-----------");
        boolean deleted = manager.removeBook("BOOK004");
        System.out.println("حذف Java Concurrency: " + (deleted ? "✅ نجح" : "❌ فشل"));
        System.out.println("عدد الكتب المتبقية: " + manager.getBooks().size());
        System.out.println();
        
        // ===== ملخص نهائي =====
        System.out.println("=== 📊 ملخص نهائي ===");
        System.out.println("عدد الكتب: " + manager.getBooks().size());
        System.out.println("عدد الأعضاء: " + manager.getMembers().size());
        System.out.println("عدد الاستعارات الكلية: " + manager.getLoans().size());
        System.out.println("عدد الاستعارات النشطة: " + 
            manager.getLoans().stream().filter(l -> !l.isReturned()).count());
    }
}
