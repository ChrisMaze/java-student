package com.tw.controller;

import com.tw.model.Student;
import com.tw.model.StudentRepository;
import com.tw.view.PrintReport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Command {
    public void reciveCommand() {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        switch (a) {
            case 1:
                System.out.printf("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
                while (true) {
                    String input = s.next();
                    String pattern = "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";
                    Student stu = null;
                    Matcher m = Pattern.compile(pattern).matcher(input);
                    if (m.matches()) {
                        stu = new Student(m.group(1), m.group(2), Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)),
                                Integer.parseInt(m.group(5)), Integer.parseInt(m.group(6)));
                        StudentRepository.getInstance().addStudents(stu);
                        System.out.printf("学生" + m.group(1) + "的成绩被添加\n");
                        break;
                    } else {
                        System.out.printf("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
                    }
                }
                break;
            case 2:
                System.out.printf("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
                while (true) {
                    String input = s.next();
                    String pattern = "^(\\d+[\\s]*+[,]+[\\s]*)*(\\d+)$";
                    List<Student> stus = new ArrayList<>();
                    Matcher matcher = Pattern.compile(pattern).matcher(input);
                    boolean isMatche = matcher.matches();
                    String[] sno = input.split(",");
                    if (isMatche) {
                        for (String temp : sno
                        ) {
                            if (StudentRepository.getInstance().isExist(temp)) {
                                stus.add(StudentRepository.getInstance().findStudentBySno(temp));
                            }
                        }
                        PrintReport printReport = new PrintReport(stus);
                        System.out.println(printReport.reportCard());
                        break;
                    } else {
                        System.out.printf("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
                    }
                }
                break;
            case 3:
                System.exit(0);
        }
    }
}
