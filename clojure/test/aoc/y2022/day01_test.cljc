(ns aoc.y2022.day01-test
  (:require [aoc.input.y2022.day01 :as input]
            [aoc.sample.y2022.day01 :as sample]
            [aoc.y2022.day01 :as sut]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2022/day/1

(deftest test-part-1
  (is (zero? (sut/part-1 "")))
  (is (zero? (sut/part-1 "0")))
  (is (= 1 (sut/part-1 "1")))
  (is (= 2 (sut/part-1 "2")))
  (is (= 1 (sut/part-1 "1\n\n1")))
  (is (= 2 (sut/part-1 "1\n\n2")))
  (is (= 3 (sut/part-1 "1\n2")))
  (is (= 24000 (sut/part-1 sample/data)))
  (is (= 72511 (sut/part-1 input/data))))

(deftest test-part-2
  (is (zero? (sut/part-2 "")))
  (is (zero? (sut/part-2 "0")))
  (is (= 1 (sut/part-2 "1")))
  (is (= 2 (sut/part-2 "1\n1")))
  (is (= 3 (sut/part-2 "1\n\n2")))
  (is (= 6 (sut/part-2 "1\n\n2\n\n3")))
  (is (= 9 (sut/part-2 "1\n\n2\n\n3\n\n4")))
  (is (= 45000 (sut/part-2 sample/data)))
  (is (= 212117 (sut/part-2 input/data))))