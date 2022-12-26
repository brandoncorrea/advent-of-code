(ns aoc.2022.day01-spec
  (:require [aoc.2022.day01 :refer :all]
            [aoc.util :as util]
            [speclj.core :refer :all]))

; https://adventofcode.com/2022/day/1

(def input-data (util/input-data 2022 1))
(def sample-data (util/sample-data 2022 1))

(describe "AoC Day 1"

  (context "Part 1"
    (it "no elves"
      (should= 0 (part-1 "")))

    (it "one elf with no calories"
      (should= 0 (part-1 "0")))

    (it "one elf with one calorie"
      (should= 1 (part-1 "1")))

    (it "one elf with two calories"
      (should= 2 (part-1 "2")))

    (it "two elves with one calorie"
      (should= 1 (part-1 "1\n\n1")))

    (it "two elves with different calories"
      (should= 2 (part-1 "1\n\n2")))

    (it "one elf with two rations"
      (should= 3 (part-1 "1\n2")))

    (it "solves sample data"
      (should= 24000 (part-1 sample-data)))

    (it "solves test data"
      (should= 72511 (part-1 input-data))))

  (context "Part 2"
    (it "no elves"
      (should= 0 (part-2 "")))

    (it "one elf with no calories"
      (should= 0 (part-2 "0")))

    (it "one elf with one calorie"
      (should= 1 (part-2 "1")))

    (it "one elf with two calories"
      (should= 2 (part-2 "1\n1")))

    (it "two elves"
      (should= 3 (part-2 "1\n\n2")))

    (it "three elves"
      (should= 6 (part-2 "1\n\n2\n\n3")))

    (it "four elves"
      (should= 9 (part-2 "1\n\n2\n\n3\n\n4")))

    (it "sample data"
      (should= 45000 (part-2 sample-data)))

    (it "test data"
      (should= 212117 (part-2 input-data)))))
