(ns aoc.y2025.day04
  (:require [clojure.string :as str]))

(defn- adjacent-range [n]
  (range (dec n) (+ 2 n)))

(defn- neighboring-slots [[row col :as slot]]
  (for [row' (adjacent-range row)
        col' (adjacent-range col)
        :let [neighbor [row' col']]
        :when (not= slot neighbor)]
    neighbor))

(defn- roll? [contents] (= "@" contents))

(defn- accessible? [shelves slot]
  (->> (neighboring-slots slot)
       (filter #(roll? (get-in shelves %)))
       count
       (> 4)))

(defn- roll-slots [shelves]
  (for [[row shelf] (map-indexed vector shelves)
        [col contents] (map-indexed vector shelf)
        :when (roll? contents)]
    [row col]))

(defn- accessible-slots [shelves]
  (->> (roll-slots shelves)
       (filter (partial accessible? shelves))))

(defn- parse-shelves [n]
  (->> (str/split-lines n)
       (remove str/blank?)
       (mapv #(str/split % #""))))

(defn part-1 [n]
  (-> n
      parse-shelves
      accessible-slots
      count))

(defn- empty-slots [shelves slots]
  (reduce #(assoc-in %1 %2 ".") shelves slots))

(defn- total-removable [shelves]
  (if-let [slots (seq (accessible-slots shelves))]
    (+ (count slots)
       (total-removable (empty-slots shelves slots)))
    0))

(defn part-2 [n]
  (-> n
      parse-shelves
      total-removable))
