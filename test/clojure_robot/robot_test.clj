(ns clojure-robot.robot-test
  (:require [clojure.test :refer :all]
            [clojure-robot.robot :refer :all]))

(deftest robot
  (testing "placement"
    (is (= {:x 0 :y 0 :d :south}
           (place 0 0 :south))))

  (testing "move"
    (testing "north"
      (is (= {:x 2 :y 3 :d :north}
             (move {:x 2 :y 2 :d :north}))))

    (testing "east"
      (is (= {:x 3 :y 2 :d :east}
             (move {:x 2 :y 2 :d :east}))))

    (testing "south"
      (is (= {:x 2 :y 1 :d :south}
             (move {:x 2 :y 2 :d :south}))))

    (testing "west"
      (is (= {:x 1 :y 2 :d :west}
             (move {:x 2 :y 2 :d :west}))))

    (testing "invalid movement"
      (let [robot-east {:x 4 :y 0 :d :east}
            robot-south {:x 4 :y 0 :d :south}]
        (is (= robot-east (move robot-east)))
        (is (= robot-south (move robot-south))))))

  (testing "left"
    (is (= {:d :west} (left {:d :north})))
    (is (= {:d :north} (left {:d :east}))))

  (testing "right"
    (is (= {:d :north} (right {:d :west})))
    (is (= {:d :east} (right {:d :north}))))

  (testing "report"
    (is (= "0,1,NORTH\n" (with-out-str
                           (report-status {:x 0 :y 1 :d :north}))))))
