import unisim.base.Person;
import unisim.uni.Major;
import unisim.uni.Student;
import unisim.uni.Professor;
import unisim.uni.Course;
import unisim.uni.PresentedCourse;
import unisim.uni.Transcript;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Matin", "123456789");
        Person person2 = new Person("Mohammad", "987654321");
        Person person3 = new Person("pishawa", "456123789");
        Person person4 = new Person("Mahan", "123789456");
        Person person5 = new Person("Hossein", "789123456");

        Major cs = new Major("cs", 35);
        Major math = new Major("math", 30);

        Student student1 = new Student(person1.id, 1403, cs.id);
        Student student2 = new Student(person2.id, 1403, cs.id);
        Student student3 = new Student(person3.id, 1403, math.id);

        System.out.println(Person.findByID(student1.personID).name + "\t" + student1.studentID);
        System.out.println(Person.findByID(student2.personID).name + "\t" + student2.studentID);
        System.out.println(Person.findByID(student3.personID).name + "\t" + student3.studentID + "\n");

        Professor professor1 = new Professor(person4.id, cs.id);
        Professor professor2 = new Professor(person5.id, math.id);

        System.out.println(Person.findByID(professor1.personID).name + "\t" + professor1.id );
        System.out.println(Person.findByID(professor2.personID).name + "\t" + professor2.id + "\n");


        Course course1 = new Course("bp", 3);
        Course course2 = new Course("ap", 3);
        Course course3 = new Course("math1", 3);

        PresentedCourse pc1 = new PresentedCourse(course1.id, professor1.id, 60);
        PresentedCourse pc2 =  new PresentedCourse(course2.id, professor1.id, 60);
        PresentedCourse pc3 = new PresentedCourse(course3.id, professor2.id, 80);

        pc1.addStudent(student1.id);
        pc1.addStudent(student2.id);
        pc2.addStudent(student1.id);
        pc2.addStudent(student2.id);
        pc2.addStudent(student3.id);
        pc3.addStudent(student3.id);

        Transcript transcript1 = new Transcript(student1.id);
        Transcript transcript2 = new Transcript(student2.id);
        Transcript transcript3 = new Transcript(student3.id);

        transcript1.setGrade(pc1.id, 19);
        transcript1.setGrade(pc2.id, 19);
        transcript2.setGrade(pc1.id, 20);
        transcript2.setGrade(pc2.id, 18);
        transcript3.setGrade(pc2.id, 17.5);
        transcript3.setGrade(pc3.id, 19.5);
        System.out.println();

        transcript1.printTranscript();
        transcript2.printTranscript();
        transcript3.printTranscript();


        System.out.println("Grade point of " + Person.findByID(student1.personID).name + ": " + transcript1.getGPA());
        System.out.println("Grade point of " + Person.findByID(student2.personID).name + ": " + transcript2.getGPA());
        System.out.println("Grade point of " + Person.findByID(student3.personID).name + ": " + transcript3.getGPA());
    }
}