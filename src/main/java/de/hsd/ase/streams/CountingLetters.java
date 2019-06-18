package de.hsd.ase.streams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class CountingLetters {

    public static void main(String[] args) {
        IntStream infiniteStream = IntStream.iterate(2, (number) -> number * 2);
        OptionalInt max = infiniteStream.max();

        // we will never reach this line
        System.out.println("MAX: " + max.getAsInt());
    }


    public static long averageNumberOfLettersIgnoringAllUpperCaseInputs(String[] inputStrings) {
        IntStream stream = Arrays.stream(inputStrings)
                .filter(input -> !isAllUpperCase(input))
                .mapToInt(String::length)
                .peek(ignoredInt -> System.out.println(Thread.currentThread().getName()));

        // the computation does not start before calling the terminal operation
        OptionalDouble optionalDouble = stream.average();

        // XXX: re-using streams does not work
        // System.out.println("sum: " + stream.sum());

        double average = optionalDouble.orElse(0);
        System.out.println("avg: " + average);
        return Math.round(average);
    }

    static boolean isAllUpperCase(String input) {
        System.out.println("  processing " + input);
        return input.equals(input.toUpperCase());
    }
}
