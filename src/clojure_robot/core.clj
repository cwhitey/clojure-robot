(ns clojure-robot.core
  (:require [clojure-robot.robot :as r]
            [clojure-robot.util :refer :all]))

(def place-re #"PLACE (\d) (\d) (.*)")

(defn run-command [robot command-string]
  (condp re-find command-string
    place-re :>> (fn [[_ x y d]]
                   (r/place
                    (parse-int x)
                    (parse-int y)
                    (keyword (.toLowerCase d))))

    #"MOVE"   (r/move robot)
    #"LEFT"   (r/left robot)
    #"RIGHT"  (r/right robot)
    #"REPORT" (r/report-status robot)))

(defn run-program [program-string]
  (let [command-list (clojure.string/split-lines program-string)
        commands (drop-while #(not (re-matches place-re %)) command-list)]
    commands
    #_(reduce run-command [] (clojure.string/split-lines commands))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
