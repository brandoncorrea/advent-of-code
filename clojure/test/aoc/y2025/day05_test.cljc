(ns aoc.y2025.day05-test
  (:require [aoc.input.y2025.day05 :as input]
            [aoc.sample.y2025.day05 :as sample]
            [aoc.y2025.day05 :as sut]
            [clojure.test :refer [deftest is]]))

(deftest test-part-1
  (is (= 0 (sut/part-1 "")))
  (is (= 1 (sut/part-1 "1-1\n\n1")))
  (is (= 1 (sut/part-1 "2-2\n\n2")))
  (is (= 0 (sut/part-1 "1-1\n\n2")))
  (is (= 2 (sut/part-1 "1-1\n\n1\n1")))
  (is (= 2 (sut/part-1 "1-1\n3-3\n\n3\n3")))
  (is (= 3 (sut/part-1 sample/data)))
  (is (= 756 (sut/part-1 input/data))))

(deftest test-part-2
  (is (= 0 (sut/part-2 "")))
  (is (= 1 (sut/part-2 "1-1")))
  (is (= 1 (sut/part-2 "2-2")))
  (is (= 2 (sut/part-2 "1-2")))
  (is (= 2 (sut/part-2 "2-3")))
  (is (= 4 (sut/part-2 "1-3\n2-4"))))
