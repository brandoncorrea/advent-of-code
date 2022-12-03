(ns aoc.2022.day02
  (:require [aoc.util :as util]
            [clojure.string :as string]))

(def part-1-scoring
  {"A X" 4
   "A Y" 8
   "A Z" 3
   "B X" 1
   "B Y" 5
   "B Z" 9
   "C X" 7
   "C Y" 2
   "C Z" 6})

(def part-2-scoring
  {"A X" 3
   "A Y" 4
   "A Z" 8
   "B X" 1
   "B Y" 5
   "B Z" 9
   "C X" 2
   "C Y" 6
   "C Z" 7})

(defn total-score [scoring n] (->> n string/split-lines (map scoring) util/sum))
(def part-1 (partial total-score part-1-scoring))
(def part-2 (partial total-score part-2-scoring))
