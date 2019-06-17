package de.hsd.ase;


public class App {

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        var greeting = new App().getGreeting();
        System.out.println(greeting);
    }
}
