(ns aoc.y2021.day01-test
  (:require [aoc.input.y2021.day01 :as input]
            [aoc.util :as util]
            [aoc.y2021.day01 :as sut]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]))

; https://adventofcode.com/2021/day/1

(def input-data (-> input/data
                    str/split-lines
                    util/parse-longs))

(deftest test-increases
  (doseq [[coll expected] [[[] 0]
                           [[10] 0]
                           [[10 10 0] 0]
                           [[10 9 8 7] 0]
                           [[10 11] 1]
                           [[10 11 12] 2]
                           [[10 11 12 11] 2]]]
    (is (= expected (sut/increases coll))))
  (is (= 1288 (sut/increases input-data))))

(deftest test-window-increases
  (doseq [[coll size expected] [[[] 3 0]
                                [[1] 3 0]
                                [[1 2] 3 0]
                                [[1 2 3] 3 0]
                                [[1 2 3 4] 3 1]
                                [[1 2 3 4 5] 3 2]
                                [[1 2 3 4 5 6] 3 3]
                                [[1 2 3 4] 2 2]
                                [[1 2 3 4 5 6] 2 4]
                                [[1 2 3 4 5 4] 2 3]]]
    (is (= expected (sut/window-increases size coll))))
  (is (= 1311 (sut/window-increases 3 input-data))))
