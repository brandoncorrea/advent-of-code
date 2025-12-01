(ns aoc.y2022.day01-spec
  (:require [aoc.y2022.day01 :as sut]
            [aoc.input.y2022.day01 :as input]
            [aoc.sample.y2022.day01 :as sample]
            [speclj.core #?(:clj :refer :cljs :refer-macros) [context describe it should=]]))

; https://adventofcode.com/2022/day/1

(describe "AoC Day 1"

  (context "Part 1"
    (it "no elves"
      (should= 0 (sut/part-1 "")))

    (it "one elf with no calories"
      (should= 0 (sut/part-1 "0")))

    (it "one elf with one calorie"
      (should= 1 (sut/part-1 "1")))

    (it "one elf with two calories"
      (should= 2 (sut/part-1 "2")))

    (it "two elves with one calorie"
      (should= 1 (sut/part-1 "1\n\n1")))

    (it "two elves with different calories"
      (should= 2 (sut/part-1 "1\n\n2")))

    (it "one elf with two rations"
      (should= 3 (sut/part-1 "1\n2")))

    (it "solves sample data"
      (should= 24000 (sut/part-1 sample/data)))

    (it "solves test data"
      (should= 72511 (sut/part-1 input/data))))

  (context "Part 2"
    (it "no elves"
      (should= 0 (sut/part-2 "")))

    (it "one elf with no calories"
      (should= 0 (sut/part-2 "0")))

    (it "one elf with one calorie"
      (should= 1 (sut/part-2 "1")))

    (it "one elf with two calories"
      (should= 2 (sut/part-2 "1\n1")))

    (it "two elves"
      (should= 3 (sut/part-2 "1\n\n2")))

    (it "three elves"
      (should= 6 (sut/part-2 "1\n\n2\n\n3")))

    (it "four elves"
      (should= 9 (sut/part-2 "1\n\n2\n\n3\n\n4")))

    (it "sample data"
      (should= 45000 (sut/part-2 sample/data)))

    (it "test data"
      (should= 212117 (sut/part-2 input/data)))))
