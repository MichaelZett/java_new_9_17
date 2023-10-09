package de.zettsystems.smallapi;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UnmodifiableCollectionCreation {
    /**
     * @deprecated use UnmodifiableCollectionCreation#createImmutableCollectionJava instead
     */
    // Deprecation forRemoval ist neu
    @Deprecated(forRemoval = true, since = "Java 9")
    public Collection<String> createImmutableCollection(String first, String second) {
        return ImmutableList.of(first, second);
    }

    // List.of() ist neu
    public Collection<String> createImmutableCollectionJava(String first, String second) {
        return List.of(first, second);
    }

    public Set<String> getAllEntriesAsSet() {
        final Collection<String> entries = retrieveEntries();
        return Set.copyOf(entries);
    }

    public List<String> getAllEntriesAsListJava10() {
        return retrieveEntries().stream().collect(Collectors.toUnmodifiableList());
    }

    public List<String> getAllEntriesAsListJava16() {
        return retrieveEntries().stream().toList();
    }

    private Collection<String> retrieveEntries() {
        return Arrays.asList("A", "B");
    }
}
