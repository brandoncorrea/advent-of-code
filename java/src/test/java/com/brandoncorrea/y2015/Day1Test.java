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

    @Nested
    class Part2 {

        @Test
        public void emptyInputIsNegative() {
            assertBasementAt(-1, null);
            assertBasementAt(-1, "");
        }

        @Test
        public void firstMoveGoesUnderground() {
            assertBasementAt(1, ")");
        }

        @Test
        public void neverGoesUnderground() {
            assertBasementAt(-1, "(");
            assertBasementAt(-1, "()((");
        }

        @Test
        public void allMovesGoDown() {
            assertBasementAt(1, ")))");
        }

        @Test
        public void entersBasementOnThirdStep() {
            assertBasementAt(3, "())");
        }

        @Test
        public void entersBasementOnFifthStep() {
            assertBasementAt(5, "()())");
        }

        @Test
        public void puzzleInput() throws Exception {
            String input = TestHelper.puzzleInput(2015, 1);
            assertBasementAt(1783, input);
        }

        void assertBasementAt(int step, String input) {
            assertEquals(step, Day1.part2(input));
        }
    }
}
