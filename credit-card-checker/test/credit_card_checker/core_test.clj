(ns credit-card-checker.core-test
  (:require [clojure.test :refer :all]
            [credit-card-checker.core :refer :all]))

(deftest determine-card-type
  (testing "All 15 character long numbers are Amex"
    (is (= (card-type 344393372439132) :amex)))
  (testing "All 13 character long numbers are Visa"
    (is (= (card-type 1352423597392) :visa)))
  (testing "All Amex cards begin with 34 or 37"
    (is (= (card-type 372383921738298) :amex)))
  (testing "All Discover cards begin with 6011"
    (is (= (card-type 6011324395942849) :discover)))
  (testing "All Master cards begin with numbers 51-55"
    (is (= (card-type 5234948324950382) :mastercard)))
  (testing "Anything else is invalid"
    (is (= (card-type 1234524352) :invalid-card-number)))
)
