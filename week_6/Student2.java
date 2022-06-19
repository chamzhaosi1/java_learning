import java.util.Scanner;

public class Student2 {
    private String studName;
    private String studID;

    public Student2(){//no arg constructor
    }

    public Student2(String studName, String studID) { //parameterized constructor
        this.studName = studName;
        this.studID = studID;
    }

    public String getStudName() {
        return this.studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudID() {
        return this.studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public static void main(String[] args){
        // Student2[] student = new Student2[1];

        // student[0] = new Student2("Cham", "2250160-BSE");
        // // student[0].setStudID("2250160-BSE"); //wrong

        // for(Student2 std: student){
        //     System.out.println(std.getStudName() + " " + std.getStudID());
        // }

        Student2[] studArray = new Student2[5];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i< studArray.length; i++){
            Student2 student = new Student2();
            System.out.println("Please enter " + (i+1) + " student detail: ");

            System.out.print("Student Name: ");
            String name = input.nextLine();
            student.setStudName(name);

            System.out.print("Student ID: ");
            String id = input.nextLine();
            student.setStudID(id);

            studArray[i] = student;
            System.out.println();
        }

        displayAllStudent(studArray[0]);
        displayAllStudent(studArray[0], studArray[1]);
        displayAllStudent(studArray[0], studArray[1], studArray[2]);

        // System.out.println("All Student Detail: ");
        // System.out.println("Name\t|\tStudent ID");
        // System.out.println("------------------------------");
        // // int count =0;
        // for (Student2 std : studArray){
        //     // count++;
        //     // System.out.println( count +": "+ std.getStudName() + "\t|\t" + std.getStudID());
        //     System.out.println(std.getStudName() + "\t|\t" + std.getStudID());
        // }

        input.close();
    }

    public static void displayAllStudent(Student2 ... studArray){
        System.out.println("All Student Detail: ");
        System.out.println("Name\t|\tStudent ID");
        System.out.println("------------------------------");
        for (Student2 std : studArray){
            System.out.println(std.getStudName() + "\t|\t" + std.getStudID());
        }
        System.out.println();
    }
}
