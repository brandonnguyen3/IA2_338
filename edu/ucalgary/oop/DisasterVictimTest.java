/*Changed all ArrayLists to LinkedLists */


/*Info about This test file
 * Was not able to complete the tests for the interface. Will most likely highly modify it in the final submission.
 * They should work more like setters. 
 * 
 */

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

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

    /*Should throw an exception if the birthdate being set is from the future. */
    @Test
    public void testInvalidAgeCalculation() {
        // Given
        DisasterVictim victim = new DisasterVictim();
        
        // When setting an invalid future date
        assertThrows(IllegalArgumentException.class, () -> {
            victim.setDateOfBirth("2025-01-01");
            victim.calculateAge();
        });
    }

    /*Tests that an exception is thrown when  */

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

    /*Tests that we can remove FamilyConnecton can remove a FamilyRelation from the list. */
    @Test
    public void testRemoveFamilyConnection() {
        // Given
        DisasterVictim victim3 = new DisasterVictim("Steve", "2024-01-20");
        DisasterVictim victim4 = new DisasterVictim("Mike", "2024-01-22");
        FamilyRelation relation = new FamilyRelation(victim3, "parent", victim4);
        
        victim3.addFamilyConnection(relation);

        victim3.removeFamilyConnection(relation);

        //If it is removed, we should expect 0. 
        assertEquals(0, victim3.getFamilyConnections().size());
        assertFalse(victim3.getFamilyConnections().contains(relation));
    }
    /*Tests for the interface. 
     * enterInfo()
     * enterFamilyConnection():FamilyRelation
     * enterMedicalRecords(): MedicalRecord
    */

    /*Tests enterInfo from the Interface. Will test that info can be added to the constructor. */
    @Test
    public void testEnterInfo() {
        // Given
        String firstName = "John";
        String entryDate = "2024-01-20";
        String userInput = firstName + "\n" + entryDate;
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // When
        DisasterVictim victimInfo.enterInfo();

        // Then
        assertEquals(firstName, victimInfo.getFirstName());
        assertEquals(entryDate, victimInfo.getEntryDate());

        // Reset System.in
        System.setIn(System.in);
    }

    /*Tests enterFamilyConnection. Note differs from the UML diagram. 
    Modifed enterFamilyConnection(personTwo:DisasterVictim): FamilyRelation */
    @Test
    public void testEnterFamilyConnection(){
        DisasterVictim personOne = new DisasterVictim("Case", "2024-03-11");
        DisasterVictim personTwo = new DisasterVictim("Mark", "2024-03-12")
        String relationInput = "siblings";
        InputStream inputStream = new ByteArrayInputStream(relationInput.getBytes());
        System.setIn(inputStream);

        //When
        FamilyRelation relationFromInterface = new FamilyRelation(new EnterDisasterVictim());

        //Should test whether the sibling relationship is set. 
        assertEquals("The relationship should be siblings", relationInput, relationFromInterface.getRelationshipTo());

        System.setIn(System.in);
    }

    /*Test for enterMedicalRecords() from the interface. Note this differs from the UML diagram. Now
     * takes an argument of Location. enterMedicalRecords(location:Location)*/

    @Test
    public void testEnterMedicalRecords() {
        // Given
        String inputTreatmentDetails = "Urgent Care";
        String inputDate = "2024-01-20";
        String userInput = inputTreatmentDetails + "\n" + inputDate;
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // When
        Location victimInfo = new Location(new EnterDisasterVictim());



        
        // Reset System.in
        System.setIn(System.in);
    }


    /*Test FamilyRelation Consistency: Requirement 2 */


    
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