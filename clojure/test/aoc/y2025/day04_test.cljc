(ns aoc.y2025.day04-test
  (:require [aoc.input.y2025.day04 :as input]
            [aoc.sample.y2025.day04 :as sample]
            [aoc.y2025.day04 :as sut]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2025/day/4

(deftest test-part-1
  (is (= 0 (sut/part-1 "")))
  (is (= 1 (sut/part-1 "@")))
  (is (= 2 (sut/part-1 "@@")))
  (is (= 4 (sut/part-1 "@@@\n@@@\n@@@")))
  (is (= 1 (sut/part-1 "...\n.@.\n...")))
  (is (= 13 (sut/part-1 sample/data)))
  (is (= 1478 (sut/part-1 input/data))))

(deftest test-part-2
  (is (= 43 (sut/part-2 sample/data)))
  (is (= 9120 (sut/part-2 input/data))))
