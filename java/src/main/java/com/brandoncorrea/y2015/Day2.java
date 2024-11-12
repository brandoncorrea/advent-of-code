package com.brandoncorrea.y2015;

import java.util.Arrays;

import static java.lang.Integer.min;


public class Day2 {

    public static int part1(String input) {
        return Arrays
                .stream(input.split("\n"))
                .filter(item -> !item.isBlank())
                .mapToInt(Day2::giftPaper).sum();
    }

    public static int giftPaper(String gift) {
        var dimensions = Arrays.stream(gift.split("x"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        var length = dimensions[0] * dimensions[1];
        var depth = dimensions[1] * dimensions[2];
        var height = dimensions[2] * dimensions[0];
        var smallestSide = min(min(length, depth), height);
        return (2 * (length + depth + height)) + smallestSide;
    }
}
