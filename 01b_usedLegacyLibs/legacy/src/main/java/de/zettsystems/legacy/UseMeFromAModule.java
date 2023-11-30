package de.zettsystems.legacy;


import de.zettsystems.morelegacy.NoModulesWithMe;

public class UseMeFromAModule {
    public void saySomething() {
        System.out.println("I am automatic and I use a non-module jar!");
        new NoModulesWithMe().saySomething();
    }
}
