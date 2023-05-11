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
    public void testConvert_I() throws RomanNumberException {
        
        assertEquals("I", IntegerToRoman.convert(1));
    }

    @Test
    public void testConvert_II() throws RomanNumberException {
        
        assertEquals("II", IntegerToRoman.convert(2));
    }

    @Test
    public void testConvert_IV() throws RomanNumberException {
        
        assertEquals("IV", IntegerToRoman.convert(4));
    }
    
    @Test
    public void testConvert_V() throws RomanNumberException {
        
        assertEquals("V", IntegerToRoman.convert(5));
    }

    @Test
    public void testConvert_VI() throws RomanNumberException {
        
        assertEquals("VI", IntegerToRoman.convert(6));
    }

    @Test
    public void testConvert_IX() throws RomanNumberException {
        
        assertEquals("IX", IntegerToRoman.convert(9));
    }

    @Test
    public void testConvert_X() throws RomanNumberException {
        
        assertEquals("X", IntegerToRoman.convert(10));
    }
}