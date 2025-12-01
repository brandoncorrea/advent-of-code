(ns aoc.2022.day01
  (:require [aoc.util :as util]
            [clojure.string :as str]))

(defn rations->calories [elf]
  (-> elf
      str/split-lines
      util/->ints
      util/sum))

(defn elves->calories [elves]
  (->> (str/split elves #"\n\n")
       (map rations->calories)))

(defn top-calories [n elves]
  (if (empty? elves)
    0
    (->> elves
         elves->calories
         util/rsort
         (take n)
         util/sum)))

(def part-1 (partial top-calories 1))
(def part-2 (partial top-calories 3))
