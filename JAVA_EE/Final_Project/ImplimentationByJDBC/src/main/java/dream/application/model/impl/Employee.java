package dream.application.model.impl;

import java.time.LocalDate;

/**
 * EMPLOYEE TABLE
 * Created by Splayd on 09.05.2017.
 */
public class Employee {

    private int id;
    private String surname;
    private String name;
    private LocalDate dateBirth;
    private String phoneNumber;
    private String appointment;
    private float salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", dateBirth=" + dateBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", appointment='" + appointment + '\'' +
                ", salary=" + salary +
                '}';
    }
}
