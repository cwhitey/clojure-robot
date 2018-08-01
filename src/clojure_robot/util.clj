(ns clojure-robot.util)

(defn parse-int [s]
  (try (Integer/parseInt s)
       (catch Throwable _)))
