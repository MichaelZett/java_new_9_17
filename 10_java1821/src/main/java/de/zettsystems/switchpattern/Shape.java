package de.zettsystems.switchpattern;

import java.awt.*;

public sealed interface Shape {
}

record Circle(Point middle) implements Shape {

}
record Rectangle(Point lowerLeft, Point upperRight) implements Shape {

}
