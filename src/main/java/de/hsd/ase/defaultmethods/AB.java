package de.hsd.ase.defaultmethods;

public class AB extends A implements B {

    public static void main(String[] args) {
        var ab = new AB();
        System.out.println(ab.whoAmI());
    }
}
