package com.stemlink.tutor;

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

class Student {

    private final String studentId;
    private String name;
    private String email;

    private static int studentCounter = 1;
    private static int totalStudents = 0;

    public Student(String name, String email) {
        this.studentId = String.format("STU-%03d", studentCounter);
        this.name = name;
        this.email = email;

        studentCounter++;
        totalStudents++;
    }

    public String getDetails() {
        return studentId + ", " + name + ", " + email;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}
