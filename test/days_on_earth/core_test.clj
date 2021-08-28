(ns days-on-earth.core-test
  (:require [clojure.test :refer :all]
            [days-on-earth.core :refer :all]
            [clj-time.core :as t]))

(deftest calculate-test
  (testing "calculate function with one arity"
    (is (= 1 (calculate {:year (t/year (t/yesterday))
                         :month (t/month (t/yesterday))
                         :day (t/day (t/yesterday))}))))

  (testing "calculate function with two arity"
    (is (= 90 (calculate {:year 1980 :month 2 :day 3}
                         {:year 1980 :month 5 :day 3})))))
