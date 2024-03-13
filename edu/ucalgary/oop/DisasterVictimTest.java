/*Changed all ArrayLists to LinkedLists */

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private List<Supply> suppliesToSet; 
    private List<FamilyRelation> familyRelations; 
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female"; 
    private String expectedComments = "Needs medical attention and speaks 2 languages";


    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new LinkedList<>();
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
        
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        

    }
    //Test for calculateAge. First we set the dateOfBirth and calculateAge should return the correct age.
    @Test
    public void testCalculateAge() {
        // Given
        DisasterVictim victim = new DisasterVictim();
        victim.setDateOfBirth("1984-12-30");

        // When
        Integer age = victim.calculateAge();

        // Then
        assertEquals("The age should be 39",39, age);
    }

    /*Tests that addDietraryRestrictions(restriction: DietraryRestriction): void 
    will properly keep track of dietrary restrictions. getDietraryRestrictions is used to test the results. */
    @Test
    public void testDietraryRestrictions() {
        // Given
        DisasterVictim victim = new DisasterVictim();

        // When
        victim.addDietraryRestrictions(DietraryRestriction.MOML);

        // Then
        assertEquals(DietraryRestriction.MOML, victim.getDietraryRestrictions());
    }

    /*Tests setGender(gender:String): void. The result should be verified with the getGender():String*/

        @Test
        public void testSetGender() {
            // Given
            DisasterVictim victim = new DisasterVictim();
            
            // When
            victim.setGender("boy");
    
            // Then
            assertEquals("boy", victim.getGender());
        }

        /*Should test whether an invalid input throws an exception. We provide invalid input of InvalidGender */
        @Test
        public void testInvalidGenderInput() {
            // Given
            DisasterVictim victim = new DisasterVictim();
    
            assertThrows(IllegalArgumentException.class, () -> {
                victim.setGender("InvalidGender");
            });
        }

    /*Tests that a dietrary restriction can be removed with removeDietraryRestriction()
    Will use getDietraryRestrictions(): LinkedList<DietaryRestriction> to confirm the results. */    
    @Test
    public void testRemoveDietaryRestriction() {
        // Given
        DisasterVictim victim = new DisasterVictim();
        victim.addDietaryRestrictions(DietaryRestriction.MOML);
        victim.addDietaryRestrictions(DietaryRestriction.PFML);

        // When
        victim.removeDietaryRestriction(DietaryRestriction.MOML);

        // Then
        assertEquals(1, victim.getDietaryRestrictions().size());
        assertFalse(victim.getDietaryRestrictions().contains(DietaryRestriction.MOML));
        assertTrue(victim.getDietaryRestrictions().contains(DietaryRestriction.PFML));
    }    

    //insert tests for addFamilyConnection
    //insert tests for removeFamilyConnection
    /*insert tests for Interface
     * Enter FamilyConnection
     * enterInfo
     * enterMedicalRecords
    */
    
    // Tests that were provided with GP2. Slight modifications were made to account for requirment 1: (changing ArrayLists)
    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }
    
    @Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }

    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }

    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }

    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        List<FamilyRelation> expectedRelations = new LinkedList<>();
        expectedRelations.add(relation);
        victim2.setFamilyConnections(expectedRelations);

        List<FamilyRelation> testFamily = victim2.getFamilyConnections();
        boolean correct = false;

        if ((testFamily!=null) && (testFamily.get(0) == expectedRelations.get(0))) {
                correct = true;
        }
        assertTrue("addFamilyConnection should add a family relationship", correct);
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        List<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = false;
 
        for (Supply supply : testSupplies) {
            if (supply == newSupply) {
                correct = true;
                break;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }
}