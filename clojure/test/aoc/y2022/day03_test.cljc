(ns aoc.y2022.day03-test
  (:require [aoc.input.y2022.day03 :as input]
            [aoc.sample.y2022.day03 :as sample]
            [aoc.y2022.day03 :as sut]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2022/day/3

(deftest test-part-1
  (is (= 1 (sut/part-1 "aa")))
  (is (= 27 (sut/part-1 "AA")))
  (is (= 2 (sut/part-1 "bb")))
  (is (= 2 (sut/part-1 "XbYb")))
  (is (= 2 (sut/part-1 "bXbY")))
  (is (= 16 (sut/part-1 "vJrwpWtwJgWrhcsFMMfFFhFp")))
  (is (= 38 (sut/part-1 "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")))
  (is (= 54 (sut/part-1 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")))
  (is (= 8243 (sut/part-1 input/data))))

(deftest test-part-2
  (is (= 1 (sut/part-2 "aa")))
  (is (= 27 (sut/part-2 "AA")))
  (is (= 2 (sut/part-2 "bb")))
  (is (= 2 (sut/part-2 "ab\nbc")))
  (is (= 18 (sut/part-2 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg")))
  (is (= 52 (sut/part-2 "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw")))
  (is (= 70 (sut/part-2 sample/data)))
  (is (= 2631 (sut/part-2 input/data))))