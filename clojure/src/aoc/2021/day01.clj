(ns aoc.2021.day01
  (:require [aoc.util :as util]))

(defn increases [nums]
  (util/enumerate util/lt? (partition 2 1 nums)))
(defn window-increases [size coll]
  (increases (map util/sum (partition size 1 coll))))
