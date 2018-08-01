(ns clojure-robot.robot)

(def dirs #{:north :east :south :west})

(def left-map
  {:north :west
   :west  :south
   :south :east
   :east  :north})

(def right-map
  {:west  :north
   :south :west
   :east  :south
   :north :east})

(defn narrow-range [num lower upper]
  (cond
    (< num lower) lower
    (> num upper) upper
    :else num))

(defn narrow [num]
  (narrow-range num 0 4))

(defn limit-movement [robot]
  (-> robot
       (update :x narrow)
       (update :y narrow)))

(defn place [x y d]
  (when (dirs d)
    (limit-movement {:x x :y y :d d})))

(defn left [robot]
  (update robot :d #(get left-map %)))

(defn right [robot]
  (update robot :d #(get right-map %)))

(defn move [robot]
  (limit-movement
   (case (:d robot)
     :north (update robot :y inc)
     :east  (update robot :x inc)
     :south (update robot :y dec)
     :west  (update robot :x dec))))

(defn report-status [robot]
  (printf "%d,%d,%s\n" (:x robot) (:y robot) (.toUpperCase (name (:d robot))))
  robot)
