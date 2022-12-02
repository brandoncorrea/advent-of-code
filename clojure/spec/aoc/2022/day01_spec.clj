(ns aoc.2022.day01-spec
  (:require [speclj.core :refer :all]
            [aoc.2022.day01 :refer :all]))

; https://adventofcode.com/2022/day/1

(def base-case "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000")
(def input-data (slurp "../input/2022/day_01.txt"))

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

    (it "base case"
      (should= 24000 (part-1 base-case)))

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

    (it "base case"
      (should= 45000 (part-2 base-case)))

    (it "test data"
      (should= 212117 (part-2 input-data)))))
