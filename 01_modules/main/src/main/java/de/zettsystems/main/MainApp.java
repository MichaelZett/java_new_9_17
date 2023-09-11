package de.zettsystems.main;

import de.zettsystems.automatic.AutomaticModule;
import de.zettsystems.hello.HelloSayer;

import java.util.ServiceLoader;
//import de.zettsystems.goodbye.GoodbyeSayer;

public class MainApp {
    public static void main(String[] args) {
        new HelloSayer().sayHello();
        new AutomaticModule().saySomething();
//        new GoodbyeSayer().sayGoodbye();
    }
}
