package com.tw.model;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class StudentTest {
    @Test
    public void should_return_totalScore() {
        Student student = new Student("tom", "001", 80, 80, 80, 80);
        assertEquals(320.0, student.getTotalScore(), 0.0);
    }
}
