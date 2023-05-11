////////////////////////////////////////////////////////////////////
// Riccardo Cavalli 2042893
// Pietro Giovanni Marchiorato 2042365
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;

import java.util.Objects;

public class RomanPrinter {

  static int array[] = new int[100];
  static String matrice[][] = new String[7][7];

  public static String print(int num) 
  throws RomanNumberException {
    return printAsciiArt(IntegerToRoman.convert(num));
  }
  private static String printAsciiArt(String romanNumber) 
  throws RomanNumberException  {
    Objects.requireNonNull(romanNumber, "The roman number must not be null");

    if (romanNumber == "") 
    {
      throw new RomanNumberException(
        "You can't print an empty string in Roman ascii art"
      );
    }
    if (romanNumber.length() > 12) 
    {
      throw new RomanNumberException(
        "You can't print a Roman number longer than 12 characters"
      );
    }
    if (romanNumber.startsWith("MMMM")) 
    {
      throw new RomanNumberException(
        "You can't print a Roman number greater than 3999"
      );
    }
    if (romanNumber.replaceAll("[IVXLCDM]*", "").length() > 0)
    {
      throw new RomanNumberException(
        "The string contains incompatible characters"
      );
    }
    return null;
  }
}