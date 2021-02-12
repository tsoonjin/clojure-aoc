(ns aoc.day5.solve
  (:require [clojure.string :as string] [clojure.set :as set])
)

(defn locate-binary [start end input lowSymbol highSymbol]
  (loop [
    i start
    j end
    k input
  ]
    (cond
      (empty? (rest k)) (if (= lowSymbol (first k)) i j)
      (= lowSymbol (first k)) (recur i (/ (- (+ i j) 1) 2) (rest k))
      (= highSymbol (first k)) (recur (+ (/ (- (+ i j) 1) 2) 1) j (rest k))
    )
  )
)

(defn read-input [input]
  (-> input
      slurp
      (string/split #"\n")
))
(defn get-row [input]
  (locate-binary 0 127 input \F \B)
)

(defn get-col [input]
  (locate-binary 0 7 input \L \R)
)

(defn get-seatid [input]
  (+ (* 8 (get-row (subs input 0 7))) (get-col (subs input 7 10)))
)

(defn isNearbySeatOccupied [currSeats seatId]
  (and
    (contains? currSeats (+ seatId 1))
    (contains? currSeats (- seatId 1))
  )
)

(defn -main [& args]
  (println "AOC Day 5")
  (def minSeatId (+ (* 1 8) 0))
  (def maxSeatId (+ (* 126 8) 7))
  (def input (read-input "./src/aoc/day5/input"))
  (def seats (map get-seatid input))
  (def possibleSeats (set (range minSeatId (+ maxSeatId 1))))
  (def boardingPassSeats (set seats))
  (prn (apply max seats))
  (def missingSeats (filter (partial isNearbySeatOccupied boardingPassSeats) (set/difference possibleSeats boardingPassSeats)))
  (prn (first missingSeats))
)
