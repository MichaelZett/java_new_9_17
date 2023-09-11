package de.zettsystems.main;

import de.zettsystems.hello.HelloService;

import java.util.ServiceLoader;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Doing lookup....");
        Iterable<HelloService> services =
                ServiceLoader.load(HelloService.class);

        services.forEach(HelloService::sayHello);
    }
}
