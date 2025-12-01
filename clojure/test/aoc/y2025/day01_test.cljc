(ns aoc.y2025.day01-test
  (:require [aoc.input.y2025.day01 :as input]
            [aoc.sample.y2025.day01 :as sample]
            [aoc.y2025.day01 :as sut]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2025/day/1

(deftest test-part-1
  (is (zero? (sut/part-1 "\n\n")))
  (is (zero? (sut/part-1 "L1\nR1")))
  (is (= 1 (sut/part-1 "L50")))
  (is (= 1 (sut/part-1 "R50")))
  (is (= 2 (sut/part-1 "R50\nR50\nR50")))
  (is (= 3 (sut/part-1 sample/data)))
  (is (= 1129 (sut/part-1 input/data))))

(deftest test-part-2
  (is (zero? (sut/part-2 "\n\n")))
  (is (zero? (sut/part-2 "L1\nR1")))
  (is (= 1 (sut/part-2 "L50")))
  (is (= 1 (sut/part-2 "R50")))
  (is (= 1 (sut/part-2 "L51")))
  (is (= 1 (sut/part-2 "R51")))
  (is (= 2 (sut/part-2 "R151")))
  (is (= 6 (sut/part-2 sample/data)))
  (is (= 6638 (sut/part-2 input/data))))
