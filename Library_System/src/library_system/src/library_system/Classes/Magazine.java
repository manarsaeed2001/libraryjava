package library_system.Classes;

import library_system.Classes.Item;

public class Magazine extends Item {
    private int issueNumber;
        private static final long serialVersionUID = 1L;

    public Magazine(String title, String author, String itemId, int issueNumber) {
        super(title, author, itemId);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void display() {
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Item ID: " + getItemId());
        System.out.println("Issue Number: " + issueNumber);
    }
    
    @Override
    public String info() {
        String result = 
        "Magazine Title: " + getTitle() + "  "+
       "Author: " + getAuthor() + "  "+
        "Item ID: " + getItemId() + "  "+
       "Issue Number: " + issueNumber + "  " ;
        
        return result;
    } 
     
     public static Magazine fromString(String str) {
        // Parsing the string and creating a new Magazine object
        String[] parts = str.split(" ");
        String title = parts[2];
        String author = parts[4];
        String itemId = parts[7];
        int issueNumber = Integer.parseInt(parts[10]);
        return new Magazine(title, author, itemId, issueNumber);
    }


}
