(ns clojure-robot.core-test
  (:require [clojure.test :refer :all]
            [clojure-robot.core :refer :all]
            [clojure-robot.robot :refer :all]))

(deftest core
  (testing "command parsing"
    (testing "place command"
      (is (= {:x 0 :y 0 :d :north}
             (run-command "PLACE 0 0 NORTH")))
      (is (= {:x 0 :y 4 :d :east}
             (run-command "PLACE 0 4 EAST"))))))
