(ns aoc.util-spec
  (:require [aoc.util :refer :all]
            [speclj.core :refer :all]))

(describe "Util"
  (it "pow"
    (should= 1 (pow 1 1))
    (should= 1 (pow 1 2))
    (should= 2 (pow 2 1))
    (should= 64 (pow 2 6)))
  )