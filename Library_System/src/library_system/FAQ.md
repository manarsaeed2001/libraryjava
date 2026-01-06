# 📚 Library Management System - comprehensive questions and answers

## ❓ Questions 

### 1️⃣ LibraryManager 

**:**
LibraryManager Class Main that . from ArrayLists from with in .

```java
// ( - from)
ArrayList<Item> items = new ArrayList<>();
ArrayList<Member> members = new ArrayList<>();
// 
items.add(new Book(...));

// ( New - from)
LibraryManager manager = new LibraryManager();
manager.addBook(new Book(...)); // Practical 
```

**:**
- ✅ in 
- ✅ Easy Usage 
- ✅ OOP
- ✅ from from

---

### 2️⃣ about 

**:**
 `searchBooks()` that in about :

```java
// Search about on "Java"
ArrayList<Book> results = manager.searchBooks("Java");

for (Book book : results) {
 System.out.println(book.getTitle());
 System.out.println(book.getAuthor());
}
```

** Search:**
- ✅ about words in about
- ✅ about words in 
- ✅ Search (Java = java)

---

### 3️⃣ 

**:**
 `borrowBook()`:

```java
String message = manager.borrowBook("BOOK001", "MEM001");
System.out.println(message);

// :
// ✅ Borrowing 
// ❌ Existing
// ❌ Existing
// ❌ 
```

** about Borrowing:**
1. from 
2. from 
3. from 
4. Record Borrowing (Loan) New
5. ( )

---

### 4️⃣ 

**:**
 `returnBook()`:

```java
String message = manager.returnBook("BOOK001");
System.out.println(message);

// :
// ✅ 
// ✅ + Fees : X
// ❌ on Borrowing 
```

**Fee Calculation:**
- in 14 
- about Fees
- Fees = (Late Days) × 2.0 Riyals

---

### 5️⃣ StudentMember 

**:**
StudentMember () on discount 50% on Fees:

```java
// Regular
Member member1 = new Member("", "MEM001", "0501234567", "Regular");
double fee1 = member1.calculateFee(5); // 5 * 2.0 = 10

// 
StudentMember member2 = new StudentMember("", "MEM002", "0509876543");
double fee2 = member2.calculateFee(5); // (5 * 2.0) * 0.5 = 5
```

**:**
```
Late Days: 5
 Regular: 10 Riyals
: 5 Riyals (discount 50%)
```

---

### 6️⃣ 

**:**
 `isBookAvailable()`:

```java
if (manager.isBookAvailable("BOOK001")) {
 System.out.println(" ✅");
} else {
 System.out.println(" ❌");
}

// on Books 
ArrayList<Book> available = manager.getAvailableBooks();
```

---

### 7️⃣ with

**:**
 `getMemberActiveLoans()`:

```java
ArrayList<Loan> memberLoans = manager.getMemberActiveLoans("MEM001");

for (Loan loan : memberLoans) {
 System.out.println(loan.getItem().getTitle());
 System.out.println(" Borrowing: " + loan.getBorrowDate());
 System.out.println(": " + (loan.isReturned() ? "" : ""));
}
```

---

### 8️⃣ Encapsulation 

**:**
Encapsulation about Data Access :

```java
// ❌ - Access 
manager.books.add(book); // books 

// ✅ Correct - 
manager.addBook(book); // 

// ❌ - Fields 
book.pageNum = 1000;

// ✅ Correct - setter
book.setPageNum(1000);
```

**:**
- ✅ Data from 
- ✅ in in Access 
- ✅ Easy Development 

---

### 9️⃣ Inheritance 

**:**
Inheritance about from :

```
Person (Class Basic)
 ├── Member ( from Person)
 │ └── StudentMember ( from Member)
 └── Employee ( from Person)

Item (Class Basic)
 ├── Book ( from Item)
 │ └── BorrowableBook ( from Book)
 └── Magazine ( from Item)
```

**:**
```java
// StudentMember Member
StudentMember student = new StudentMember("", "STU001", "0501234567");
String name = student.getName(); // from Person
String membership = student.getMembershipType(); // from Member
```

---

### 🔟 Polymorphism 

**:**
Polymorphism about Type:

```java
// implements Searchable
Book book = new Book("Java", "Author", "ID", 500);
Magazine mag = new Magazine("Tech Monthly", "Publisher", "MAG001", 12);

// 
book.matches("Java"); // searches in title and author
mag.matches("Tech"); // in about ( )

// 
Member member = new Member("", "M1", "0501234567", "Regular");
StudentMember student = new StudentMember("", "S1", "0509876543");

// 
member.calculateFee(5); // 10
student.calculateFee(5); // 5
```

---

### 1️⃣1️⃣ Interface 

**:**
Interface Class:

```java
// 
public interface Searchable {
 boolean matches(String keyword);
}

// Book on 
public class Book extends Item implements Searchable {
 @Override
 public boolean matches(String keyword) {
 return getTitle().contains(keyword) || getAuthor().contains(keyword);
 }
}

// Usage
if (book instanceof Searchable) {
 if (book.matches("Java")) {
 // 
 }
}
```

---

### 1️⃣2️⃣ Data

**:**
you can Data to Library:

```java
// LibraryManager to Library
List<Item> items = new ArrayList<>(libraryManager.getBooks());
Library library = new Library(
 items,
 libraryManager.getMembers(),
 new ArrayList<>() // in
);

// 
FileManager.saveLibrary("data.txt", library);

// 
Library loaded = FileManager.loadLibrary("data.txt");
```

---

### 1️⃣3️⃣ about "null" with

**:**
null about " " "":

```java
// - null
Book book = manager.findBookById("UNKNOWN");
if (book == null) {
 System.out.println(" Existing");
} else {
 System.out.println(book.getTitle());
}

// from
Book book = manager.findBookById("BOOK001");
if (book != null) {
 System.out.println(book.info());
}
```

---

### 1️⃣4️⃣ New

**:**
 from Easy New:

```java
// : Borrowing
public String extendLoan(String bookId, int Days) {
 for (Loan loan : loans) {
 if (loan.getItem().getItemId().equals(bookId) && !loan.isReturned()) {
 // Date 
 return "✅ Period " + Days + " ";
 }
 }
 return "❌ on Borrowing ";
}
```

---

### 1️⃣5️⃣ Best practices

**:**

1. ** LibraryManager :**
 ```java
 // from on ArrayList
 manager.addBook(book);
 ```

2. ** from Errors:**
 ```java
 if (bookId == null || bookId.isEmpty()) {
 return "❌ with ";
 }
 ```

3. ** :**
 ```java
 // ✅ 
 ArrayList<Book> availableBooks = manager.getAvailableBooks();
 
 // ❌ 
 ArrayList<Book> b = manager.getBooks();
 ```

4. ** comments:**
 ```java
 // Fee Calculation on (Polymorphism)
 double fee = member.calculateFee(DaysLate);
 ```

5. ** Code:**
 ```java
 // Correct
 assertTrue(manager.borrowBook("B1", "M1").contains(""));
 ```

---

## 📌 Summary 

| | Explanation | Example |
|--------|-------|--------|
| **Encapsulation** | Data | `private ArrayList<Book> books;` |
| **Inheritance** | from | `StudentMember extends Member` |
| **Polymorphism** | | `calculateFee()` |
| **Interface** | Implementation | `implements Searchable` |
| **LibraryManager** | Class Main | |
| **Loan** | Record Borrowing | |

---

**Do you have questions ** 💡
