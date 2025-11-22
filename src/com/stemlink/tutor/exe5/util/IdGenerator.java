package com.stemlink.tutor.exe5.util;

public class IdGenerator {

    private static int studentCounter = 1;
    private static int mentorCounter = 1;
    private static int bookingCounter = 1;

    public static String generateStudentId() {
        return String.format("STU-%03d", studentCounter++);
    }

    public static String generateMentorId() {
        return String.format("MEN-%03d", mentorCounter++);
    }

    public static String generateBookingId() {
        return String.format("BK-%03d", bookingCounter++);
    }

    private IdGenerator() {
    }
}

