(ns clojure-robot.core-test
  (:require [clojure.test :refer :all]
            [clojure-robot.core :refer :all]
            [clojure-robot.robot :refer :all]))

(deftest core
  (testing "command parsing"
    (testing "PLACE command"
      (is (= {:x 0 :y 0 :d :north}
             (run-command {} "PLACE 0 0 NORTH")))
      (is (= {:x 0 :y 4 :d :east}
             (run-command {} "PLACE 0 4 EAST")))
      (testing "invalid direction"
        (is (= nil
               (run-command {} "PLACE 0 4 FOO")))))
    (testing "MOVE command"
      (is (= {:x 0 :y 1 :d :north}
             (run-command {:x 0 :y 0 :d :north} "MOVE"))))
    (testing "LEFT command"
      (is (= {:x 0 :y 0 :d :west}
             (run-command {:x 0 :y 0 :d :north} "LEFT"))))
    (testing "RIGHT command"
      (is (= {:x 0 :y 0 :d :east}
             (run-command {:x 0 :y 0 :d :north} "RIGHT"))))
    (testing "REPORT command"
      (is (not-empty (with-out-str
                       (run-command {:x 0 :y 0 :d :north} "REPORT")))))))
