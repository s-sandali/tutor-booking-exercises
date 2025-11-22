package com.stemlink.tutor;

public class FeeCalculator {

    private static final double STANDARD_RATE = 1500.0;
    private static final double URGENT_RATE = 2500.0;
    private static final double GROUP_RATE = 1200.0;
    private static final double PLATFORM_FEE_PERCENTAGE = 0.15;

    private FeeCalculator() {}

    public static double calculateBaseFee(String bookingType, int hours) {

        switch (bookingType.toUpperCase()) {
            case "STANDARD":
                return STANDARD_RATE * hours;

            case "URGENT":
                return URGENT_RATE * hours;

            case "GROUP":
                return GROUP_RATE * hours;

            default:
                throw new IllegalArgumentException("Invalid booking type");
        }
    }

    public static double calculatePlatformFee(double baseFee) {
        return baseFee * PLATFORM_FEE_PERCENTAGE;
    }

    public static double calculateTotal(String bookingType, int hours) {
        double baseFee = calculateBaseFee(bookingType, hours);
        double platformFee = calculatePlatformFee(baseFee);
        return baseFee + platformFee;
    }
}
