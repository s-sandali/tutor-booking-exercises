package com.stemlink.tutor.exe5.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MentorSchedule {

    private final String mentorId;
    private final List<TimeSlot> availableSlots = new ArrayList<>();

    public MentorSchedule(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorId() {
        return mentorId;
    }

    public List<TimeSlot> getAvailableSlots() {
        return Collections.unmodifiableList(availableSlots);
    }

    public void addAvailableSlot(LocalDateTime start, LocalDateTime end) {
        TimeSlot newSlot = new TimeSlot(start, end);
        for (TimeSlot slot : availableSlots) {
            if (!isSlotNonOverlapping(newSlot, slot)) {
                throw new IllegalArgumentException("New slot overlaps existing availability");
            }
        }
        availableSlots.add(newSlot);
    }

    public boolean isAvailableFor(LocalDateTime start, LocalDateTime end) {
        for (TimeSlot slot : availableSlots) {
            if (start.compareTo(slot.getStart()) >= 0 && end.compareTo(slot.getEnd()) <= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSlotNonOverlapping(TimeSlot a, TimeSlot b) {
        return a.getEnd().compareTo(b.getStart()) <= 0 || a.getStart().compareTo(b.getEnd()) >= 0;
    }

    public static class TimeSlot {
        private final LocalDateTime start;
        private final LocalDateTime end;

        public TimeSlot(LocalDateTime start, LocalDateTime end) {
            if (end.isBefore(start) || end.equals(start)) {
                throw new IllegalArgumentException("End time must be after start time");
            }
            this.start = start;
            this.end = end;
        }

        public LocalDateTime getStart() { return start; }
        public LocalDateTime getEnd() { return end; }
    }
}

