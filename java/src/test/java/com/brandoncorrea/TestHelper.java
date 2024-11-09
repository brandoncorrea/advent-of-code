package com.brandoncorrea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestHelper {

    public static String puzzleInput(int year, int day) throws IOException {
        String path = String.format("../input/%d/day_%02d.txt", year, day);
        return Files.readString(Path.of(path));
    }

}
