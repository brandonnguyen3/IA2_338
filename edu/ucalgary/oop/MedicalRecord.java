/**
@author Brandon Nguyen
@version 1.01
*/

/*
 * Modifications made to dateOfTreatment. We now inherit from it. 
 */
package edu.ucalgary.oop;

public class MedicalRecord extends Date {
    private Location location;
    private String treatmentDetails;

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        super(dateOfTreatment); // Call the Date class constructor with the dateOfTreatment
        setLocation(location);
        this.treatmentDetails = treatmentDetails;
    }

    // Getter and setter for location
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // Getter and setter for treatmentDetails
    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) throws IllegalArgumentException {
        this.treatmentDetails = treatmentDetails;
    }

    // Inherited method from Date for getting the date of treatment
    public String getDateOfTreatment() {
        return super.getDate(); // Calling the inherited getDate() method from Date
    }

    // Inherited method from Date for setting the date of treatment
    public void setDateOfTreatment(String dateOfTreatment) {
        super.setDate(dateOfTreatment); // Calling the inherited setDate() method from Date
    }
}
