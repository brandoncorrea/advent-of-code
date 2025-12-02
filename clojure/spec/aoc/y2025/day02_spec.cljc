(ns aoc.y2025.day02-spec
  (:require [aoc.y2025.day02 :as sut]
            [aoc.input.y2025.day02 :as input]
            [aoc.sample.y2025.day02 :as sample]
            [speclj.core #?(:cljs :refer-macros :default :refer) [context describe it should=]]))

; https://adventofcode.com/2025/day/2

(describe "Year 2025 Day 2"

  (context "Part 1"

    (it "no ids"
      (should= 0 (sut/part-1 "")))

    (it "sequence of one id, which is invalid"
      (should= 11 (sut/part-1 "11-11"))
      (should= 22 (sut/part-1 "22-22")))

    (it "sequence of all valid ids"
      (should= 0 (sut/part-1 "12-13"))
      (should= 0 (sut/part-1 "1698522-1698528"))
      (should= 0 (sut/part-1 "565653-565659"))
      (should= 0 (sut/part-1 "824824821-824824827"))
      (should= 0 (sut/part-1 "2121212118-2121212124")))

    (it "sequence of ids where one is invalid"
      (should= 11 (sut/part-1 "9-20"))
      (should= 11 (sut/part-1 "10-20")))

    (it "sequence of ids where two are invalid"
      (should= 33 (sut/part-1 "11-22"))
      (should= 33 (sut/part-1 "10-23")))

    (it "multiple sets of ids where only one is invalid"
      (should= 11 (sut/part-1 "11-11,10-10")))

    (it "multiple sets of ids where both contain invalid ids"
      (should= 22 (sut/part-1 "11-11,11-11"))
      (should= 44 (sut/part-1 "11-11,11-22")))

    (it "single number repeats many times"
      (should= 222222 (sut/part-1 "222220-222224")))

    (it "id repeats digits twice"
      (should= 1010 (sut/part-1 "1009-1011"))
      (should= 2121 (sut/part-1 "2120-2122")))

    (it "id repeats digits three times"
      (should= 446446 (sut/part-1 "446443-446449")))

    (it "id repeats four times"
      (should= 38593859 (sut/part-1 "38593856-38593862")))

    (it "id repeats five times"
      (should= 1188511885 (sut/part-1 "1188511880-1188511890")))

    (it "Sample Data"
      (should= 1227775554 (sut/part-1 sample/data)))

    (it "Input Data"
      (should= 31839939622 (sut/part-1 input/data)))
    )

  (context "Part 2"

    (it "two invalid ids"
      (should= 33 (sut/part-2 "11-22"))
      (should= 210 (sut/part-2 "95-115"))
      (should= 2009 (sut/part-2 "998-1012")))

    (it "repeats five digits twice"
      (should= 1188511885 (sut/part-2 "1188511880-1188511890")))

    (it "repeats the same digit six times"
      (should= 222222 (sut/part-2 "222220-222224")))

    (it "repeats three digits twice"
      (should= 446446 (sut/part-2 "446443-446449")))

    (it "repeats four digits twice"
      (should= 38593859 (sut/part-2 "38593856-38593862")))

    (it "repeats two digits three times"
      (should= 565656 (sut/part-2 "565653-565659")))

    (it "repeats three digits three times"
      (should= 824824824 (sut/part-2 "824824821-824824827")))

    (it "repeats two digits five times"
      (should= 2121212121 (sut/part-2 "2121212118-2121212124")))

    (it "Sample Data"
      (should= 4174379265 (sut/part-2 sample/data)))

    (it "Input Data"
      (should= 41662374059 (sut/part-2 input/data)))
    )
  )
