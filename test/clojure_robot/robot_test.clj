(ns clojure-robot.robot-test
  (:require [clojure-robot.robot :refer :all]
            [clojure.test :refer :all]))

(deftest robot
  (testing "placement"
    (is (= (place 0 0 :SOUTH) {:x 0 :y 0 :d :SOUTH})))

  (testing "move"
    (testing "north"
      (is (= (move {:x 2 :y 2 :direction :north}) {:x 2 :y 3 :direction :north})))

    (testing "east"
      (is (= (move {:x 2 :y 2 :direction :east}) {:x 3 :y 2 :direction :east})))

    (testing "south"
      (is (= (move {:x 2 :y 2 :direction :south}) {:x 2 :y 1 :direction :south})))

    (testing "west"
      (is (= (move {:x 2 :y 2 :direction :west}) {:x 1 :y 2 :direction :west})))

    (testing "invalid movement"
      (let [robot-east {:x 4 :y 0 :direction :east}
            robot-south {:x 4 :y 0 :direction :south}]
        (is (= (move robot-east) robot-east))
        (is (= (move robot-south) robot-south)))))

  (testing "left"
    (is (= (left {:direction :north}) {:direction :west}))
    (is (= (left {:direction :east}) {:direction :north})))

  (testing "right"
    (is (= (right {:direction :west}) {:direction :north}))
    (is (= (right {:direction :north}) {:direction :east}))))
