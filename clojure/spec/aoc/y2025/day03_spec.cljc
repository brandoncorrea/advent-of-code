(ns aoc.y2025.day03-spec
  (:require [aoc.y2025.day03 :as sut]
            [aoc.input.y2025.day03 :as input]
            [aoc.sample.y2025.day03 :as sample]
            [speclj.core #?(:cljs :refer-macros :default :refer) [context describe it should=]]))

; https://adventofcode.com/2025/day/3

(describe "Year 2025 Day 3"

  (context "Part 1"

    (it "no banks"
      (should= 0 (sut/part-1 "")))

    (it "has two batteries"
      (should= 11 (sut/part-1 "11")))

    (it "has three batteries of the same joltage"
      (should= 22 (sut/part-1 "222")))

    (it "batteries in ascending order"
      (should= 23 (sut/part-1 "123")))

    (it "batteries in descending order"
      (should= 32 (sut/part-1 "321")))

    (it "Sample Data"
      (should= 98 (sut/part-1 "987654321111111"))
      (should= 89 (sut/part-1 "811111111111119"))
      (should= 78 (sut/part-1 "234234234234278"))
      (should= 92 (sut/part-1 "818181911112111"))
      (should= 357 (sut/part-1 sample/data)))

    (it "Input Data"
      (should= 17031 (sut/part-1 input/data)))
    )

  (context "Part 2"

    (it "Sample Data"
      (should= 3121910778619 (sut/part-2 sample/data)))

    (it "Input Data"
      (should= 168575096286051 (sut/part-2 input/data)))
    )
  )
