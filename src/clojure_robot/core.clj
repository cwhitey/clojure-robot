(ns clojure-robot.core
  (:require [clojure-robot.robot :as r]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn run-command [command-string]
  (condp re-find command-string
    #"PLACE" (r/place 0 0 :north)))
