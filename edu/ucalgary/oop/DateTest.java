/**
@author Brandon Nguyen
@version 1.1
 */

//Last changed: 03/26 4:34

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void testValidDateCreation() {
        // Valid date
        String validDate = "2024-03-26";
        Date date = new Date(validDate);
        assertEquals("getDate should return the valid date", validDate, date.getDate());
    }

    @Test
    public void testInvalidDateCreation() {
        // Invalid date format
        String invalidDate = "2024/03/26";
        try {
            Date date = new Date(invalidDate);
            fail("Should throw an IllegalArgumentException for invalid date format");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date format for treatment details. Expected format: YYYY-MM-DD", e.getMessage());
        }
    }

    @Test
    public void testSetValidDate() {
        // Valid date
        String validDate = "2024-03-26";
        Date date = new Date("2024-01-01");
        date.setDate(validDate);
        assertEquals("After setting a valid date, getDate should return the updated valid date", validDate, date.getDate());
    }

    @Test
    public void testSetInvalidDate() {
        // Invalid date format
        String invalidDate = "2024/03/26";
        Date date = new Date("2024-01-01");
        try {
            date.setDate(invalidDate);
            fail("Should throw an IllegalArgumentException for invalid date format");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date format. Expected format: YYYY-MM-DD", e.getMessage());
        }
    }

    @Test
    public void testIsValidDateFormatValid() {
        // Valid date format
        String validDate = "2024-03-26";
        Date date = new Date(validDate);
        assertTrue("isValidDateFormat should return true for a valid date format", date.isValidDateFormat(validDate));
    }

    @Test
    public void testIsValidDateFormatInvalid() {
        // Invalid date format
        String invalidDate = "2024/03/26";
        Date date = new Date("2024-01-01");
        assertFalse("isValidDateFormat should return false for an invalid date format", date.isValidDateFormat(invalidDate));
    }
}
