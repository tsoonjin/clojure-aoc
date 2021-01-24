(ns aoc.day2.solve
  (:require [clojure.math.combinatorics :as combo])
)
(require '[clojure.string :as string])

(defn validPassword? [line]
  (let [
    [limit alphabet password] (string/split line #" ")
    [minAlpha maxAlpha] (string/split limit #"-")
    [alpha] (subs alphabet 0 1)
    wordMap (frequencies password)
    actualNum (get wordMap alpha)
  ]
  (and actualNum (and (>= actualNum (Integer/parseInt minAlpha)) (<= actualNum (Integer/parseInt maxAlpha))
))))

(defn validPassword2? [line]
  (let [
    [limit alphabet password] (string/split line #" ")
    [minAlpha maxAlpha] (map #(Integer/parseInt %) (string/split limit #"-"))
    alpha (subs alphabet 0 1)
    minWord (str (get password (- minAlpha 1)))
    maxWord (str (get password (- maxAlpha 1)))
    orgate (or (= minWord alpha) (= maxWord alpha))
    nandgate (not (and (= minWord alpha) (= maxWord alpha)))
  ]
    (and orgate nandgate)
)
)


(defn -main [& args]
  (println "AOC Day 2")
  (def input (slurp "./src/aoc/day2/input"))
  (def parsed (string/split-lines input))
  (def answer1 (filter validPassword? parsed))
  (def answer2 (filter validPassword2? parsed))
  ; (def answer1 (filter #(validPassword? %) (string/split-lines input)))
  (println (count answer1))
  (println (count answer2))
 )
