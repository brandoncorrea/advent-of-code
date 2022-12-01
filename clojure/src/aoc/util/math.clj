(ns aoc.util.math)

(def sum (partial apply +))
(def product (partial apply *))
(defn pow [n e] (apply * (repeat e n)))
