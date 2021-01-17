(ns aoc.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  ;; An option with a required argument
  [["-d" "--day DAY" "AOC Day"
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 366) "Must be a number between 0 and 65536"]]
   ["-h" "--help"]]
)

(defn -main [& args]
  (def options
    (:options (parse-opts args cli-options)))
  (println (:day options))
)
