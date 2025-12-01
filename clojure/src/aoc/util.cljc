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

(defn char-code [c]
  #?(:clj  (int c)
     :cljs (.charCodeAt c 0)))

(defn populated-lines [s]
  (->> (str/split-lines s)
       (remove str/blank?)))

(defn ffilter [pred coll]
  (reduce #(when (pred %2) (reduced %2)) nil coll))

#?(:clj
   (defn render-template [template mapping]
     (reduce
       (fn [src [key value]] (str/replace src (format "!%s!" key) (str value)))
       template
       (seq mapping))))