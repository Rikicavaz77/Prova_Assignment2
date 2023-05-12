package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.BeforeClass;

public class IntegerToRomanTest {

    @BeforeClass 
    public static void classSetUp() {
        new IntegerToRoman();
    }
    
    @Test
    public void testConvert_WithNegativeNumberAsInput() {
        
        RomanNumberException exc = assertThrows(
            RomanNumberException.class,
            () -> IntegerToRoman.convert(-1)
        );
            
        assertEquals("Negative numbers are not convertible into Roman ones", exc.getMessage());
    }

    @Test
    public void testConvert_With0AsInput() {
        
        RomanNumberException exc = assertThrows(
            RomanNumberException.class,
            () -> IntegerToRoman.convert(0)
        );
            
        assertEquals("0 is not convertible into a Roman numeral", exc.getMessage());
    }

    @Test
    public void testConvert_WithMoreThan3999AsInput() {
        
        RomanNumberException exc = assertThrows(
            RomanNumberException.class,
            () -> IntegerToRoman.convert(4000)
        );
            
        assertEquals("I, V, X, L, C, D and M only support numbers from 1 to 3999", exc.getMessage());
    }

    @Test
    public void testConvert_One() throws RomanNumberException {
        
        assertRomanNumberEquals("I", 1);
    }

    @Test
    public void testConvert_Two() throws RomanNumberException {
        
        assertRomanNumberEquals("II", 2);
    }

    @Test
    public void testConvert_Four() throws RomanNumberException {
        
        assertRomanNumberEquals("IV", 4);
    }
    
    @Test
    public void testConvert_Five() throws RomanNumberException {
        
        assertRomanNumberEquals("V", 5);
    }

    @Test
    public void testConvert_Six() throws RomanNumberException {
        
        assertRomanNumberEquals("VI", 6);
    }

    @Test
    public void testConvert_Nine() throws RomanNumberException {
        
        assertRomanNumberEquals("IX", 9);
    }

    @Test
    public void testConvert_Ten() throws RomanNumberException {
        
        assertRomanNumberEquals("X", 10);
    }

    @Test
    public void testConvert_Fourteen() throws RomanNumberException {
        
        assertRomanNumberEquals("XIV", 14);
    }

    @Test
    public void testConvert_Thirtynine() throws RomanNumberException {
        
        assertRomanNumberEquals("XXXIX", 39);
    }

    @Test
    public void testConvert_Forty() throws RomanNumberException {
        
        assertRomanNumberEquals("XL", 40);
    }

    @Test
    public void testConvert_FourtyOne() throws RomanNumberException {
        
        assertRomanNumberEquals("XLI", 41);
    }

    @Test
    public void testConvert_Fifty() throws RomanNumberException {
        
        assertRomanNumberEquals("L", 50);
    }

    @Test
    public void testConvert_SixtyTwo() throws RomanNumberException {
        
        assertRomanNumberEquals("LXII", 62);
    }

    @Test
    public void testConvert_EightyNine() throws RomanNumberException {
        
        assertRomanNumberEquals("LXXXIX", 89);
    }

    @Test
    public void testConvert_Ninety() throws RomanNumberException {
        
        assertRomanNumberEquals("XC", 90);
    }

    @Test
    public void testConvert_NinetyNine() throws RomanNumberException {
        
        assertRomanNumberEquals("XCIX", 99);
    }

    @Test
    public void testConvert_Hundred() throws RomanNumberException {
        
        assertRomanNumberEquals("C", 100);
    }

    @Test
    public void testConvert_ThreeHundredAndNinetyNine() throws RomanNumberException {
        
        assertRomanNumberEquals("CCCXCIX", 399);
    }

    @Test
    public void testConvert_FourHundred() throws RomanNumberException {
        
        assertRomanNumberEquals("CD", 400);
    }

    @Test
    public void testConvert_FiveHundred() throws RomanNumberException {
        
        assertRomanNumberEquals("D", 500);
    }

    @Test
    public void testConvert_EightHundredAndNinetyEight() throws RomanNumberException {
        
        assertRomanNumberEquals("DCCCXCVIII", 898);
    }

    @Test
    public void testConvert_NineHundred() throws RomanNumberException {
        
        assertRomanNumberEquals("CM", 900);
    }

    @Test
    public void testConvert_OneThousand() throws RomanNumberException {
        
        assertRomanNumberEquals("M", 1000);
    }

    private static void assertRomanNumberEquals(String roman, int number) 
    {
        try {
            assertEquals(roman, IntegerToRoman.convert(number));
        } catch (RomanNumberException e) {};
    }
}