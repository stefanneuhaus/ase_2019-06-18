package de.hsd.ase.defaultmethods;

public class BC implements B, C {

    public static void main(String[] args) {
        var bc = new BC();
        System.out.println(bc.whoAmI());
    }

    // override method to resolve ambiguity
    public String whoAmI() {
        return "BC";
    }
}
