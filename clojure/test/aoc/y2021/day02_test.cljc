(ns aoc.y2021.day02-test
  (:require [aoc.input.y2021.day02 :as input]
            [aoc.sample.y2021.day02 :as sample]
            [aoc.util :as util]
            [aoc.y2021.day02 :as sut]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2021/day/2

(defn parsed-input [data]
  (->> data
       str/split-lines
       (map util/->words)
       (mapcat (juxt (comp keyword first) (comp parse-long second)))))

(def input-data (parsed-input input/data))
(def sample-data (parsed-input sample/data))

(deftest test-part-1
  (is (zero? (sut/day-2-p1 [])))
  (is (zero? (sut/day-2-p1 [:forward 1 :forward 2 :forward 10000])))
  (is (zero? (sut/day-2-p1 [:up 1 :up 6 :down 2 :down 1 :up 3 :down 2 :up 50])))
  (is (= 10 (sut/day-2-p1 [:down 2 :forward 5])))
  (is (= 40 (sut/day-2-p1 [:down 1 :down 3 :forward 4 :forward 6])))
  (is (= 21 (sut/day-2-p1 [:down 4 :up 3 :down 20 :forward 1])))
  (is (= 150 (sut/day-2-p1 sample-data)))
  (is (= 1938402 (sut/day-2-p1 input-data))))

(deftest test-part-2
  (is (zero? (sut/day-2-p2 [])))
  (is (zero? (sut/day-2-p2 [:forward 1 :forward 2 :forward 10000])))
  (is (zero? (sut/day-2-p2 [:up 1 :up 6 :down 2 :down 1 :up 3 :down 2 :up 50])))
  (is (= 108 (sut/day-2-p2 [:down 3 :forward 6])))
  (is (= 900 (sut/day-2-p2 sample-data)))
  (is (= 1947878632 (sut/day-2-p2 input-data))))
