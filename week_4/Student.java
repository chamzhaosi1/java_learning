public class Student{
  
    // String name;
    // String studentID;

    //instance field
    private String name;
    private String studentID;

    public Student(){

    }

    public Student(String name, String studentID){
        setName(name);
        setStudentID(studentID);
    }

    public String getName(){// accessor method/ getter method
        return name;
    }

    private void setName(String name){ // mutator method or setter method
        this.name = name;
    }

    public String getStudentID(){
        return studentID;
    }

    private void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public static void main(String[] args) {
        Student stud = new Student("Lim", "2250149-BSE");

        String name = stud.getName();
        String studentID = stud.getStudentID();

        System.out.println("My name is " + name + ", and my student ID is " + studentID + ".");

        //Because in the same class the private method still can be invoked 
        stud.setName("Cham");
        stud.setStudentID("2250160-BSE");

        name = stud.getName();
        studentID = stud.getStudentID();

        System.out.println("My name is " + name + ", and my student ID is " + studentID + ".");

        Student stud_2 = new Student();

        stud_2.setName("Ng");
        stud_2.setStudentID("2250170_DWD");

        name = stud_2.getName();
        studentID = stud_2.getStudentID();

        System.out.println("My name is " + name + ", and my student ID is " + studentID + ".");
    }
}

class test_private_method{

    public static void main(String[] args) {
        Student stud_3 = new Student("Bang", "2220198_BSA");

        //Because this main is not under same class the class's private method connot be invoked
        // stud_3.setName("Ng");
        // stud_3.setStudentID("2250170");

        String name = stud_3.getName();
        String studentID = stud_3.getStudentID();

        System.out.println("My name is " + name + ", and my student ID is " + studentID + ".");

        //Becuase the name filed is private access, outside code cannot be accessed
        // stud_3.name = "abc";
    }
}
