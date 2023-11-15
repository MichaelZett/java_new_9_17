package de.zettsystems.smallapi;

import java.util.Optional;

public class OptionalOrElseThrow {

    public void showNewMethod(String value) {
        // throws NoSuchElementException wenn leer - soll nun an Stelle von get() benutzt werden
        String someValue = Optional.ofNullable(value).orElseThrow();
    }

    public void showOldStyle(String value) {
        // throws NoSuchElementException wenn leer
        String someValue = Optional.ofNullable(value).get();
    }
}
