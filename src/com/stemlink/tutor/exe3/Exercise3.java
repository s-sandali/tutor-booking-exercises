package com.stemlink.tutor.exe3;

import java.time.LocalDateTime;

public class Exercise3 {
    public static void main(String[] args) {

        Booking booking1 = new Booking(
                "STU-001",
                "MEN-005",
                "Core Java OOP",
                LocalDateTime.of(2025, 11, 20, 14, 0),
                2
        );

        System.out.println("Original Booking:");
        System.out.println(booking1.getBookingDetails());

        Booking booking2 = new Booking(
                booking1.getStudentId(),
                booking1.getMentorId(),
                booking1.getSubject(),
                LocalDateTime.of(2025, 11, 21, 14, 0), // changed date
                3 // changed duration
        );

        System.out.println("\n'Modified' Booking (new object):");
        System.out.println(booking2.getBookingDetails());

        // Demonstrate immutability
        System.out.println("\nAre they the same object? " + (booking1 == booking2));
        System.out.println("Original booking unchanged? " +
                (booking1.getDurationHours() == 2));
    }
}
