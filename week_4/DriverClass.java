public class DriverClass {

    public void showName(){
        Student stud_6 = new Student("Abu", "2250067-TSCL");
        String name = stud_6.getName();
        String studentID = stud_6.getStudentID();

        System.out.println("My name is " + name + ", and my student ID is " + studentID + ".");
    }

    public static void main(String[] args) {
        Student stud_5 = new Student("Ali", "2250097-BSE");

        //Because this main is not under same class the class's private method connot be invoked
        // stud_5.setName("Ali");
        // stud_5.setStudentID("2250097");

        String name = stud_5.getName();
        String studentID = stud_5.getStudentID();

        System.out.println("My name is " + name + ", and my student ID is " + studentID + ".");

        DriverClass dc = new DriverClass();
        dc.showName();

    }
}
