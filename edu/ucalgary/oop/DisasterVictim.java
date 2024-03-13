/*Modified DisasterVictim to now use linked lists.  */

package edu.ucalgary.oop;

import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;

public class DisasterVictim {
    private static int counter = 0;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private List<FamilyRelation> familyConnections = new LinkedList<>();
    private List<MedicalRecord> medicalRecords = new LinkedList<>();
    private List<Supply> personalBelongings = new LinkedList<>();
    private final String ENTRY_DATE;
    private String gender;
    private String comments;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    // Getters and setters

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public List<FamilyRelation> getFamilyConnections() {
        return new LinkedList<>(familyConnections);
    }

    public List<MedicalRecord> getMedicalRecords() {
        return new LinkedList<>(medicalRecords);
    }

    public List<Supply> getPersonalBelongings() {
        return new LinkedList<>(personalBelongings);
    }

    // Correct the setters to accept Lists instead of arrays
    public void setFamilyConnections(List<FamilyRelation> connections) {
        this.familyConnections.clear();
        this.familyConnections.addAll(connections);
    }

    public void setMedicalRecords(List<MedicalRecord> records) {
        this.medicalRecords.clear();
        this.medicalRecords.addAll(records);
    }

    public void setPersonalBelongings(List<Supply> belongings) {
        this.personalBelongings = new LinkedList<>(belongings);
    }

    // Add a Supply to personalBelonging
    public void addPersonalBelonging(Supply supply) {
        this.personalBelongings.add(supply);
    }

    // Remove a Supply from personalBelongings
    public void removePersonalBelonging(Supply unwantedSupply) {
        this.personalBelongings.remove(unwantedSupply);
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        familyConnections.remove(exRelation);
    }

    public void addFamilyConnection(FamilyRelation record) {
        familyConnections.add(record);
    }

    // Add a MedicalRecord to medicalRecords
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.matches("(?i)^(male|female|other)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are male, female, or other.");
        }
        this.gender = gender.toLowerCase(); // Store in a consistent format
    }
}
