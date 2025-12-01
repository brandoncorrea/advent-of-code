(ns aoc.y2022.day03
  (:require [aoc.util :as util]
            [clojure.string :as str]))

(defn includes? [v coll] (some (partial = v) coll))

(defn char-priority [c]
  (let [ascii (util/char-code c)]
    (- ascii (if (>= ascii 97) 96 38))))

(defn find-common-char [[compartment & compartments]]
  (util/ffilter #(every? (partial includes? %) compartments) compartment))

(defn priority [v] (-> v find-common-char char-priority))
(defn ->compartment [rucksack] (split-at (/ (count rucksack) 2) rucksack))

(defn priority-total [partition-fn rucksacks]
  (->> rucksacks
       str/split-lines
       (remove str/blank?)
       partition-fn
       (transduce (map priority) +)))

(defn partition-rucksack [s] (map ->compartment s))
(defn partition-threes [s] (partition-all 3 s))
(defn part-1 [s] (priority-total partition-rucksack s))
(defn part-2 [s] (priority-total partition-threes s))
