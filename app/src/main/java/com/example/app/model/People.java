package com.example.app.model;

public class People {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String courseDesired;

    public People() {
    }

    public People(String firstName, String lastName, String contactNumber, String courseDesired) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.courseDesired = courseDesired;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCourseDesired() {
        return courseDesired;
    }

    public void setCourseDesired(String courseDesired) {
        this.courseDesired = courseDesired;
    }
}
