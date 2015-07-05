(ns credit-card-checker.core)

(defn card-length
  [number]
  (count (str number)))

(defn card-type
  "Determines if a card number is amex, mastercard, visa, or discover."
  [number]
  (cond (= (card-length number) 15) :amex
        (= (card-length number) 13) :visa
        (= (subs (str number) 0 4) "6011") :discover
        (contains? #{51 52 53 54 55} (read-string (subs (str number) 0 2))) :mastercard
        :else :invalid-card-number))
