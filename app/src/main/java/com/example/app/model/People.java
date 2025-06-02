package com.example.app.model;

public class People {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String diseredCourse;


    public People() {
    }

    public People(String firstName, String lastName, String contactNumber, String diseredCourse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.diseredCourse = diseredCourse;
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

    public String getDiseredCourse() {
        return diseredCourse;
    }

    public void setDiseredCourse(String diseredCourse) {
        this.diseredCourse = diseredCourse;
    }
}
