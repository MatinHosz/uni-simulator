package unisim.uni;

import java.util.ArrayList;

public class Professor {
    public int id;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    public int personID;
    public int majorID;

    public Professor(int personID, int majorID) {
        this.personID = personID;
        this.majorID = majorID;
        id = professorList.size() + 1;
        professorList.add(this);
    }
    public static Professor findByID(int id) {
        for (Professor professor : professorList) {
            if (professor.id == id)
                return professor;
        }
        return null;
    }
}
