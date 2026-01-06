package library_system.Classes;

import java.util.ArrayList;

/**
 * LibraryManager - Main class for library management
 * Consolidates all operations related to books, members, and loans
 * 
 * OOP Principles:
 * - Encapsulation: All fields are private with getters/setters
 * - Inheritance: Uses class hierarchy (Person, Item, Member, StudentMember)
 * - Polymorphism: Override methods in calculateFee and matches
 * - Interface: Uses Searchable and Borrowable interfaces
 */
public class LibraryManager {
    
    // ===== Encapsulation: Private fields =====
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;
    
    // Constructor
    public LibraryManager() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }
    
    // ===== Getters =====
    public ArrayList<Book> getBooks() {
        return books;
    }
    
    public ArrayList<Member> getMembers() {
        return members;
    }
    
    public ArrayList<Loan> getLoans() {
        return loans;
    }
    
    // ===== BOOK OPERATIONS =====
    
    /**
     * Add a new book
     */
    public void addBook(Book book) {
        if (book != null && !books.contains(book)) {
            books.add(book);
        }
    }
    
    /**
     * Remove a book
     */
    public boolean removeBook(String bookId) {
        return books.removeIf(book -> book.getItemId().equals(bookId));
    }
    
    /**
     * Search for a book by ID
     */
    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getItemId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Search books using Searchable Interface
     * Polymorphism: Uses matches() from Searchable
     */
    public ArrayList<Book> searchBooks(String keyword) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            // Use Searchable interface
            if (book.matches(keyword)) {
                results.add(book);
            }
        }
        return results;
    }
    
    /**
     * Get only available books
     */
    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (isBookAvailable(book.getItemId())) {
                available.add(book);
            }
        }
        return available;
    }
    
    // ===== MEMBER OPERATIONS =====
    
    /**
     * Add a new member
     */
    public void addMember(Member member) {
        if (member != null && !members.contains(member)) {
            members.add(member);
        }
    }
    
    /**
     * Remove a member
     */
    public boolean removeMember(String memberId) {
        return members.removeIf(member -> member.getId().equals(memberId));
    }
    
    /**
     * Search for a member by ID
     */
    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    // ===== LOAN / BORROW OPERATIONS =====
    
    /**
     * Borrow a book
     * Updates book status (unavailable)
     * Creates a new loan record
     */
    public String borrowBook(String bookId, String memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);
        
        // Validate data
        if (book == null) {
            return "❌ Book not found";
        }
        if (member == null) {
            return "❌ Member not found";
        }
        
        // Check book availability
        if (!isBookAvailable(bookId)) {
            return "❌ Book is currently unavailable";
        }
        
        // Create new loan record
        Loan loan = new Loan(book, member);
        loans.add(loan);
        
        return "✅ Book borrowed successfully";
    }
    
    /**
     * Return a book
     * Update loan record as returned
     */
    public String returnBook(String bookId) {
        for (Loan loan : loans) {
            if (loan.getItem().getItemId().equals(bookId) && !loan.isReturned()) {
                loan.returnItem();
                
                // Calculate late fees if applicable
                long daysLate = loan.calculateDaysLate();
                if (daysLate > 0) {
                    Member member = loan.getMember();
                    double fee = member.calculateFee((int)daysLate);
                    return "✅ Book returned successfully\n⚠️ Late fees: " + fee;
                }
                
                return "✅ Book returned successfully";
            }
        }
        return "❌ No active loan found for this book";
    }
    
    /**
     * Check if a book is available
     * Available book = no active loan
     */
    public boolean isBookAvailable(String bookId) {
        for (Loan loan : loans) {
            if (loan.getItem().getItemId().equals(bookId) && !loan.isReturned()) {
                return false; // Book is borrowed
            }
        }
        return true; // Book is available
    }
    
    /**
     * Get active loans for a member
     */
    public ArrayList<Loan> getMemberActiveLoans(String memberId) {
        ArrayList<Loan> memberLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getMember().getId().equals(memberId) && !loan.isReturned()) {
                memberLoans.add(loan);
            }
        }
        return memberLoans;
    }
    
    /**
     * Display status of all books
     */
    public String getAllBooksStatus() {
        if (books.isEmpty()) {
            return "No books in library";
        }
        
        StringBuilder status = new StringBuilder();
        for (Book book : books) {
            status.append(book.info()).append("\n");
            status.append("Status: ").append(isBookAvailable(book.getItemId()) ? "Available ✅" : "Borrowed ❌").append("\n");
            status.append("-------------------\n");
        }
        return status.toString();
    }
}
