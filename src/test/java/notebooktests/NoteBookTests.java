package notebooktests;

import com.testing.tasks.notebook.View;
import com.testing.tasks.notebook.Model;
import org.junit.After;
import org.junit.Assert;
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

public class NoteBookTests {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    Model model;
    Scanner scanner;
    View view;
    List<String> list;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUp() {
        model = new Model();
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
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

    @Test
    public void validLastnameInput() {
        String testLastname = "Name";
        provideInput(testLastname);
        scanner = new Scanner(System.in);
        View.printMessageWithoutNewLine(model.inputRegex(scanner, Model.LASTNAME_REGEX));
        scanner.close();
        assertEquals(testLastname, getOutput());
    }

    @Test
    public void invalidLastnameInput() {
        String testLastname = "Name23";
        provideInput(testLastname);
        scanner = new Scanner(System.in);
        View.printMessageWithoutNewLine(model.inputRegex(scanner, Model.LASTNAME_REGEX));
        scanner.close();
        assertEquals(View.TRY_AGAIN + System.lineSeparator() + null, getOutput());
    }

    @Test
    public void getLastNameFirstNameSurnameInShort() {
        String lastname = "lastname";
        String firstname = "firstname";
        String surname = "surname";
        list.add(lastname);
        list.add(firstname);
        list.add(surname);
        String shortInfo = list.get(0) + " " + list.get(1).charAt(0) + ".";
        String result = model.getLastnameFirstnameSurname(list);
        Assert.assertEquals(shortInfo, result);
    }
}
