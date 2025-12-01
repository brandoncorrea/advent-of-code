(ns aoc.y2022.day02-spec
  (:require [aoc.y2022.day02 :as sut]
            [aoc.input.y2022.day02 :as input]
            [aoc.sample.y2022.day02 :as sample]
            [speclj.core #?(:cljs :refer-macros :default :refer) [context describe it should=]]))

; https://adventofcode.com/2022/day/2

(describe "Year 2022 Day 2"

  (context "Part 1"
    (it "Solves Part 1"
      (should= 4 (sut/part-1 "A X"))
      (should= 8 (sut/part-1 "A Y"))
      (should= 3 (sut/part-1 "A Z"))
      (should= 1 (sut/part-1 "B X"))
      (should= 5 (sut/part-1 "B Y"))
      (should= 9 (sut/part-1 "B Z"))
      (should= 7 (sut/part-1 "C X"))
      (should= 2 (sut/part-1 "C Y"))
      (should= 6 (sut/part-1 "C Z"))
      (should= 10 (sut/part-1 "C Z\nA X"))
      (should= 15 (sut/part-1 sample/data))
      (should= 12772 (sut/part-1 input/data))))

  (context "Part 2"
    (it "Solves Part 2"
      (should= 3 (sut/part-2 "A X"))
      (should= 4 (sut/part-2 "A Y"))
      (should= 8 (sut/part-2 "A Z"))
      (should= 1 (sut/part-2 "B X"))
      (should= 5 (sut/part-2 "B Y"))
      (should= 9 (sut/part-2 "B Z"))
      (should= 2 (sut/part-2 "C X"))
      (should= 6 (sut/part-2 "C Y"))
      (should= 7 (sut/part-2 "C Z"))
      (should= 10 (sut/part-2 "C Z\nA X"))
      (should= 12 (sut/part-2 sample/data))
      (should= 11618 (sut/part-2 input/data))))
  )
