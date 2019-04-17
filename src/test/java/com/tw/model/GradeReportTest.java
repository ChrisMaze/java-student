package com.tw.model;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class GradeReportTest {
     List<Student> students = new ArrayList(){
         {
             add(new Student("Tom", "001", 95, 95, 95, 96));
             add(new Student("Tom0", "002", 80, 85, 100, 100));
         }
     };

@Test
    public void should_return_midScore()
    {
        GradeReport gradeReport = new GradeReport(students);
        assertEquals(373.0, gradeReport.getMidScore(), 0.0);
    }
    @Test
    public void should_return_AverageScore()
    {
        GradeReport gradeReport = new GradeReport(students);
        assertEquals(373.0, gradeReport.getAverageScore(), 0.0);
    }
}
