(ns clojure-robot.core
  (:require [clojure.string :refer [split-lines]]
            [clojure-robot.robot :as r]
            [clojure-robot.util :refer :all]))

(def place-regex #"PLACE (\d) (\d) (.*)")

(defn run-command [robot command-string]
  (condp re-find command-string
    place-regex :>> (fn [[_ x y d]]
                      (r/place
                       (parse-int x)
                       (parse-int y)
                       (keyword (.toLowerCase d))))

    #"MOVE"   (r/move robot)
    #"LEFT"   (r/left robot)
    #"RIGHT"  (r/right robot)
    #"REPORT" (r/report-status robot)))

(defn run-program [command-list]
  (let [commands (drop-while (complement (partial re-matches place-regex)) command-list)]
    (reduce run-command [] commands)))

(defn -main
  "I don't do a whole lot ... yet."
  [command-input]
  (run-program (split-lines command-input)))
