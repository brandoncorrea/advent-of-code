(ns aoc.util)

(def ->int #(Integer/parseInt %))
(def sum (partial apply +))
(def product (partial apply *))
(def rsort (partial sort-by -))
(defn enumerate [pred coll]
  (reduce #(if (pred %2) (inc %1) %1) 0 coll))
(def lt? (partial apply <))
(defn pow [n e] (apply * (repeat e n)))
