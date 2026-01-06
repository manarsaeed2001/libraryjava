/**
 * INTEGRATION GUIDE - Guide LibraryManager with Interface Fees
 * 
 * this in LibraryManager New with Swing
 */

/*
 * ============================================
 * 1. LibraryManager in Main program
 * ============================================
 */

// in The_Main.java
public static void main(String[] args) {
 // from ArrayLists from
 // ArrayList<Item> items = new ArrayList<>();
 // ArrayList<Member> members = new ArrayList<>();
 
 // LibraryManager
 LibraryManager libraryManager = new LibraryManager();
 
 // Data Existing
 Library savedLibrary = FileManager.loadLibrary("A new file.txt");
 if (savedLibrary != null) {
 // Data to 
 for (Item item : savedLibrary.getItems()) {
 if (item instanceof Book) {
 libraryManager.addBook((Book) item);
 }
 }
 for (Member member : savedLibrary.getMembers()) {
 libraryManager.addMember(member);
 }
 }
 
 // Fees
 SwingUtilities.invokeLater(() -> {
 Log_in loginWindow = new Log_in(libraryManager);
 loginWindow.setVisible(true);
 });
}

/*
 * ============================================
 * 2. in Admin_page.java - Books
 * ============================================
 */

private void addBookAction() {
 String title = titleField.getText();
 String author = authorField.getText();
 String bookId = bookIdField.getText();
 int pages = Integer.parseInt(pagesField.getText());
 
 Book book = new Book(title, author, bookId, pages);
 libraryManager.addBook(book);
 
 // 
 refreshBookTable();
 
 // 
 JOptionPane.showMessageDialog(this, "✅ ");
}

private void refreshBookTable() {
 DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
 model.setRowCount(0); // 
 
 // Books New
 for (Book book : libraryManager.getBooks()) {
 Object[] row = {
 book.getItemId(),
 book.getTitle(),
 book.getAuthor(),
 book.getPageNum(),
 libraryManager.isBookAvailable(book.getItemId()) ? " ✅" : " ❌"
 };
 model.addRow(row);
 }
}

/*
 * ============================================
 * 3. in Member_page.java - Borrowing 
 * ============================================
 */

private void borrowBookAction() {
 String bookId = JOptionPane.showInputDialog(" with :");
 
 // with
 String memberId = currentMemberId;
 
 String result = libraryManager.borrowBook(bookId, memberId);
 JOptionPane.showMessageDialog(this, result);
 
 // Display Books 
 refreshAvailableBooks();
 
 // 
 refreshMemberLoans();
}

private void refreshAvailableBooks() {
 DefaultListModel<String> model = new DefaultListModel<>();
 
 for (Book book : libraryManager.getAvailableBooks()) {
 model.addElement(book.getTitle() + " (" + book.getItemId() + ")");
 }
 
 availableBooksPanel.setModel(model);
}

private void refreshMemberLoans() {
 DefaultTableModel model = (DefaultTableModel) loansTable.getModel();
 model.setRowCount(0);
 
 for (Loan loan : libraryManager.getMemberActiveLoans(currentMemberId)) {
 Object[] row = {
 loan.getItem().getItemId(),
 loan.getItem().getTitle(),
 loan.getBorrowDate(),
 " 📖"
 };
 model.addRow(row);
 }
}

/*
 * ============================================
 * 4. Search books - Search Action
 * ============================================
 */

private void searchBooksAction() {
 String keyword = searchField.getText();
 
 if (keyword.isEmpty()) {
 JOptionPane.showMessageDialog(this, "⚠️ words ");
 return;
 }
 
 ArrayList<Book> results = libraryManager.searchBooks(keyword);
 
 // Display in 
 DefaultTableModel model = (DefaultTableModel) searchResultsTable.getModel();
 model.setRowCount(0);
 
 if (results.isEmpty()) {
 JOptionPane.showMessageDialog(this, "❌ on ");
 return;
 }
 
 for (Book book : results) {
 Object[] row = {
 book.getItemId(),
 book.getTitle(),
 book.getAuthor(),
 libraryManager.isBookAvailable(book.getItemId()) ? " ✅" : " ❌"
 };
 model.addRow(row);
 }
 
 JOptionPane.showMessageDialog(this, "✅ on " + results.size() + " ");
}

/*
 * ============================================
 * 5. 
 * ============================================
 */

private void returnBookAction() {
 String bookId = JOptionPane.showInputDialog(" with :");
 
 String result = libraryManager.returnBook(bookId);
 JOptionPane.showMessageDialog(this, result);
 
 // 
 refreshMemberLoans();
 refreshBookTable();
}

/*
 * ============================================
 * 6. Data
 * ============================================
 */

private void saveDataAction() {
 // LibraryManager to Library 
 Library library = new Library(
 convertBooksToItems(libraryManager.getBooks()),
 libraryManager.getMembers(),
 new ArrayList<>() // in 
 );
 
 FileManager.saveLibrary("A new file.txt", library);
 JOptionPane.showMessageDialog(this, "✅ Data ");
}

/*
 * ============================================
 * 7. Display 
 * ============================================
 */

private void showStatistics() {
 int totalBooks = libraryManager.getBooks().size();
 int availableBooks = libraryManager.getAvailableBooks().size();
 int borrowedBooks = totalBooks - availableBooks;
 int totalMembers = libraryManager.getMembers().size();
 int activeLoans = (int) libraryManager.getLoans()
 .stream()
 .filter(l -> !l.isReturned())
 .count();
 
 String stats = String.format(
 "📚 \n" +
 "==================\n" +
 " Books: %d\n" +
 "Books : %d ✅\n" +
 "Books : %d 📖\n" +
 " Members: %d\n" +
 " : %d",
 totalBooks, availableBooks, borrowedBooks, totalMembers, activeLoans
 );
 
 JOptionPane.showMessageDialog(this, stats);
}

/*
 * ============================================
 * 8. Books 
 * ============================================
 */

// in initComponents() 
private void createBookTable() {
 String[] columnNames = {"with", "about", "", "pages", "Status"};
 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
 
 bookTable = new JTable(model);
 bookTable.setColumnSelectionAllowed(false);
 bookTable.setRowSelectionAllowed(true);
 
 // Data 
 refreshBookTable();
}

/*
 * ============================================
 * 9. Error Handling from 
 * ============================================
 */

private void validateAndAddBook() {
 try {
 if (titleField.getText().isEmpty()) {
 throw new IllegalArgumentException("⚠️ about ");
 }
 if (authorField.getText().isEmpty()) {
 throw new IllegalArgumentException("⚠️ ");
 }
 if (bookIdField.getText().isEmpty()) {
 throw new IllegalArgumentException("⚠️ with ");
 }
 
 int pages = Integer.parseInt(pagesField.getText());
 if (pages <= 0) {
 throw new IllegalArgumentException("⚠️ pages ");
 }
 
 // Data Correct
 addBookAction();
 
 } catch (NumberFormatException e) {
 JOptionPane.showMessageDialog(this, "❌ pages ");
 } catch (IllegalArgumentException e) {
 JOptionPane.showMessageDialog(this, e.getMessage());
 }
}

/*
 * ============================================
 * 10. on 
 * ============================================
 */

// New 
public void extendLoanPeriod(String bookId, int additionalDays) {
 // Data from
 for (Loan loan : libraryManager.getLoans()) {
 if (loan.getItem().getItemId().equals(bookId) && !loan.isReturned()) {
 // Date New (in )
 System.out.println(" Period " + additionalDays + " ");
 return;
 }
 }
}

/*
 * ============================================
 * Summary
 * ============================================
 * 
 * :
 * ✅ Clean and easy to understand code
 * ✅ Easy Development
 * ✅ from 
 * ✅ Easy (Unit Testing)
 * ✅ OOP Correct
 * 
 * Steps:
 * 1. ArrayLists LibraryManager 
 * 2. (addBook, searchBooks, etc)
 * 3. Interface Fees Practical
 * 4. / Data about 
 */
