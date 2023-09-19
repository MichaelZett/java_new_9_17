package de.zettsystems.smallapi;

import java.util.Objects;
import java.util.Optional;

public class OptionalStream {

    public void showThatStream(String value) {
        Optional.ofNullable(value)
                .stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
