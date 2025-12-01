# Advent of Code – Clojure

Advent of Code solutions in Clojure (JVM, Babashka, CLJS, CLJD, CLJR).

## Loading Input Data

    # Copy input data into Clojure vars
    bb sync-inputs

## New Problem Files

Run the `advent` command with the year and the day.

    # Babashka
    bb advent 2025 1

    # Clojure CLI
    clj -M:advent 2025 1

Files will be created in the src and spec folders under a directory for that year.

## Testing

    # Run all tests
    bb test-all

### speclj

    # Run specs once
    clj -M:test:spec

    # Run specs automatically
    clj -M:test:spec -a

    # Run ClojureScript specs once
    clj -M:test:cljs once

    # Run ClojureScript specs automatically
    clj -M:test:cljs

    # Run Babashka specs
    bb spec

    # Run Clojure CLR specs once
    cljr -M:test:spec

    # Run Clojure CLR specs automatically
    cljr -M:test:spec -a

### clojure.test

    # Run Clojure Tests
    clj -M:test-clj

    # Run ClojureScript Tests
    clj -M:test-cljs

    # Run Babashka Tests
    bb test

    # Run ClojureDart Tests
    clj -M:test-cljd

    # Run Clojure CLR tests
    cljr -M:test-cljr
