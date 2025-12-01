(ns aoc.2025.day01
  (:require [aoc.util :as util]
            [clojure.string :as str]))

(defn- normalize-dial [dial-result]
  (let [dial (rem dial-result 100)]
    (cond-> dial (neg? dial) (+ 100))))

(defmulti inc-zeros (fn [safe _dial-result] (:strategy safe)))

(defmethod inc-zeros :strict [safe dial-result]
  (cond-> safe
          (zero? (normalize-dial dial-result))
          (update :zeros inc)))

(defmethod inc-zeros :loose [{:keys [dial] :as safe} dial-result]
  (let [passes (cond-> (abs (quot dial-result 100))
                       (not (or (pos? dial-result)
                                (zero? dial)))
                       inc)]
    (update safe :zeros + passes)))

(defn- evaluate-dial [{:keys [dial]} operation]
  (let [rotations (util/->int (re-find #"\d+" operation))
        operator  (if (str/starts-with? operation "R") + -)]
    (operator dial rotations)))

(defn- rotate-dial [safe operation]
  (let [dial-result (evaluate-dial safe operation)]
    (-> (inc-zeros safe dial-result)
        (assoc :dial (normalize-dial dial-result)))))

(defn- count-zero-dials [n strategy]
  (->> (str/split-lines n)
       (remove str/blank?)
       (reduce rotate-dial {:dial     50
                            :zeros    0
                            :strategy strategy})
       :zeros))

(defn part-1 [n]
  (count-zero-dials n :strict))

(defn part-2 [n]
  (count-zero-dials n :loose))
