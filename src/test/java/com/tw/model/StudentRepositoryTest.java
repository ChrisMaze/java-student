package com.tw.model;
import org.junit.Test;

import static org.junit.Assert.*;
public class StudentRepositoryTest {
    Student student1 = new Student("Tom", "001", 90, 90, 90, 90);
    Student student2 = new Student("Jack", "002", 90, 90, 90, 90);
    Student student3 = new Student("Jerry", "003", 90, 90, 90, 90);
    Student student4 = new Student("Zino", "004", 90, 90, 90, 90);
    Student student5 = new Student("Harris", "005", 90, 90, 90, 90);
    @Test
    public void should_add_student(){

        StudentRepository studentRepository = StudentRepository.getInstance();
        studentRepository.addStudents(student1,student2,student3,student4,student5);
        String name = "jenny";
        String sno = "003";
        int math = 80;
        int english = 95;
        int chinese = 90;
        int program = 88;
        Student student6 = new Student(name,sno,math,chinese,english,program);
        studentRepository.addStudents(student6);
        assertEquals(6, studentRepository.getStudents().size());
    }
    public void should_return_Ture()
    {
        StudentRepository studentRepository = StudentRepository.getInstance();
        studentRepository.addStudents(student1,student2,student3,student4,student5);
        assertTrue(studentRepository.isExist("001"));
        assertFalse(studentRepository.isExist("007"));
    }

}
