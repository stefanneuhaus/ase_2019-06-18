package de.hsd.ase.streams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParallelStreamsTest {

    @Test
    public void cheapOperation() {
        long result = ParallelStreams.processLongStream(150_000, ParallelStreams::cheapOperation);

        assertEquals(11249925000L, result);
    }

    @Test
    public void expensiveOperation() {
        long result = ParallelStreams.processLongStream(150_000, ParallelStreams::expensiveOperation);

        assertEquals(11324924925000000L, result);
    }
}
