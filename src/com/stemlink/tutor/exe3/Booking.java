package com.stemlink.tutor.exe3;

import com.stemlink.tutor.exe2.CustomDateTimeFormatter;

import java.time.LocalDateTime;

public final class Booking {

    private static int bookingCounter = 1;

    private final String bookingId;
    private final String studentId;
    private final String mentorId;
    private final String subject;
    private final LocalDateTime scheduledTime;
    private final int durationHours;
    private final LocalDateTime createdAt;
    private final String status;

    public Booking(String studentId,
                   String mentorId,
                   String subject,
                   LocalDateTime scheduledTime,
                   int durationHours) {

        this.bookingId = String.format("BK-%03d", bookingCounter++);
        this.studentId = studentId;
        this.mentorId = mentorId;
        this.subject = subject;
        this.scheduledTime = scheduledTime;
        this.durationHours = durationHours;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public String getBookingId() { return bookingId; }
    public String getStudentId() { return studentId; }
    public String getMentorId() { return mentorId; }
    public String getSubject() { return subject; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public int getDurationHours() { return durationHours; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getStatus() { return status; }

    public String getBookingDetails() {
        return String.format("Booking ID: %s\n" +"Student: %s | Mentor: %s\n" +"Subject: %s\n" +"Scheduled: %s\n" + "Duration: %d hours\n" +"Status: %s\n" +"Created: %s",
                bookingId, studentId,mentorId,subject,CustomDateTimeFormatter.formatDateTime(scheduledTime),
                durationHours, status,CustomDateTimeFormatter.formatDateTime(createdAt) );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) obj;

        return this.bookingId.equals(other.bookingId);
    }


    @Override
    public int hashCode() {
        return bookingId.hashCode();
    }
}
