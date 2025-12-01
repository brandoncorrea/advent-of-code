(ns aoc.sync-inputs
  (:require [aoc.util :as util]
            [clojure.java.io :as io]))

(def template
"(ns aoc.!KIND!.y!YEAR!.day!DAY!)

(def data
  \"!DATA!\"
  )
")

(defn sync-content-file [kind year target-dir content-file]
  (let [day     (->> (.getName content-file)
                     (re-find #"\d+")
                     parse-long
                     (format "%02d"))
        file    (str target-dir "/day" day ".cljc")
        content (util/render-template
                  template
                  {"KIND" kind
                   "YEAR" year
                   "DAY"  day
                   "DATA" (slurp content-file)})]
    (spit file content)))

(defn sync-year-dir [kind year-dir]
  (let [year       (.getName year-dir)
        target-dir (str "resources/aoc/" kind "/y" year)]
    (io/make-parents target-dir ".")
    (doseq [content-file (.listFiles year-dir)
            :when (.isFile content-file)]
      (sync-content-file kind year target-dir content-file))))

(defn sync-kind [kind]
  (doseq [year-dir (.listFiles (io/file (str "../" kind)))
          :when (.isDirectory year-dir)]
    (sync-year-dir kind year-dir)))

(defn -main []
  (sync-kind "input")
  (sync-kind "sample"))
