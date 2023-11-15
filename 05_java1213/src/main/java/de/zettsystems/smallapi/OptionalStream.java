package de.zettsystems.smallapi;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalStream {

    public List<String> showWithoutStream(Optional<String> optionalValue) {
        List<String> result = optionalValue.isPresent()
                ? Collections.singletonList(optionalValue.get())
                : Collections.emptyList();
        return result;
    }

    public List<String> showWithStream(Optional<String> optionalValue) {
        List<String> result = optionalValue.stream().toList();
        optionalValue.stream().collect(Collectors.toList());
        return result;
    }
}
