package unisim.uni;

import java.util.ArrayList;

public class Student {
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<Student>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        studentList.add(this);
        id = studentList.size();

    }
    public static Student findByID(int id) {
        for (Student student : studentList) {
            if (student.id == id)
                return student;
        }
        return null;
    }
    public void setStudentCode() {
        double studentCode = (entranceYear * 1e5) + (majorID * 1e3) + id;
        studentID = "" + studentCode;
    }
}
