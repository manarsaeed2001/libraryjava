package library_system;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library_system.Classes.Book;
import library_system.Classes.Employee;
import library_system.Classes.Item;
import library_system.Classes.Library;
import library_system.Classes.Member;
import library_system.Classes.Searchable;

public class Search_Books extends javax.swing.JFrame {
    static ArrayList<Item> items_;
    static ArrayList<Member> members_;
    static ArrayList<Employee> emp;

    public Search_Books(ArrayList<Item> items_, ArrayList<Member> members_, ArrayList<Employee> emp) {
        initComponents();
        this.items_ = items_;
        this.members_ = members_;
        this.emp = emp;
        
        // تحميل الجدول بكل الكتب عند الفتح
        refreshTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        clearButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Books");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("🔍 Search Books");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
        jLabel2.setText("Search by Title or Author:");

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 12));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(102, 102, 0));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("🔎 Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Book ID", "Title", "Author", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        booksTable.setFont(new java.awt.Font("Segoe UI", 0, 11));
        jScrollPane1.setViewportView(booksTable);

        clearButton.setBackground(new java.awt.Color(102, 102, 102));
        clearButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear Search");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(102, 0, 0));
        closeButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {
        performSearch();
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchField.setText("");
        refreshTable();
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void performSearch() {
        String keyword = searchField.getText().trim();
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();
        model.setRowCount(0);

        if (keyword.isEmpty()) {
            refreshTable();
            return;
        }

        // البحث في الكتب باستخدام الواجهة Searchable
        for (Item item : items_) {
            if (item instanceof Searchable) {
                Searchable searchable = (Searchable) item;
                if (searchable.matches(keyword)) {
                    Book book = (Book) item;
                    String status = book.matches(keyword) ? "✅ Available" : "❌ Borrowed";
                    model.addRow(new Object[]{
                        book.getItemId(),
                        book.getTitle(),
                        book.getAuthor(),
                        status
                    });
                }
            }
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, 
                "No books found matching '" + keyword + "'", 
                "Search Result", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, 
                "Found " + model.getRowCount() + " book(s)", 
                "Search Result", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();
        model.setRowCount(0);

        for (Item item : items_) {
            if (item instanceof Book) {
                Book book = (Book) item;
                String status = "✅ Available";
                model.addRow(new Object[]{
                    book.getItemId(),
                    book.getTitle(),
                    book.getAuthor(),
                    status
                });
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_Books(items_, members_, emp).setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable booksTable;
    private javax.swing.JTextField searchField;
    // End of variables declaration
}
