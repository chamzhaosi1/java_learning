public class test {
    public static void main(String[] args) {
        Student stud_4 = new Student("Xin", "2220256-BSE");

        String name = stud_4.getName();
        String studentID = stud_4.getStudentID();

        System.out.println("My name is " + name + ", and my student ID is " + studentID + ".");
    }
}
