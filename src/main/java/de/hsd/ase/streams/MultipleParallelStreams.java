package de.hsd.ase.streams;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultipleParallelStreams {

    public static void main(String[] args) throws InterruptedException {
        Thread longRunningOperations = new Thread(MultipleParallelStreams::processBlockingOperationsInParallel, "thread-blocking");

        // TODO: uncomment me!
        // longRunningOperations.start();

        Thread.sleep(2000);

        sumUpInParallel();

        longRunningOperations.join();
    }

    private static void sumUpInParallel() {
        int result = IntStream.range(1, 1000)
                .parallel()
                .peek(ignored -> System.out.println(Thread.currentThread().getName()))
                .sum();
        System.out.println("sum: " + result);
    }


    static void processBlockingOperationsInParallel() {
        IntStream.range(0, 20)
                .parallel()
                .forEach(MultipleParallelStreams::longRunningCall);
        System.out.println("Finished all blocking operations.");
    }

    static void longRunningCall(int ignoredInput) {
        System.out.println("Executing long running calculation ... -- " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            // ignore
        }
        System.out.println("  done.");
    }
}
