package library_system.Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable {

    private Item item;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(Item item, Member member) {
        this.item = item;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
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

    public boolean isReturned() {
        return returnDate != null;
    }

    public void returnItem() {
        this.returnDate = LocalDate.now();
    }
}
