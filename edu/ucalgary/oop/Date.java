/**
@author Brandon Nguyen <a
@version 1.1
*/


package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Date class which MedicalRecord, ReliefService, and DisasterVictim will inherit from.
 */
class Date {
    //Store a value of date as a string. 
    private String date;

    // Constructor
    public Date(String date) {
        if (!isValidDateFormat(date)) {
            throw new IllegalArgumentException("Invalid date format for treatment details. Expected format: YYYY-MM-DD");
        }
        this.date = date;
    }


    /*setDate is used to turn the string into integers and pass those in the setters.  */
    public void setDate(String date) {
        if (!isValidDateFormat(date)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        } 
        this.date = date;
    }

    /*getDate retrieves the entire date and returns a string with the parts.*/
    public String getDate() {
        return this.date;
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