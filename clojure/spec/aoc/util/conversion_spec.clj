(ns aoc.util.conversion-spec
  (:require [speclj.core :refer :all]
            [aoc.util.conversion :refer :all]))

(describe "binary->int"
  (it "Converts 0 to integer"
    (should= 0 (binary->int "0")))
  (it "Converts 1 to integer"
    (should= 1 (binary->int "1")))
  (it "Converts 10 to 2"
    (should= 2 (binary->int"10")))
  (it "Converts 1101101 to 109"
    (should= 109 (binary->int "1101101"))))