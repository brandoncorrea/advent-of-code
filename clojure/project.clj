(defproject aoc "1.0.0-SNAPSHOT"
  :description "Solutions to https://adventofcode.com"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[speclj "3.3.2"]]}}
  :plugins [[speclj "3.3.2"]]
  :test-paths ["spec/"]
  :aliases {"aoc" ["run" "-m" "aoc.generator"]})
