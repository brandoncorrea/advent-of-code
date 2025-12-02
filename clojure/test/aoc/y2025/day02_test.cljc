(ns aoc.y2025.day02-test
  (:require [aoc.input.y2025.day02 :as input]
            [aoc.sample.y2025.day02 :as sample]
            [aoc.y2025.day02 :as sut]
            [clojure.test :refer [deftest is]]))

(deftest test-part-1
  (is (= 0 (sut/part-1 "")))
  (is (= 11 (sut/part-1 "11-11")))
  (is (= 22 (sut/part-1 "22-22")))
  (is (= 0 (sut/part-1 "12-13")))
  (is (= 0 (sut/part-1 "1698522-1698528")))
  (is (= 0 (sut/part-1 "565653-565659")))
  (is (= 0 (sut/part-1 "824824821-824824827")))
  (is (= 0 (sut/part-1 "2121212118-2121212124")))
  (is (= 11 (sut/part-1 "9-20")))
  (is (= 11 (sut/part-1 "10-20")))
  (is (= 33 (sut/part-1 "11-22")))
  (is (= 33 (sut/part-1 "10-23")))
  (is (= 11 (sut/part-1 "11-11,10-10")))
  (is (= 22 (sut/part-1 "11-11,11-11")))
  (is (= 44 (sut/part-1 "11-11,11-22")))
  (is (= 222222 (sut/part-1 "222220-222224")))
  (is (= 1010 (sut/part-1 "1009-1011")))
  (is (= 2121 (sut/part-1 "2120-2122")))
  (is (= 446446 (sut/part-1 "446443-446449")))
  (is (= 38593859 (sut/part-1 "38593856-38593862")))
  (is (= 1188511885 (sut/part-1 "1188511880-1188511890")))
  (is (= 1227775554 (sut/part-1 sample/data)))
  (is (= 31839939622 (sut/part-1 input/data))))

(deftest test-part-2
  (is (= 33 (sut/part-2 "11-22")))
  (is (= 210 (sut/part-2 "95-115")))
  (is (= 2009 (sut/part-2 "998-1012")))
  (is (= 1188511885 (sut/part-2 "1188511880-1188511890")))
  (is (= 222222 (sut/part-2 "222220-222224")))
  (is (= 446446 (sut/part-2 "446443-446449")))
  (is (= 38593859 (sut/part-2 "38593856-38593862")))
  (is (= 565656 (sut/part-2 "565653-565659")))
  (is (= 824824824 (sut/part-2 "824824821-824824827")))
  (is (= 2121212121 (sut/part-2 "2121212118-2121212124")))
  (is (= 4174379265 (sut/part-2 sample/data)))
  (is (= 41662374059 (sut/part-2 input/data))))
