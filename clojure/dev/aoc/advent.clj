(ns aoc.advent
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

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

(defn write-template [path template mapping]
  (let [{:strs [Y DS]} mapping
        file    (format path Y DS)
        content (render template mapping)]
    (io/make-parents file)
    (println "writing to" file)
    (spit file content)))

(defn -main [year day]
  (let [day     (parse-long day)
        mapping {"D"  day
                 "DS" (format "%02d" day)
                 "Y"  (parse-long year)}]
    (write-template "spec/aoc/%d/day%s_spec.clj" spec-template mapping)
    (write-template "src/aoc/%d/day%s.clj" src-template mapping)))
