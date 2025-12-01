(ns aoc.y2022.day02-test
  (:require [aoc.input.y2022.day02 :as input]
            [aoc.sample.y2022.day02 :as sample]
            [aoc.y2022.day02 :as sut]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2022/day/2

(deftest test-part-1
  (is (= 4 (sut/part-1 "A X")))
  (is (= 8 (sut/part-1 "A Y")))
  (is (= 3 (sut/part-1 "A Z")))
  (is (= 1 (sut/part-1 "B X")))
  (is (= 5 (sut/part-1 "B Y")))
  (is (= 9 (sut/part-1 "B Z")))
  (is (= 7 (sut/part-1 "C X")))
  (is (= 2 (sut/part-1 "C Y")))
  (is (= 6 (sut/part-1 "C Z")))
  (is (= 10 (sut/part-1 "C Z\nA X")))
  (is (= 15 (sut/part-1 sample/data)))
  (is (= 12772 (sut/part-1 input/data))))

(deftest test-part-2
  (is (= 3 (sut/part-2 "A X")))
  (is (= 4 (sut/part-2 "A Y")))
  (is (= 8 (sut/part-2 "A Z")))
  (is (= 1 (sut/part-2 "B X")))
  (is (= 5 (sut/part-2 "B Y")))
  (is (= 9 (sut/part-2 "B Z")))
  (is (= 2 (sut/part-2 "C X")))
  (is (= 6 (sut/part-2 "C Y")))
  (is (= 7 (sut/part-2 "C Z")))
  (is (= 10 (sut/part-2 "C Z\nA X")))
  (is (= 12 (sut/part-2 sample/data)))
  (is (= 11618 (sut/part-2 input/data))))
