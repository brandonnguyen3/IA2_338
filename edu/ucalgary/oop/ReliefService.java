/**
@author Brandon Nguyen
@version 1.1
 */

/*
 * Modifications: (03/26)
 * Got rid of dateOfInquiry. Now inherits it from Date.
 * Got rid of Date Helper function
 */

 package edu.ucalgary.oop;

 
 public class ReliefService extends Date {
     private Inquirer inquirer;
     private DisasterVictim missingPerson;
     
     private String infoProvided;
     private Location lastKnownLocation;
 
     // Constructor
     public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        super(dateOfInquiry); 
        this.inquirer = inquirer; 
         this.missingPerson = missingPerson;
         this.infoProvided = infoProvided;
         this.lastKnownLocation = lastKnownLocation;
     }
 
     // Getter and setter for inquirer
     public Inquirer getInquirer() {
         return inquirer;
     }
 
     public void setInquirer(Inquirer inquirer) {
         this.inquirer = inquirer;
     }
 
     // Getter and setter for missingPerson
     public DisasterVictim getMissingPerson() {
         return missingPerson;
     }
 
     public void setMissingPerson(DisasterVictim missingPerson) {
         this.missingPerson = missingPerson;
     }
 
     // Getter and setter for dateOfInquiry
     public String getDateOfInquiry() {
        return super.getDate();
     }
 
     public void setDateOfInquiry(String dateOfInquiry) {
        super.setDate(dateOfInquiry);
     }
 
     // Getter and setter for infoProvided
     public String getInfoProvided() {
         return infoProvided;
     }
 
     public void setInfoProvided(String infoProvided) {
         this.infoProvided = infoProvided;
     }
 
     // Getter and setter for lastKnownLocation
     public Location getLastKnownLocation() {
         return lastKnownLocation;
     }
 
     public void setLastKnownLocation(Location lastKnownLocation) {
         this.lastKnownLocation = lastKnownLocation;
     }
 
     //modify getLogDetails to be a linkedList instead. 
     public String getLogDetails() {
        return "Inquirer: " + inquirer.getFirstName() + 
            ", Missing Person: " + missingPerson.getFirstName() + 
            ", Date of Inquiry: " + getDateOfInquiry() + 
            ", Info Provided: " + infoProvided + 
            ", Last Known Location: " + lastKnownLocation.getName();
     }
     
 }