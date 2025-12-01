(ns aoc.y2025.day01-spec
  (:require [aoc.y2025.day01 :as sut]
            [aoc.input.y2025.day01 :as input]
            [aoc.sample.y2025.day01 :as sample]
            [speclj.core #?(:cljs :refer-macros :default :refer) [describe context it should=]]))

; https://adventofcode.com/2025/day/1

(describe "Year 2025 Day 1"

  (context "Part 1"

    (it "no rotations"
      (should= 0 (sut/part-1 "\n\n")))

    (it "one rotation to the left and back to the right"
      (should= 0 (sut/part-1 "L1\nR1")))

    (it "one rotation 50 to the left"
      (should= 1 (sut/part-1 "L50")))

    (it "one rotation 50 to the right"
      (should= 1 (sut/part-1 "R50")))

    (it "three rotations 50 to the right"
      (should= 2 (sut/part-1 "R50\nR50\nR50")))

    (it "Sample Data"
      (should= 3 (sut/part-1 sample/data)))

    (it "Input Data"
      (should= 1129 (sut/part-1 input/data)))
    )

  (context "Part 2"

    (it "no rotations"
      (should= 0 (sut/part-2 "\n\n")))

    (it "one rotation to the left and back to the right"
      (should= 0 (sut/part-2 "L1\nR1")))

    (it "one rotation to the left lands on 0"
      (should= 1 (sut/part-2 "L50")))

    (it "rotates 0 times from 0 to 0"
      (should= 1 (sut/part-2 "L50\nL0\nR0")))

    (it "one rotation to the right lands on 0"
      (should= 1 (sut/part-2 "R50")))

    (it "one rotation to the left passes 0"
      (should= 1 (sut/part-2 "L51")))

    (it "one rotation to the right passes 0"
      (should= 1 (sut/part-2 "R51")))

    (it "one rotation to the right passes 0 twice"
      (should= 2 (sut/part-2 "R151")))

    (it "Sample Data"
      (should= 6 (sut/part-2 sample/data)))

    (it "Input Data"
      (should= 6638 (sut/part-2 input/data)))
    )
  )
