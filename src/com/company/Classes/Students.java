package com.company.Classes;

import java.io.*;

public class Students implements Serializable{
    public static final int YEAR_NOW = 2022;
    private Student[] students;
    private int currentStudentNumber;

    public Students(final  int studentsNumber) {
        this.students = new Student[studentsNumber];
        currentStudentNumber=-1;
    }

    public String findThirdCourse(){
        String result = "Students in the third year and older: " + System.lineSeparator();

        for(final Student student :students){
            if(YEAR_NOW - student.getAdmission()>=2){
                result += student + System.lineSeparator();
            }
        }
        return result;
    }
    public void addStudent(final Student student) {
        if (++currentStudentNumber < students.length) {
            students[currentStudentNumber] = student;
        }
    }

    public String toString() {
        String result = "Students: " + System.lineSeparator();

        for (final Student student : students) {
            result += student + System.lineSeparator();
        }

        return result;
    }
}

