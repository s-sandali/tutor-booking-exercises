package com.stemlink.tutor.exe5.constants;

public class PlatformConstants {

    public static final int MIN_BOOKING_HOURS = 1;
    public static final int MAX_BOOKING_HOURS = 4;
    public static final int MAX_ADVANCE_BOOKING_DAYS = 30;

    public static final double STANDARD_HOURLY_RATE = 1500.0;
    public static final double URGENT_MULTIPLIER = 1.5;
    public static final double GROUP_DISCOUNT = 0.8;
    public static final double PLATFORM_FEE_PERCENTAGE = 0.15;

    public static final double MIN_MENTOR_RATING = 1.0;
    public static final double MAX_MENTOR_RATING = 5.0;
    public static final double MINIMUM_ACCEPTABLE_RATING = 3.0;

    public static final double FIRST_TIME_DISCOUNT = 0.20;
    public static final double BULK_DISCOUNT = 0.10;
    public static final double LOYALTY_DISCOUNT = 0.05;


    private PlatformConstants() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}

