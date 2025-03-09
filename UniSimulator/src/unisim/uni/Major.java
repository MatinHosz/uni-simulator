package unisim.uni;

import java.util.ArrayList;

public class Major {
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<Major>();
    public String name;
    public final int capacity;
    public int numberOfStudent = 0;

    public Major(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        id = majorList.size() + 1;
        majorList.add(this);
    }

    public void addStudent() {
        if (++numberOfStudent > capacity)
            System.out.print("The major capacity is full.");
        else
            numberOfStudent++;
    }

}