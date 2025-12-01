(ns aoc.y2022.day03-spec
  (:require [aoc.y2022.day03 :as sut]
            [aoc.input.y2022.day03 :as input]
            [aoc.sample.y2022.day03 :as sample]
            [speclj.core #?(:clj :refer :cljs :refer-macros) [context describe it should=]]))

; https://adventofcode.com/2022/day/3

(describe "Year 2022 Day 3"

  (context "Part 1"
    (it "Solves Part 1"
      (should= 1 (sut/part-1 "aa"))
      (should= 27 (sut/part-1 "AA"))
      (should= 2 (sut/part-1 "bb"))
      (should= 2 (sut/part-1 "XbYb"))
      (should= 2 (sut/part-1 "bXbY"))
      (should= 16 (sut/part-1 "vJrwpWtwJgWrhcsFMMfFFhFp"))
      (should= 38 (sut/part-1 "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))
      (should= 54 (sut/part-1 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))
      (should= 8243 (sut/part-1 input/data))))

  (context "Part 2"
    (it "Solves Part 2"
      (should= 1 (sut/part-2 "aa"))
      (should= 27 (sut/part-2 "AA"))
      (should= 2 (sut/part-2 "bb"))
      (should= 2 (sut/part-2 "ab\nbc"))
      (should= 18 (sut/part-2 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg"))
      (should= 52 (sut/part-2 "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw"))
      (should= 70 (sut/part-2 sample/data))
      (should= 2631 (sut/part-2 input/data))))
  )
