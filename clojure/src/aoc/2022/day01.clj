(ns aoc.2022.day01
  (:require [clojure.string :as string]
            [aoc.util :as util]))

(def split-elves #(string/split % #"\n\n"))

(def rations->calories (comp util/sum util/->ints string/split-lines))

(defn elves->calories [elves]
  (->> elves split-elves (map rations->calories)))

(defn top-calories [n elves]
  (if (empty? elves)
    0
    (->> elves elves->calories util/rsort (take n) util/sum)))

(def part-1 (partial top-calories 1))
(def part-2 (partial top-calories 3))
