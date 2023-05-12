package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.BeforeClass;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


public class RomanPrinterTest {

    @BeforeClass 
    public static void classSetUp() {
        new RomanPrinter();
    }

    @Test
    public void testPrint_WithNullAsInput() throws NullPointerException, RomanNumberException {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(-1))
                .thenReturn(null);

            NullPointerException exc = assertThrows(
                NullPointerException.class,
                () -> RomanPrinter.print(-1)
            );
            
            assertEquals("The roman number must not be null", exc.getMessage());
        }                     
    }

    @Test
    public void testPrint_WithEmptyStringAsInput() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(0))
                .thenReturn("");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(0)
            );
            
            assertEquals("You can't print an empty string in Roman ascii art", exc.getMessage());
        }                     
    }

    @Test
    public void testPrint_WithTooLongInput() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(13000))
                .thenReturn("MMMMMMMMMMMMM");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(13000)
            );
            
            assertEquals("You can't print a Roman number longer than 12 characters", exc.getMessage());
        }       
    }

    @Test
    public void testPrint_WithTooBigInput() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(4000))
                .thenReturn("MMMM");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(4000)
            );
            
            assertEquals("You can't print a Roman number greater than 3999", exc.getMessage());
        }       
    }

    @Test
    public void testPrint_WithIncompatibleSymbol() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(-2))
                .thenReturn("ciao");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(-2)
            );
            
            assertEquals("The string contains incompatible characters", exc.getMessage());
        }       
    }

    @Test
    public void testPrint_One() throws RomanNumberException {

        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(1))
                .thenReturn("I");

            assertEquals(
                " _____ \n" +
                "|_   _|\n" +
                "  | |  \n" +
                "  | |  \n" +
                " _| |_ \n" +
                "|_____|", 
                RomanPrinter.print(1)
            );
        }
    }  
    
    @Test
    public void testPrint_Two() throws RomanNumberException {

        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(2))
                .thenReturn("II");

            assertEquals(
                " _____   _____ \n" +
                "|_   _| |_   _|\n" +
                "  | |     | |  \n" +
                "  | |     | |  \n" +
                " _| |_   _| |_ \n" +
                "|_____| |_____|", 
                RomanPrinter.print(2)
            );
        }
    }

    @Test
    public void testPrint_Four() throws RomanNumberException {

        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(4))
                .thenReturn("IV");

            assertEquals(
                " _____  __      __\n" +
                "|_   _| \\ \\    / /\n" +
                "  | |    \\ \\  / / \n" +
                "  | |     \\ \\/ /  \n" +
                " _| |_     \\  /   \n" +
                "|_____|     \\/    ", 
                RomanPrinter.print(4)
            );
        }
    }

    @Test
    public void testPrint_Five() throws RomanNumberException {

        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(5))
                .thenReturn("V");

            assertEquals(
                "__      __\n" +
                "\\ \\    / /\n" +
                " \\ \\  / / \n" +
                "  \\ \\/ /  \n" +
                "   \\  /   \n" +
                "    \\/    ", 
                RomanPrinter.print(5)
            );
        }
    }

    @Test
    public void testPrint_Six() throws RomanNumberException {

        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(6))
                .thenReturn("VI");

            assertEquals(
                "__      __  _____ \n" +
                "\\ \\    / / |_   _|\n" +
                " \\ \\  / /    | |  \n" +
                "  \\ \\/ /     | |  \n" +
                "   \\  /     _| |_ \n" +
                "    \\/     |_____|", 
                RomanPrinter.print(6)
            );
        }
    }

    @Test
    public void testPrint_Nine() throws RomanNumberException {

        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(9))
                .thenReturn("IX");

            assertEquals(
                " _____  __   __\n" +
                "|_   _| \\ \\ / /\n" +
                "  | |    \\ V / \n" +
                "  | |     > <  \n" +
                " _| |_   / . \\ \n" +
                "|_____| /_/ \\_\\", 
                RomanPrinter.print(9)
            );
        }
    } 
    
    @Test
    public void testPrint_Ten() throws RomanNumberException {

        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(10))
                .thenReturn("X");

            assertEquals(
                "__   __\n" +
                "\\ \\ / /\n" +
                " \\ V / \n" +
                "  > <  \n" +
                " / . \\ \n" +
                "/_/ \\_\\", 
                RomanPrinter.print(10)
            );
        }
    }  

    @Test
    public void testPrint_Thirtynine() throws RomanNumberException {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(39))
                .thenReturn("XXXIX");

            assertEquals(
                "__   __ __   __ __   __  _____  __   __\n" +
                "\\ \\ / / \\ \\ / / \\ \\ / / |_   _| \\ \\ / /\n" +
                " \\ V /   \\ V /   \\ V /    | |    \\ V / \n" +
                "  > <     > <     > <     | |     > <  \n" +
                " / . \\   / . \\   / . \\   _| |_   / . \\ \n" +
                "/_/ \\_\\ /_/ \\_\\ /_/ \\_\\ |_____| /_/ \\_\\", 
                RomanPrinter.print(39)
            );
        }
    }

    @Test
    public void testPrint_FourtyOne() throws RomanNumberException {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(41))
                .thenReturn("XLI");

            assertEquals(
                "__   __  _        _____ \n" +
                "\\ \\ / / | |      |_   _|\n" +
                " \\ V /  | |        | |  \n" +
                "  > <   | |        | |  \n" +
                " / . \\  | |____   _| |_ \n" +
                "/_/ \\_\\ |______| |_____|", 
                RomanPrinter.print(41)
            );
        }
    }

    @Test
    public void testConvert_Fifty() throws RomanNumberException {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(50))
                .thenReturn("L");

            assertEquals(
                " _      \n" +
                "| |     \n" +
                "| |     \n" +
                "| |     \n" +
                "| |____ \n" +
                "|______|", 
                RomanPrinter.print(50)
            );
        }
    }
}