(ns aoc.day4.solve
  (:require [clojure.string :as string])
)

(defn read-input [input]
  (-> input
      slurp
      (string/split #"\n\n")
))


(defn iter-input [xs]
  (doseq [x xs]
    (prn x)
  )
)

(defn validateField? [line]
  (let [
     x (keyword (second line))
     y (second (string/split (first line) #":"))
  ]
    (case x
      :byr (and
        (= 4 (count y))
        (>= (Integer/parseInt y) 1920)
        (<= (Integer/parseInt y) 2002)
      )
      :iyr (and
        (= 4 (count y))
        (>= (Integer/parseInt y) 2010)
        (<= (Integer/parseInt y) 2020)
      )
      :eyr (and
        (= 4 (count y))
        (>= (Integer/parseInt y) 2020)
        (<= (Integer/parseInt y) 2030)
      )
      :hgt (let [
        metric (subs y (- (count y) 2) (count y))
        measure (subs y 0 (- (count y) 2))
      ]
        (case metric
          "cm" (and
            (>= (Integer/parseInt measure) 150)
            (<= (Integer/parseInt measure) 193)
          )
          "in" (and
            (>= (Integer/parseInt measure) 59)
            (<= (Integer/parseInt measure) 76)
          )
          false
        )
      )
      :hcl (re-matches #"^#[a-f0-9]{6}" y)
      :ecl (re-matches #"amb|blu|brn|gry|grn|hzl|oth" y)
      :pid (re-matches #"^\d{9}" y)
      false
    )
  )
)

(defn isValidPassport? [passport]
  (let [ x (re-seq #"(byr|ecl|eyr|pid|iyr|hgt|hcl):\S+" passport)
]
    (def filtered (filter validateField? x))

    (= 7 (count filtered))
  )
)

(defn isCorrectPassport? [passport]
  (let [ x (re-seq #"(byr|ecl|eyr|pid|iyr|hgt|hcl):\S+" passport)
]
    (= 7 (count x))
  )
)

(defn -main [& args]
  (println "AOC Day 4")
  (def input (read-input "./src/aoc/day4/input"))
  (prn (count (filter isCorrectPassport? input)))
  (prn (count (filter isValidPassport? input)))
)
