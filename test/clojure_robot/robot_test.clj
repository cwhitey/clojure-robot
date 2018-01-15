(ns clojure-robot.robot-test
  (:require [clojure-robot.robot :refer :all]
            [clojure.test :refer :all]))

(deftest robot
  (testing "placement"
    (is (= (place 0 0 :south) {:x 0 :y 0 :d :south})))

  (testing "move"
    (testing "north"
      (is (= (move {:x 2 :y 2 :d :north})
             {:x 2 :y 3 :d :north})))

    (testing "east"
      (is (= (move {:x 2 :y 2 :d :east})
             {:x 3 :y 2 :d :east})))

    (testing "south"
      (is (= (move {:x 2 :y 2 :d :south})
             {:x 2 :y 1 :d :south})))

    (testing "west"
      (is (= (move {:x 2 :y 2 :d :west})
             {:x 1 :y 2 :d :west})))

    (testing "invalid movement"
      (let [robot-east {:x 4 :y 0 :d :east}
            robot-south {:x 4 :y 0 :d :south}]
        (is (= (move robot-east) robot-east))
        (is (= (move robot-south) robot-south)))))

  (testing "left"
    (is (= (turn-left {:d :north}) {:d :west}))
    (is (= (turn-left {:d :east}) {:d :north})))

  (testing "right"
    (is (= (turn-right {:d :west}) {:d :north}))
    (is (= (turn-right {:d :north}) {:d :east}))))
