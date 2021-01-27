(ns aoc.day3.solve
  (:require [clojure.math.combinatorics :as combo])
)
(require '[clojure.string :as string])


(defn calculateSlope [input slopeX slopeY]
  (let [
    x (atom 0)
    y (atom 0)
    tree (atom 0)
    multiplier (* (int(Math/ceil (/ (count input) (count (input 0))))) slopeY)
    forestMap (vec (map #(vec(flatten (repeat multiplier (string/split % #"")))) input))

    ]
    (while (< @x (count forestMap))
      (do
        (swap! x + slopeX)
        (swap! y + slopeY)
        (let [obj (get-in forestMap [@x @y])]
          (if (= obj "#") (swap! tree inc))
        )
      )
    )
    @tree
  )
)

(defn -main [& args]
  (println "AOC Day 3")
  (def x (atom 0))
  (def y (atom 0))
  (def tree (atom 0))
  (def input (string/split-lines (slurp "./src/aoc/day3/input")))
  (def multiplier (* (int(Math/ceil (/ (count input) (count (input 0))))) 3))
  (def forestMap (vec (map #(vec(flatten (repeat multiplier (string/split % #"")))) input)))
  (while (< @x (count forestMap))
    (do
      (swap! x + 1)
      (swap! y + 3)
      (let [obj (get-in forestMap [@x @y])]
        (if (= obj "#") (swap! tree inc))
      )
    )
  )
  (println @tree)
  (def answer2 (apply * (map #(calculateSlope input (first %) (second %)) [[1 1] [1 3] [1 5] [1 7] [2 1]])))
  (println answer2)
)
