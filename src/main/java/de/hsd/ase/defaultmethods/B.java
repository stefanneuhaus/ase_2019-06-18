package de.hsd.ase.defaultmethods;

public interface B {

    default String whoAmI() {
        return "B";
    }
}
