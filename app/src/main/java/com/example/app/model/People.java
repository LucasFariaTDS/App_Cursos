package com.example.app.model;

public class People {
    private final String firstName;
    private final String lastName;
    private final String desiredCourse;
    private final String contactNumber;

    public People(String firstName, String lastName, String desiredCourse, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.desiredCourse = desiredCourse;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getDesiredCourse() {
        return desiredCourse;
    }

    @Override
    public String toString() {
        return String.format("People: First Name = '%s', Last Name = '%s', Desired Course = '%s', Contact Number = '%s'}",
                firstName, lastName, desiredCourse, contactNumber);
    }
}
