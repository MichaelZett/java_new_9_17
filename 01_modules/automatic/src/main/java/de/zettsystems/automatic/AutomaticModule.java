package de.zettsystems.automatic;

import de.zettsystems.unnamed.UnnamedModule;

public class AutomaticModule {
    public void saySomething() {
        System.out.println("I am automatic and I use a non-module jar!");
        new UnnamedModule().saySomething();
    }
}
