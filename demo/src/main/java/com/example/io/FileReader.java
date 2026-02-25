package com.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    public List<String> readLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            lines = stream
                    .filter(line -> !line.trim().isEmpty())
                    .collect(Collectors.toList());
        }
        return lines;
    }
}