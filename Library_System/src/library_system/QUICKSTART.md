# 🔧 Guide 

## 📦 

- **Java 8 **
- **IDE ** (NetBeans, Eclipse, VS Code)
- **Console/Terminal**

---

## 🚀 

### 1️⃣ Compile the program

```bash
cd "c:\Users\asmaa\Downloads\finalbackup_library\Library_System\src"

javac -encoding UTF-8 -d ..\build\classes library_system\Classes\*.java library_system\*.java
```

### 2️⃣ Main program

```bash
cd "c:\Users\asmaa\Downloads\finalbackup_library\Library_System\build\classes"

java -cp . library_system.The_Main
```

### 3️⃣ Program Display Demonstration

```bash
cd "c:\Users\asmaa\Downloads\finalbackup_library\Library_System\build\classes"

java library_system.LibraryDemo
```

---

## 📋 Files 

### Files Basic :

```
1. README.md ← Start here
2. IMPROVEMENTS_REPORT.md ← Structure
3. INTEGRATION_GUIDE.md ← with Interface
4. FAQ.md ← Questions Comprehensive
5. FINAL_REPORT.md ← Final Summary
```

### Files :

```
1. LibraryManager.java ← Class Main New
2. Loan.java ← Enhanced New
3. LibraryDemo.java ← examples Complete
4. Book.java ← Searchable
5. StudentMember.java ← on Polymorphism
```

---

## 🎯 Usage Quick

### LibraryManager:

```java
LibraryManager manager = new LibraryManager();
```

### :

```java
Book book = new Book("Java Programming", "Herbert Schildt", "BOOK001", 500);
manager.addBook(book);
```

### :

```java
Member member = new Member("", "MEM001", "0501234567", "Regular");
manager.addMember(member);
```

### (discount):

```java
StudentMember student = new StudentMember("", "STU001", "0509876543");
manager.addMember(student);
```

### Borrowing :

```java
String result = manager.borrowBook("BOOK001", "MEM001");
System.out.println(result); // ✅ Borrowing 
```

### :

```java
String result = manager.returnBook("BOOK001");
System.out.println(result); // ✅ + Fees
```

### Search:

```java
ArrayList<Book> results = manager.searchBooks("Java");
for (Book book : results) {
 System.out.println(book.getTitle());
}
```

### Books :

```java
ArrayList<Book> available = manager.getAvailableBooks();
```

### :

```java
ArrayList<Loan> loans = manager.getMemberActiveLoans("MEM001");
```

### Fee Calculation:

```java
double fee = member.calculateFee(5); // 5 
```

---

## 🧪 

### 1: Display Books

```java
manager.addBook(new Book("Book1", "Author1", "B1", 300));
manager.addBook(new Book("Book2", "Author2", "B2", 400));
System.out.println("Books : " + manager.getBooks().size()); // 2
```

### 2: Search

```java
ArrayList<Book> results = manager.searchBooks("Book1");
System.out.println(" Search: " + results.size()); // 1
```

### 3: Borrowing and Returning

```java
String borrow = manager.borrowBook("B1", "M1");
System.out.println(borrow); // ✅ Borrowing 

boolean available = manager.isBookAvailable("B1");
System.out.println(": " + available); // false

String return_msg = manager.returnBook("B1");
System.out.println(return_msg); // ✅ 
```

### 4: discount

```java
Member normal = new Member("A", "M1", "050", "Regular");
StudentMember student = new StudentMember("B", "S1", "050");

double fee1 = normal.calculateFee(5); // 10
double fee2 = student.calculateFee(5); // 5

System.out.println(": " + fee1); // 10
System.out.println(": " + fee2); // 5
```

---

## 📊 

### about Run LibraryDemo:

```
=== 📚 Library Management System - Display Demonstration ===

1️⃣ Books:
-----------
✅ 4 

2️⃣ Members:
-----------
✅ 3 Members ( Regular + discount 50%)

3️⃣ Books:
-----------
Book Title: Java Programming Author: Herbert Schildt Item ID: BOOK001 Number of Pages: 500
Status: ✅
...

4️⃣ Search books:
-----------
Search about 'Java':
 ✓ Book Title: Java Programming ...
 ✓ Book Title: Java Concurrency ...

5️⃣ Borrowing Books:
-----------
 Java Programming: ✅ Borrowing 
...

=== 📊 Summary ===
 Books: 3
 Members: 3
 : 3
 : 1
```

---

## ❌ Errors 

### ❌ "Can't find main class"

**:** with Program 

**:**
```bash
javac -encoding UTF-8 -d ..\build\classes library_system\Classes\*.java library_system\*.java
```

### ❌ "Class Not Found Exception"

**:** in 

**:**
```bash
# in build\classes
cd ..\build\classes
```

### ❌ Encoding errors

**:** Total Correct

**:**
```bash
javac -encoding UTF-8 ... # UTF-8 
```

### ❌ ClassNotFoundException in Runtime

**:** Files .class Existing in 

**:**
```bash
# Complete from New
javac -encoding UTF-8 -d ..\build\classes library_system\Classes\*.java library_system\*.java
```

---

## 🔄 

### :

```
1. README.md
2. FAQ.md
3. LibraryDemo
4. Code in LibraryManager.java
5. Program
```

### :

```
1. IMPROVEMENTS_REPORT.md
2. LibraryManager 
3. INTEGRATION_GUIDE.md with Interface
4. New
```

### :

```
1. LibraryDemo
2. Practical 
3. Data 
4. from Fees 
```

---

## 📝 

1. ** LibraryManager **
 - ArrayList 
 - LibraryManager

2. ** from Errors**
 - 
 - ✅ ❌ 

3. ** Data**
 - FileManager Data
 - Data about 

4. ** OOP**
 - Encapsulation
 - Inheritance Polymorphism
 - Interfaces

---

## 🎓 in

- comments in Code - 
- IDE Code 
- Program 
- about 

---

## ✅ Checklist 

- [ ] Java (java -version)
- [ ] Project in Correct
- [ ] Files .java Existing
- [ ] Compile the program 
- [ ] Correct
- [ ] Program runs without errors

---

## 🚀 Steps 

1. Main program LibraryDemo
2. 
3. Code Documentation
4. New
5. in 

---

** ! ! 🎉**
