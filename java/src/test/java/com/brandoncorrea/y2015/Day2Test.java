package com.brandoncorrea.y2015;

import com.brandoncorrea.TestHelper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

    @Nested
    class Part1 {

        @Test
        public void noGifts() {
            assertDimensions(0, "");
        }

        @Test
        public void nullGifts() {
            assertDimensions(0, null);
        }

        @Test
        public void blankGift() {
            assertDimensions(0, "   ");
        }

        @Test
        public void unitSquare() {
            assertDimensions(7, "1x1x1");
        }

        @Test
        public void sideOfZero() {
            assertDimensions(2, "1x0x1");
        }

        @Test
        public void doublySizedUnitSquare() {
            assertDimensions(28, "2x2x2");
        }

        @Test
        public void twoGifts() {
            assertDimensions(35, "1x1x1\n2x2x2");
        }

        @Test
        public void usesSmallestSideForSlack() {
            assertDimensions(24, "1x2x3");
            assertDimensions(24, "2x3x1");
            assertDimensions(24, "3x1x2");
        }

        @Test
        public void puzzleInput() throws IOException {
            var input = TestHelper.puzzleInput(2015, 2);
            assertDimensions(1588178, input);
        }

        void assertDimensions(int squareFeet, String input) {
            assertEquals(squareFeet, Day2.part1(input));
        }
    }
}
