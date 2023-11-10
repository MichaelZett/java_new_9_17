package de.zettsystems.java16.records;

import lombok.Builder;

import java.util.Objects;

public record CustomerValidatingConstructor(String name, boolean vip) {
    public CustomerValidatingConstructor(String name) {
        this(name, false);
    }

    public CustomerValidatingConstructor {
        Objects.requireNonNull(name);
    }
}
