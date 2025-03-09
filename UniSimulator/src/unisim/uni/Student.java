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
        id = studentList.size() + 1;
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;

        setStudentCode();
        studentList.add(this);
    }
    public static Student findByID(int id) {
        for (Student student : studentList) {
            if (student.id == id)
                return student;
        }
        return null;
    }
    public void setStudentCode() {
        long studentCode = ((entranceYear - 1000) * 100_000L) + (majorID * 1000L) + id;
        studentID = String.valueOf(studentCode);
    }
}
