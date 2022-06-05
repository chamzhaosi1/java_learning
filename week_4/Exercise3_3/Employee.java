package Exercise3_3;

public class Employee {
    private String name;
    private int idNumber;
    private String department;
    private String position;


    public Employee(String name, int idNumber, String department, String position) {
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
        this.position = position;
    }

    public Employee(String name, int idNumber) {
        this(name, idNumber, "", "");
    }


    public Employee() {
        this("", 0, "", "");
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static void main(String[] args) {
        System.out.println("\t\t\tName\t\t ID Number \t Department \t Position");
        System.out.println("___________________________________________________________________________________");

        Employee emp1 = new Employee("Elizabeth Swann", 47888, "Accounting", "Vice President");
        System.out.println("Frist Employee: \t" + emp1.getName() + "\t" + emp1.getIdNumber() +"\t"+ emp1.getDepartment() +"\t"+ emp1.getPosition());

        Employee emp2 = new Employee("Will Turner", 10101, "IT", "Programmer");
        System.out.println("second Employee: \t" + emp2.getName() + "\t" + emp2.getIdNumber() +"\t"+ emp2.getDepartment() +"\t\t"+ emp2.getPosition());

        Employee emp3 = new Employee();

        emp3.setName("Elizabeth Swann");
        emp3.setIdNumber(81774);
        emp3.setDepartment("Manufacturing");
        emp3.setPosition("Engineer");

        System.out.println("Third Employee: \t" + emp3.getName() + "\t" + emp3.getIdNumber() +"\t"+ emp3.getDepartment() +"\t"+ emp3.getPosition());
    }
}
