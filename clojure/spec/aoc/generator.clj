(ns aoc.generator
  (:import (java.io File FileOutputStream)
           (java.text DecimalFormat))
  (:require [clojure.string :as str]))

(def spec-template
"(ns aoc.!Y!.day!DS!-spec
  (:require [speclj.core :refer :all]
            [aoc.!Y!.day!DS! :refer :all]))

; https://adventofcode.com/!Y!/day/!D!

(describe \"AoC Day !D!\"

  (it \"Solves Day !D!\"
    (should= -1 (day-!D! -1)))
  )
")

(def src-template
"(ns aoc.!Y!.day!DS!)

(defn day-!D! [n]
  )
")

(defn render [src mapping]
  (reduce
    (fn [src [key value]] (str/replace src (format "!%s!" key) (str value)))
    src
    (seq mapping)))

(defn write-file [path content]
  (.mkdirs (.getParentFile (File. path)))
  (let [output (FileOutputStream. path)
        bytes (.getBytes content)]
    (println "writing" (count bytes) "bytes to" path)
    (.write output (.getBytes content))
    (.close output)))

(defn -main [year day]
  (let [year (Integer/parseInt year)
        day (Integer/parseInt day)
        day-str (.format (DecimalFormat. "00") day)
        spec-content (render spec-template {"D" day "DS" day-str "Y" year})
        spec-file (format "spec/aoc/%d/day%s_spec.clj" year day-str)
        src-content (render src-template {"D" day "DS" day-str "Y" year})
        src-file (format "src/aoc/%d/day%s.clj" year day-str)]
    (write-file spec-file spec-content)
    (write-file src-file src-content)))
