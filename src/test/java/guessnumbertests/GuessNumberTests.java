package guessnumbertests;

import com.testing.tasks.guessnumber.Model;
import com.testing.tasks.guessnumber.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GuessNumberTests {
    //For IO testing
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    Model model;
    Scanner scanner;
    List<Integer> numbers;
    List<Integer> newNumbers;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUp() {
        model = new Model();
        scanner = new Scanner(System.in);
        numbers = new ArrayList<>();
        newNumbers = new ArrayList<>();
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private void provideInput(byte[] data) {
        testIn = new ByteArrayInputStream(data, 1, 1);
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void randomNumberWithParameters() throws IllegalArgumentException {
        model.setFirstNumber(10);
        model.setSecondNumber(9);
        model.getRandomNumber(model.getFirstNumber(), model.getSecondNumber());
    }

    @Test
    public void checkSwapToNewRangeWhenFirstNumberGreaterThanSecond() {
        model.setFirstNumber(10);
        model.setSecondNumber(9);
        Integer firstNumber = model.getFirstNumber();
        Integer secondNumber = model.getSecondNumber();
        numbers.add(model.getFirstNumber());
        numbers.add(model.getSecondNumber());
        model.swapFromStartedToNewRange(numbers, newNumbers);
        assertEquals(firstNumber, newNumbers.get(1));
        assertEquals(secondNumber, newNumbers.get(0));
    }

    @Test
    public void checkSwapToNewRangeWhileFirstLessThanSecond() {
        model.setFirstNumber(9);
        model.setSecondNumber(10);
        Integer firstNumber = model.getFirstNumber();
        Integer secondNumber = model.getSecondNumber();
        numbers.add(model.getFirstNumber());
        numbers.add(model.getSecondNumber());
        model.swapFromStartedToNewRange(numbers, newNumbers);
        assertEquals(firstNumber, newNumbers.get(0));
        assertEquals(secondNumber, newNumbers.get(1));
    }

    @Test
    public void testNotIntegerInput() {
        String testString = "Hello!";
        provideInput(testString);
        scanner = new Scanner(System.in);
        model.validateTheIntegerInput(scanner);
        scanner.close();
        assertEquals(View.INPUT_NOT_INTEGER, getOutput());
    }

    @Test
    public void testIntegerInput() {
        String testInteger = "98";
        provideInput(testInteger);
        scanner = new Scanner(System.in);
        model.validateTheIntegerInput(scanner);
        new View().printMessageWithoutNewLine(scanner.next());
        scanner.close();
        assertEquals(testInteger, getOutput());
    }
}
