(ns aoc.util
  (:require [clojure.string :as str]))

(defn parse-longs [coll] (map parse-long coll))
(defn sum [vals] (apply + vals))
(defn product [vals] (apply * vals))
(defn rsort [coll] (sort-by - coll))
(defn count-where [pred coll]
  (reduce #(cond-> %1 (pred %2) inc) 0 coll))
(defn lt? [vals] (apply < vals))
(defn ->words [s] (str/split s #"\s"))

(defn populated-lines [s]
  (->> (str/split-lines s)
       (remove str/blank?)))

(defn ffilter [pred coll]
  (reduce #(when (pred %2) (reduced %2)) nil coll))

(defn- folder-data [folder year day] (slurp (format "../%s/%d/day_%02d.txt" folder year day)))
(def input-data (partial folder-data "input"))
(def sample-data (partial folder-data "sample"))
