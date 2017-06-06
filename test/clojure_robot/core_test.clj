(ns clojure-robot.core-test
  (:require [clojure.test :refer :all]
            [clojure-robot.core :refer :all]
            [clojure-robot.robot :refer :all]))

(deftest robot 
  (testing "placement"
    (is (= (place 0 0 :SOUTH) {:x 0 :y 0 :d :SOUTH}))))
