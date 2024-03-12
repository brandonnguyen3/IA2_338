/*
 * Author: Brandon Nguyen
 * Date: 03/12/2024
 */

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void testSetDate_ValidDateFormat() {
        Date date = new Date(1, 1, 2000);
        date.setDate("2024-03-12");
        assertEquals(12, date.getDay());
        assertEquals(3, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test
    public void testSetDate_InvalidDateFormat() {
        Date date = new Date(1, 1, 2000);
        assertThrows(IllegalArgumentException.class, () -> {
            date.setDate("2024/03/12");
        });
    }

    @Test
    public void testGetDate() {
        Date date = new Date(12, 3, 2024);
        assertEquals("2024-03-12", date.getDate());
    }

    @Test
    public void testIsValidDateFormat_ValidFormat() {
        Date date = new Date(12, 3, 2024);
        assertTrue(date.isValidDateFormat("2024-03-12"));
    }

    @Test
    public void testIsValidDateFormat_InvalidFormat() {
        Date date = new Date(12, 3, 2024);
        assertFalse(date.isValidDateFormat("2024/03/12"));
    }
}
