package de.hsd.ase.localvariabletypeinference;

public class Var {

    public String var;

    public static int var() {
        return 42;
    }

    public static void main(String[] args) {
        int result = var();
        System.out.println(result);
    }
}
