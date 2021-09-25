#!/usr/local/bin/clojure -M
(require '[clojure.string :as string])

(defn strToNum
  [xs]
  "Convert vector of string to vector of int"
  (map #(Integer/parseInt %) xs)
)

(defn calcWeight
  [x]
  (let [
    remaining (- (Math/floor (/ x 3)) 2)
  ]
    (cond
      (<= remaining 0) 0
      :else (+ remaining (calcWeight remaining))
    )
  )
)

(defn main [& args]
  (def sum
    (->> (slurp "01.txt")
         (string/split-lines)
         (strToNum)
         (map #(- (Math/floor (/ % 3)) 2))
         (reduce +)
    )
  )
  (def sum2
    (->> (slurp "01.txt")
         (string/split-lines)
         (strToNum)
         (map #(calcWeight %))
         (reduce +)
    )
  )
  (println sum sum2)
)

(main)
