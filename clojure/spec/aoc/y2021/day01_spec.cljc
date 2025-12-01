(ns aoc.y2021.day01-spec
  (:require [aoc.y2021.day01 :as sut]
            [aoc.util :as util]
            [clojure.string :as str]
            [aoc.input.y2021.day01 :as input]
            [speclj.core #?(:cljs :refer-macros :default :refer) [describe it should=]]))

; https://adventofcode.com/2021/day/1

(def input-data (-> input/data
                    str/split-lines
                    util/parse-longs))

(describe "increases"

  (for [[coll expected] [[[] 0]
                         [[10] 0]
                         [[10 10 0] 0]
                         [[10 9 8 7] 0]
                         [[10 11] 1]
                         [[10 11 12] 2]
                         [[10 11 12 11] 2]]]
    (it (str coll " results in " expected " increases")
      (should= expected (sut/increases coll))))

  (it "Tests Advent of Code Increases"
    (should= 1288 (sut/increases input-data)))
  )

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
    (it (str coll " results in " expected " for size " size)
      (should= expected (sut/window-increases size coll))))

  (it "Tests Advent of Code Window Increases"
    (should= 1311 (sut/window-increases 3 input-data)))
  )