package com.stemlink.tutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateTimeFormatter {

    private CustomDateTimeFormatter() {}

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static String formatDateLong(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
    }

    public static String formatTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("h:mm a"));
    }
}
