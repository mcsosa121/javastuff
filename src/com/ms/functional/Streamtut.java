package com.ms.functional;

import java.util.Arrays;
import java.util.stream.Stream;

public class Streamtut {
    public static void main(String[] sa) {
        // Streams are useful for processing sequences of elements.
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");

    }
}
