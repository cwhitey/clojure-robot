(ns clojure-robot.robot)

(def left-map {:north :west
               :west  :south
               :south :east
               :east  :north})

(def right-map {:west :north
                :south :west
                :east :south
                :north :east})

(defn within-edge? [num]
  (and (>= num 0) (<= num 4)))

(defn valid-placement? [placement]
  (let [{:keys [x y]} placement]
    (every? within-edge? [x y])))

(defn place [x y direction]
  (let [robot {:x x :y y :d direction}]
    (when (valid-placement? robot) robot)))

(defn left [robot]
  (update robot :direction #(get left-map %)))

(defn right [robot]
  (update robot :direction #(get right-map %)))

(defn move [robot]
  (let [{:keys [x y direction]} robot
        new-pos (case direction
                  :north (update robot :y inc)
                  :east  (update robot :x inc)
                  :south (update robot :y dec)
                  :west  (update robot :x dec))]
    (if (valid-placement? new-pos) new-pos)))
