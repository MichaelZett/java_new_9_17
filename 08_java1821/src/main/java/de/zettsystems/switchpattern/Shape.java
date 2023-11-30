package de.zettsystems.switchpattern;

import java.awt.*;

/**
 * Da Circle und Rectangle in der gleichen Datei stehen (Compilation Unit), kann ich auf
 * permits Circle, Rectangle verzichten.
 */
public sealed interface Shape  {
}

record Circle(Point middle) implements Shape {

}
record Rectangle(Point lowerLeft, Point upperRight) implements Shape {

}
