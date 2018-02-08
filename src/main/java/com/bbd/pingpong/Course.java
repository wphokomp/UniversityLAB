package com.bbd.pingpong;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private ArrayList<Student> students;
    private int capacity;
    private static int numberOfCourses = 0;

    public  Course(){}

    public Course(String name, int cap){
        this.students = new ArrayList<>();
        this.name = name;
        this.capacity = cap;
        numberOfCourses++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student s){
        for (int i = 0; i < this.students.size(); i++){
            if ((this.students.get(i)).getStudentNumber() == s.getStudentNumber())
                return (false);
        }
        if (this.capacity > this.students.size() && this.students.add(s)){
            return (true);
        }
        else
            return (false);
    }

    public boolean unenrollStudent(Student s){
        if(this.students.remove(s)) {
            return true;
        }else {
            return false;
        }
    }
}