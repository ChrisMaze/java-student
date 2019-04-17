package com.tw.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GradeReport {
    private List<Student> students;
    public GradeReport(List<Student> students){
        this.students = students.stream().map(stu-> new Student(
                stu.getName(),
                stu.getSno(),
                stu.getMathScore(),
                stu.getChineseScore(),
                stu.getEnglishScore(),
                stu.getProgramScore())).collect(Collectors.toList());
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getTotalScore(){
        return this.students.stream().mapToDouble(item -> item.getTotalScore()).sum();
    }
    public double getAverageScore(){
        return this.getTotalScore()/students.size();
    }
    public double getMidScore() {
        List<Double> arr = students.stream().map(Student::getTotalScore).collect(Collectors.toList());
        Collections.sort(arr);
        double i;
        if (arr.size()%2 == 0)
        {
            i = (arr.get(arr.size()/2)+arr.get(arr.size()/2 -1))/2;
        }
        else {
            i = arr.get(arr.size()/2);
        }
        return i;
    }

}
