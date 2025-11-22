package com.stemlink.tutor.exe2;

import java.time.LocalDateTime;

public class BookingValidator {

    private BookingValidator() {}

    // Booking time must be after the current time to make sure it is valid
    public static boolean isValidBookingTime(LocalDateTime bookingTime) {
        return bookingTime.isAfter(LocalDateTime.now());
    }

    // Duration  between 1–4 hours
    public static boolean isValidDuration(int hours) {
        if (hours >= 1 && hours <= 4) {
            return true;
        } else {
            return false;
        }
    }


    // see if timeslot doesnt overlap with exisiting booking
    public static boolean isSlotAvailable(
            LocalDateTime newStart,
            LocalDateTime newEnd,
            LocalDateTime existingStart,
            LocalDateTime existingEnd) {

        if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) {
            return false; // slots overlap
        }
        return true; // available
    }

}
