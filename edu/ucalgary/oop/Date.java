package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Date class which MedicalRecord, ReliefService, and DisasterVictim will inherit from.
 */
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

    /*setDate is used to turn the string into integers and pass those in the setters.  */
    public void setDate(String date) {
        if (!isValidDateFormat(date)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        } 
        String[] parts = date.split("-");
        this.year = Integer.parseInt(parts[0]);
        this.month = Integer.parseInt(parts[1]);
        this.day = Integer.parseInt(parts[2]);
    }

    /*getDate retrieves the entire date and returns a string with the parts.*/
    public String getDate() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    //used to check that it is in the format of YYYY-MM-DD
    public boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
       

}