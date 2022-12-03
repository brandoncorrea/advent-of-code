(ns aoc.2022.day03-spec
  (:require [aoc.2022.day03 :refer :all]
            [aoc.util :as util]
            [speclj.core :refer :all]))

; https://adventofcode.com/2022/day/3

(def input-data (util/input-data 2022 3))

(describe "Year 2022 Day 3"

  (context "Part 1"
    (it "Solves Part 1"
      (should= 1 (part-1 "aa"))
      (should= 27 (part-1 "AA"))
      (should= 2 (part-1 "bb"))
      (should= 2 (part-1 "XbYb"))
      (should= 2 (part-1 "bXbY"))
      (should= 16 (part-1 "vJrwpWtwJgWrhcsFMMfFFhFp"))
      (should= 38 (part-1 "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))
      (should= 54 (part-1 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))
      (should= 8243 (part-1 input-data))))

  (context "Part 2"
    (it "Solves Part 2"
      (should= 1 (part-2 "aa"))
      (should= 27 (part-2 "AA"))
      (should= 2 (part-2 "bb"))
      (should= 2 (part-2 "ab\nbc"))
      (should= 18 (part-2 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg"))
      (should= 52 (part-2 "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw"))
      (should= 70 (part-2 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg\nwMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw"))
      (should= 2631 (part-2 input-data))))
  )
