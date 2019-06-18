package de.hsd.ase.functionalinterfaces;

// XXX: no functional interface
//@FunctionalInterface
public interface RunnablePredicate extends Runnable {

    boolean test(String t);
}
