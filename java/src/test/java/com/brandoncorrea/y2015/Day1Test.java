package com.brandoncorrea.y2015;

import com.brandoncorrea.TestHelper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    @Nested
    class Part1 {

        @Test
        public void emptyInput() {
            assertFloorEquals(0, null);
            assertFloorEquals(0, "");
        }

        @Test
        public void unknownCharactersGoNowhere() {
            assertFloorEquals(0, "abc \t123");
        }

        @Test
        public void upOneFloor() {
            assertFloorEquals(1, "(");
        }

        @Test
        public void downOneFloor() {
            assertFloorEquals(-1, ")");
        }

        @Test
        public void upTwoFloors() {
            assertFloorEquals(2, "((");
        }

        @Test
        public void downThreeFloors() {
            assertFloorEquals(-3, ")))");
        }

        @Test
        public void sampleInput() {
            assertFloorEquals(0, "(())");
            assertFloorEquals(0, "()()");
            assertFloorEquals(3, "(((");
            assertFloorEquals(3, "(()(()(");
            assertFloorEquals(-1, "())");
            assertFloorEquals(-1, "))(");
            assertFloorEquals(-3, ")))");
            assertFloorEquals(-3, ")())())");
        }

        @Test
        public void puzzleInput() throws Exception {
            String input = TestHelper.puzzleInput(2015, 1);
            assertFloorEquals(232, input);
        }

        void assertFloorEquals(int expected, String input) {
            assertEquals(expected, Day1.part1(input));
        }
    }
}
