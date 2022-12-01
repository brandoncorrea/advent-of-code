(ns aoc.util.math-spec
  (:require [speclj.core :refer :all]
            [aoc.util.math :refer :all]))

(describe "pow"
  (it "1^1 = 1" (should= 1 (pow 1 1)))
  (it "1^2 = 1" (should= 1 (pow 1 2)))
  (it "2^1 = 2" (should= 2 (pow 2 1)))
  (it "2^6 = 64" (should= 64 (pow 2 6))))