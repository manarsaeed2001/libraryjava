package library_system.Classes;

import java.time.LocalDate;

/*
 * كلاس Loan مسؤول عن تتبع عمليات الاستعارة
 * يربط بين:
 * - العنصر (كتاب / مجلة)
 * - العضو الذي استعار
 * - تاريخ الاستعارة
 * - تاريخ الإرجاع
 */
public class Loan {

    // العنصر المستعار (Book أو Magazine)
    private Item item;

    // العضو الذي قام بالاستعارة
    private Member member;

    // تاريخ الاستعارة
    private LocalDate borrowDate;

    // تاريخ الإرجاع (يكون null إذا لم يُرجع بعد)
    private LocalDate returnDate;

    // إنشاء عملية استعارة جديدة
    public Loan(Item item, Member member) {
        this.item = item;
        this.member = member;
        this.borrowDate = LocalDate.now(); // تاريخ اليوم
        this.returnDate = null;            // لم يُرجع بعد
    }

    // إرجاع العنصر
    public void returnItem() {
        this.returnDate = LocalDate.now(); // تسجيل تاريخ الإرجاع
    }

    // هل تم إرجاع العنصر؟
    public boolean isReturned() {
        return returnDate != null;
    }

    public Item getItem() {
        return item;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
