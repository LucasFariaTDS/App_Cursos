package com.example.app.model;

public class People {
    private String firstName;
    private String lastName;
    private String desiredCourse;
    private String contactNumber;

    public People() {
    }

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
        return "People: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", desiredCourse='" + desiredCourse + '\''+
                ", contactNumber='" + contactNumber + '\'';
    }
}
