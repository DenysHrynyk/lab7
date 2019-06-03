package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    StringProcessor manager = new StringProcessor();
    String testString;
    List<String> expected;
    List<String> actual;

    @BeforeEach
    public void setUp() {
        expected = new LinkedList<String>();
        actual = new LinkedList<String>();

        testString = "https://github.com/victoriafolyush/Python, https://github.com/DenysHrynyk/lab7";

        expected.add("/victoriafolyush/");
        expected.add("/DenysHrynyk/");

        manager.setLine(testString);
    }

    @Test
    public void testFindMatch() {
        actual = manager.findMatch();
        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals(expected, actual);
        manager.showResults();
    }

    @Test
    public void testFindMatchNotFound() {
        manager.setLine("https://www.jetbrains.com/help/idea/create-tests.html");
        actual = manager.findMatch();
        Assertions.assertEquals(0, actual.size());
        manager.showResults();
    }

}