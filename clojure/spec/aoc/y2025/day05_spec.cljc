(ns aoc.y2025.day05-spec
  (:require [aoc.y2025.day05 :as sut]
            [aoc.input.y2025.day05 :as input]
            [aoc.sample.y2025.day05 :as sample]
            [speclj.core #?(:cljs :refer-macros :default :refer) [context describe it should=]]))

; https://adventofcode.com/2025/day/5

(describe "Year 2025 Day 5"

  (context "Part 1"

    (it "no bins and no ingredients"
      (should= 0 (sut/part-1 "")))

    (it "one fresh ingredient"
      (should= 1 (sut/part-1 "1-1\n\n1"))
      (should= 1 (sut/part-1 "2-2\n\n2")))

    (it "one ingredient that is not fresh"
      (should= 0 (sut/part-1 "1-1\n\n2")))

    (it "two ingredients that are fresh"
      (should= 2 (sut/part-1 "1-1\n\n1\n1")))

    (it "two different ingredients that are fresh"
      (should= 2 (sut/part-1 "1-1\n3-3\n\n3\n3")))

    (it "Sample Data"
      (should= 3 (sut/part-1 sample/data)))

    (it "Input Data"
      (should= 756 (sut/part-1 input/data)))
    )

  (context "Part 2"

    (it "no bins and no ingredients"
      (should= 0 (sut/part-2 "")))

    (it "one valid bin"
      (should= 1 (sut/part-2 "1-1"))
      (should= 1 (sut/part-2 "2-2")))

    (it "two valid bins"
      (should= 2 (sut/part-2 "1-2"))
      (should= 2 (sut/part-2 "2-3")))

    (it "two overlapping bins"
      (should= 4 (sut/part-2 "1-3\n2-4"))
      (should= 14 (sut/part-2 "2-10\n5-15")))

    (it "Sample Data"
      (should= 14 (sut/part-2 sample/data)))

    (it "Input Data"
      (should= 355555479253787 (sut/part-2 input/data)))
    )
  )
