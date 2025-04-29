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

(def filename "./src/tridenda/suspects.csv")


(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\r\n")))

(parse (slurp filename))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(parse (slurp filename))

;; rows => (["Edward Cullen" "10"] ["Bella Swan" "0"] ["Charlie Swan" "0"] ["Jacob Black" "3"] ["Carlisle Cullen" "6"])
;; unmapped-row => ["Edward Cullen" "10"]

(map vector vamp-keys ["Edward Cullen" "10"])

(first (mapify (parse (slurp filename))))
(mapify (parse (slurp filename)))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(glitter-filter 3 (mapify (parse (slurp filename))))


;; Exercises
;; The vampire analysis program you now have is already decades ahead of anything else on the market. But how could you make it better? I suggest trying the following:

;; 1. Turn the result of your glitter filter 
;;     into a list of names.

;; 2. Write a function, append, which will append 
;;     a new suspect to your list of suspects.

;; 3. Write a function, validate, which will check that 
;;     :name and :glitter-index are present when you append. 
;;     The validate function should accept two arguments: 
;;     a map of keywords to validating functions, similar 
;;     to conversions, and the record to be validated.

;; 4. Write a function that will take your list of maps 
;;     and convert it back to a CSV string. You’ll need 
;;     to use the clojure.string/join function.
