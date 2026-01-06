package library_system.Classes;

public interface Borrowable {
    void borrowItem(String borrower);
    void returnItem();
    boolean isBorrowed();

}
