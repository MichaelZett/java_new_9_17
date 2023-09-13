package de.zettsystems.uebung913_loesung;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SomeClass {
    public static void main(String[] args) {
        final List<String> aList = Arrays.asList("a", "b", "c", "   ", "a", "z", "a", "e", "b");
        final Optional<String> result = retrieveMaxOccurance(aList);
        System.out.println("Am häufigsten kommt vor: " + result.orElseThrow());

        String[] anArray = convertToArray(aList);
        Arrays.stream(anArray).forEach(System.out::println);

        aList.stream().filter(Objects::nonNull).filter(Predicate.not(String::isBlank)).forEach(System.out::println);
    }

    private static boolean isNotBlank(String string) {
        return string != null && !string.trim().isEmpty();
    }

    public List<String> createAnUnmodifiableList() {
        return List.of("OneString", "TwoString");
    }

    public Set<String> createAnUnmodifiableSet() {
        return Set.of("OneString", "TwoString");
    }

    public Map<String, String> createAnUnmodifiableMap() {
        return Map.of("Key", "Value");
    }

    public static Optional<String> retrieveMaxOccurance(List<String> strings) {
        var freqMap = strings.stream()
                .collect(groupingBy(s -> s, counting()));
        var maxEntryOpt = freqMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        return maxEntryOpt.map(Map.Entry::getKey);
    }

    public static String[] convertToArray(List<String> sampleList) {
        return sampleList.toArray(String[]::new);
    }

}
