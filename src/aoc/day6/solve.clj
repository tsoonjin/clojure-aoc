(ns aoc.day6.solve
  (:require [clojure.string :as string] [clojure.set :as set])
)

(defn read-input [input]
  (-> input
      slurp
      (string/split #"\n\n")
))

(defn get-questions-answered [input]
  (count (reduce #(into %1 (re-seq #"\w" %2)) #{} (string/split-lines input)))
)

(defn get-questions-all-yes [input]
  (let [members (string/split-lines input)]
    (count (filter (fn [[key val]] (= val (count members))) (frequencies (reduce #(into %1 (re-seq #"\w" %2)) () members)
  ))
  )
))

(defn -main [& args]
  (println "AOC Day 6")
  (def input (read-input "./src/aoc/day6/input"))
  (def questionsAnswered (apply + (map get-questions-answered input)))
  (println questionsAnswered)
  (def questionsAnsweredAll (apply + (map get-questions-all-yes input)))
  (println questionsAnsweredAll)
)
