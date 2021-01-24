(ns aoc.day1.solve
  (:require [clojure.math.combinatorics :as combo])
)
(require '[clojure.string :as string])

(defn strToNum
  [xs]
  "Convert vector of string to vector of int"
  (map #(Integer/parseInt %) xs)
)

(defn -main [& args]
  (println "AOC Day 1")
  (def input (slurp "input1.txt"))
  (def inputIntegers (strToNum (string/split-lines input)))
  (def answer1 (first (flatten (map #(* (first %) (last %)) (filter #(= (+ (first %) (last %)) 2020) (combo/combinations inputIntegers 2))))))
  (println answer1)
  (def answer2 (first (flatten (map #(apply * %) (filter #(= (apply + %) 2020) (combo/combinations inputIntegers 3))))))
  (println answer2)
)
