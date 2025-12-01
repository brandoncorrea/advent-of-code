(ns aoc.2021.day02-spec
  (:require [aoc.2021.day02 :refer :all]
            [aoc.util :as util]
            [clojure.string :as string]
            [speclj.core :refer :all]))

; https://adventofcode.com/2021/day/2

(defn parsed-input [input-data-fn]
  (->> (input-data-fn 2021 2)
       string/split-lines
       (map util/->words)
       (mapcat (juxt (comp keyword first) (comp parse-long second)))))

(def input-data (parsed-input util/input-data))
(def sample-data (parsed-input util/sample-data))

(describe "AoC Day 2 Part 1"
  (it "No moves results in 0"
    (should= 0 (day-2-p1 [])))
  (it "Only forward moves results in 0"
    (should= 0 (day-2-p1 [:forward 1 :forward 2 :forward 10000])))
  (it "Only up or down moves results in 0"
    (should= 0 (day-2-p1 [:up 1 :up 6 :down 2 :down 1 :up 3 :down 2 :up 50])))
  (it "Down and forward result in their product"
    (should= 10 (day-2-p1 [:down 2 :forward 5])))
  (it "Down 2 and Forward 2 results in the product of the sums of each"
    (should= 40 (day-2-p1 [:down 1 :down 3 :forward 4 :forward 6])))
  (it "Ups are taken as negatives"
    (should= 21 (day-2-p1 [:down 4 :up 3 :down 20 :forward 1])))
  (it "Solves AoC Example"
    (should= 150 (day-2-p1 sample-data)))
  (it "Solves AoC Test Data"
    (should= 1938402 (day-2-p1 input-data))))

(describe "AoC Day 2 Part 2"
  (it "No moves results in 0"
    (should= 0 (day-2-p2 [])))
  (it "Only forward moves results in 0"
    (should= 0 (day-2-p2 [:forward 1 :forward 2 :forward 10000])))
  (it "Only up or down moves results in 0"
    (should= 0 (day-2-p2 [:up 1 :up 6 :down 2 :down 1 :up 3 :down 2 :up 50])))
  (it "Down and Forward results in down times forward squared"
    (should= 108 (day-2-p2 [:down 3 :forward 6])))
  (it "Solves AoC Example"
    (should= 900 (day-2-p2 sample-data)))
  (it "Solves AoC Test Data"
    (should= 1947878632 (day-2-p2 input-data))))
