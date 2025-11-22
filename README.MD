# Static & Final Keywords - Hands-On Practice


---

## Learning Objectives

By completing these exercises, you will:

- Master the distinction between **static and instance** members
- Implement the **Builder pattern** using static nested classes
- Create **immutable classes** using the `final` keyword
- Apply Single Responsibility Principle when designing utility classes
- Build a **mini version of the tutor booking system's core components**

---


###  Project Structure


```text
tutor-booking-exercises/
├── src/
│   ├── Main.java
│   └── com/
│       └── stemlink/
│           └── tutor/
│               ├── Exercise5.java
│               ├── exe1/
│               │   ├── Exercise1.java
│               │   └── Student.java
│               ├── exe2/
│               │   ├── BookingValidator.java
│               │   ├── CustomDateTimeFormatter.java
│               │   ├── Exercise2.java
│               │   └── FeeCalculator.java
│               ├── exe3/
│               │   ├── Booking.java
│               │   ├── BookingModificationTest.java
│               │   └── Exercise3.java
│               ├── exe4/
│               │   ├── CustomDateTimeFormatter.java
│               │   ├── Exercise4.java
│               │   └── SessionRequest.java
│               └── exe5/
│                   ├── BookingSystem.java
│                   ├── constants/
│                   │   └── PlatformConstants.java
│                   ├── model/
│                   │   ├── Booking.java
│                   │   ├── BookingStatus.java
│                   │   ├── Mentor.java
│                   │   ├── MentorSchedule.java
│                   │   ├── Student.java
│                   │   └── Subject.java
│                   └── util/
│                       ├── BookingValidator.java
│                       ├── DiscountCalculator.java
│                       ├── FeeCalculator.java
│                       └── IdGenerator.java
└── README.md

