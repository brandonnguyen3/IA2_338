package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.Period;

// Parent class
class Date {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getters and setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Method to display date
    public void displayDate() {
        System.out.println(day + "/" + month + "/" + year);
    }

    // Method to calculate age\
    /* 
    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
    */
}