(ns aoc.2021.day01-spec
  (:require [aoc.2021.day01 :refer :all]
            [aoc.util :as util]
            [clojure.string :as string]
            [speclj.core :refer :all]))

; https://adventofcode.com/2021/day/2

(def input-data (-> (util/input-data 2021 1)
                    string/split-lines
                    util/parse-longs))

(describe "increases"
  (for [[coll expected] [[[] 0]
                         [[10] 0]
                         [[10 10 0] 0]
                         [[10 9 8 7] 0]
                         [[10 11] 1]
                         [[10 11 12] 2]
                         [[10 11 12 11] 2]]]
    (it (format "%s results in %d increases" coll expected)
      (should= expected (increases coll))))
  (it "Tests Advent of Code Increases"
    (should= 1288 (increases input-data))))

(describe "window-increases"
  (for [[coll size expected] [[[] 3 0]
                              [[1] 3 0]
                              [[1 2] 3 0]
                              [[1 2 3] 3 0]
                              [[1 2 3 4] 3 1]
                              [[1 2 3 4 5] 3 2]
                              [[1 2 3 4 5 6] 3 3]
                              [[1 2 3 4] 2 2]
                              [[1 2 3 4 5 6] 2 4]
                              [[1 2 3 4 5 4] 2 3]]]
    (it (format "%s results in %d for size %d" coll expected size)
      (should= expected (window-increases size coll))))
  (it "Tests Advent of Code Window Increases"
    (should= 1311 (window-increases 3 input-data))))