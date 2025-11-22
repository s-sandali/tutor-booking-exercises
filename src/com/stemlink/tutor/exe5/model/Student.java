package com.stemlink.tutor.exe5.model;

import com.stemlink.tutor.exe5.util.IdGenerator;

public class Student {

    private final String studentId;
    private String name;
    private String email;

    public Student(String name, String email) {
        this.studentId = IdGenerator.generateStudentId();
        this.name = name;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDetails() {
        return studentId + " - " + name;
    }
}
