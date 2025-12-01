(ns aoc.2022.day03
  (:require [aoc.util :as util]
            [clojure.string :as string]))

(defn includes? [v coll] (some (partial = v) coll))

(defn char-priority [c]
  (let [ascii (int c)]
    (- ascii (if (>= ascii 97) 96 38))))

(defn find-common-char [[compartment & compartments]]
  (util/ffilter #(every? (partial includes? %) compartments) compartment))

(def priority (comp char-priority find-common-char))
(defn ->compartment [rucksack] (split-at (/ (count rucksack) 2) rucksack))

(defn priority-total [partition-fn rucksacks]
  (->> rucksacks
       string/split-lines
       partition-fn
       (transduce (map priority) +)))

(def partition-rucksack (partial map ->compartment))
(def partition-threes (partial partition-all 3))
(def part-1 (partial priority-total partition-rucksack))
(def part-2 (partial priority-total partition-threes))
