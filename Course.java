package com.company;

import java.lang.String;

public class Course{
    private String coursename;
    private String[] students;
    private int numberOfStudents = 0;

    public Course(String nameOfCourse){
        this.coursename = nameOfCourse;
        students = new String[0];
    }

    public String getcoursename(){
        return coursename;
    }

    private boolean containsStudent(String Student) {
        for (String student : students) {
            if (student.equals(Student)) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(String Student){
        if (!containsStudent(Student)) {
            String[] newStudents = new String[students.length + 1];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            newStudents[students.length] = Student;
            students = newStudents;
            System.out.println("Студент " + Student + " добавлен в " + coursename + ".");
        } else {
            System.out.println("Студент уже добавлен в  " + coursename + ".");
        }
    }

    public void dropStudent(String Student){
        int index = getStudentIndex(Student);
        if (index != -1) {
            String[] newStudents = new String[students.length - 1];
            System.arraycopy(students, 0, newStudents, 0, index);
            System.arraycopy(students, index + 1, newStudents, index, students.length - index - 1);
            students = newStudents;
            System.out.println("Студент " + Student + " удален из " + coursename + ".");
        } else {
            System.out.println("Студент не найден " + coursename + ".");
        }
    }

    private int getStudentIndex(String studentName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(studentName)) {
                return i;
            }
        }
        return -1;
    }

    public void getStudents(){
        System.out.println("Студенты на " + coursename + ":");
        for (String student : students) {
            System.out.println(student);
        } 
    }

    public int getNumberOfStudents(){
        for (int i = 0; i <= students.length; i++){
            if (!students[i].equals(null)){
                numberOfStudents += 1; 
            }
            else if(numberOfStudents == 0){
                System.out.println("Студентов нет ");
            }
        }
        return numberOfStudents;
    }
}
