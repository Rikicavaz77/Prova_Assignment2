////////////////////////////////////////////////////////////////////
// Riccardo Cavalli 2042893
// Pietro Giovanni Marchiorato 2042365
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;

public class IntegerToRoman 
{
  public static String convert(int number) throws RomanNumberException {
    if (number < 0) throw new RomanNumberException("I numeri negativi non sono convertibili in numero romano");
    if (number == 0) throw new RomanNumberException("Lo 0 non è convertibile in numero romano");
    if (number >= 4000) throw new RomanNumberException("Con i simboli I, V, X, L, C, D e M si possono rappresentare solo i numeri da 1 a 3999; per i numeri più grandi sono necessarie una o più linee sopra il simbolo");


    return null;
  }
}
