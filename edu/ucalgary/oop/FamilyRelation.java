/*
 * FamilyRelation
 * Author: Brandon Nguyen
 * Date: 03/12
 */

package edu.ucalgary.oop;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    // Constructor
    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;

        // Ensure a two-sided relationship
        personOne.addFamilyConnection(this);
        personTwo.addFamilyConnection(this);
    }

    // Getter and setter for personOne
    public DisasterVictim getPersonOne() {
        return personOne;
    }

    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }

    // Getter and setter for relationshipTo
    public String getRelationshipTo() {
        return relationshipTo;
    }

    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }

    // Getter and setter for personTwo
    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }
}
