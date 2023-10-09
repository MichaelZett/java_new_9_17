package de.zettsystems.var;


import jakarta.validation.constraints.NotNull;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LocalTypeInference {

    public static void main(String[] args) {

        // ORIGINAL
        List<Customer> x = executeQuery("query");
        // GOOD
        var customerList = executeQuery("query");

        // ORIGINAL
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // GOOD
        var outputStream = new ByteArrayOutputStream();

    }

    public Optional<String> parameterizedWithUglyTypes() {
        List<String> strings = List.of("a", "b", "c");
        Map<String, Long> freqMap = strings.stream()
                .collect(groupingBy(s -> s, counting()));
        Optional<Map.Entry<String, Long>> maxEntryOpt = freqMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        return maxEntryOpt.map(Map.Entry::getKey);
    }

    public Optional<String> parameterizedWithVarTypes() {
        List<String> strings = List.of("a", "b", "c");
        var freqMap = strings.stream()
                .collect(groupingBy(s -> s, counting()));
        var maxEntryOpt = freqMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        return maxEntryOpt.map(Map.Entry::getKey);
    }

    public void lambdaVar() {
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList.stream()
                .map(String::toUpperCase)
                .map((@NotNull var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println("Strings are equal: " + resultString.equals("JAVA, KOTLIN"));
    }

    private static List<Customer> executeQuery(String query) {
        return query.equals("query") ? List.of(new Customer()) : Collections.emptyList();
    }

}
