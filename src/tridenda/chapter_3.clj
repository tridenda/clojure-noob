(ns tridenda.chapter-3 
  (:require
   [clojure.repl :refer [doc]]))

(defn hello
  [x]
  (println (str "Hello, " x "!")))

(hello "World")

(+ 1 2 3)

(str "It was panda " "in the library " "with a dust butter")

(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Odin's Elbow!")

(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

(when true
  (println "Success!")
  "abra cadabra")

(nil? 1)

(nil? nil)

(= 1 1)

(= nil nil)

(= 1 2)

(or false nil :large_I_mean_venti :why_cant_I_just_say_large)

(or (= 0 1) (= "yes" "no"))

(and :free_wifi :hot_coffee)

(and :feeling_super_cool nil false)

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])


;; (def severity :mild)
;; (def error-message "OH GOD! IT'S A DISASTER WE'RE ")
;; (if (= severity :mild)
;;   (def error-message (str error-message "MILDLY INCONVENIENCED!"))
;;   (def error-message (str error-message "DOOOOOOOOMED!")))

;; (def hi-jamal "Hi, Jamal!")
;; (def hi-jamal "Hi, Jamaaaaaal!")


(defn error-message
  [severity]
  (str "OH GOD IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOMED!")))

(error-message :mild)


;; # Data Structures => Immutable -> Can't change them in place
;; ## Primitives
;;    - Numbers: Integer, Float, Ratio, BigInt, Hex/Octal
;;    - Booleans: true, false
;;    - Characters: \a \A \space
;;    - nil
;;    - Keywords: :username, :db/id ::local/setting
;;    - Symbols: 'some-symbol 'map
;;    - Strings
;; ## Collections
;;    - Vectors: [1 2 3]
;;    - Lists: '(1 2 3)
;;    - Maps: {:a 1 :b 2}
;;    - Sets: #{1 2 3}

;; Maps
{:a 1 :b 2}
(get {:a 1 :b 2} :a)
(get {:a 1 :b 2} :c 12312)
(get-in {:a 0 :b {:c "ho hum"}} [:b :c])
({:name "Tri Denda"} :name)
(:d {:a 1 :b 2 :c 3} "No gnome knows homes like noah")
(:a {:a 1 :b 2})

;; Vectors
[1 \a 3]
(get [1 2 3 4] 2)
(vector "creepy" "full" "moon")
(conj [1 2 3] 4)

;; Lists
`(1 2 3 \a)
(nth '(:a :b :c) 2)
(list 1 "two" {3 4})
(conj '(1 2 3) 4)

;; Sets
#{"Kurn connegut" 20 :icicle}
(hash-set 1 1 2 23 23 241232 3423)
(conj #{:a :b} :b)
(set [3 4 4 3 3 434])
(contains? #{:a :b} :a)
(contains? #{:a :b} 3)
(:a #{:a :b})




;; Functions
(+ 1 2 3 2323)
(* 1 2 323 3)
(first [1 2 3 4])
(or + -)
((or + -) 1 2 3)
((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)
;; (1 2 3 4) <- isn't valid function
;; ("test" 1 2 3)

(inc 1.1)
(map inc [0 1 2 3])

(+ (inc 199) (/ 100 (- 7 2)))


;; Defining a function
(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GO! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "Zelda")

(defn no-params
  []
  "I take no parameters!")

(no-params)

(defn one-param
  [x]
  (str "I take one parameter: " x))

(one-param 1)

(defn two-params
  [x y]
  (str "Two Parameters! Tha's nothing! Pah! I will smoosh them "
       "together to spite you! " x y))

(two-params "One" "two")

(defn multi-arity
  ;; 3-arity arguments and body
  ([x y z]
   (str x y z))
  ;; 2-arity arguments and body
  ([x y]
   (str x y))
  ;; 1-arity arguments and body
  ([x]
   (str x)))

(multi-arity 1 2 3)


(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kanye West" "slap")
(x-chop "Kanye West")


(defn weird-arity
  ([]
     "Destiny dressed you this morning, my friend, and now Fear is
     trying to pull off your pants. If you give up, if you give in,
     you're gonna end up naked with Fear just standing there laughing
     at your dangling unmentionables! - the Tick")
  ([number]
     (inc number)))

(weird-arity)
(weird-arity 1)

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Joe")

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes") 

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman", "jama"])

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 23 :lng 67 :tst 23})

(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Magoo"])

((fn [x] (* x 3)) 8)

(def my-special-multiplier (fn [x] (* x 3)))

(my-special-multiplier 12)

(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Darth Vader" "Mr. Blagoo"])

(#(str %1 " and " %2) "cornbread" "butter beans")

(#(identity %&) 1 "blarg" :yip)


(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts ;; initial first value
         final-body-parts []] ;; initial second value
    (if (empty? remaining-asym-parts) ;; check if this empty
      final-body-parts ;; the result
      (let [[part & remaining] remaining-asym-parts] ;; descruture
        (recur remaining ;; (recur new-remaining new-final-body-parts)
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-parts)

;; let
(let [x 3]
  x)

(let [[x & xs] [1 2 3 4]]
  xs)

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

(def x 0)
(let [x 1] x)

(def x 0)
(let [x (inc x)] x)

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians]) 


(re-find #"^left-" "left-eye")





;; -----------------------------------------------
;; Exercises
;; -----------------------------------------------

;; 1. Use the str, vector, list, hash-map, and hash-set functions.
(str "Hello, " "My name is" "Tri Denda")
(list :a :b :b)
(hash-map :a 2 :b 3)
(hash-set 2 3 4 23 23)

;; 2. Write a function that takes a number and adds 100 to it.
(defn add-by-100
  [x]
  (+ x 100))
(add-by-100 200)

;; 3. Write a function, dec-maker, that works exactly like 
;;    the function inc-maker except with subtraction:
(defn dec-maker
 [x]
 (fn [y] (- y x)))
 
(def dec9 (dec-maker 9))
(dec9 10)

;; 4. Write a function, mapset, that works like map except 
;;    the return value is a set:
;; (mapset inc [1 1 2 2])
;; ; => #{2 3}

;; 5. Create a function that’s similar to symmetrize-body-parts 
;;    except that it has to work with weird space aliens with radial symmetry. 
;;    Instead of two eyes, arms, legs, and so on, they have five.


;; 6. Create a function that generalizes symmetrize-body-parts and 
;;    the function you created in Exercise 5. The new function should 
;;    take a collection of body parts and the number of matching body parts 
;;    to add. If you’re completely new to Lisp languages and functional 
;;    programming, it probably won’t be obvious how to do this. 
;;    If you get stuck, just move on to the next chapter and revisit 
;;    the problem later.



