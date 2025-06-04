package com.example.app.model;

public class People {
    private String firstName;
    private String lastName;
    private String diseredCourse;
    private String contactNumber;



    public People() {
    }

    public People(String firstName, String lastName, String diseredCourse,String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.diseredCourse = diseredCourse;
        this.contactNumber = contactNumber;
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

    @Override
    public String toString() {
        return "People: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                " +, diseredCourse='" + diseredCourse + '\''+
                ", contactNumber='" + contactNumber + '\'';
    }
}
