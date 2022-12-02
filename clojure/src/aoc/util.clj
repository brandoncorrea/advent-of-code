(ns aoc.util
  (:require [clojure.string :as string]))

(def ->int #(Integer/parseInt %))
(def ->ints (partial map ->int))
(def sum (partial apply +))
(def product (partial apply *))
(def rsort (partial sort-by -))
(defn enumerate [pred coll]
  (reduce #(if (pred %2) (inc %1) %1) 0 coll))
(def lt? (partial apply <))
(defn pow [n e] (apply * (repeat e n)))
(defn ->words [s] (string/split s #"\s"))
(def slurp-lines (comp string/split-lines slurp))