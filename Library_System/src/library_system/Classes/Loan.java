package library_system.Classes;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * كلاس Loan مسؤول عن تتبع عمليات الاستعارة
 * يربط بين:
 * - العنصر (Book أو Magazine)
 * - العضو الذي استعار
 * - تاريخ الاستعارة
 * - تاريخ الإرجاع
 */
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;

    // العنصر المستعار
    private Item item;

    // العضو الذي قام بالاستعارة
    private Member member;

    // تاريخ الاستعارة
    private LocalDate borrowDate;

    // تاريخ الإرجاع (null إذا لم يُرجع بعد)
    private LocalDate returnDate;

    // إنشاء عملية استعارة جديدة
    public Loan(Item item, Member member) {
        this.item = item;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    // إرجاع العنصر
    public void returnItem() {
        this.returnDate = LocalDate.now();
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
