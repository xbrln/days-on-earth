(ns days-on-earth.core-test
  (:require [clojure.test :refer :all]
            [days-on-earth.core :refer :all]
            [clj-time.core :as t]))

(deftest calculate-test
  (testing "calculate function with one arity"
    (let [date (t/ago (t/days 7))]
      (is (= 7 (calculate {:year (t/year date)
                           :month (t/month date)
                           :day (t/day date)})))))

  (testing "calculate function with two arity"
    (is (= 90 (calculate {:year 1980 :month 2 :day 3}
                         {:year 1980 :month 5 :day 3})))))

(deftest forecast-date-test
  (testing "forecast-date"
    (is (= "2021-01-11" (forecast-date {:year 2021 :month 1 :day 1} 10)))))

(deftest forecast-test
  (testing "forecast"
    (is (= [[:milestone 100 :date "2021-04-11" :age 0]
            [:milestone 200 :date "2021-07-20" :age 0]]
           (forecast {:year 2021 :month 1 :day 1} 100 2)))))
