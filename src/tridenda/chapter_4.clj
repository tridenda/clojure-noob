(ns tridenda.chapter-4 
  (:require
   [clojure.repl :refer [doc]]))

(take 23 (range 0 100))

(map inc [1 2 3 4])

(defn titleize
  [topic]
  (str topic " for the Brave and True"))

(map titleize ["Hamsters" "Ragnarok"])
(map titleize '("Hamsters" "Ragnarok"))
(map titleize #{"Elbows" "Soap Carving"})
(map #(titleize (second %)) {:uncomfortable-thing "Winking"})

(seq [1 2 3])

(println "Hello")

(map identity {:sunlight-reaction "Glitter!"})

(into {} (map identity {:sunlight-reaction "Glitter!"}))


(into ["Cherry"] '("Pine" "Spruce"))

(conj [0] [1])

(into [0] [1])

(apply max [1 2 3 4])

(defn my-into
  [target additions]
  (apply conj target additions))

(def sums
  (fn [& more-args]
    (apply + (into [20] more-args))))


;; A Vampire Data Analysis Program for the FWPD