(ns days-on-earth.core-test
  (:require [clojure.test :refer :all]
            [days-on-earth.core :refer :all]
            [clj-time.core :as t]))

(deftest calculate-test
  (testing "if calculate function returns 1 when input date is yesterday"
    (is (= 1 (calculate {:year (t/year (t/yesterday))
                         :month (t/month (t/yesterday))
                         :day (t/day (t/yesterday))})))))
