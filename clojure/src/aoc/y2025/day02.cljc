(ns aoc.y2025.day02
  (:require [clojure.string :as str]))

(defn- repeat-up-to [digits size repetitions]
  (->> (take (quot size repetitions) digits)
       (repeat repetitions)
       (apply concat)))

(defn- divisible-by? [num div]
  (zero? (rem num div)))

(defn- invalid? [repeat-twice? n]
  (let [digits      (seq (str n))
        size        (count digits)
        repetitions (if repeat-twice? 2 size)]
    (->> (range 2 (inc repetitions))
         (filter (partial divisible-by? size))
         (map (partial repeat-up-to digits size))
         (some (partial = digits)))))

(defn- invalid-ids-in-range [repeat-twice? [start end]]
  (->> (range (max 11 start) (inc end))
       (filter (partial invalid? repeat-twice?))))

(defn- create-bounds [id-range]
  (->> (str/split (str/trim id-range) #"-")
       (map parse-long)))

(defn- sum-invalid-ids [repeat-twice? n]
  (->> (str/split n #",")
       (remove str/blank?)
       (map create-bounds)
       (mapcat (partial invalid-ids-in-range repeat-twice?))
       (reduce +)))

(defn part-1 [n] (sum-invalid-ids true n))
(defn part-2 [n] (sum-invalid-ids false n))
