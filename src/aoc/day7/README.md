# Lessons learned

- Trigger specific script with lein with `lein run -m aoc.day1.solve`
- `for` loop is by default lazy evaluated; to show side-effect wrap it in `dorun`
- using require ensure the `'` is used to not evaluate the statement
- `use 'namespace` = require + refer that exposes all functions in namespace
- can also wrap everything in `ns`
    ```
    (ns test
        (:require [clojure.string :as string] [second.lib :as lib])
    )
    ```
- test
