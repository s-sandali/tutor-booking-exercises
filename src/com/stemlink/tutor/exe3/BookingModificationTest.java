package com.stemlink.tutor;

import java.time.LocalDateTime;

public class BookingModificationTest {
    public static void main(String[] args) {

        Booking b = new Booking(
                "STU-002",
                "MEN-002",
                "Spring Boot",
                LocalDateTime.now().plusDays(1),
                2
        );

        // ❌ This will NOT compile (uncomment to see the error)
        // b.bookingId = "TEST-000";  // Cannot assign a value to final variable

        // ✅ Correct way → Create a new booking
        Booking newBooking = new Booking(
                b.getStudentId(),
                b.getMentorId(),
                b.getSubject(),
                LocalDateTime.now().plusDays(2),
                3
        );

        System.out.println("Created a new modified booking:");
        System.out.println(newBooking.getBookingDetails());
    }
}
