import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable{
    private String name, studentId;

    Student (String name, String studentId){
        this.name = name;
        this.studentId = studentId;
    }

    public String getName(){
        return this.name;
    }
    public String getStudentId(){
        return this.studentId;
    }

    public static void main(String [] args) throws IOException, Exception{
        Student student = new Student("Cham", "1234");

        FileOutputStream outputStream = new FileOutputStream("Student.dat");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(student);

        objectOutputStream.close();


        FileInputStream inStream = new FileInputStream("Student.dat");

        ObjectInputStream objectInputStream = new ObjectInputStream(inStream);

        Student student2 = (Student) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println("Student Name: " + student2.getName() + "\n Student ID: " + student2.getStudentId());
    }
}