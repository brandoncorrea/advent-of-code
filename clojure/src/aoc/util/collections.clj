(ns aoc.util.collections)

(defn enumerate [pred coll]
  (count (filter pred coll)))
