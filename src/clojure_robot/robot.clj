(ns clojure-robot.robot)

(def ^:private left-map {:north :west
                         :west  :south
                         :south :east
                         :east  :north})

(def ^:private right-map {:west  :north
                          :south :west
                          :east  :south
                          :north :east})

(defn ^:private within-edge? [num]
  (and (>= num 0) (<= num 4)))

(defn ^:private valid-placement? [placement]
  (let [{:keys [x y]} placement]
    (every? within-edge? [x y])))

(defn place [x y direction]
  (let [robot {:x x :y y :d direction}]
    (when (valid-placement? robot) robot)))

(defn left [robot]
  (update robot :direction #(get left-map %)))

(defn right [robot]
  (update robot :direction #(get right-map %)))

(defn ^:private move-unsafe [robot]
  (case (:direction robot)
    :north (update robot :y inc)
    :east  (update robot :x inc)
    :south (update robot :y dec)
    :west  (update robot :x dec)))

(defn move [robot]
  (let [new-pos (move-unsafe robot)]
    (if (valid-placement? new-pos)
      new-pos
      robot)))

(defn report [robot]
  (let [{:keys [x y direction]} robot]
    (println (str "x: " x ", y: " y "dir: " direction))))
