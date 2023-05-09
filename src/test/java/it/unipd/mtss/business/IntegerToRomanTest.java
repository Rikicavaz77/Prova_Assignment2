package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class IntegerToRomanTest {
    
    @Rule
	public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testConvert_WithNegativeNumberAsInput() throws RomanNumberException {
        thrown.expect(RomanNumberException.class);
		thrown.expectMessage("Negative numbers are not convertible into Roman ones");

        IntegerToRoman.convert(-1);
    }

    @Test
    public void testConvert_With0AsInput() throws RomanNumberException {
        thrown.expect(RomanNumberException.class);
		thrown.expectMessage("0 is not convertible into a Roman numeral");

        IntegerToRoman.convert(0);
    }

    @Test
    public void testConvert_WithMoreThan3999AsInput() throws RomanNumberException {
        thrown.expect(RomanNumberException.class);
		thrown.expectMessage("I, V, X, L, C, D and M only support numbers from 1 to 3999");

        IntegerToRoman.convert(4000);
    }
      

}