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
            assertEquals(0, Day2.part1(""));
        }

        @Test
        public void blankGift() {
            assertEquals(0, Day2.part1("   "));
        }

        @Test
        public void unitSquare() {
            assertEquals(7, Day2.part1("1x1x1"));
        }

        @Test
        public void sideOfZero() {
            assertEquals(2, Day2.part1("1x0x1"));
        }

        @Test
        public void doublySizedUnitSquare() {
            assertEquals(28, Day2.part1("2x2x2"));
        }

        @Test
        public void twoGifts() {
            assertEquals(35, Day2.part1("1x1x1\n2x2x2"));
        }

        @Test
        public void usesSmallestSideForSlack() {
            assertEquals(24, Day2.part1("1x2x3"));
            assertEquals(24, Day2.part1("2x3x1"));
            assertEquals(24, Day2.part1("3x1x2"));
        }

        @Test
        public void puzzleInput() throws IOException {
            var input = TestHelper.puzzleInput(2015, 2);
            assertEquals(1588178, Day2.part1(input));
        }
    }
}
