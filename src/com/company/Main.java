package com.company;

import com.company.Classes.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        first();
        second();

    }

    /**
     * Фамилия
     * Специальность
     * Год поступления
     * Оценка по физике
     * Оценка по математике
     * Оценка по информатике
     *
     * Определить количество студентов, учащихся на 3
     * курсе и старше и напечатать все сведения о них.
     */

    public static void first() throws IOException {
        Students students = new Students(5);
        try {
            students = StudentDatabase.Load();
            System.out.println(students);
        }
        catch (Exception e){
            final Student student1 = new Student("Ivanov", Speciality.SPECIALITY1,2021,98,24,85);
            final Student student2 = new Student("Petrov",Speciality.SPECIALITY2,2020,91,65,56);
            final Student student3 = new Student("Antonov",Speciality.SPECIALITY3,2019,48,83,42);
            final Student student4 = new Student("Anegin",Speciality.SPECIALITY4,2018,53,55,53);
            final Student student5 = new Student("Potapov",Speciality.SPECIALITY5,2017,78,71,68);

            System.out.println();

            students.addStudent(student1);
            students.addStudent(student2);
            students.addStudent(student3);
            students.addStudent(student4);
            students.addStudent(student5);
            System.out.println(students);
            System.out.println();
            System.out.println(students.findThirdCourse());
        }

        StudentDatabase.Save(students);

    }

    /**
     * Фамилия работника
     * Должность
     * Дата подписания контракта
     * Срок действия контракта
     * Оклад
     *
     * Вывести сведения о работниках, подписавших контракт
     * менее года назад.
     */

    public static void second() throws IOException {
        Workers workers = new Workers(5);
        try {
            workers = WorkerDatabase.Load();
            System.out.println(workers);
        }catch (Exception e){
            final Worker worker1 = new Worker("Ivanov", Position.POSITION1,50000);
            final Worker worker2 = new Worker("Petrov",Position.POSITION2,60000);
            final Worker worker3 = new Worker("Antonov",Position.POSITION3,70000);
            final Worker worker4 = new Worker("Anegin",Position.POSITION4,80000);
            final Worker worker5 = new Worker("Potapov",Position.POSITION5,90000);

            System.out.println();

            workers.addWorker(worker1);
            workers.addWorker(worker2);
            workers.addWorker(worker3);
            workers.addWorker(worker4);
            workers.addWorker(worker5);
            System.out.println(workers);
            System.out.println();
            System.out.println(workers.findWorkers());
        }
        WorkerDatabase.Save(workers);

    }
}
