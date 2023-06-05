package com.company;

import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

public class Main {
    static ArrayList<Course> courses = new ArrayList<>();
    public static void main(String[] args) {
        
        String menu = "";

        do{ 
        System.out.println("Выберите действие: ");
        System.out.println("1. Создать дисциплину \n2. Добавить студента на дисциплину \n3. Удалить студента с дисциплины\n4. Список студентов по дисциплине\nВведите 0, чтобы завершить работу");
        Scanner in = new Scanner(System.in); 
        Scanner search = new Scanner(System.in);
                menu = in.nextLine();

        switch(menu){
            case "1":{
                setCorse();
                break;
            }
            case "2":{
                System.out.print("Сколько студентов Вы хотите добавить?: ");
                int constNum = in.nextInt();
            for (Course course : courses) {
                if (getFound() == true) {
                    for (int i = 1; i<=constNum; i++){
                    System.out.println("Введите имя" + i +"студента: ");
                    String studentName = search.nextLine();
                    course.addStudent(studentName);
                    }
                }
                    }
                    break;}
            case "3":{
            for (Course course : courses) {
                if (getFound() == true) {
                    System.out.println("Введите имя студента: ");
                    String studentName = search.nextLine();
                    course.dropStudent(studentName);
                    }
                    }
                break;
                }

            case "4":{
            for (Course course : courses) {
                if (getFound() == true) {
                course.getStudents(); 
                }                   
            break;
            }}

        }
}
   while(!menu.equals("0"));
}

        static void setCorse(){
        Scanner scanner = new Scanner(System.in);
                System.out.println("Введите название дисциплины: ");
                String name = scanner.nextLine();
                courses.add(new Course(name));
            
            System.out.println("Дисциплина успешно добавлена");
        }
        

    static boolean getFound(){
    System.out.println("Введите название дисциплины: ");
    Scanner search = new Scanner(System.in);
    String Name = search.nextLine();
        for (Course course : courses) {
            if (course.getcoursename().equals(Name)) {
                return true;
            }
            else {
                System.out.println("Дисциплина не найдена");
            }
        }
            
    return false;

    }
}