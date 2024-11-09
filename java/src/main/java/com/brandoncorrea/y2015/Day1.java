package com.brandoncorrea.y2015;

public class Day1 {

    public static int part1(String input) {
        return sanitize(input).chars().map(Day1::step).sum();
    }

    public static int part2(String input) {
        int floor = 0;
        int position = 1;
        for (char c : sanitize(input).toCharArray()) {
            floor += step(c);
            if (floor == -1) return position;
            position++;
        }
        return -1;
    }

    static String sanitize(String input) {
        return input == null ? "" : input;
    }

    static int step(int direction) {
        if (direction == '(') return 1;
        else if (direction == ')') return -1;
        return 0;
    }
}
