package org.example.entity;
import lombok.*;

@Getter
@Setter
public class Student {

    //thuoc tinh
    private String id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private double gpa;

    //khoi tao
    //BoilerPlate: nhung doan code lap di lap lai, luc nao cung can viet
    public Student() {
    }

    public Student(String id, String firstName, String lastName, int yearOfBirth, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
    }

    //getter, setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    //toString
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gpa=" + gpa +
                '}';
    }
}
