package de.hsd.ase.streams;

import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;

public class ParallelStreams {

    static long processLongStream(int numberOfStreamElements, LongUnaryOperator operator) {
        long startMillis = System.currentTimeMillis();

        long result = LongStream.range(0, numberOfStreamElements)
                .parallel()
                .map(operator)
                .peek(ignoredLong -> System.out.println(Thread.currentThread().getName()))
                .sum();

        long durationMillis = System.currentTimeMillis() - startMillis;
        long durationSeconds = durationMillis / 1_000;
        System.out.println("Result: " + result + " (took " + durationSeconds + " sec)");

        return result;
    }


    static long cheapOperation(long input) {
        return input;
    }

    static long expensiveOperation(long input) {
        long result = 0;
        for (int i = 0; i < 1000; i++) {
            result += i;
            for (int j = 0; j < 1000; j++) {
                result += j;
                result += input;
            }
        }
        return result;
    }
}
