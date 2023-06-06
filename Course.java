/**
 * Класс для представления дисциплины.
 */
package com.company;

import java.lang.String;

public class Course{
    private String coursename;
    private String[] students;
    
    /**
     * Конструктор класса Course.
     * @param nameOfCourse название дисциплины
     */
    public Course(String nameOfCourse){
        this.coursename = nameOfCourse;
        students = new String[0];
    }

    /**
     * Метод для получения названия дисциплины.
     * @return название дисциплины
     */
    public String getcoursename(){
        return coursename;
    }

    /**
     * Метод для проверки наличия студента на дисциплине.
     * @param Student имя студента
     * @return true, если студент уже есть на дисциплине, false - в противном случае
     */
    private boolean containsStudent(String Student) {
        for (String student : students) {
            if (student.equals(Student)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для добавления студента на дисциплину.
     * @param Student имя студента
     */
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

    /**
     * Метод для удаления студента с дисциплины.
     * @param Student имя студента
     */
    public void dropStudent(String Student){
        int index = getNumberOfStudents(Student);
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

    /**
     * Метод для получения индекса студента в массиве студентов.
     * @param studentName имя студента
     * @return индекс студента в массиве студентов
     */
    private int getNumberOfStudents(String studentName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(studentName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Метод для получения списка студентов на дисциплине.
     */
    public void getStudents(){
        System.out.println("Студенты на " + coursename + ":");
        for (String student : students) {
            System.out.println(student);
        } 
    }
}