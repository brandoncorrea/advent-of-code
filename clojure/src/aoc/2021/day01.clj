(ns aoc.2021.day01
  (:require [aoc.util :as util]))

(defn increases [nums]
  (->> (partition 2 1 nums)
       (util/count-where util/lt?)))

(defn window-increases [size coll]
  (->> (partition size 1 coll)
       (map util/sum)
       increases))
