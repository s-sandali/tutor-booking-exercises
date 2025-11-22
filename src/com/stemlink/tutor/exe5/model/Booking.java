package com.stemlink.tutor.exe5.model;

import java.time.LocalDateTime;
import com.stemlink.tutor.exe5.util.IdGenerator;

public final class Booking {

    private final String bookingId;
    private final String studentId;
    private final String mentorId;
    private final String subject;
    private final LocalDateTime scheduledTime;
    private final int durationHours;
    private final LocalDateTime createdAt;
    private BookingStatus status;

    public Booking(String studentId, String mentorId, String subject,
                   LocalDateTime scheduledTime, int duration) {

        this.bookingId = IdGenerator.generateBookingId();
        this.studentId = studentId;
        this.mentorId = mentorId;
        this.subject = subject;
        this.scheduledTime = scheduledTime;
        this.durationHours = duration;
        this.status = BookingStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public String getBookingId() {
        return bookingId;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public boolean updateStatus(BookingStatus newStatus) {
        if (status.canTransitionTo(newStatus)) {
            this.status = newStatus;
            return true;
        }
        return false;
    }
}
