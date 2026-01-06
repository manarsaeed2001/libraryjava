# 📚 Library Management System - Report Improvements 

## ✅ Improvements from

### 1️⃣ LibraryManager Comprehensive
**:** `LibraryManager.java`

**:**
- ✅ **Encapsulation**: Fields `private` with getters/setters
- ✅ **Separation of Concerns**: from about 
- ✅ **Comprehensive Methods**:
 - Book Management (Add, Remove, Search, Display)
 - Member Management (Add, Remove, Search)
 - (Borrow, Return, Track Loans)
 - Fee Calculation 

**Example:**
```java
LibraryManager manager = new LibraryManager();
manager.addBook(new Book("Java Programming", "Gosling", "BOOK001", 500));
ArrayList<Book> results = manager.searchBooks("Java");
String message = manager.borrowBook("BOOK001", "MEM001");
```

---

### 2️⃣ Loan
**:** `Loan.java`

**:**
```java
// Calculate Late Days (14 )
public long calculateDaysLate() {
 if (isReturned()) {
 long borrowDays = ChronoUnit.DAYS.between(borrowDate, returnDate);
 long DaysLate = Math.max(0, borrowDays - 14);
 return DaysLate;
 }
 return 0;
}
```

**:** Calculate Fees about 

---

### 3️⃣ OOP Implemented

#### ) Encapsulation
```java
// in LibraryManager
private ArrayList<Book> books; // private
private ArrayList<Member> members; // private
private ArrayList<Loan> loans; // private

public ArrayList<Book> getBooks() { return books; } // getter
public void addBook(Book book) { ... } // method
```

#### ) Inheritance
```java
// StudentMember from Member
public class StudentMember extends Member {
 @Override
 public double calculateFee(int DaysLate) {
 return super.calculateFee(DaysLate) * 0.5; // discount 50%
 }
}
```

#### ) Polymorphism
```java
// in searchBooks() - interface Searchable
for (Book book : books) {
 if (book.matches(keyword)) { // Polymorphic call
 results.add(book);
 }
}
```

#### ) Interface
```java
// Searchable interface
public interface Searchable {
 boolean matches(String keyword);
}

// Book implements Searchable
public class Book extends Item implements Searchable {
 @Override
 public boolean matches(String keyword) {
 return getTitle().toLowerCase().contains(keyword.toLowerCase())
 || getAuthor().toLowerCase().contains(keyword.toLowerCase());
 }
}
```

---

### 4️⃣ Basic

#### 
```java
manager.addBook(new Book("Title", "Author", "ID", 300));
// : Borrowing
```

#### Search about 
```java
ArrayList<Book> results = manager.searchBooks("Programming");
// in about 
```

#### Borrowing 
```java
String message = manager.borrowBook("BOOK001", "MEM001");
// ✅ " Borrowing " 
// 
// ❌ " "
```

#### 
```java
String message = manager.returnBook("BOOK001");
// : + Fee Calculation 
```

#### 
```java
boolean available = manager.isBookAvailable("BOOK001");
// true = 
// false = 
```

---

## 📊 

### :
```
1. 
 ├─ 
 └─ 

2. 
 ├─ Borrowing (loan.isReturned() = false)
 └─ Borrowing

3. 
 ├─ Borrowing (loan.isReturned() = true)
 ├─ Calculate Late Days
 └─ Fee Calculation 
```

---

## 💰 Fee Calculation 

### :
```
 = 14 
Late Days = Borrowing - 14

Members Regular:
 Fees = Late Days × 2.0

 (StudentMember):
 Fees = (Late Days × 2.0) × 0.5 // discount 50%
```

### :
```
: 1 
: 20 
 Borrowing = 19 
Late Days = 19 - 14 = 5 

 Regular: 5 × 2.0 = 10
: 5 × 2.0 × 0.5 = 5
```

---

## 🔍 Search in

### Search words :
```java
ArrayList<Book> results = manager.searchBooks("Programming");
// about:
// - "Programming" in about
// - "Programming" in 
// - Case-insensitive ( )
```

### on Books :
```java
ArrayList<Book> available = manager.getAvailableBooks();
// Books that 
```

### :
```java
ArrayList<Loan> memberLoans = manager.getMemberActiveLoans("MEM001");
// Books that 
```

---

## 🛠️ 

### ✅ OOP:
- [x] Encapsulation - All fields are private
- [x] Inheritance - StudentMember extends Member
- [x] Polymorphism - override calculateFee()
- [x] Interface - Searchable interface

### ✅ Features Basic:
- [x] Books
- [x] Books
- [x] Search books
- [x] Borrowing Books
- [x] Books
- [x] 

### ✅ Features in:
- [x] Fee Calculation 
- [x] StudentMember with discount 50%
- [x] Borrowing and Returning
- [x] 

---

## 📝 Files /

| | Status | |
|------|--------|---------|
| `LibraryManager.java` | ✨ New | Class Main Comprehensive |
| `Loan.java` | ✏️ with | calculateDaysLate() |
| `Member.java` | ✓ | calculateFee() Existing |
| `StudentMember.java` | ✓ | override discount |
| `Book.java` | ✓ | implements Searchable |
| `Searchable.java` | ✓ | Search |

---

## 🚀 in Usage

### :
```java
LibraryManager manager = new LibraryManager();

// 
manager.addBook(new Book("Java Programming", "Gosling", "BOOK001", 500));
manager.addBook(new Book("Data Structures", "Cormen", "BOOK002", 400));

// Members
manager.addMember(new Member("", "MEM001", "0501234567", "Regular"));
manager.addMember(new StudentMember("", "MEM002", "0509876543"));
```

### Borrowing:
```java
// Borrowing
String msg1 = manager.borrowBook("BOOK001", "MEM001");
System.out.println(msg1); // ✅ Borrowing 

// ( 20 )
String msg2 = manager.returnBook("BOOK001");
System.out.println(msg2); // ✅ + Fees
```

### Search:
```java
ArrayList<Book> results = manager.searchBooks("Java");
for (Book book : results) {
 System.out.println(book.info());
}
```

---

## 📌 

1. **Serialization**: Classes saving/loading from Files
2. **Thread Safety**: `CopyOnWriteArrayList`
3. **Validation**: from Data
4. **Comments**: JavaDoc

---

## 🎯 Steps (Optional)

1. Search Button in Fees
2. UI Display (available/borrowed)
3. (Logging)
4. New Borrowing
5. 

---

** from Improvements ✅**
Project Best practices in Programming Java Basic OOP.
