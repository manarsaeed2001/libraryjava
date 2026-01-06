/**
 * INTEGRATION GUIDE - دليل دمج LibraryManager مع الواجهات الرسومية
 * 
 * هذا الملف يشرح كيفية دمج فئة LibraryManager الجديدة مع واجهات Swing
 */

/*
 * ============================================
 * 1. تهيئة LibraryManager في البرنامج الرئيسي
 * ============================================
 */

// في The_Main.java
public static void main(String[] args) {
    // بدلاً من ArrayLists منفصلة
    // ArrayList<Item> items = new ArrayList<>();
    // ArrayList<Member> members = new ArrayList<>();
    
    // استخدم LibraryManager
    LibraryManager libraryManager = new LibraryManager();
    
    // حمّل البيانات المحفوظة إذا كانت موجودة
    Library savedLibrary = FileManager.loadLibrary("A new file.txt");
    if (savedLibrary != null) {
        // انسخ البيانات إلى المدير
        for (Item item : savedLibrary.getItems()) {
            if (item instanceof Book) {
                libraryManager.addBook((Book) item);
            }
        }
        for (Member member : savedLibrary.getMembers()) {
            libraryManager.addMember(member);
        }
    }
    
    // مرّر المدير للواجهات الرسومية
    SwingUtilities.invokeLater(() -> {
        Log_in loginWindow = new Log_in(libraryManager);
        loginWindow.setVisible(true);
    });
}

/*
 * ============================================
 * 2. في Admin_page.java - إضافة الكتب
 * ============================================
 */

private void addBookAction() {
    String title = titleField.getText();
    String author = authorField.getText();
    String bookId = bookIdField.getText();
    int pages = Integer.parseInt(pagesField.getText());
    
    Book book = new Book(title, author, bookId, pages);
    libraryManager.addBook(book);
    
    // تحديث الجدول
    refreshBookTable();
    
    // إظهار رسالة نجاح
    JOptionPane.showMessageDialog(this, "✅ تم إضافة الكتاب بنجاح");
}

private void refreshBookTable() {
    DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
    model.setRowCount(0); // حذف الصفوف القديمة
    
    // أضف جميع الكتب الجديدة
    for (Book book : libraryManager.getBooks()) {
        Object[] row = {
            book.getItemId(),
            book.getTitle(),
            book.getAuthor(),
            book.getPageNum(),
            libraryManager.isBookAvailable(book.getItemId()) ? "متاح ✅" : "مستعار ❌"
        };
        model.addRow(row);
    }
}

/*
 * ============================================
 * 3. في Member_page.java - استعارة الكتاب
 * ============================================
 */

private void borrowBookAction() {
    String bookId = JOptionPane.showInputDialog("أدخل معرّف الكتاب:");
    
    // نفترض أن المستخدم الحالي معروف
    String memberId = currentMemberId;
    
    String result = libraryManager.borrowBook(bookId, memberId);
    JOptionPane.showMessageDialog(this, result);
    
    // تحديث عرض الكتب المتاحة
    refreshAvailableBooks();
    
    // تحديث استعارات العضو
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
            "نشط 📖"
        };
        model.addRow(row);
    }
}

/*
 * ============================================
 * 4. البحث عن الكتب - Search Action
 * ============================================
 */

private void searchBooksAction() {
    String keyword = searchField.getText();
    
    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "⚠️ أدخل كلمة للبحث");
        return;
    }
    
    ArrayList<Book> results = libraryManager.searchBooks(keyword);
    
    // عرض النتائج في جدول
    DefaultTableModel model = (DefaultTableModel) searchResultsTable.getModel();
    model.setRowCount(0);
    
    if (results.isEmpty()) {
        JOptionPane.showMessageDialog(this, "❌ لم يتم العثور على نتائج");
        return;
    }
    
    for (Book book : results) {
        Object[] row = {
            book.getItemId(),
            book.getTitle(),
            book.getAuthor(),
            libraryManager.isBookAvailable(book.getItemId()) ? "متاح ✅" : "مستعار ❌"
        };
        model.addRow(row);
    }
    
    JOptionPane.showMessageDialog(this, "✅ تم العثور على " + results.size() + " نتائج");
}

/*
 * ============================================
 * 5. إرجاع الكتاب
 * ============================================
 */

private void returnBookAction() {
    String bookId = JOptionPane.showInputDialog("أدخل معرّف الكتاب المراد إرجاعه:");
    
    String result = libraryManager.returnBook(bookId);
    JOptionPane.showMessageDialog(this, result);
    
    // تحديث الواجهة
    refreshMemberLoans();
    refreshBookTable();
}

/*
 * ============================================
 * 6. حفظ البيانات
 * ============================================
 */

private void saveDataAction() {
    // تحويل بيانات LibraryManager إلى Library للحفظ
    Library library = new Library(
        convertBooksToItems(libraryManager.getBooks()),
        libraryManager.getMembers(),
        new ArrayList<>() // موظفين فارغة
    );
    
    FileManager.saveLibrary("A new file.txt", library);
    JOptionPane.showMessageDialog(this, "✅ تم حفظ البيانات بنجاح");
}

/*
 * ============================================
 * 7. عرض إحصائيات المكتبة
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
        "📚 إحصائيات المكتبة\n" +
        "==================\n" +
        "إجمالي الكتب: %d\n" +
        "الكتب المتاحة: %d ✅\n" +
        "الكتب المستعارة: %d 📖\n" +
        "إجمالي الأعضاء: %d\n" +
        "الاستعارات النشطة: %d",
        totalBooks, availableBooks, borrowedBooks, totalMembers, activeLoans
    );
    
    JOptionPane.showMessageDialog(this, stats);
}

/*
 * ============================================
 * 8. نموذج جدول الكتب الموصى به
 * ============================================
 */

// في initComponents() أو مشابه
private void createBookTable() {
    String[] columnNames = {"المعرّف", "العنوان", "المؤلف", "الصفحات", "الحالة"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    
    bookTable = new JTable(model);
    bookTable.setColumnSelectionAllowed(false);
    bookTable.setRowSelectionAllowed(true);
    
    // تحديث البيانات الأولية
    refreshBookTable();
}

/*
 * ============================================
 * 9. معالجة الأخطاء والتحقق من الصحة
 * ============================================
 */

private void validateAndAddBook() {
    try {
        if (titleField.getText().isEmpty()) {
            throw new IllegalArgumentException("⚠️ أدخل عنوان الكتاب");
        }
        if (authorField.getText().isEmpty()) {
            throw new IllegalArgumentException("⚠️ أدخل اسم المؤلف");
        }
        if (bookIdField.getText().isEmpty()) {
            throw new IllegalArgumentException("⚠️ أدخل معرّف الكتاب");
        }
        
        int pages = Integer.parseInt(pagesField.getText());
        if (pages <= 0) {
            throw new IllegalArgumentException("⚠️ عدد الصفحات يجب أن يكون موجباً");
        }
        
        // إذا وصلنا هنا، البيانات صحيحة
        addBookAction();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "❌ عدد الصفحات يجب أن يكون رقماً");
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

/*
 * ============================================
 * 10. مثال على كود قابل للتوسع
 * ============================================
 */

// إضافة ميزة جديدة بسهولة
public void extendLoanPeriod(String bookId, int additionalDays) {
    // يمكن إضافة هذه الميزة بسهولة لأن البيانات منظمة
    for (Loan loan : libraryManager.getLoans()) {
        if (loan.getItem().getItemId().equals(bookId) && !loan.isReturned()) {
            // حفظ التاريخ الجديد (في نسخة مستقبلية)
            System.out.println("تم تمديد الفترة بـ " + additionalDays + " أيام");
            return;
        }
    }
}

/*
 * ============================================
 * الملخص
 * ============================================
 * 
 * المزايا:
 * ✅ كود نظيف وسهل الفهم
 * ✅ سهل الصيانة والتطوير
 * ✅ فصل واضح بين المنطق والواجهة
 * ✅ سهل الاختبار (Unit Testing)
 * ✅ يتبع مبادئ OOP الصحيحة
 * 
 * الخطوات:
 * 1. استبدل ArrayLists برسالة بـ LibraryManager واحد
 * 2. استخدم الدوال العامة للعمليات (addBook, searchBooks, etc)
 * 3. حدّث الواجهات الرسومية بعد كل عملية
 * 4. احفظ/حمّل البيانات عند الحاجة
 */
