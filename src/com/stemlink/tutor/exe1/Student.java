package com.stemlink.tutor.exe1;

public class Student {

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


