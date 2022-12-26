(ns aoc.advent
  (:import (java.io File FileOutputStream)
           (java.text DecimalFormat))
  (:require [clojure.string :as str]))

(def spec-template
"(ns aoc.!Y!.day!DS!-spec
  (:require [aoc.!Y!.day!DS! :refer :all]
            [aoc.util :as util]
            [speclj.core :refer :all]))

; https://adventofcode.com/!Y!/day/!D!

(def input-data (util/input-data !Y! !D!))
(def sample-data (util/sample-data !Y! !D!))

(describe \"Year !Y! Day !D!\"

  (context \"Part 1\"
    (it \"Solves Part 1\"
      (should= 1 (part-1 1)))

    #_(it \"Sample Data\"
      (should= 1 (part-1 sample-data)))

    #_(it \"Input Data\"
      (should= 1 (part-1 input-data)))
    )

  #_(context \"Part 2\"
    (it \"Solves Part 2\"
      (should= 1 (part-2 1)))

    #_(it \"Sample Data\"
      (should= 1 (part-1 sample-data)))

    #_(it \"Input Data\"
      (should= 1 (part-1 input-data)))
    )
  )
")

(def src-template
"(ns aoc.!Y!.day!DS!)

(defn part-1 [n]
  )

#_(defn part-2 [n]
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
