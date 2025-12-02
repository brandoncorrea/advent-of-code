(ns aoc.advent
  (:require [aoc.util :as util]
            [clojure.java.io :as io]))

(def spec-template
"(ns aoc.y!Y!.day!DS!-spec
  (:require [aoc.y!Y!.day!DS! :as sut]
            [aoc.input.y!Y!.day!DS! :as input]
            [aoc.sample.y!Y!.day!DS! :as sample]
            [speclj.core #?(:cljs :refer-macros :default :refer) [context describe it should=]]))

; https://adventofcode.com/!Y!/day/!D!

(describe \"Year !Y! Day !D!\"

  (context \"Part 1\"
    (it \"Solves Part 1\"
      (should= 1 (sut/part-1 1)))

    #_(it \"Sample Data\"
      (should= 1 (sut/part-1 sample/data)))

    #_(it \"Input Data\"
      (should= 1 (sut/part-1 input/data)))
    )

  #_(context \"Part 2\"
    (it \"Solves Part 2\"
      (should= 1 (sut/part-2 1)))

    #_(it \"Sample Data\"
      (should= 1 (sut/part-2 sample/data)))

    #_(it \"Input Data\"
      (should= 1 (sut/part-2 input/data)))
    )
  )
")

(def src-template
"(ns aoc.y!Y!.day!DS!)

(defn part-1 [n]
  )

#_(defn part-2 [n]
  )
")

(defn write-template [path template mapping]
  (let [{:strs [Y DS]} mapping
        file    (format path Y DS)
        content (util/render-template template mapping)]
    (io/make-parents file)
    (println "writing to" file)
    (spit file content)))

(defn -main [year day]
  (let [day     (parse-long day)
        mapping {"D"  day
                 "DS" (format "%02d" day)
                 "Y"  (parse-long year)}]
    (write-template "spec/aoc/y%d/day%s_spec.cljc" spec-template mapping)
    (write-template "src/aoc/y%d/day%s.cljc" src-template mapping)))
