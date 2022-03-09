(ns aoc.day7.solve
  (:require [clojure.string :as string] [clojure.set :as set])
)

(defn read-input [input]
  (-> input
      slurp
      (string/split #"\n")
))

(defn parse-single-bag [bag]
  (first (re-seq #"(\d+) (.*)\ bags" bag))
)

(defn parse-bag-rule [bag]
  (let [
    [[_ main-bag components]] (re-seq #"(.*)\ contain\ (.*)" bag)
    [[_ key-bag]] (re-seq #"(.*)\ bags" main-bag)
    subComponents (string/split components #",")
  ]
    (println subComponents)
  )
)

(defn -main [& args]
  (println "AOC Day 7")
  (def input (read-input "./src/aoc/day7/input"))
  (doseq [bag input] (parse-bag-rule bag))
)
