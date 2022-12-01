(ns aoc.2021.day02
  (:require [aoc.util.math :refer [product]]))

(defn- navigate-move [[d h a] [type v]]
  (cond (= :down type) [d h (+ a v)]
        (= :up type) [d h (- a v)]
        :else [(+ d (* a v)) (+ h v) a]))

(defn navigate [moves]
  (reduce navigate-move [0 0 0] (partition 2 moves)))

(defn course-product [section moves]
  (-> moves navigate section product))
(def day-2-p1 (partial course-product rest))
(def day-2-p2 (partial course-product drop-last))
