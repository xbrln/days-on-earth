(ns days-on-earth.core
  (:require [clj-time.core :as t]))

(defn calculate
  "Given a date, return the number of days from that date till today.
  Input parameter is a map with :year, :month and :day as keywords. Example {:year 1980 :month 1 :day 10}
  Keep in mind that singe digit numbers should not be prefixed with 0, since in Java, numbers prefixed with a 0 are treated as octal. So January should be represented as 1 and not 01  "
  [date]
  (t/in-days
    (t/interval
      (t/date-time (:year date) (:month date) (:day date))
      (t/now))))

(comment
  (calculate {:year 1980 :month 1 :day 10}))
