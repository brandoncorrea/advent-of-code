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

(defn- folder-data [folder year day] (slurp (format "../%s/%d/day_%02d.txt" folder year day)))
(def input-data (partial folder-data "input"))
(def sample-data (partial folder-data "sample"))
