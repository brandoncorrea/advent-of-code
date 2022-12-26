(ns aoc.2022.day02-spec
  (:require [aoc.2022.day02 :refer :all]
            [aoc.util :as util]
            [speclj.core :refer :all]))

; https://adventofcode.com/2022/day/2

(def input-data (util/input-data 2022 2))
(def sample-data (util/sample-data 2022 2))

(describe "Year 2022 Day 2"

  (context "Part 1"
    (it "Solves Part 1"
      (should= 4 (part-1 "A X"))
      (should= 8 (part-1 "A Y"))
      (should= 3 (part-1 "A Z"))
      (should= 1 (part-1 "B X"))
      (should= 5 (part-1 "B Y"))
      (should= 9 (part-1 "B Z"))
      (should= 7 (part-1 "C X"))
      (should= 2 (part-1 "C Y"))
      (should= 6 (part-1 "C Z"))
      (should= 10 (part-1 "C Z\nA X"))
      (should= 15 (part-1 sample-data))
      (should= 12772 (part-1 input-data))))

  (context "Part 2"
    (it "Solves Part 2"
      (should= 3 (part-2 "A X"))
      (should= 4 (part-2 "A Y"))
      (should= 8 (part-2 "A Z"))
      (should= 1 (part-2 "B X"))
      (should= 5 (part-2 "B Y"))
      (should= 9 (part-2 "B Z"))
      (should= 2 (part-2 "C X"))
      (should= 6 (part-2 "C Y"))
      (should= 7 (part-2 "C Z"))
      (should= 10 (part-2 "C Z\nA X"))
      (should= 12 (part-2 sample-data))
      (should= 11618 (part-2 input-data))))
  )
