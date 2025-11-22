package com.stemlink.tutor.exe5.util;

import com.stemlink.tutor.exe5.constants.PlatformConstants;

public class FeeCalculator {

    private FeeCalculator() {}

    public static double calculateBaseFee(String bookingType, int hours) {
        if ("URGENT".equalsIgnoreCase(bookingType)) {
            return PlatformConstants.STANDARD_HOURLY_RATE * PlatformConstants.URGENT_MULTIPLIER * hours;
        }
        return PlatformConstants.STANDARD_HOURLY_RATE * hours;
    }

    public static double calculatePlatformFee(double baseFee) {
        return baseFee * PlatformConstants.PLATFORM_FEE_PERCENTAGE;
    }
}
