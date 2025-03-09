package unisim.uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;
    public int courseID;
    public int professorID;
    public static int capacity;

    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<PresentedCourse>();
    public ArrayList<Integer> studentIds = new ArrayList<>();

    public PresentedCourse(int courseID, int professorID, int maxCapacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        capacity = maxCapacity;
        id = presentedCourseList.size() + 1;
        presentedCourseList.add(this);
    }

    public static PresentedCourse findByID(int id) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == id)
                return presentedCourse;
        }
        return null;
    }
    public void addStudent(int studentID) {
        if (studentIds.size() >= capacity)
            System.out.print("The course capacity is full");
        else
            studentIds.add(studentID);
    }
}
