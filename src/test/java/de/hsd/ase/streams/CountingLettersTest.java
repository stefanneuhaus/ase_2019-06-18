package de.hsd.ase.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingLettersTest {

    @Test
    public void emptyArray() {
        String[] inputStrings = {};

        Assertions.assertEquals(0, CountingLetters.averageNumberOfLettersIgnoringAllUpperCaseInputs(inputStrings));
    }

    @Test
    public void singleEntryArray() {
        String[] inputStrings = {
                "Hello mom."
        };

        assertEquals(10, CountingLetters.averageNumberOfLettersIgnoringAllUpperCaseInputs(inputStrings));
    }

    @Test
    public void onlyAllUpperCaseStrings() {
        String[] inputStrings = {
                "HELLO MOM."
        };

        assertEquals(0, CountingLetters.averageNumberOfLettersIgnoringAllUpperCaseInputs(inputStrings));
    }

    @Test
    public void mixedCase() {
        String[] inputStrings = {
                "Software Engineering",
                "HSD",
                "Streams API",
                "OOP",
                "Spring Break"
        };

        assertEquals(14, CountingLetters.averageNumberOfLettersIgnoringAllUpperCaseInputs(inputStrings));
    }
}
