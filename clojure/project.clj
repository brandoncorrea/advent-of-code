(defproject aoc "1.0.0-SNAPSHOT"
  :description "Solutions to https://adventofcode.com"
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :profiles {:dev {:dependencies [[speclj "3.4.1"]]}}
  :plugins [[speclj "3.4.1"]]
  :test-paths ["spec/"]
  :aliases {"advent" ["run" "-m" "aoc.generator"]})
