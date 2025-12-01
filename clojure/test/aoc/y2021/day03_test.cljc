(ns aoc.y2021.day03-test
  (:require [aoc.input.y2021.day03 :as input]
            [aoc.sample.y2021.day03 :as sample]
            [aoc.y2021.day03 :as sut]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2021/day/3

(def diagnostic (str/split-lines input/data))
(def example (str/split-lines sample/data))


(deftest test-most-common
  (is (zero? (sut/most-common ["00100"] 0)))
  (is (= 1 (sut/most-common ["11011" "10111"] 0)))
  (is (= 1 (sut/most-common ["00100" "11011" "10111"] 0)))
  (is (zero? (sut/most-common ["00100" "11011" "10111"] 1)))
  (is (= 1 (sut/most-common ["10110" "01111"] 0))))

(deftest test-least-common
  (is (= 1 (sut/least-common ["00100"] 0)))
  (is (zero? (sut/least-common ["00101" "00111"] 2)))
  (is (= 1 (sut/least-common ["00100" "10101" "00010"] 3)))
  (is (zero? (sut/least-common ["10110" "01111"] 0))))

(deftest test-gamma-rate
  (is (= 109 (sut/gamma-rate ["1101101"])))
  (is (= 83 (sut/gamma-rate ["1101011" "1010011" "0010101"])))
  (is (= 22 (sut/gamma-rate example))))

(deftest test-epsilon-rate
  (is (= 18 (sut/epsilon-rate ["1101101"])))
  (is (= 44 (sut/epsilon-rate ["1101011" "1010011" "0010101"])))
  (is (= 9 (sut/epsilon-rate example))))

(deftest test-power-consumption
  (is (= 198 (sut/power-consumption example)))
  (is (= 4006064 (sut/power-consumption diagnostic))))

(deftest test-binary->int
  (is (zero? (sut/binary->int "0")))
  (is (= 1 (sut/binary->int "1")))
  (is (= 2 (sut/binary->int "10")))
  (is (= 109 (sut/binary->int "1101101"))))
