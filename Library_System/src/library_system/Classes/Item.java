package library_system.Classes;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String title;
    private String author;
    private String itemId;

    public Item(String title, String author, String itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemId() {
        return itemId;
    }
    
      


    public abstract void display();
    
     public abstract String info();
}
