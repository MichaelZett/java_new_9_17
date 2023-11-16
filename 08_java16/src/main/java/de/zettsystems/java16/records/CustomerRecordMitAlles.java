package de.zettsystems.java16.records;

public record CustomerRecordMitAlles(String name, boolean vip) implements Cloneable /*extends geht nicht */{

    private static int counter;

    // Überschreiben der "getter" geht
    @Override
    public boolean vip() {
        return vip;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static int getCounter() {
        return counter;
    }
}
