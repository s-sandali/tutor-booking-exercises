package com.stemlink.tutor.exe5.util;

import com.stemlink.tutor.exe5.constants.PlatformConstants;

import java.time.LocalDateTime;

public class BookingValidator {

    private BookingValidator() {}

    // Booking time must be after the current time to make sure it is valid
    public static boolean isValidBookingTime(LocalDateTime bookingTime) {
        return bookingTime.isAfter(LocalDateTime.now());
    }

    // Booking must not be more than MAX_ADVANCE_BOOKING_DAYS days in the future
    public static boolean isWithinAdvanceBookingLimit(LocalDateTime bookingTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime maxAllowed = now.plusDays(PlatformConstants.MAX_ADVANCE_BOOKING_DAYS);
        return !bookingTime.isAfter(maxAllowed);
    }

    // Duration between 1–4 hours
    public static boolean isValidDuration(int hours) {
        return hours >= PlatformConstants.MIN_BOOKING_HOURS && hours <= PlatformConstants.MAX_BOOKING_HOURS;
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
