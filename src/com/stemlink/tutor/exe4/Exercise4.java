package com.stemlink.tutor;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("=== Creating Different Session Requests ===\n");

        // 1. Simple session
        SessionRequest simple = new SessionRequest.Builder(
                "STU-001",
                "MEN-003",
                "Java Basics"
        ).build();

        System.out.println("1. Simple Session:");
        System.out.println(simple);
        System.out.println();

        // 2. Detailed session
        SessionRequest detailed = new SessionRequest.Builder(
                "STU-002",
                "MEN-005",
                "Spring Boot REST APIs"
        )
                .sessionNotes("Focus on exception handling and validation")
                .materialsNeeded(Arrays.asList("Laptop", "Spring Boot docs", "Postman"))
                .preferredTime(LocalDateTime.now().plusDays(3))
                .build();

        System.out.println("2. Detailed Session:");
        System.out.println(detailed);
        System.out.println();

        // 3. Urgent session
        SessionRequest urgent = new SessionRequest.Builder(
                "STU-003",
                "MEN-002",
                "Database Design"
        )
                .isUrgent(true)
                .preferredTime(LocalDateTime.now().plusDays(2))
                .sessionNotes("Need help before exam!")
                .build();

        System.out.println("3. Urgent Session:");
        System.out.println(urgent);
        System.out.println();

        // 4. Group session
        SessionRequest group = new SessionRequest.Builder(
                "STU-004",
                "MEN-001",
                "React Fundamentals"
        )
                .maxStudents(4)
                .materialsNeeded(Arrays.asList("Laptop", "VS Code", "Node.js installed"))
                .build();

        System.out.println("4. Group Session:");
        System.out.println(group);
        System.out.println();

        // 5. Validation test
        try {
            SessionRequest invalid = new SessionRequest.Builder(
                    "STU-005",
                    "MEN-002",
                    "Advanced Java"
            )
                    .maxStudents(1) // invalid: group but only 1 student
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("5. Validation Test:");
            System.out.println("✅ Caught error: " + e.getMessage());
        }
    }
}
