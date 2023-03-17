package com.techelevator.lecture;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Abdikadir", "Sheikh"));
        studentList.add(new Student("Alex", "Stone"));
        studentList.add(new Student("Brian", "Garza"));
        studentList.add(new Student("Erica", "Buck"));
        studentList.add(new Student("Grant", "Steiner"));
        studentList.add(new Student("James", "Trussell"));
        studentList.add(new Student("Kevin", "Little"));
        studentList.add(new Student("Martha", "Abebe"));
        studentList.add(new Student("Nick", "Grover"));
        studentList.add(new Student("Nicole", "Nguyen"));
        studentList.add(new Student("Riley", "Williamson"));
        studentList.add(new Student("Sarab", "B"));
        studentList.add(new Student("Shraddha", "Sharma"));
        studentList.add(new Student("Servando", "Bermudez"));
        studentList.add(new Student("Tia", "Bulliner"));
        studentList.add(new Student("Vincent", "Patterson"));
        studentList.add(new Student("Quang", "Huynh"));
        studentList.add(new Student("Whitney", "Bescheinen"));

        System.out.println(studentList.get(7));


        int numberOfGroups = 5;
        int maxLength = 20;

        Scanner userInput = new Scanner(System.in);

        while(!input.equals("E")) {
            System.out.println("Welcome!  [Current number of groups: " + numberOfGroups + " Number of students: " + studentList.size() + "]");
            System.out.println("Please enter an option");
            System.out.println("[C]hange number of groups");
            System.out.println("[P]rint out a new list of groups");
            System.out.println("[S]huffle the groups");
            System.out.println("[E]nd program");
            String input = userInput.nextLine().toLowerCase(;

            if (input.equals("e")) {
                break;
            }

        }

    }





}