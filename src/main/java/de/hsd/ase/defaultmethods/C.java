package de.hsd.ase.defaultmethods;

public interface C {

    default String whoAmI() {
        return "C";
    }
}
