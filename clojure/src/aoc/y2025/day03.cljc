(ns aoc.y2025.day03
  (:require [clojure.math :as math]
            [clojure.string :as str]))

(defn- greater-rating [greatest next-rating]
  (if (> (second next-rating) (second greatest))
    next-rating
    greatest))

(defn- greatest-rating-within-limit [switches batteries]
  (->> (drop-last (dec switches) batteries)
       (map-indexed vector)
       (reduce greater-rating)))

(defn- max-joltage [switches ratings]
  (if (zero? switches)
    0
    (let [[max-idx max-value] (greatest-rating-within-limit switches ratings)
          multiplier        (long (math/pow 10 (dec switches)))
          joltage           (* multiplier max-value)
          remaining-joltage (->> (drop (inc max-idx) ratings)
                                 (max-joltage (dec switches)))]
      (+ joltage remaining-joltage))))

(defn- bank->joltage-ratings [bank]
  (map (comp parse-long str) bank))

(defn- output-joltage [switches banks]
  (->> (str/split-lines banks)
       (remove str/blank?)
       (map bank->joltage-ratings)
       (map (partial max-joltage switches))
       (apply +)))

(defn part-1 [banks]
  (output-joltage 2 banks))

(defn part-2 [banks]
  (output-joltage 12 banks))
