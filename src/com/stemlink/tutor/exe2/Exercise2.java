package com.stemlink.tutor;

import java.time.LocalDateTime;

public class Exercise2 {

    public static void main(String[] args) {

        // Testing BookingValidator
        System.out.println("=== Testing BookingValidator ===");
        LocalDateTime futureTime = LocalDateTime.now().plusDays(2);

        System.out.println("Future time valid? " +
                BookingValidator.isValidBookingTime(futureTime));

        System.out.println("3 hours valid? " +
                BookingValidator.isValidDuration(3));

        System.out.println("5 hours valid? " +
                BookingValidator.isValidDuration(5));


        //  Testing FeeCalculator
        System.out.println("\n=== Testing FeeCalculator ===");

        System.out.println("Standard 2h: LKR " +
                FeeCalculator.calculateTotal("STANDARD", 2));

        System.out.println("Urgent 3h: LKR " +
                FeeCalculator.calculateTotal("URGENT", 3));


        // Testing CustomDateTimeFormatter
        System.out.println("\n=== Testing DateTimeFormatter ===");

        LocalDateTime now = LocalDateTime.now();

        System.out.println("Standard: " +
                CustomDateTimeFormatter.formatDateTime(now));

        System.out.println("Long: " +
                CustomDateTimeFormatter.formatDateLong(now));

        System.out.println("Time: " +
                CustomDateTimeFormatter.formatTime(now));
    }
}
