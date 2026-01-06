package library_system.Classes;

public class Book extends Item implements Searchable {

    private int pageNum;
    private static final long serialVersionUID = 1L;

    public Book(String title, String author, String itemId, int pageNum) {
        super(title, author, itemId);
        this.pageNum = pageNum;
    }

    // ===== Getters & Setters =====
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    // ===== Searchable =====
    @Override
    public boolean matches(String keyword) {
        return getTitle().toLowerCase().contains(keyword.toLowerCase())
            || getAuthor().toLowerCase().contains(keyword.toLowerCase());
    }

    // ===== Display =====
    @Override
    public void display() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Item ID: " + getItemId());
        System.out.println("Number of Pages: " + pageNum);
    }

    @Override
    public String info() {
        return "Book Title: " + getTitle() + "  " +
               "Author: " + getAuthor() + "  " +
               "Item ID: " + getItemId() + "  " +
               "Number of Pages: " + pageNum;
    }

    // ===== File Parsing =====
    public static Book fromString(String str) {
        String[] parts = str.split(" ");
        String title = parts[2];
        String author = parts[4];
        String itemId = parts[7];
        int pageNum = Integer.parseInt(parts[11]);
        return new Book(title, author, itemId, pageNum);
    }
}
