package unisim.uni;

import unisim.base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript(int studentID) {
        this.studentID = studentID;

    }
    public void setGrade(int presentedCourseID, double grade) {
        if (PresentedCourse.findByID(presentedCourseID) != null) {
            for (int studentId : PresentedCourse.findByID(presentedCourseID).studentIds) {
                if (studentId == studentID)
                    transcript.put(presentedCourseID, grade);
            }
        }
        else
            System.out.print("PresentedCourseID doesn't exist");
    }
    public void printTranscript() {
        int personID = Student.findByID(studentID).personID;
        String name = Person.findByID(personID).name;
        String studentUniID = Student.findByID(studentID).studentID;
        System.out.print(" " + name + "\t" + studentUniID);

        transcript.forEach((presentedCourseID, grade) -> {
            int courseID = PresentedCourse.findByID(presentedCourseID).courseID;
            String courseTitle = Course.findByID(courseID).title;
            System.out.println(courseTitle + ": " + grade);
        });
    }
    public double getGPA() {
        final double[] sumOfGrades = {0};
        final double[] sumOfUnits = {0};
        transcript.forEach((presentedCourseID, grade) -> {
            int courseID = PresentedCourse.findByID(presentedCourseID).courseID;
            int courseUnits = Course.findByID(courseID).units;
            sumOfGrades[0] += grade * courseUnits;
            sumOfUnits[0] += courseUnits;
        });
        return sumOfGrades[0] / sumOfUnits[0];
    }
}