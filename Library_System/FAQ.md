# 📚 نظام إدارة المكتبة - أسئلة وأجوبة شاملة

## ❓ أسئلة متكررة

### 1️⃣ ما هي LibraryManager وملاذا يجب استخدامها؟

**الإجابة:**
LibraryManager هي الفئة الرئيسية التي تدير جميع عمليات المكتبة. بدلاً من استخدام عدة ArrayLists منفصلة، تجمع كل الوظائف في مكان واحد.

```java
// قبل (الطريقة القديمة - غير منظمة)
ArrayList<Item> items = new ArrayList<>();
ArrayList<Member> members = new ArrayList<>();
// إضافة كتاب يدويا
items.add(new Book(...));

// بعد (الطريقة الجديدة - منظمة)
LibraryManager manager = new LibraryManager();
manager.addBook(new Book(...)); // نفس العملية لكن أوضح
```

**المزايا:**
- ✅ كل عمليات المكتبة في مكان واحد
- ✅ سهل الاستخدام والصيانة
- ✅ يتبع مبادئ OOP
- ✅ آمن ومنظم

---

### 2️⃣ كيف أبحث عن كتاب؟

**الإجابة:**
استخدم دالة `searchBooks()` التي تبحث في العنوان واسم المؤلف:

```java
// البحث عن كتب تحتوي على "Java"
ArrayList<Book> results = manager.searchBooks("Java");

for (Book book : results) {
    System.out.println(book.getTitle());
    System.out.println(book.getAuthor());
}
```

**كيف يعمل البحث:**
- ✅ يبحث عن الكلمة في العنوان
- ✅ يبحث عن الكلمة في اسم المؤلف
- ✅ البحث غير حساس لحالة الأحرف (Java = java)

---

### 3️⃣ كيف أستعير كتاباً؟

**الإجابة:**
استخدم دالة `borrowBook()`:

```java
String message = manager.borrowBook("BOOK001", "MEM001");
System.out.println(message);

// النتائج الممكنة:
// ✅ تم استعارة الكتاب بنجاح
// ❌ الكتاب غير موجود
// ❌ العضو غير موجود
// ❌ الكتاب غير متاح حالياً
```

**ماذا يحدث عند الاستعارة:**
1. التحقق من وجود الكتاب
2. التحقق من وجود العضو
3. التحقق من توفر الكتاب
4. إنشاء سجل استعارة (Loan) جديد
5. تحديث حالة الكتاب (أصبح مستعاراً)

---

### 4️⃣ كيف أرجع كتاباً؟

**الإجابة:**
استخدم دالة `returnBook()`:

```java
String message = manager.returnBook("BOOK001");
System.out.println(message);

// النتائج الممكنة:
// ✅ تم إرجاع الكتاب بنجاح
// ✅ تم إرجاع الكتاب بنجاح + رسوم التأخير: X
// ❌ لم يتم العثور على استعارة نشطة
```

**حساب الرسوم:**
- الكتاب يُرجع في مدة 14 يوم
- إذا تأخرت عن ذلك، تُحسب الرسوم
- الرسوم = (أيام التأخير) × 2.0 ريال

---

### 5️⃣ ما هو StudentMember وما هي مميزاته؟

**الإجابة:**
StudentMember هو عضو خاص (طالب) يحصل على خصم 50% على الرسوم:

```java
// عضو عادي
Member member1 = new Member("أحمد", "MEM001", "0501234567", "Regular");
double fee1 = member1.calculateFee(5); // 5 * 2.0 = 10

// طالب
StudentMember member2 = new StudentMember("فاطمة", "MEM002", "0509876543");
double fee2 = member2.calculateFee(5); // (5 * 2.0) * 0.5 = 5
```

**الفرق:**
```
أيام التأخير: 5
العضو العادي: 10 ريال
الطالب: 5 ريال (خصم 50%)
```

---

### 6️⃣ كيف أعرف أن الكتاب متاح أم لا؟

**الإجابة:**
استخدم دالة `isBookAvailable()`:

```java
if (manager.isBookAvailable("BOOK001")) {
    System.out.println("الكتاب متاح ✅");
} else {
    System.out.println("الكتاب مستعار ❌");
}

// أو احصل على قائمة الكتب المتاحة
ArrayList<Book> available = manager.getAvailableBooks();
```

---

### 7️⃣ كيف أعرف استعارات عضو معين؟

**الإجابة:**
استخدم دالة `getMemberActiveLoans()`:

```java
ArrayList<Loan> memberLoans = manager.getMemberActiveLoans("MEM001");

for (Loan loan : memberLoans) {
    System.out.println(loan.getItem().getTitle());
    System.out.println("تاريخ الاستعارة: " + loan.getBorrowDate());
    System.out.println("حالة: " + (loan.isReturned() ? "مرجع" : "نشط"));
}
```

---

### 8️⃣ ما هي Encapsulation وكيف طُبقت؟

**الإجابة:**
Encapsulation تعني إخفاء تفاصيل البيانات وعدم السماح بالوصول المباشر:

```java
// ❌ خطأ - لا يمكن الوصول مباشرة
manager.books.add(book); // books محمية

// ✅ صحيح - استخدم الدوال العامة
manager.addBook(book);   // دالة عامة

// ❌ خطأ - لا تستطيع تغيير الحقول مباشرة
book.pageNum = 1000;

// ✅ صحيح - استخدم setter
book.setPageNum(1000);
```

**الفوائد:**
- ✅ حماية البيانات من التعديل الخاطئ
- ✅ التحكم في كيفية الوصول للبيانات
- ✅ سهل التطوير والصيانة

---

### 9️⃣ ما هي Inheritance وكيف طُبقت؟

**الإجابة:**
Inheritance تعني أن فئة ترث من فئة أخرى:

```
Person (الفئة الأساسية)
  ├── Member (يرث من Person)
  │    └── StudentMember (يرث من Member)
  └── Employee (يرث من Person)

Item (الفئة الأساسية)
  ├── Book (يرث من Item)
  │    └── BorrowableBook (يرث من Book)
  └── Magazine (يرث من Item)
```

**الفائدة:**
```java
// StudentMember يرث كل خصائص Member
StudentMember student = new StudentMember("أحمد", "STU001", "0501234567");
String name = student.getName();      // من Person
String membership = student.getMembershipType(); // من Member
```

---

### 🔟 ما هي Polymorphism وكيف طُبقت؟

**الإجابة:**
Polymorphism تعني أن نفس الدالة تتصرف بشكل مختلف حسب النوع:

```java
// كلاهما implements Searchable
Book book = new Book("Java", "Author", "ID", 500);
Magazine mag = new Magazine("Tech Monthly", "Publisher", "MAG001", 12);

// نفس الدالة بتصرفات مختلفة
book.matches("Java");    // يبحث في العنوان والمؤلف
mag.matches("Tech");     // يبحث في العنوان والناشر (إذا كانت مطبقة)

// أو
Member member = new Member("أحمد", "M1", "0501234567", "Regular");
StudentMember student = new StudentMember("فاطمة", "S1", "0509876543");

// نفس الدالة بنتائج مختلفة
member.calculateFee(5);  // 10
student.calculateFee(5); // 5
```

---

### 1️⃣1️⃣ ما هي Interface وكيف طُبقت؟

**الإجابة:**
Interface عقد يحدد ما يجب أن تفعله الفئة:

```java
// تعريف العقد
public interface Searchable {
    boolean matches(String keyword);
}

// Book توافق على العقد
public class Book extends Item implements Searchable {
    @Override
    public boolean matches(String keyword) {
        return getTitle().contains(keyword) || getAuthor().contains(keyword);
    }
}

// الاستخدام
if (book instanceof Searchable) {
    if (book.matches("Java")) {
        // وجدنا الكتاب
    }
}
```

---

### 1️⃣2️⃣ كيف أحفظ البيانات؟

**الإجابة:**
يمكنك حفظ البيانات بتحويلها إلى كائن Library:

```java
// تحويل بيانات LibraryManager إلى Library
List<Item> items = new ArrayList<>(libraryManager.getBooks());
Library library = new Library(
    items,
    libraryManager.getMembers(),
    new ArrayList<>() // موظفين
);

// حفظ الملف
FileManager.saveLibrary("data.txt", library);

// حمّل الملف لاحقاً
Library loaded = FileManager.loadLibrary("data.txt");
```

---

### 1️⃣3️⃣ ماذا تعني "null" وكيف تتعامل معها؟

**الإجابة:**
null تعني "لا شيء" أو "فارغ":

```java
// خطأ - قد ترجع null
Book book = manager.findBookById("UNKNOWN");
if (book == null) {
    System.out.println("الكتاب غير موجود");
} else {
    System.out.println(book.getTitle());
}

// الطريقة الآمنة
Book book = manager.findBookById("BOOK001");
if (book != null) {
    System.out.println(book.info());
}
```

---

### 1️⃣4️⃣ كيف أضيف ميزة جديدة؟

**الإجابة:**
البناء منظم يسهل إضافة ميزات جديدة:

```java
// مثال: تمديد فترة الاستعارة
public String extendLoan(String bookId, int days) {
    for (Loan loan : loans) {
        if (loan.getItem().getItemId().equals(bookId) && !loan.isReturned()) {
            // يمكن تمديد التاريخ هنا
            return "✅ تم تمديد الفترة بـ " + days + " أيام";
        }
    }
    return "❌ لم يتم العثور على استعارة نشطة";
}
```

---

### 1️⃣5️⃣ ما هي أفضل الممارسات؟

**الإجابة:**

1. **استخدم LibraryManager لكل العمليات:**
   ```java
   // بدلاً من التعديل المباشر على ArrayList
   manager.addBook(book);
   ```

2. **تحقق من الأخطاء:**
   ```java
   if (bookId == null || bookId.isEmpty()) {
       return "❌ معرّف فارغ";
   }
   ```

3. **استخدم أسماء واضحة:**
   ```java
   // ✅ واضح
   ArrayList<Book> availableBooks = manager.getAvailableBooks();
   
   // ❌ غير واضح
   ArrayList<Book> b = manager.getBooks();
   ```

4. **أضف comments:**
   ```java
   // حساب الرسوم بناءً على نوع العضو (Polymorphism)
   double fee = member.calculateFee(daysLate);
   ```

5. **اختبر الكود:**
   ```java
   // تأكد أن كل دالة تعمل بشكل صحيح
   assertTrue(manager.borrowBook("B1", "M1").contains("نجاح"));
   ```

---

## 📌 ملخص سريع

| المفهوم | الشرح | المثال |
|--------|-------|--------|
| **Encapsulation** | إخفاء البيانات | `private ArrayList<Book> books;` |
| **Inheritance** | ترث من فئة أخرى | `StudentMember extends Member` |
| **Polymorphism** | نفس الدالة، سلوك مختلف | `calculateFee()` |
| **Interface** | عقد يجب تطبيقه | `implements Searchable` |
| **LibraryManager** | الفئة الرئيسية | تدير كل عمليات المكتبة |
| **Loan** | سجل استعارة | يربط بين الكتاب والعضو |

---

**هل لديك أسئلة أخرى؟** 💡
