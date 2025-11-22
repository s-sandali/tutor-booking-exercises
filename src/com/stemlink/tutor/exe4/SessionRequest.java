package com.stemlink.tutor.exe4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SessionRequest {

    private final String studentId;
    private final String mentorId;
    private final String subject;

    private final String sessionNotes;
    private final List<String> materialsNeeded;
    private final boolean isUrgent;
    private final LocalDateTime preferredTime;
    private final int maxStudents;

    // Private Constructor
    private SessionRequest(Builder builder) {
        this.studentId = builder.studentId;
        this.mentorId = builder.mentorId;
        this.subject = builder.subject;

        this.sessionNotes = builder.sessionNotes;
        this.materialsNeeded = new ArrayList<>(builder.materialsNeeded);
        this.isUrgent = builder.isUrgent;
        this.preferredTime = builder.preferredTime;
        this.maxStudents = builder.maxStudents;
    }

    // Getters Only
    public String getStudentId() { return studentId; }
    public String getMentorId() { return mentorId; }
    public String getSubject() { return subject; }
    public String getSessionNotes() { return sessionNotes; }
    public List<String> getMaterialsNeeded() { return materialsNeeded; }
    public boolean isUrgent() { return isUrgent; }
    public LocalDateTime getPreferredTime() { return preferredTime; }
    public int getMaxStudents() { return maxStudents; }

    @Override
    public String toString() {

        String type;
        if (maxStudents > 1) {
            type = "Group (max " + maxStudents + " students)";
        } else {
            type = "Individual";
        }
        String notesText;
        if (sessionNotes.equals("")) {
            notesText = "(none)";
        } else {
            notesText = sessionNotes;
        }
        String materialsText;
        if (materialsNeeded.isEmpty()) {
            materialsText = "(none)";
        } else {
            materialsText = materialsNeeded.toString();
        }
        String preferredTimeText;
        if (preferredTime == null) {
            preferredTimeText = "Not specified";
        } else {
            preferredTimeText = CustomDateTimeFormatter.formatDateTime(preferredTime);
        }
        return "SessionRequest {\n" +
                "  Student: " + studentId + " | Mentor: " + mentorId + "\n" +
                "  Subject: " + subject + "\n" +
                "  Type: " + type + " | Urgent: " + (isUrgent ? "Yes" : "No") + "\n" +
                "  Notes: " + notesText + "\n" +
                "  Materials: " + materialsText + "\n" +
                "  Preferred Time: " + preferredTimeText + "\n" +
                "}";
    }


    // STATIC NESTED BUILDER CLASS
    public static class Builder {

        // Required Fields
        private final String studentId;
        private final String mentorId;
        private final String subject;

        // Optional Fields (defaults)
        private String sessionNotes = "";
        private List<String> materialsNeeded = new ArrayList<>();
        private boolean isUrgent = false;
        private LocalDateTime preferredTime = null;
        private int maxStudents = 1;

        // Required Constructor
        public Builder(String studentId, String mentorId, String subject) {
            this.studentId = studentId;
            this.mentorId = mentorId;
            this.subject = subject;
        }

        // Fluent Setters
        public Builder sessionNotes(String notes) {
            this.sessionNotes = notes;
            return this;
        }

        public Builder materialsNeeded(List<String> materials) {
            this.materialsNeeded = new ArrayList<>(materials);
            return this;
        }

        public Builder isUrgent(boolean urgent) {
            this.isUrgent = urgent;
            return this;
        }

        public Builder preferredTime(LocalDateTime preferredTime) {
            this.preferredTime = preferredTime;
            return this;
        }

        public Builder maxStudents(int maxStudents) {
            this.maxStudents = maxStudents;
            return this;
        }


        public SessionRequest build() {

            if (subject == null || subject.trim().isEmpty()) {
                throw new IllegalArgumentException("Subject cannot be empty");
            }

            if (maxStudents == 1 && isGroupSessionRequested()) {
                throw new IllegalArgumentException(
                        "Group sessions must allow at least 2 students"
                );
            }

            if (isUrgent && preferredTime != null &&
                    preferredTime.isAfter(LocalDateTime.now().plusDays(7))) {
                throw new IllegalArgumentException(
                        "Urgent sessions must be within 7 days"
                );
            }

            return new SessionRequest(this);
        }

        private boolean isGroupSessionRequested() {
            return maxStudents > 1;
        }
    }
}
