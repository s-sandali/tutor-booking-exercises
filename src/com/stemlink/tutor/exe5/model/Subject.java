package com.stemlink.tutor.exe5.model;

public final class Subject {

    private final String subjectCode;
    private final String title;
    private final int creditHours;
    private final String category;

    public Subject(String subjectCode, String title, int creditHours, String category) {
        this.subjectCode = subjectCode;
        this.title = title;
        this.creditHours = creditHours;
        this.category = category;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectCode.equals(subject.subjectCode);
    }

    @Override
    public int hashCode() {
        return subjectCode.hashCode();
    }

    @Override
    public String toString() {
        return subjectCode + " - " + title + " (" + creditHours + " hrs)";
    }
}

