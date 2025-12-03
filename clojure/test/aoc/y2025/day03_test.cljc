(ns aoc.y2025.day03-test
  (:require [aoc.input.y2025.day03 :as input]
            [aoc.sample.y2025.day03 :as sample]
            [aoc.y2025.day03 :as sut]
            [clojure.test :refer [deftest is]]))

(deftest test-part-1
  (is (= 0 (sut/part-1 "")))
  (is (= 11 (sut/part-1 "11")))
  (is (= 22 (sut/part-1 "222")))
  (is (= 23 (sut/part-1 "123")))
  (is (= 32 (sut/part-1 "321")))
  (is (= 98 (sut/part-1 "987654321111111")))
  (is (= 89 (sut/part-1 "811111111111119")))
  (is (= 78 (sut/part-1 "234234234234278")))
  (is (= 92 (sut/part-1 "818181911112111")))
  (is (= 357 (sut/part-1 sample/data)))
  (is (= 17031 (sut/part-1 input/data))))

(deftest test-part-2
  (is (= 3121910778619 (sut/part-2 sample/data)))
  (is (= 168575096286051 (sut/part-2 input/data))))
