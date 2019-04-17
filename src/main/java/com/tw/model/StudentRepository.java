package com.tw.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class StudentRepository {

    private List<Student> students;
    private StudentRepository() {
        students = new ArrayList();
    }
    private  static StudentRepository studentRepository = null;
    public static StudentRepository getInstance(){
        if (studentRepository == null)
            studentRepository = new StudentRepository();
        return studentRepository;
    }
    public void addStudents(Student... stu) {
        this.students.addAll(asList(stu));
    }
    public Student findStudentBySno(String stuSno) {
        return this.students.stream()
                .filter(stu -> stu.getSno().equals(stuSno))
                .map(Student::new)
                .findFirst().orElse(null);
    }
    public List<Student> getStudents(){
        return students;
    }

    public boolean isExist(String stuSno) {
        return findStudentBySno(stuSno) != null;
    }

}
