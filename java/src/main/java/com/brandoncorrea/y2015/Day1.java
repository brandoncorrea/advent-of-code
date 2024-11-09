package com.brandoncorrea.y2015;

public class Day1 {

    public static int part1(String input) {
        if (input == null) return 0;
        return input.chars().map(Day1::step).sum();
    }

    static int step(int direction) {
        if (direction == '(') return 1;
        else if (direction == ')') return -1;
        return 0;
    }
}
