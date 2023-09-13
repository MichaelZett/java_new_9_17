package de.zettsystems.smallapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewMethods {
    public static void main(String[] args) throws IOException {
        stringMethods();
        fileMethods();
        teeing();
        numberFormat();
        collectionToArray();
        not();
    }

    /**
     * indent, transform, isBlank, lines, strip, stripLeading, stripTrailing, and repeat
     */
    public static void stringMethods() {
        System.out.println("**************_String_**************");
        String multilineString = "First part \n \n second \n third.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .toList();
        final List<String> expected = List.of("First part", "second", "third.");
        System.out.println("Lists are equal: " + (lines.equals(expected)));
        System.out.println("Repeat".repeat(3));
        System.out.print("Start    -");
        System.out.print("    Strip    ".stripLeading());
        System.out.print("-Middle-");
        System.out.print("    Strip    ".stripTrailing());
        System.out.println("-End");

        String text = "Hello World!\nDas hier ist Java 12.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);

        String transformed = text.transform(value ->
                new StringBuilder(value).reverse().toString()
        );
        System.out.println(transformed);
    }

    /**
     * mismatch, Files.writeString, Files.readString
     */
    public static void fileMethods() throws IOException {
        System.out.println("**************_File_**************");
        Path filePath = Files.writeString(Files.createTempFile(Paths.get("target"), "test", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        System.out.println("Strings are equal: " + (fileContent.equals("Sample text")));

        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12");
        Files.writeString(filePath2, "Java 12");

        long mismatch = Files.mismatch(filePath1, filePath2);
        System.out.println("Files sind gleich: " + (mismatch == -1L));

        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12");
        Files.writeString(filePath4, "Java 13");

        mismatch = Files.mismatch(filePath3, filePath4);
        System.out.println("Files sind unterschiedlich an Position: " + mismatch);
    }

    public static void collectionToArray() {
        System.out.println("**************_Collections_**************");
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);
        System.out.println("Arrays are equal: " + (Arrays.equals(sampleArray, new String[]{"Java", "Kotlin"})));
    }

    public static void not() {
        System.out.println("**************_Predicate_**************");
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .toList();
        System.out.println("Lists are equal: " + (withoutBlanks.equals(List.of("Java", "Kotlin"))));
    }

    /**
     * 2 downstream collectoren und eine merge-Funktion
     */
    public static void teeing() {
        System.out.println("**************_Collectors_**************");
        double mean = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));
        System.out.println("Mittelwert ist: " + mean);
    }

    public static void numberFormat() {
        System.out.println("**************_Number Format_**************");
        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("de", "DE"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println("Short Format: " + likesShort.format(1887));

        NumberFormat likesLong =
                NumberFormat.getCompactNumberInstance(new Locale("de", "DE"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        System.out.println("Long Format: " + likesLong.format(1887));
    }

}
