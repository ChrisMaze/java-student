package com.tw.view;
import com.tw.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class PrintReportTest {
    List<Student> students = new ArrayList(){
        {
            add(new Student("Tom", "001", 95, 95, 95, 96));
            add(new Student("Tom0", "002", 80, 85, 100, 100));
        }
    };
    @Test
    public void should_print_view() {
        assertEquals("```\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n" +
                "```",new PrintReport(students).toString());
    }
    @Test
    public  void should_return_report_card(){
        PrintReport printReport = new PrintReport(students);
        assertEquals("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n"+
                "========================\n" +
                "Tom|95|95|95|96|95.25|381.0\n" +
                "Tom0|80|85|100|100|91.25|365.0\n" +
                "========================\n" +
                "全班总平局分数：373.0\n" +
                "全班总分中位数：373.0\n" +
                "```", printReport.reportCard());
    }
}

