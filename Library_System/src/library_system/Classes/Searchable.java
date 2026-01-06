package library_system.Classes;

// Interface للبحث داخل عناصر المكتبة
public interface Searchable {

    // ترجع true إذا الكلمة موجودة داخل العنصر
    boolean matches(String keyword);
}
