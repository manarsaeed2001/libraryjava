package library_system.Classes;

public class Employee extends Person {
    private String jobTitle;
    private double salary;
    private static final long serialVersionUID = 1L;

    public Employee(String name, String id, String contactInfo, String jobTitle, double salary) {
        super(name, id, contactInfo);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void displayInfo() {
        
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee ID: " + getId());
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
    }
    
     public String info() {
        String display = "Employee Name: " + getName()+ "  " +
        "Employee ID: " + getId()+ "  " +
        "Contact Info: " + getContactInfo()+"  " +
        "Job Title: " + jobTitle+ "  " +
          "Salary: " + salary  +"  "   ;
         return  display;
    }
     
     

       public static Employee fromString(String str) {
        // Parsing the string and creating a new Employee object
        String[] parts = str.split(" ");
        String name = parts[2];
        String id = parts[5];
        String contactInfo = parts[8];
        String jobTitle = parts[11];
        double salary = Double.parseDouble(parts[13]);
        return new Employee(name, id, contactInfo, jobTitle, salary);
    }

  
}
