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
        
        assertEquals("I", IntegerToRoman.convert(1));
    }

    @Test
    public void testConvert_Two() throws RomanNumberException {
        
        assertEquals("II", IntegerToRoman.convert(2));
    }

    @Test
    public void testConvert_Four() throws RomanNumberException {
        
        assertEquals("IV", IntegerToRoman.convert(4));
    }
    
    @Test
    public void testConvert_Five() throws RomanNumberException {
        
        assertEquals("V", IntegerToRoman.convert(5));
    }

    @Test
    public void testConvert_Six() throws RomanNumberException {
        
        assertEquals("VI", IntegerToRoman.convert(6));
    }

    @Test
    public void testConvert_Nine() throws RomanNumberException {
        
        assertEquals("IX", IntegerToRoman.convert(9));
    }

    @Test
    public void testConvert_Ten() throws RomanNumberException {
        
        assertEquals("X", IntegerToRoman.convert(10));
    }

    @Test
    public void testConvert_Fourteen() throws RomanNumberException {
        
        assertEquals("XIV", IntegerToRoman.convert(14));
    }

    @Test
    public void testConvert_Thirtynine() throws RomanNumberException {
        
        assertEquals("XXXIX", IntegerToRoman.convert(39));
    }

    @Test
    public void testConvert_Forty() throws RomanNumberException {
        
        assertEquals("XL", IntegerToRoman.convert(40));
    }

    @Test
    public void testConvert_FourtyOne() throws RomanNumberException {
        
        assertEquals("XLI", IntegerToRoman.convert(41));
    }

    @Test
    public void testConvert_Fifty() throws RomanNumberException {
        
        assertEquals("L", IntegerToRoman.convert(50));
    }

    @Test
    public void testConvert_SixtyTwo() throws RomanNumberException {
        
        assertEquals("LXII", IntegerToRoman.convert(62));
    }

    @Test
    public void testConvert_EightyNine() throws RomanNumberException {
        
        assertEquals("LXXXIX", IntegerToRoman.convert(89));
    }

    @Test
    public void testConvert_Ninety() throws RomanNumberException {
        
        assertEquals("XC", IntegerToRoman.convert(90));
    }

    @Test
    public void testConvert_NinetyNine() throws RomanNumberException {
        
        assertEquals("XCIX", IntegerToRoman.convert(99));
    }

    @Test
    public void testConvert_Hundred() throws RomanNumberException {
        
        assertEquals("C", IntegerToRoman.convert(100));
    }

    @Test
    public void testConvert_ThreeHundredAndNinetyNine() throws RomanNumberException {
        
        assertEquals("CCCXCIX", IntegerToRoman.convert(399));
    }

    @Test
    public void testConvert_FourHundred() throws RomanNumberException {
        
        assertEquals("CD", IntegerToRoman.convert(400));
    }

    @Test
    public void testConvert_FiveHundred() throws RomanNumberException {
        
        assertEquals("D", IntegerToRoman.convert(500));
    }

    @Test
    public void testConvert_EightHundredAndNinetyEight() throws RomanNumberException {
        
        assertEquals("DCCCXCVIII", IntegerToRoman.convert(898));
    }

    @Test
    public void testConvert_NineHundred() throws RomanNumberException {
        
        assertEquals("CM", IntegerToRoman.convert(900));
    }

    @Test
    public void testConvert_OneThousand() throws RomanNumberException {
        
        assertEquals("M", IntegerToRoman.convert(1000));
    }
}