package com.bbd.pingpong;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testUniversityEnroll {
    Student s1 = null;
    Student s2 = null;
    Student s3 = null;
    Student s4 = null;
    Course c   = null;

    @BeforeEach
    public void setUp()
    {
        int k = 64;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> stNumber = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            names.add("William" + (k += 2));
            stNumber.add(k);
        }

        s1 = new Student(names.get(0), stNumber.get(0), "19930723");
        s2 = new Student(names.get(1), stNumber.get(1), "19931809");
        s3 = new Student(names.get(2), stNumber.get(2), "19951002");
        s4 = new Student(names.get(3), 66, "19231212");
        c = new Course("Machine Learning", 3);
    }

    @Test
    public void testStudent() {

        assertEquals(UniversityEnrollment.studentName(s1), s1.getName());
        assertEquals(66, s1.getStudentNumber());
        assertEquals("19930723", s1.getDob());

        assertEquals("William68", s2.getName());
        assertEquals(68, s2.getStudentNumber());
        assertEquals("19931809", s2.getDob());

        assertEquals("William70", s3.getName());
        assertEquals(70, s3.getStudentNumber());
        assertEquals("19951002", s3.getDob());
    }

    @Test
    public void testCourse(){
        assertEquals("Machine Learning", c.getName());
        assertEquals(3, c.getCapacity());

        assertTrue(c.enrollStudent(s1));
        assertTrue(c.enrollStudent(s2));
        assertFalse(c.enrollStudent(s4));

        String student1 = c.getStudents().get(0).getName() + " " + c.getStudents().get(0).getStudentNumber();
        String student2 = c.getStudents().get(1).getName() + " " + c.getStudents().get(1).getStudentNumber();

        assertEquals("William66 66", student1);
        assertEquals("William68 68", student2);

        assertFalse(c.unenrollStudent(s3));
        assertTrue(c.unenrollStudent(s1));
        assertTrue(c.unenrollStudent(s2));
    }
}