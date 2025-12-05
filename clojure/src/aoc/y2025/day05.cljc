(ns aoc.y2025.day05
  (:require [aoc.util :as util]
            [clojure.set :as set]
            [clojure.string :as str]))

(defn- in-bin? [[start end] ingredient]
  (<= start ingredient end))

(defn- bins-overlap? [[start-1 :as bin-1] [start-2 :as bin-2]]
  (or (in-bin? bin-1 start-2)
      (in-bin? bin-2 start-1)))

(defn- bin-size [[start end]]
  (- (inc end) start))

(defn- join-bins [bins]
  [(util/min-by first bins)
   (util/max-by second bins)])

(defn- overlapping-bins [bin bins]
  (->> bins
       (filter #(bins-overlap? bin %))
       set))

(defn- conj-bin [bins bin]
  (let [overlapping (overlapping-bins bin bins)]
    (conj (set/difference bins overlapping)
          (join-bins (conj overlapping bin)))))

(defn- bin-range [bin]
  (util/parse-longs (str/split bin #"-")))

(defn- bin-ranges [bins]
  (->> bins
       util/populated-lines
       (map bin-range)
       (reduce conj-bin #{})))

(defn- fresh? [bins ingredient]
  (some #(in-bin? % ingredient) bins))

(defn- ingredients [stock]
  (-> stock util/populated-lines util/parse-longs))

(defn- split-database [database]
  (str/split database #"\n\n" 2))

(defn part-1 [database]
  (let [[bins stock] (split-database database)
        bins (bin-ranges bins)]
    (->> stock
         ingredients
         (util/count-where #(fresh? bins %)))))

(defn part-2 [database]
  (->> database
       split-database
       first
       bin-ranges
       (util/sum-by bin-size)))
