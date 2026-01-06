package library_system.Classes;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Loan class for tracking borrowing operations
 * Links between:
 * - The borrowed item (Book or Magazine)
 * - The member who borrowed it
 * - Borrow date and return date
 */
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;

    // The borrowed item
    private Item item;

    // The member who borrowed
    private Member member;

    // Borrow date
    private LocalDate borrowDate;

    // Return date (null if not returned yet)
    private LocalDate returnDate;

    // Create new borrow operation
    public Loan(Item item, Member member) {
        this.item = item;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    // Return the item
    public void returnItem() {
        this.returnDate = LocalDate.now();
    }

    // Is the item returned?
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
    
    /**
     * Calculate days late
     * Books must be returned within 14 days
     * Late fees are calculated based on days over the limit
     */
    public long calculateDaysLate() {
        if (isReturned()) {
            long borrowDays = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, returnDate);
            long daysLate = Math.max(0, borrowDays - 14); // 14-day grace period
            return daysLate;
        }
        return 0;
    }
}
