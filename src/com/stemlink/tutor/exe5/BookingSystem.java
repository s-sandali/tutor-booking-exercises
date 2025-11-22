package com.stemlink.tutor.exe5;

import com.stemlink.tutor.exe5.model.Booking;
import com.stemlink.tutor.exe5.model.Mentor;
import com.stemlink.tutor.exe5.model.Student;
import com.stemlink.tutor.exe5.model.Subject;
import com.stemlink.tutor.exe5.model.MentorSchedule;
import com.stemlink.tutor.exe5.util.BookingValidator;
import com.stemlink.tutor.exe5.util.FeeCalculator;
import com.stemlink.tutor.exe5.util.DiscountCalculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingSystem {

    private static final List<Student> students = new ArrayList<>();
    private static final List<Mentor> mentors = new ArrayList<>();
    private static final List<Subject> subjects = new ArrayList<>();
    private static final List<Booking> bookings = new ArrayList<>();
    private static final Map<String, MentorSchedule> mentorSchedules = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    STEM Link Tutor Booking System");
        System.out.println("========================================\n");

        initializeSubjects();
        registerUsers();
        initializeMentorSchedules();
        createBookings();
        displayStatistics();
    }

    private static void initializeSubjects() {
        System.out.println("Initializing subjects...");

        subjects.add(new Subject("JAVA-01", "Core Java OOP", 40, "PROGRAMMING"));
        subjects.add(new Subject("SPR-01", "Spring Boot Basics", 32, "PROGRAMMING"));
        subjects.add(new Subject("DB-01", "Database Design", 24, "DATABASE"));
        subjects.add(new Subject("REACT-01", "React Fundamentals", 36, "WEB"));
        subjects.add(new Subject("DSA-01", "Data Structures", 48, "PROGRAMMING"));

        for (Subject subject : subjects) {
            System.out.println("  Added: " + subject);
        }
    }

    private static void registerUsers() {
        System.out.println("\nRegistering users...");

        Student s1 = new Student("Alice Johnson", "alice@example.com");
        Student s2 = new Student("Bob Smith", "bob@example.com");
        Student s3 = new Student("Carol White", "carol@example.com");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        for (Student s : students) {
            System.out.println("  Student registered: " + s.getDetails());
        }

        Mentor m1 = new Mentor("MEN-001", "Dr. Sarah Ahmed", "sarah@example.com", "Java", 2000.0, 4.5);
        Mentor m2 = new Mentor("MEN-002", "Prof. John Doe", "john@example.com", "Spring Boot", 2500.0,3.7);
        Mentor m3 = new Mentor("MEN-003", "Ms. Emily Chen", "emily@example.com", "React", 1800.0, 4.9);

        mentors.add(m1);
        mentors.add(m2);
        mentors.add(m3);

        m1.setRating(4.8);
        m2.setRating(4.9);
        m3.setRating(4.7);

        for (Mentor m : mentors) {
            System.out.println("  Mentor registered: " + m.getMentorId() + " - " + m.getName() +
                    " (" + m.getSpecialization() + ", LKR " + m.getHourlyRate() + "/hr, Rating " + m.getRating() + ")");
        }
    }

    private static void initializeMentorSchedules() {
        for (Mentor mentor : mentors) {
            MentorSchedule schedule = new MentorSchedule(mentor.getMentorId());
            LocalDateTime baseDay = LocalDateTime.now().plusDays(1).withHour(8).withMinute(0);
            schedule.addAvailableSlot(baseDay, baseDay.withHour(18));
            mentorSchedules.put(mentor.getMentorId(), schedule);
        }
    }

    private static void createBookings() {
        System.out.println("\nCreating bookings...");

        LocalDateTime now = LocalDateTime.now().plusDays(1);

        attemptBooking(students.get(0).getStudentId(), mentors.get(0).getMentorId(),
                "Core Java OOP", now.withHour(14).withMinute(0), 2);

        attemptBooking(students.get(1).getStudentId(), mentors.get(1).getMentorId(),
                "Spring Boot Basics", now.withHour(10).withMinute(0), 3);

        attemptBooking(students.get(0).getStudentId(), mentors.get(2).getMentorId(),
                "React Fundamentals", now.withHour(16).withMinute(0), 5);

        attemptBooking(students.get(2).getStudentId(), mentors.get(0).getMentorId(),
                "Database Design", now.withHour(9).withMinute(0), 1);

        attemptBooking(students.get(2).getStudentId(), mentors.get(2).getMentorId(),
                "Data Structures", now.withHour(11).withMinute(0), 2);
    }

    private static void displayStatistics() {
        System.out.println("\nSystem Statistics");
        System.out.println("========================================");

        System.out.println("  Total Students: " + students.size());
        System.out.println("  Total Mentors: " + mentors.size());
        System.out.println("  Total Subjects: " + subjects.size());
        System.out.println("  Total Bookings: " + bookings.size());

        double totalRevenue = 0.0;
        int totalDuration = 0;

        for (Booking booking : bookings) {
            double baseFee = FeeCalculator.calculateBaseFee("STANDARD", booking.getDurationHours());
            double platformFee = FeeCalculator.calculatePlatformFee(baseFee);
            totalRevenue += baseFee + platformFee;
            totalDuration += booking.getDurationHours();
        }

        double averageDuration = bookings.isEmpty() ? 0 : (double) totalDuration / bookings.size();

        System.out.println("  Total Revenue: LKR " + String.format("%.2f", totalRevenue));
        System.out.println("  Average Duration: " + String.format("%.1f", averageDuration) + " hours");
    }

    private static void attemptBooking(
            String studentId,
            String mentorId,
            String subject,
            LocalDateTime scheduledTime,
            int duration
    ) {
        System.out.println("\n  Attempting booking:");
        System.out.println("    Student: " + studentId);
        System.out.println("    Mentor: " + mentorId);
        System.out.println("    Subject: " + subject);
        System.out.println("    Time: " + scheduledTime);
        System.out.println("    Duration: " + duration + " hours");

        if (!BookingValidator.isValidBookingTime(scheduledTime)) {
            System.out.println("    Invalid booking time (must be in future)");
            return;
        }

        if (!BookingValidator.isWithinAdvanceBookingLimit(scheduledTime)) {
            System.out.println("    Invalid booking time (must be within " +
                    "next " + com.stemlink.tutor.exe5.constants.PlatformConstants.MAX_ADVANCE_BOOKING_DAYS + " days)");
            return;
        }

        if (!BookingValidator.isValidDuration(duration)) {
            System.out.println("    Invalid duration (must be 1-4 hours)");
            return;
        }

        MentorSchedule schedule = mentorSchedules.get(mentorId);
        if (schedule == null) {
            System.out.println("    No schedule found for mentor");
            return;
        }

        LocalDateTime endTime = scheduledTime.plusHours(duration);
        if (!schedule.isAvailableFor(scheduledTime, endTime)) {
            System.out.println("    Mentor not available for this time slot");
            return;
        }

        Booking booking = new Booking(studentId, mentorId, subject, scheduledTime, duration);
        bookings.add(booking);

        double baseFee = FeeCalculator.calculateBaseFee("STANDARD", duration);

        int previousForStudent = (int) bookings.stream()
                .filter(b -> !b.getBookingId().equals(booking.getBookingId()))
                .filter(b -> b.getDurationHours() > 0)
                .count();
        boolean isFirstTime = previousForStudent == 0;

        double discount = DiscountCalculator.calculateTotalDiscount(baseFee, isFirstTime, duration, previousForStudent);
        double discountedBase = baseFee - discount;

        double platformFee = FeeCalculator.calculatePlatformFee(discountedBase);
        double total = discountedBase + platformFee;

        System.out.println("    Booking created: " + booking.getBookingId());
        System.out.println("    Fees - Base: LKR " + baseFee +
                " | Discounts: LKR " + discount +
                " | Platform: LKR " + platformFee +
                " | Total: LKR " + total);
    }
}
