(ns aoc.y2021.day03-spec
  (:require [aoc.y2021.day03 :as sut]
            [aoc.input.y2021.day03 :as input]
            [aoc.sample.y2021.day03 :as sample]
            [clojure.string :as string]
            [speclj.core #?(:cljs :refer-macros :default :refer) [context describe focus-it it should=]]))

; https://adventofcode.com/2021/day/3

(def diagnostic (string/split-lines input/data))
(def example (string/split-lines sample/data))

(describe "AoC Day 3"

  (context "most-common"
    (it "Results in most common value for single-item collection"
      (should= 0 (sut/most-common ["00100"] 0)))
    (it "Results in most common value for two item collection"
      (should= 1 (sut/most-common ["11011" "10111"] 0)))
    (it "Results in most common value for three items"
      (should= 1 (sut/most-common ["00100" "11011" "10111"] 0)))
    (it "Results in most common value for second index"
      (should= 0 (sut/most-common ["00100" "11011" "10111"] 1)))
    (it "Results in 1 if 1 and 0 are equally common"
      (should= 1 (sut/most-common ["10110" "01111"] 0))))

  (context "least-common"
    (it "Results in least common value for single-item collection"
      (should= 1 (sut/least-common ["00100"] 0)))
    (it "Results in least common value for two item collection"
      (should= 0 (sut/least-common ["00101" "00111"] 2)))
    (it "Results in least common value for three values at third index"
      (should= 1 (sut/least-common ["00100" "10101" "00010"] 3)))
    (it "Results in 0 if 1 and 0 are equally common"
      (should= 0 (sut/least-common ["10110" "01111"] 0))))

  (context "gamma-rate"
    (it "Results in first number for single-item collection"
      (should= 109 (sut/gamma-rate ["1101101"])))
    (it "Results in the result of sequence of most common values in collections"
      (should= 83 (sut/gamma-rate ["1101011" "1010011" "0010101"])))
    (it "Results in gamma rate of example data"
      (should= 22 (sut/gamma-rate example))))

  (context "epsilon-rate"
    (it "Results in first number for single-item collection"
      (should= 18 (sut/epsilon-rate ["1101101"])))
    (it "Results in results of sequence of least common values in collection"
      (should= 44 (sut/epsilon-rate ["1101011" "1010011" "0010101"])))
    (it "Results in epsilon rate of example data"
      (should= 9 (sut/epsilon-rate example))))

  (context "power-consumption"
    (it "Multiplies gamma rate by epsilon rate"
      (should= 198 (sut/power-consumption example))
      (should= 4006064 (sut/power-consumption diagnostic))))

  #_(context "remove-uncommon-n"
      (it "Results in the collection of items containing the most common n"
        (should= [] (remove-uncommon-n [] 0))
        (should= ["01001" "01101"] (remove-uncommon-n ["01001" "01101" "10111"] 0))))

  (context "binary->int"
    (it "Converts 0 to integer"
      (should= 0 (sut/binary->int "0")))
    (it "Converts 1 to integer"
      (should= 1 (sut/binary->int "1")))
    (it "Converts 10 to 2"
      (should= 2 (sut/binary->int "10")))
    (it "Converts 1101101 to 109"
      (should= 109 (sut/binary->int "1101101"))))

  ;(describe "oxygen-rating"
  ;  (it "as"
  ;    (should= 1 (oxygen-rating ["1101101"]))))
  )

; 095ce4ad-c9c8-44d4-bef1-2c58b2127ce5