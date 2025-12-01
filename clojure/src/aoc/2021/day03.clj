(ns aoc.2021.day03
  (:require [clojure.math :as math]
            [clojure.string :as s]))

(defn- binary-seq [s] (map (comp parse-long str) (reverse s)))
(defn- add-binary-position [[sum exp] n]
  [(+ sum (* n (int (math/pow 2 exp))))
   (inc exp)])

(defn binary->int [s]
  (first (reduce add-binary-position [0 0] (binary-seq s))))

(defn split [n] (s/split n #""))

(defn nth-frequencies [coll n]
  (frequencies (map #(nth (split %) n) coll)))

(defn gt? [counts k1 k2]
  (> (get counts k1 0)
     (get counts k2 0)))

(defn most-common [coll n]
  (if (gt? (nth-frequencies coll n) "0" "1")
    0 1))

(defn least-common [coll n]
  (if (gt? (nth-frequencies coll n) "0" "1")
    1 0))

(def n-range (comp range count first))
(defn- binary-string [f coll]
  (apply str (map (partial f coll) (n-range coll))))

(def gamma-rate (comp binary->int (partial binary-string most-common)))
(def epsilon-rate (comp binary->int (partial binary-string least-common)))

(defn power-consumption [n]
  (* (gamma-rate n)
     (epsilon-rate n)))

(defn remove-uncommon-n [coll n]
  (filter #(= (nth % 0) (str (most-common coll 0)))
          (map split coll))
  )

(defn oxygen-rating [nums]
  (reduce (fn [coll n]
            (let [common-n (most-common coll n)]
              (filter #(= common-n (nth % n)) coll)))
          (map split nums)
          (n-range nums))
  )