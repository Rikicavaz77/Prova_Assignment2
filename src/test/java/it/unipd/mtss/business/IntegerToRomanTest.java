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
		thrown.expectMessage("I numeri negativi non sono convertibili in numero romano");

        IntegerToRoman.convert(-1);
    }

    @Test
    public void testConvert_With0AsInput() throws RomanNumberException {
        thrown.expect(RomanNumberException.class);
		thrown.expectMessage("Lo 0 non è convertibile in numero romano");

        IntegerToRoman.convert(0);
    }

    @Test
    public void testConvert_WithMoreThan3999AsInput() throws RomanNumberException {
        thrown.expect(RomanNumberException.class);
		thrown.expectMessage("Con i simboli I, V, X, L, C, D e M si possono rappresentare solo i numeri da 1 a 3999; per i numeri più grandi sono necessarie una o più linee sopra il simbolo");

        IntegerToRoman.convert(4000);
    }
      

}