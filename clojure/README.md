# Advent of Code – Clojure

Advent of Code solutions in Clojure.

### New Problem Files

Run the `advent` command with the year and the day.

    # Babashka
    bb advent 2025 1

    # Clojure CLI
    clj -M:advent 2025 1

Files will be created in the src and spec folders under a directory for that year.

### Specs

    # Run specs once
    clj -M:test:spec

    # Run specs automatically
    clj -M:test:spec -a
