package library_system.Classes;

public class Book extends Item {
    private int pagenum;
    private static final long serialVersionUID = 1L;

    public Book(String title, String author, String itemId, int pagenum) {
        super(title, author, itemId);
        this.pagenum = pagenum;
    }

    public int getpagenum() {
        return pagenum;
    }
    
    public void stepagenum(){
         this.pagenum = pagenum;
    }

    @Override
    public void display() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Item ID: " + getItemId());
        System.out.println("Number of Pages: " + pagenum);
    }
    
    @Override
    public String info() {
        String result = 
        "Book Title: " + getTitle() + "  "+
       "Author: " + getAuthor() + "  "+
        "Item ID: " + getItemId() + "  "+
       "Number of Pages: " + pagenum + "  " ;
        
        return result;
    } 
    
        public static Book fromString(String str) {
        // Parsing the string and creating a new Book object
        String[] parts = str.split(" ");
        String title = parts[2];
        String author = parts[4];
        String itemId = parts[7];
        int pageNum = Integer.parseInt(parts[11]);
        return new Book(title, author, itemId, pageNum);
    }

}
