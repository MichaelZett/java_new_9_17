package de.zettsystems.main;

import de.zettsystems.legacy.UseMeFromAModule;
import de.zettsystems.hello.HelloSayer;

//import de.zettsystems.goodbye.GoodbyeSayer;

public class MainApp {
    public static void main(String[] args) {
        new HelloSayer().sayHello();
        new UseMeFromAModule().saySomething();
//        new GoodbyeSayer().sayGoodbye();
    }
}
