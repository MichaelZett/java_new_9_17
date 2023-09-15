package de.zettsystems.java16.records;

import lombok.NonNull;

import java.util.Objects;

public class CustomerOldSchool {
    private final String name;
    private final boolean vip;

    public CustomerOldSchool(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOldSchool that = (CustomerOldSchool) o;
        return vip == that.vip && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vip);
    }

    @Override
    public String toString() {
        return "CustomerOldSchool{" +
                "name='" + name + '\'' +
                ", vip=" + vip +
                '}';
    }
}
