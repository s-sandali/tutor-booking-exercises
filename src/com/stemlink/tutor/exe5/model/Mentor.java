package com.stemlink.tutor.exe5.model;

import com.stemlink.tutor.exe5.constants.PlatformConstants;

public class Mentor {

    private final String mentorId;
    private final String name;
    private final String email;
    private final String specialization;
    private final double hourlyRate;
    private double rating;

    public Mentor(String mentorId, String name, String email, String specialization, double hourlyRate, double rating) {
        this.mentorId = mentorId;
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
        setRating(rating); // enforce bounds through setter
    }

    public String getMentorId() {
        return mentorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < PlatformConstants.MIN_MENTOR_RATING || rating > PlatformConstants.MAX_MENTOR_RATING) {
            throw new IllegalArgumentException("Rating must be between " + PlatformConstants.MIN_MENTOR_RATING +" and " + PlatformConstants.MAX_MENTOR_RATING);
        }
        this.rating = rating;
    }

    public String getDetails() {
        return mentorId + " - " + name;
    }
}
