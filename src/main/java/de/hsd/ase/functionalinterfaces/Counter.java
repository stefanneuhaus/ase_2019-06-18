package de.hsd.ase.functionalinterfaces;

public interface Counter {

    String COUNTER_PREFIX = "count: ";

    long getCount();

    default boolean isPositive() {
        return getCount() > 0;
    }

    default String prettyPrintCount() {
        return counterPrefix() + getCount();
    }

    static String counterPrefix() {
        return COUNTER_PREFIX;
    }
}
