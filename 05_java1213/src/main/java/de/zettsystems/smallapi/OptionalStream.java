package de.zettsystems.smallapi;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalStream {

    public List<String> showWithoutStream(Optional<String> optionalValue) {
        List<String> result = optionalValue.isPresent()
                ? Collections.singletonList(optionalValue.get())
                : Collections.emptyList();
        return result;
    }

    public List<String> showWithStream(Optional<String> optionalValue) {
        List<String> result = optionalValue.stream().toList();
        return result;
    }
}
