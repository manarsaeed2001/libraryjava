# 🔧 دليل الأوامر والتشغيل

## 📦 متطلبات التشغيل

- **Java 8 أو أحدث**
- **IDE اختياري** (NetBeans, Eclipse, VS Code)
- **Console/Terminal**

---

## 🚀 خطوات التشغيل

### 1️⃣ تجميع البرنامج

```bash
cd "c:\Users\asmaa\Downloads\finalbackup_library\Library_System\src"

javac -encoding UTF-8 -d ..\build\classes library_system\Classes\*.java library_system\*.java
```

### 2️⃣ تشغيل البرنامج الرئيسي

```bash
cd "c:\Users\asmaa\Downloads\finalbackup_library\Library_System\build\classes"

java -cp . library_system.The_Main
```

### 3️⃣ تشغيل برنامج العرض التوضيحي

```bash
cd "c:\Users\asmaa\Downloads\finalbackup_library\Library_System\build\classes"

java library_system.LibraryDemo
```

---

## 📋 الملفات المهمة

### الملفات الأساسية للفهم:

```
1. README.md                  ← ابدأ من هنا
2. IMPROVEMENTS_REPORT.md     ← فهم البنية
3. INTEGRATION_GUIDE.md       ← الربط مع الواجهات
4. FAQ.md                     ← الأسئلة الشاملة
5. FINAL_REPORT.md            ← الملخص النهائي
```

### الملفات البرمجية المهمة:

```
1. LibraryManager.java        ← الفئة الرئيسية الجديدة
2. Loan.java                  ← محسّن بدالة جديدة
3. LibraryDemo.java           ← مثال عملي كامل
4. Book.java                  ← يطبق Searchable
5. StudentMember.java         ← مثال على Polymorphism
```

---

## 🎯 الاستخدام السريع

### إنشاء LibraryManager:

```java
LibraryManager manager = new LibraryManager();
```

### إضافة كتاب:

```java
Book book = new Book("Java Programming", "Herbert Schildt", "BOOK001", 500);
manager.addBook(book);
```

### إضافة عضو:

```java
Member member = new Member("أحمد", "MEM001", "0501234567", "Regular");
manager.addMember(member);
```

### إضافة طالب (بخصم):

```java
StudentMember student = new StudentMember("فاطمة", "STU001", "0509876543");
manager.addMember(student);
```

### استعارة كتاب:

```java
String result = manager.borrowBook("BOOK001", "MEM001");
System.out.println(result);  // ✅ تم استعارة الكتاب بنجاح
```

### إرجاع كتاب:

```java
String result = manager.returnBook("BOOK001");
System.out.println(result);  // ✅ تم إرجاع الكتاب + الرسوم
```

### البحث:

```java
ArrayList<Book> results = manager.searchBooks("Java");
for (Book book : results) {
    System.out.println(book.getTitle());
}
```

### الكتب المتاحة:

```java
ArrayList<Book> available = manager.getAvailableBooks();
```

### استعارات العضو:

```java
ArrayList<Loan> loans = manager.getMemberActiveLoans("MEM001");
```

### حساب الرسوم:

```java
double fee = member.calculateFee(5);  // 5 أيام تأخير
```

---

## 🧪 الاختبارات

### اختبار 1: إضافة وعرض الكتب

```java
manager.addBook(new Book("Book1", "Author1", "B1", 300));
manager.addBook(new Book("Book2", "Author2", "B2", 400));
System.out.println("الكتب المضافة: " + manager.getBooks().size());  // 2
```

### اختبار 2: البحث

```java
ArrayList<Book> results = manager.searchBooks("Book1");
System.out.println("نتائج البحث: " + results.size());  // 1
```

### اختبار 3: الاستعارة والإرجاع

```java
String borrow = manager.borrowBook("B1", "M1");
System.out.println(borrow);  // ✅ تم استعارة الكتاب بنجاح

boolean available = manager.isBookAvailable("B1");
System.out.println("متاح: " + available);  // false

String return_msg = manager.returnBook("B1");
System.out.println(return_msg);  // ✅ تم إرجاع الكتاب بنجاح
```

### اختبار 4: الخصم

```java
Member normal = new Member("A", "M1", "050", "Regular");
StudentMember student = new StudentMember("B", "S1", "050");

double fee1 = normal.calculateFee(5);    // 10
double fee2 = student.calculateFee(5);   // 5

System.out.println("العضو: " + fee1);    // 10
System.out.println("الطالب: " + fee2);   // 5
```

---

## 📊 المخرجات المتوقعة

### عند تشغيل LibraryDemo:

```
=== 📚 نظام إدارة المكتبة - عرض توضيحي ===

1️⃣ إضافة الكتب:
-----------
✅ تمت إضافة 4 كتب

2️⃣ إضافة الأعضاء:
-----------
✅ تمت إضافة 3 أعضاء (عضوين عاديين + طالب بخصم 50%)

3️⃣ حالة الكتب:
-----------
Book Title: Java Programming  Author: Herbert Schildt  Item ID: BOOK001  Number of Pages: 500
الحالة: متاح ✅
...

4️⃣ البحث عن الكتب:
-----------
البحث عن 'Java':
  ✓ Book Title: Java Programming  ...
  ✓ Book Title: Java Concurrency  ...

5️⃣ استعارة الكتب:
-----------
أحمد يستعير Java Programming: ✅ تم استعارة الكتاب بنجاح
...

=== 📊 ملخص نهائي ===
عدد الكتب: 3
عدد الأعضاء: 3
عدد الاستعارات الكلية: 3
عدد الاستعارات النشطة: 1
```

---

## ❌ الأخطاء الشائعة وحلولها

### ❌ "Can't find main class"

**السبب:** لم تجمع البرنامج أولاً

**الحل:**
```bash
javac -encoding UTF-8 -d ..\build\classes library_system\Classes\*.java library_system\*.java
```

### ❌ "Class Not Found Exception"

**السبب:** أنت في المجلد الخاطئ

**الحل:**
```bash
# تأكد أنك في build\classes
cd ..\build\classes
```

### ❌ Encoding errors

**السبب:** المجموعة الرمزية غير صحيحة

**الحل:**
```bash
javac -encoding UTF-8 ...  # استخدم UTF-8 دائماً
```

### ❌ ClassNotFoundException في Runtime

**السبب:** الملفات .class غير موجودة أو في المكان الخاطئ

**الحل:**
```bash
# تجميع كامل من جديد
javac -encoding UTF-8 -d ..\build\classes library_system\Classes\*.java library_system\*.java
```

---

## 🔄 سير العمل الموصى به

### إذا كنت مبتدئاً:

```
1. اقرأ README.md
2. اقرأ FAQ.md
3. شغّل LibraryDemo
4. اقرأ الكود في LibraryManager.java
5. جرّب تعديل البرنامج
```

### إذا كنت متقدماً:

```
1. اقرأ IMPROVEMENTS_REPORT.md
2. ادرس LibraryManager مباشرة
3. استخدم INTEGRATION_GUIDE.md لربط مع الواجهات
4. أضف ميزات جديدة
```

### إذا كنت تريد الاختبار:

```
1. شغّل LibraryDemo
2. اختبر كل عملية يدويا
3. عدّل البيانات واختبر مرة أخرى
4. تأكد من الرسوم والخصومات
```

---

## 📝 ملاحظات مهمة

1. **استخدم LibraryManager دائماً**
   - لا تستخدم ArrayList مباشرة
   - استخدم دوال LibraryManager

2. **تحقق من الأخطاء**
   - كل دالة ترجع رسالة توضح النتيجة
   - ✅ للنجاح و ❌ للفشل

3. **احفظ البيانات**
   - استخدم FileManager لحفظ البيانات
   - حمّل البيانات عند البداية

4. **طبّق OOP**
   - استخدم Encapsulation
   - استخدم Inheritance و Polymorphism
   - استخدم Interfaces

---

## 🎓 موارد إضافية

- اقرأ comments في الكود - كل شيء موثق
- استخدم IDE لفهم الكود بشكل أفضل
- جرّب تعديل البرنامج لفهمه أعمق
- اسأل عن مفاهيم غير واضحة

---

## ✅ Checklist للتشغيل

- [ ] Java مثبت (java -version)
- [ ] المشروع محفوظ في المسار الصحيح
- [ ] جميع الملفات .java موجودة
- [ ] تم تجميع البرنامج بنجاح
- [ ] الأوامر مكتوبة بشكل صحيح
- [ ] البرنامج يعمل بدون أخطاء

---

## 🚀 الخطوات التالية

1. شغّل البرنامج الرئيسي أو LibraryDemo
2. جرّب جميع العمليات
3. ادرس الكود والوثائق
4. أضف ميزات جديدة
5. استخدمه في مشاريع أخرى

---

**كل شيء جاهز! استمتع! 🎉**
