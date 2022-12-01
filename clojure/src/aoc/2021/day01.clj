(ns aoc.2021.day01
  (:require [aoc.util.math :refer [sum]]
            [aoc.util.logic :refer [lt?]]
            [aoc.util.collections :refer [enumerate]]))

(defn increases [nums]
  (enumerate lt? (partition 2 1 nums)))
(defn window-increases [size coll]
  (increases (map sum (partition size 1 coll))))
