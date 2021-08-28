(ns days-on-earth.core
  (:require [clj-time.core :as t]))

(defn calculate
  "Given a date, return the number of days from that date till today.
  Input parameter is a map with :year, :month and :day as keywords. Example {:year 1980 :month 01 :day 10}"
  [date]
  (t/in-days
    (t/interval
      (t/date-time (:year date) (:month date) (:day date))
      (t/now))))

(comment
  (calculate {:year 1980 :month 01 :day 10}))
