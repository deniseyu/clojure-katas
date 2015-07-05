(ns credit-card-checker.core)

(defn card-length
  [number]
  (count (str number)))

(defn begins-with
  [digits number]
  (subs (str number) 0 digits))

(defn in-set
  [coll number]
  (contains? coll (read-string number)))

(defn card-type
  "Determines if a card number is amex, mastercard, visa, or discover."
  [number]
  (cond
        (and (in-set #{34 37} (begins-with 2 number)) (= (card-length number)
          15)) :amex
        (= (card-length number) 13) :visa
        (= (begins-with 4 number) "6011") :discover
        (in-set #{51 52 53 54 55} (begins-with 2 number)) :mastercard
        :else :invalid-card-number))
