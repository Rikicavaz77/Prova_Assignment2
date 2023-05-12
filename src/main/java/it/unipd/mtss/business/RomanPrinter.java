////////////////////////////////////////////////////////////////////
// Riccardo Cavalli 2042893
// Pietro Giovanni Marchiorato 2042365
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;

import java.util.Objects;

public class RomanPrinter {

  static int array[];
  static String matrice[][];

  public RomanPrinter()
  {
    array = new int[100];
    matrice = new String[6][7];

    array[73] = 0;
    matrice[0][0] = " _____ "; 
    matrice[1][0] = "|_   _|";  
    matrice[2][0] = "  | |  "; 
    matrice[3][0] = "  | |  ";
    matrice[4][0] = " _| |_ "; 
    matrice[5][0] = "|_____|"; 

    array[86] = 1;
    matrice[0][1] = "__      __"; 
    matrice[1][1] = "\\ \\    / /";
    matrice[2][1] = " \\ \\  / / "; 
    matrice[3][1] = "  \\ \\/ /  "; 
    matrice[4][1] = "   \\  /   "; 
    matrice[5][1] = "    \\/    ";

    array[88] = 2;
    matrice[0][2] = "__   __"; 
    matrice[1][2] = "\\ \\ / /";
    matrice[2][2] = " \\ V / "; 
    matrice[3][2] = "  > <  "; 
    matrice[4][2] = " / . \\ "; 
    matrice[5][2] = "/_/ \\_\\";

    array[76] = 3;
    matrice[0][3] = " _      "; 
    matrice[1][3] = "| |     ";
    matrice[2][3] = "| |     ";
    matrice[3][3] = "| |     ";
    matrice[4][3] = "| |____ ";
    matrice[5][3] = "|______|";

    array[67] = 4;
    matrice[0][4] = "  _____ "; 
    matrice[1][4] = " / ____|";
    matrice[2][4] = "| |     ";
    matrice[3][4] = "| |     ";
    matrice[4][4] = "| |____ ";
    matrice[5][4] = " \\_____|";

    array[68] = 5;
    matrice[0][5] = " _____  "; 
    matrice[1][5] = "|  __ \\ ";
    matrice[2][5] = "| |  | |";
    matrice[3][5] = "| |  | |";
    matrice[4][5] = "| |__| |";
    matrice[5][5] = "|_____/ ";

    array[77] = 6;
    matrice[0][6] = " __  __ "; 
    matrice[1][6] = "|  \\/  |";
    matrice[2][6] = "| \\  / |";
    matrice[3][6] = "| |\\/| |";
    matrice[4][6] = "| |  | |";
    matrice[5][6] = "|_|  |_|";
  }

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

    String RomanAsciArt = "";

    for (int i = 0; i < 6; i++)
    {
      for (int j = 0; j < romanNumber.length(); j++)
      {
        RomanAsciArt += matrice[i][array[(romanNumber.charAt(j))]];

        if (j + 1 != romanNumber.length())
        {
          RomanAsciArt += " ";
        }
      }
      if (i + 1 != 6)
      {
        RomanAsciArt += "\n";
      }
    }
    return RomanAsciArt;
  }
}