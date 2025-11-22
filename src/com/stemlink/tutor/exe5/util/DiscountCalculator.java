package com.stemlink.tutor.exe5.util;

import com.stemlink.tutor.exe5.constants.PlatformConstants;

public class DiscountCalculator {



    private DiscountCalculator() {}

    public static double calculateTotalDiscount(double baseFee, boolean isFirstTime, int hours, int previousSuccessfulBookings) {
        double discount = 0.0;

        if (isFirstTime) {
            discount += baseFee * PlatformConstants.FIRST_TIME_DISCOUNT;
        }

        if (hours >= 3) {
            discount += baseFee * PlatformConstants.BULK_DISCOUNT ;
        }

        if (previousSuccessfulBookings >= 5) {
            discount += baseFee * PlatformConstants.LOYALTY_DISCOUNT ;
        }

        return discount;
    }
}

