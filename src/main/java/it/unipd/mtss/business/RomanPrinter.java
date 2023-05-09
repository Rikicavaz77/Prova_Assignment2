////////////////////////////////////////////////////////////////////
// Riccardo Cavalli 2042893
// Pietro Giovanni Marchiorato 2042365
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;

public class RomanPrinter {
  public static String print(int num) 
      throws RomanNumberException {
    return printAsciiArt(IntegerToRoman.convert(num));
  }
  private static String printAsciiArt(String romanNumber) 
      throws RomanNumberException {
    return null;
  }
}