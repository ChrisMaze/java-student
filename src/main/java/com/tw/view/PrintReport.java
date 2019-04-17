package com.tw.view;
import com.tw.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class PrintReport {
    private List<Student> students;
    String report = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分\n"+
            "========================\n";
     public  PrintReport(){}
    public PrintReport(List<Student> students){
        this.students = students.stream().map(stu-> new Student(
                stu.getName(),
                stu.getSno(),
                stu.getMathScore(),
                stu.getChineseScore(),
                stu.getEnglishScore(),
                stu.getProgramScore())).collect(Collectors.toList());
    }
    public void studentsFilter(){

    }
    public String reportCard() {
        GradeReport gradeReport = new GradeReport(students);
        for (Student temp : gradeReport.getStudents()) {
            report += temp.getName()+"|"+temp.getMathScore()+"|"+temp.getChineseScore()+"|"+
                    temp.getEnglishScore()+"|"+temp.getProgramScore()+"|"+temp.getAverageScore()+"|"+
                    temp.getTotalScore()+"\n";
        }
        report+="========================\n"+"全班总平局分数："+gradeReport.getAverageScore()+"\n"+
                "全班总分中位数："+gradeReport.getMidScore()+"\n```";
        return report;
    }
    @Override
    public String toString() {
        return "```\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n" +
                "```";
    }
}
