(ns aoc.util.conversion
  (:require [aoc.util.math :as m]))

(defn ->int [c] (Integer. (str c)))

(defn- binary-seq [s] (map ->int (reverse (char-array s))))
(defn- add-binary-position [[sum exp] n]
  [(+ sum (* n (m/pow 2 exp)))
   (inc exp)])
(defn binary->int [s]
  (first (reduce add-binary-position [0 0] (binary-seq s))))