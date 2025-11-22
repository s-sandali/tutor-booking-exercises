package com.stemlink.tutor.exe1;

public class Exercise1 {

    public static void main(String[] args) {

        System.out.println("Creating students...");

        Student s1 = new Student("Alice Johnson", "alice@email.com");
        System.out.println("Student created: " + s1.getDetails());

        Student s2 = new Student("Bob Smith", "bob@email.com");
        System.out.println("Student created: " + s2.getDetails());

        Student s3 = new Student("Carol White", "carol@email.com");
        System.out.println("Student created: " + s3.getDetails());

        System.out.println();
        System.out.println("Total students registered: " + Student.getTotalStudents());
    }
}

