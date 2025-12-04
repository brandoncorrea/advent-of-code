(ns aoc.y2025.day04-spec
  (:require [aoc.y2025.day04 :as sut]
            [aoc.input.y2025.day04 :as input]
            [aoc.sample.y2025.day04 :as sample]
            [speclj.core #?(:cljs :refer-macros :default :refer) [context describe it should=]]))

; https://adventofcode.com/2025/day/4

(describe "Year 2025 Day 4"

  (context "Part 1"

    (it "no paper"
      (should= 0 (sut/part-1 "")))

    (it "one roll"
      (should= 1 (sut/part-1 "@")))

    (it "two rolls"
      (should= 2 (sut/part-1 "@@")))

    (it "3x3 grid returns the four corners"
      (should= 4 (sut/part-1 "@@@\n@@@\n@@@")))

    (it "3x3 grid center is returned"
      (should= 1 (sut/part-1 "...\n.@.\n...")))

    (it "Sample Data"
      (should= 13 (sut/part-1 sample/data)))

    (it "Input Data"
      (should= 1478 (sut/part-1 input/data)))
    )

  (context "Part 2"

    (it "Sample Data"
      (should= 43 (sut/part-2 sample/data)))

    (it "Input Data"
      (should= 9120 (sut/part-2 input/data)))
    )
  )
