package com.tw.model;

public class Student {
    private String name;
    private String sno;
    private int mathScore;
    private int chineseScore;
    private int englishScore;
    private int programScore;
    public Student(Student stu){
        this(stu.getName(),stu.getSno(),stu.getMathScore(),
                stu.getChineseScore(),stu.getEnglishScore(),stu.getProgramScore());
    }
    public Student(String sno) {
        this.sno = sno;
    }
    public Student(String name, String sno, int mathScore, int chineseScore, int englishScore, int programScore) {

        this.name = name;
        this.sno = sno;
        this.mathScore = mathScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSno() {
        return sno;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getProgramScore() {
        return programScore;
    }

    public int getEnglishScore() { return englishScore; }

    public double getAverageScore() {
        return this.getTotalScore()/4.0;
    }

    public double getTotalScore() {
        return mathScore+englishScore+programScore+chineseScore;
    }
}
