package library_system.Classes;

import library_system.Classes.Borrowable;
import library_system.Classes.Book;

public class BorrowableBook extends Book implements Borrowable {
    private boolean borrowed;
    private String borrower;

    public BorrowableBook(String title, String author, String itemId, int numberOfPages) {
        super(title, author, itemId, numberOfPages);
        this.borrowed = false;
    }

    @Override
    public void borrowItem(String borrower) {
        if (!borrowed) {
            this.borrower = borrower;
            this.borrowed = true;
            System.out.println("Item borrowed by: " + borrower);
        } else {
            System.out.println("Item is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            this.borrower = null;
            this.borrowed = false;
            System.out.println("Item returned.");
        } else {
            System.out.println("Item is not currently borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}

